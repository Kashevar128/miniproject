create table students
(
    id   bigserial primary key,
    name varchar(255) not null,
    age  int          not null
);
insert into students (name, age)
values ('Malk', 33),
       ('Artur', 45),
       ('Kevin', 40),
       ('Martin', 60),
       ('Kortni', 47);
