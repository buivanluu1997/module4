create database case_study_4;
use case_study_4;
-- thêm bảng role
create table role
(
    id        int primary key auto_increment,
    name      varchar(50),
    is_delete boolean default false
);
-- thêm bảng account
create table account
(
    id        int primary key auto_increment,
    username  varchar(100) unique not null,
    password  text                not null,
    is_delete boolean default false
);

-- them bang account_role
create table account_role
(
    id         int primary key auto_increment,
    account_id int,
    role_id    int,
    unique (account_id, role_id),
    foreign key (account_id) references account (id),
    foreign key (role_id) references role (id)
);
-- thêm bảng position
create table employee_position
(
    id        int primary key auto_increment,
    name      varchar(100) not null,
    is_delete boolean default false
);
-- thêm bảng employee
create table employee
(
    id          int primary key auto_increment,
    name        varchar(100)        not null,
    email       varchar(100) unique not null,
    gender      boolean,
    address     varchar(255),
    phone       varchar(20),
    birth_date  date,
    image_url   text,
    salary      decimal(10, 2),
    is_delete   boolean default false,
    position_id int,
    foreign key (position_id) references employee_position (id),
    account_id  int,
    foreign key (account_id) references account (id)
);
-- thêm bảng course
create table course
(
    id        int primary key auto_increment,
    name      varchar(100) not null,
    duration  varchar(50),-- thời gian học 1 khóa
    is_delete boolean default false
);
-- thêm bảng module
create table module
(
    id        int primary key auto_increment,
    name      varchar(100) not null,
    is_delete boolean default false,
    course_id int,
    foreign key (course_id) references course (id)
);
-- thêm bảng lesson
create table lesson
(
    id        int primary key auto_increment,
    name      varchar(100) not null,
    is_delete boolean default false,
    module_id int,
    foreign key (module_id) references module (id)
);
-- thêm bảng category_activity
create table category_activity
(
    id        int primary key auto_increment,
    name      varchar(100) not null,
    is_delete boolean default false
);
-- thêm bảng activity
create table activity
(
    id                   int primary key auto_increment,
    name                 varchar(100) not null,
    is_delete            boolean default false,
    category_activity_id int,
    foreign key (category_activity_id) references category_activity (id),
    lesson_id            int,
    foreign key (lesson_id) references lesson (id)
);
-- thêm bảng class
create table class
(
    id          int primary key auto_increment,
    name        varchar(100),
    start_date  datetime default current_timestamp,
    is_delete   boolean  default false,
    employee_id int,
    foreign key (employee_id) references employee (id),
    course_id   int,
    foreign key (course_id) references course (id)
);
-- thêm bảng student
create table student
(
    id         int primary key auto_increment,
    name       varchar(100)        not null,
    email      varchar(100) unique not null,
    gender     boolean,
    address    varchar(255),
    phone      varchar(20),
    birth_date date,
    image_url  text,
    is_delete  boolean default false,
    class_id   int,
    foreign key (class_id) references class (id),
    account_id int,
    foreign key (account_id) references account (id)
);
-- thêm bảng điểm danh(attendance)
create table attendance
(
    id          int primary key auto_increment,
    create_at   datetime default current_timestamp,
    status      enum ('VANG_CO_PHEP','CO_MAT','DI_MUON','VANG_KHONG_PHEP'),
    note        text,
    is_delete   boolean  default false,
    student_id  int,
    foreign key (student_id) references student (id),
    class_id    int,
    foreign key (class_id) references class (id),
    employee_id int,
    foreign key (employee_id) references employee (id)
);
-- thêm bảng nhật ký(diary)
create table dailynote
(
    id          int primary key auto_increment,
    create_at   datetime default current_timestamp,
    content     text,
    is_delete   boolean  default false,
    employee_id int,
    foreign key (employee_id) references employee (id),
    class_id    int,
    foreign key (class_id) references class (id)
);
-- thêm bảng tiến trình học tập(progress)
create table progress
(
    id          int primary key auto_increment,
    status      boolean default false,
    is_delete   boolean default false,
    student_id  int,
    foreign key (student_id) references student (id),
    activity_id int,
    foreign key (activity_id) references activity (id)
);
-- thêm bảng điểm số (score)
create table score
(
    id         int primary key auto_increment,
    theory     double,
    practice   double,
    is_delete  boolean default false,
    student_id int,
    foreign key (student_id) references student (id),
    module_id  int,
    foreign key (module_id) references module (id)
);

