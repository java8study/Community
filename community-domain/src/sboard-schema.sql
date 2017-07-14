create table tbl_board (
 bno INT NOT NULL AUTO_INCREMENT,
 title VARCHAR(200) NOT NULL,
 content TEXT NULL,
 writer VARCHAR(50) NOT NULL,
 regdate TIMESTAMP NOT NULL DEFAULT now(),
 viewcnt INT DEFAULT 0,
 PRIMARY KEY (bno));


create table tbl_reply (
rno int NOT NULL AUTO_INCREMENT,
bno int not null default 0,
replytext varchar(1000) not null,
replyer varchar(50) not null,
regdate TIMESTAMP NOT NULL DEFAULT now(),
updateDt TIMESTAMP NOT NULL DEFAULT now(),
primary key(rno)
);