use tommy;

create table food(
    code int(4) primary key,
   name varchar(50),
   supportpereat float(10),
   calory float(10),
   carbo float(10),
   protein float(10),
   fat float(10),
   sugar float(10),
   natrium float(10),
   chole float(10),
   fattyacid float(10),
   transfat float(10),
   maker varchar(30),
   material varchar(500),
   img varchar(100)
);

select * from food;