-- Them du lieu vao bang Category_activity
insert into category_activity (name)
values ('Bài tập'),
       ('Bài đọc'),
       ('Bài thực hành'),
       ('Bài Giảng');
-- Them du lieu vao bang course
insert into course (name, duration)
values ('Java', '6 tháng'),
       ('PHP', '4 tháng'),
       ('Python', '5 tháng'),
       ('C#', '3 tháng');
-- Them du lieu vao bang module
insert into module (name, course_id)
values ('Java cơ bản', 1),
       ('Java nâng cao', 1),
       ('PHP cơ bản', 2),
       ('PHP nâng cao', 2),
       ('Python cơ bản', 3),
       ('Python nâng cao', 3),
       ('C# cơ bản', 4),
       ('C# nâng cao', 4);
-- Them du lieu vao bang lesson
insert into lesson (name, module_id)
values ('Tìm hiểu Java', 1),
       ('Java OOP', 1),
       ('Java Collection', 1),
       ('Java IO', 1),
       ('Java JDBC', 1),
       ('Java Servlet', 1),
       ('Java JSP', 1),
       ('Java Spring', 1),
       ('Java Hibernate', 1),
       ('Java Restful', 1),
       ('Java Security', 1),
       ('Java Design Pattern', 1),
       ('Java Unit Test', 1),
       ('Java AWS', 1),
       ('Java ELK', 1),
       ('Java Redis', 2),
       ('Java MongoDB', 2),
       ('Java Thymeleaf', 2),
       ('Java Spring MVC', 2),
       ('Java Spring Boot', 2),
       ('Java Spring Data JPA', 2),
       ('Java Spring Security', 2),
       ('Tim hiểu PHP', 3),
       ('PHP OOP', 3),
       ('PHP PDO', 3),
       ('PHP Laravel', 3),
       ('PHP CodeIgniter', 3),
       ('PHP Symfony', 3),
       ('PHP Laravel Nova', 3),
       ('PHP Laravel Sanctum', 3),
       ('PHP Laravel Livewire', 3),
       ('PHP Unit Test', 4),
       ('PHP AWS', 4),
       ('PHP ELK', 4),
       ('PHP Redis', 4),
       ('PHP MongoDB', 4),
       ('PHP Thymeleaf', 4),
       ('PHP Spring MVC', 4),
       ('PHP Spring Boot', 4),
       ('PHP Spring Data JPA', 4),
       ('PHP Spring Security', 4),
       ('Tim hiểu Python', 5),
       ('Python OOP', 5),
       ('Python Flask', 5),
       ('Python Django', 5),
       ('Python FastAPI', 5),
       ('Python Unit Test', 5),
       ('Python AWS', 5),
       ('Python ELK', 5),
       ('Python Redis', 5),
       ('Python MongoDB', 5),
       ('Python Thymeleaf', 6),
       ('Python Spring MVC', 6),
       ('Python Spring Boot', 6),
       ('Python Spring Data JPA', 6),
       ('Python Spring Security', 6),
       ('Tim hiểu C#', 7),
       ('C# OOP', 7),
       ('C# Entity Framework', 7),
       ('C# ASP.NET', 7),
       ('C# Unit Test', 7),
       ('C# AWS', 7),
       ('C# ELK', 7),
       ('C# Redis', 7),
       ('C# MongoDB', 7),
       ('C# Thymeleaf', 8),
       ('C# Spring MVC', 8),
       ('C# Spring Boot', 8),
       ('C# Spring Data JPA', 8),
       ('C# Spring Security', 8);
