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
