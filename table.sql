drop table marks;

create table marks(
	id SERIAL primary key,
	name VARCHAR(20) not null,
	maths INT not null,
	science INT not null,
	english INT not null
);