-- Them du liệu vào bảng activity vi dụ :bài đầu tiên lesson 1 thi co 4 activity tuong ung voi 4 category_activity,dua tren bang lesson phia tren them du lieu vao.
insert into activity (name, category_activity_id, lesson_id)
values ('Java OOP', 1, 1),
       ('Java Collection', 2, 1),
       ('Java IO', 3, 1),
         ('Java JDBC', 4, 1),
         ('Java Servlet', 1, 2),
         ('Java JSP', 2, 2),
         ('Java Spring', 3, 2),
         ('Java Hibernate', 4, 2),
         ('Java Restful', 1, 3),
         ('Java Security', 2, 3),
         ('Java Design Pattern', 3, 3),
         ('Java Unit Test', 4, 3),
         ('Java AWS', 1, 4),
         ('Java ELK', 2, 4),
         ('Java Redis', 3, 4),
         ('Java MongoDB', 4, 4),
         ('Java Thymeleaf', 1, 5),
         ('Java Spring MVC', 2, 5),
         ('Java Spring Boot', 3, 5),
         ('Java Spring Data JPA', 4, 5),
         ('Java Spring Security', 1, 6),
            ('Java Design Pattern', 2, 6),
            ('Java Unit Test', 3, 6),
            ('Java AWS', 4, 6),
            ('Java ELK', 1, 7),
            ('Java Redis', 2, 7),
            ('Java MongoDB', 3, 7),
            ('Java Thymeleaf', 4, 7),
            ('Java Spring MVC', 1, 8),
            ('Java Spring Boot', 2, 8),
            ('Java Spring Data JPA', 3, 8),
            ('Java Spring Security', 4, 8),
            ('Java Design Pattern', 1, 9),
            ('Java Unit Test', 2, 9),
            ('Java AWS', 3, 9),
            ('Java ELK', 4, 9),
            ('Java Redis', 1, 10),
            ('Java MongoDB', 2, 10),
            ('Java Thymeleaf', 3, 10),
            ('Java Spring MVC', 4, 10),
            ('Java Spring Boot', 1, 11),
            ('Java Spring Data JPA', 2, 11),
            ('Java Spring Security', 3, 11),
            ('Java Design Pattern', 4, 11),
            ('Java Unit Test', 1, 12),
            ('Java AWS', 2, 12),
            ('Java ELK', 3, 12),
            ('Java Redis', 4, 12),
            ('Java MongoDB', 1, 13),
            ('Java Thymeleaf', 2, 13),
            ('Java Spring MVC', 3, 13),
            ('Java Spring Boot', 4, 13),
            ('Java Spring Data JPA', 1, 14),
            ('Java Spring Security', 2, 14),
            ('Java Design Pattern', 3, 14),
            ('Java Unit Test', 4, 14),
            ('Java AWS', 1, 15),
            ('Java ELK', 2, 15),
            ('Java Redis', 3, 15),
            ('Java MongoDB', 4, 15),
            ('Java Thymeleaf', 1, 16),
            ('Java Spring MVC', 2, 16),
            ('Java Spring Boot', 3, 16),
            ('Java Spring Data JPA', 4, 16),
            ('Java Spring Security', 1, 17),
            ('Java Design Pattern', 2, 17),
            ('Java Unit Test', 3, 17),
            ('Java AWS', 4, 17),
            ('Java ELK', 1, 18),
            ('Java Redis', 2, 18),
            ('Java MongoDB', 3, 18),
            ('Java Thymeleaf', 4, 18),
            ('Java Spring MVC', 1, 19),
            ('Java Spring Boot', 2, 19),
            ('Java Spring Data JPA', 3, 19),
            ('Java Spring Security', 4, 19),
            ('Tìm hiểu PHP',1,20),
            ('PHP OOP',2,20),
            ('PHP PDO',3,20),
            ('PHP Laravel',4,20),
            ('PHP CodeIgniter',1,21),
            ('PHP Symfony',2,21),
            ('PHP Laravel Nova',3,21),
            ('PHP Laravel Sanctum',4,21),
            ('PHP Laravel Livewire',1,22),
            ('PHP Unit Test',2,22),
            ('PHP AWS',3,22),
            ('PHP ELK',4,22),
            ('PHP Redis',1,23),
            ('PHP MongoDB',2,23),
            ('PHP Thymeleaf',3,23),
            ('PHP Spring MVC',4,23),
            ('PHP Spring Boot',1,24),
            ('PHP Spring Data JPA',2,24),
            ('PHP Spring Security',3,24),
            ('Tim hiểu Python',4,24),
            ('Python OOP',1,25),
            ('Python Flask',2,25),
            ('Python Django',3,25),
            ('Python FastAPI',4,25),
            ('Python Unit Test',1,26),
            ('Python AWS',2,26),
            ('Python ELK',3,26),
            ('Python Redis',4,26),
            ('Python MongoDB',1,27),
            ('Python Thymeleaf',2,27),
            ('Python Spring MVC',3,27),
            ('Python Spring Boot',4,27),
            ('Python Spring Data JPA',1,28),
            ('Python Spring Security',2,28),
            ('Tim hiểu C#',3,28),
            ('C# OOP',4,28),
            ('C# Entity Framework',1,29),
            ('C# ASP.NET',2,29),
            ('C# Unit Test',3,29),
            ('C# AWS',4,29),
            ('C# ELK',1,30),
            ('C# Redis',2,30),
            ('C# MongoDB',3,30),
            ('C# Thymeleaf',4,30),
            ('C# Spring MVC',1,31),
            ('C# Spring Boot',2,31),
            ('C# Spring Data JPA',3,31),
            ('C# Spring Security',4,31);
