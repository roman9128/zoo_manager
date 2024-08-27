-- создаю базу данных и подключаюсь к ней
create database human_friends; 
use human_friends;

-- создаю необходимые таблицы и наполняю их
create table animal_group (
animal_group_id int not null,
animal_group_name varchar (12) not null);

insert into animal_group values
(1, 'Pets'),
(2, 'Pack animals');

create table animal_type (
animal_type_id int not null,
animal_type_name varchar (10) not null);

insert into animal_type values
(1, 'Cat'),
(2, 'Dog'),
(3, 'Hamster'),
(4, 'Camel'),
(5, 'Donkey'),
(6, 'Horse');

create table animals (
id serial primary key,
animal_name varchar(15) not null,
animal_group_id int not null,
animal_type_id int not null,
birth_date date,
commands varchar(50));

insert into animals (animal_name, animal_group_id, animal_type_id, birth_date, commands) values
('Vasia', 1, 1, '2019-06-06', 'cry'),
('Dolia', 1, 1, '2017-04-03', 'meow'),
('Zara', 1, 2, '2010-05-10', 'voice'),
('Sus', 1, 3, '2006-10-30', 'hide'),
('Donk', 2, 5, '2007-09-12', 'hee-haw'),
('Smokey', 2, 4, '2009-10-19', 'spit'),
('Ginger', 2, 6, '2011-12-03', 'fyr');

-- удаляю записи о верблюдах
delete from animals
where animal_type_id = (select animal_type_id from animal_type where animal_type_name = 'Camel');

-- объединяю таблицы лошадей и ослов (поскольку в моей структуре данных нет отдельных таблиц для лошадей и ослов, то я их предварительно создам на основе имеющихся данных)
create table horses (
id int primary key not null,
animal_name varchar(15) not null,
animal_group_id int not null,
animal_type_id int not null,
birth_date date,
commands varchar(50));

insert into horses
select * from animals
where animal_type_id = (select animal_type_id from animal_type where animal_type_name = 'Horse');

create table donkeys (
id int primary key not null,
animal_name varchar(15) not null,
animal_group_id int not null,
animal_type_id int not null,
birth_date date,
commands varchar(50));

insert into donkeys
select * from animals
where animal_type_id = (select animal_type_id from animal_type where animal_type_name = 'Donkey');

select * from horses
union
select * from donkeys;

-- cоздаю новую таблицу для животных в возрасте от 5 до 7 лет и вычисляю их возраст с точностью до месяца (изменил изначальные требования к возрасту, т.к. в моей таблице нет животных от 1 до 3 лет)
create table youth (
id int primary key not null,
animal_name varchar(15) not null,
animal_group_id int not null,
animal_type_id int not null,
birth_date date,
commands varchar(50));

insert into youth
select * from animals
where floor(datediff(now(), birth_date) / 365.25) >= 5 and floor(datediff(now(), birth_date) / 365.25) <= 7;

select animal_name, timestampdiff(month, birth_date, now()) as age_in_months
from youth;

-- объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам (не очень понял это задание, поэтому просто выведу всю информацию)

select id, animal_name, g.animal_group_name, t.animal_type_name, birth_date, timestampdiff(month, birth_date, now()) as age_in_months,
case
	when id in (select id from youth) then 'Young'
    else 'Not enough young'
    end as 'age',
commands
from animals
join animal_type t on t.animal_type_id = animals.animal_type_id 
join animal_group g on g.animal_group_id = animals.animal_group_id
order by id;