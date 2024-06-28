drop table IF EXISTS parent;
drop table IF EXISTS child;

create TABLE parent (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

create TABLE child (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    father_id INT,
    mother_id INT,
    FOREIGN KEY (father_id) REFERENCES parent(id),
    FOREIGN KEY (mother_id) REFERENCES parent(id)
);