-- them du lieu account
insert into account (username, password)
values ('admin', '$2a$10$wKRMPSqhgrme1etVLMP1hOKxGaGIQR3KJYGeryuzznUGStlFWz04S'),
       ('employee', '$2a$10$wKRMPSqhgrme1etVLMP1hOKxGaGIQR3KJYGeryuzznUGStlFWz04S'),
       ('student', '$2a$10$wKRMPSqhgrme1etVLMP1hOKxGaGIQR3KJYGeryuzznUGStlFWz04S');
insert into role (name)
values ('ADMIN'),
       ('EMPLOYEE'),
       ('STUDENT');
insert into account_role (account_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);
-- them du lieu employee_position
insert into employee_position (name)
values ('Trưởng phòng'),
       ('Nhân viên'),
       ('Giáo viên');
-- them du lieu employee
insert into employee (name, email, gender, address, phone, birth_date, image_url, salary, position_id, account_id)
values ('Admin', '123@gmail.com', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1000, 1, 1),
       ('Employee', '134@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1000, 2, 2),
       ('Teacher', '145@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1000, 3, 3);
-- them du lieu class
insert into class (name, employee_id, course_id)
values ('Java 1', 3, 1),
       ('PHP 1', 3, 2),
       ('Python 1', 3, 3),
       ('C# 1', 3, 4);
-- them du lieu student
insert into student (name, email, gender, address, phone, birth_date, image_url, class_id)
values ('Student 1', '1234@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1),
       ('Student 2', '1235@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1),
       ('Student 3', '1236@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1),
       ('Student 4', '1237@gmail', 1, 'Hà Nội', '0123456789', '1990-01-01', 'https://www.google.com', 1);
       
       
       insert into progress (status, student_id, activity_id)
values(false, 1, 1),
      (false, 1, 2),
      (false, 1, 3),
      (false, 1, 4),
      (false, 2, 1),
      (false, 2, 2),
      (false, 2, 3),
      (false, 2, 4),
      (false, 3, 1),
      (false, 3, 2),
      (false, 3, 3),
      (false, 3, 4),
      (false, 4, 1),
      (false, 4, 2),
      (false, 4, 3),
      (false, 4, 4);
      
      insert into attendance (status, note, student_id, class_id, employee_id)
values ('VANG_CO_PHEP', 'đi học muộn', 1, 1, 3),
       ('CO_MAT', 'đi học đúng giờ', 2, 1, 3),
       ('DI_MUON', 'đi học muộn', 3, 1, 3),
       ('VANG_KHONG_PHEP', 'vắng không phép', 4, 1, 3);
-- the du lieu bang score
insert into score (theory, practice, student_id, module_id)
values (80, 90, 1, 1),
       (70, 80, 2, 1),
         (60, 70, 3, 1),
         (50, 60, 4, 1);