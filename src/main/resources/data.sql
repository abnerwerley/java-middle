insert into parent(id, name)
values
(1, 'John'),
(2, 'Paul'),
(3, 'Mary'),
(4, 'Lucy'),
(5, 'Mark');

insert into child(id, name, father_id, mother_id)
values
(1, 'John', 1, 3),
(2, 'Paul', 1, 3),
(3, 'Lucy', 2, 4),
(4, 'Claire', 1, 4),
(5, 'Simon', null, 4);


--SELECT * FROM parent WHERE id IN (1,2, 3, 4);




--delete from parent where id=1;

--select name from parent where id in(1,2,5);
--
--select
--    p.name
--from
--    parent p
--inner join
--    child c
--        on p.id = c.father_id
--group by
--    p.id
--having
--    count(c.id) >1;
--
--select c.name as child_name,
--       f.name as father_name,
--       m.name as mother_name
--from child c
--left join parent f on c.father_id = f.id
--left join parent m on c.mother_id = m.id;
--
--SELECT COUNT(*) AS children_quantity
--FROM child
--WHERE father_id = 1;
--
--select count(*) as children_quantity
--from child
--where mother_id = 3;
--
--select * from child;
--select * from parent;
--
--DROP DATABASE [IF EXISTS] db_tokenServices;
--
