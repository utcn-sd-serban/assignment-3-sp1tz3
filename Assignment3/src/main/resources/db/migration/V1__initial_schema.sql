create table if not exists user(
    userId int auto_increment,
    username varchar(32) not null,
    password varchar(100) not null,
    primary key (userid)
);

create table if not exists question(
    questionId int auto_increment,
    userId int,
    title varchar(32) not null,
    text varchar(100) not null,
    creationDate datetime not null,
    primary key (questionid)
);

create table if not exists tag(
    tagId int auto_increment,
    title varchar(32) not null,
    primary key (tagid)
);

create table if not exists answer(
    answerId int auto_increment,
    questionId int,
    userId int,
    text varchar(100) not null,
    creationDate datetime not null,
    primary key (answerid)
);

create table if not exists question_tag(
    id int auto_increment,
    tagId int,
    questionId int,
    primary key (id)
);

alter table question
add foreign key (userId) references user(userId);

alter table answer
add foreign key (questionId) references question(questionId);

alter table answer
add foreign key (userId) references user(userId);