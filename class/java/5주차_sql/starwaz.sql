use tommy;
create table starwars(episodeid int(5),
episodename varchar(50),
openyear int(5));
create table characters(characterid int(5),
charactername varchar(30),
masterid int(5),
roleid int(5),
email varchar(40));
create table casting(episodeid int(5),
characterid int(5),
realname varchar(30));
create table roles(roleid int(5),
rolename varchar(30));
insert into roles values(1001,'제다이');
insert into roles values(1002,'시스');
insert into roles values(1003,'반란군');
alter table starwars
add constraint starwars_pk primary key(episodeid);
alter table characters
add constraint characters_pk primary key(characterid);
alter table roles
add constraint roles_pk primary key(roleid);
alter table casting
add constraint casting_pk primary key(episodeid, characterid);
alter table casting 
add constraint casting_fk_c foreign key(characterid)
references characters(characterid);
alter table casting 
add constraint casting_fk_e foreign key(episodeid)
references starwars(episodeid);
alter table characters
add constraint characters_fk foreign key(roleid)
references roles(roleid);