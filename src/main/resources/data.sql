insert into Location(id,name) values (1,'Tashkent');
insert into Location(id,name) values (2,'Shoshkent');
insert into Location(id,name) values (3,'Boshkent');

insert into User(id,firstname,lastname,email,locationid) values (1,'Husanboy','Tuychiyev','husan@gmail.com',1);
insert into User(id,firstname,lastname,email,locationid) values (2,'Hasanboy','Tuychiyev','hasan@gmail.com',1);
insert into User(id,firstname,lastname,email,locationid) values (3,'Husain','Tuychiyev','husain@gmail.com',1);

insert into Post(id,post_date,details,userid) values (1,CURRENT_TIMESTAMP(),'Dont forget why you start',1);
insert into Post(id,post_date,details,userid) values (2,CURRENT_TIMESTAMP(),'Stop when you achieve',1);
insert into Post(id,post_date,details,userid) values (3,CURRENT_TIMESTAMP(),'Keep trying',3);
