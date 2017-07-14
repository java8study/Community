create table if not exists sample (
id long not null auto_increment,
userId varchar(45) not null,
userPwd varchar(80) not null,
userName varchar(45) not null,
email varhcar(80) not null
)

insert into sample(userId,userPwd,userName,email) values('A','A','A','A@naver.com'); 
insert into sample(userId,userPwd,userName,email) values('B','B','B','B@naver.com'); 
insert into sample(userId,userPwd,userName,email) values('C','C','C','C@naver.com'); 