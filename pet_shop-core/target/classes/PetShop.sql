set names utf8;
drop database if exists petshop;
create database petshop character set utf8;

use petshop;

create table roles (
	id integer not null primary key,
    role_name varchar(15)  not null unique
); 
create table users(
	id integer not null primary key auto_increment,
    
    name varchar(20) not null,
    
    surname varchar(20) not null,
    
    pass varchar(30) not null,
        
    phone varchar(20) not null ,
    
    email varchar(30) not null unique,
    
    role_id integer not null default 0, 
	foreign key (role_id) references roles(id)
    on delete cascade
    on update restrict
    
); 

create table pets(
	id integer not null primary key,
    name varchar(15) not null unique
);

create table type_product(
	id integer not null primary key,
    name varchar(20) not null unique
);

create table products (
	id integer not null primary key auto_increment,
    name varchar(50) not null unique,
    price integer not null check (price>0),
    description text not null,
    amount integer not null check (price>0),
    weight integer not null check (price>0),
    producer varchar(30) not null,
    type_id integer not null,
    age varchar(20) default null,
    breed varchar(50) default null,
    pet_id integer not null,
    photo_link text not null,
    foreign key (pet_id) references pets(id)
    on delete cascade
    on update restrict,
	foreign key (type_id) references type_product(id)
    on delete cascade
    on update restrict
);

create table orders(
	id integer not null primary key auto_increment,
    user_id integer not null,
    product_id integer not null,
    count_product integer not null,
    foreign key (user_id) references users(id)
    on delete cascade
    on update restrict,
    foreign key (product_id) references products(id)
    on delete cascade
    on update restrict
    
);

insert into roles values(0, "user");
insert into roles values(1, "admin");

insert into pets values(0, "dog");
insert into pets values(1, "cat");
insert into pets values(2, "rodent");
insert into pets values(3, "fish");
insert into pets values(4, "bird");

insert into type_product values(0, "main food");
insert into type_product values(1, "medicinal feed");
insert into type_product values(2, "goodies");
insert into type_product values(3, "canned food");

insert into users values(default, "Maksim", "Kordonets", "qwerty", "0969055386", "kordonetsmax@gmail.com",1 );
insert into users values(default, "Valera", "Prigozhin", "12345", "0689978788", "valera@gmail.com", 0);
insert into users values(default, "Philip", "Kirkorov", "Zvezda1", "7080808808", "kizkirov@mail.ru",0);
insert into users values(default, "Nikola", "Baskov", "ItsIZvezda1", "711111111", "NatureBlondin@yandex.ru", 0);
insert into users values(default, "Egor", "Krid", "blackIsBack", "712222222", "iaNeVBlackStar@gmail.com",0);
insert into users values(default, "Sviat", "Vakarchyk", "IaNeZdamsiaBezBoiu", "8069938456", "GazDliaNaselennia@meta.ua", 0);


insert into products values(default, "Yorkshire Terrier Junior", 130, "Здоровая шерсть
Эксклюзивная формула рациона поддерживает здоровье кожи и красоту длинной шерсти Йоркширского терьера. Корм обогащен Омега-3 (ЭПК и ДГК) и Омега-6 жирными кислотами, маслом бурачника и биотином.
Здоровое пищеварение
Рацион обеспечивает поддержку здорового пищеварения и поддерживает баланс микрофлоры кишечника.
Поддержание естественных механизмов защиты
Корм позволяет обеспечить естественную защиту организма щенка йоркширского терьера.
Специальная крокета
Размер, форма, текстура крокет способствует легкому захватыванию корма и его разгрызанию. Помогает ограничить образование зубного камня.", 
5, 500, "Royal Canin", 0, "для щенят", "Індивідуально для породи", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRiaDeaAb2v2QPzep1ZFsuK5Xh4UuBodrTGSqDyJzUdEO103HpkfOyCPOtlOvcmxTXES0tyyN8&usqp=CAc");
insert into products values(default, "Plan Puppy Small", 163, "Помогает развивающейся иммунной системе щенка действовать эффективно. Особое сочетание компонентов для здоровья зубов и десен. Сочетание основных питательных веществ, которое помогает поддерживать здоровье суставов вашего щенка при активном образе жизни. В состав корма входит специальный компонент для укрепления иммунитета и здоровья на долгие годы. Содержит кусочки высококачественного куриного мяса.
Первый год жизни вашей собаки имеет решающее значение для ее здоровья в дальнейшем. Чтобы помочь укрепить естественную защиту щенков в начале жизни, ветеринары и диетологи Purina разработали корм Purina PRO PLAN Puppy с комплексом OPTISTART. Комплекс OPTISTART, в состав которого входит особый ингредиент молозиво — первичное молоко матери, богатое природными антителами, помогает укрепить естественную защиту щенков для борьбы с ежедневными проблемами.",
10, 500, "Purina", 0, "для щенят", "Індивідуально для породи", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6v5YjIzeLZyHKtj4XBSUn8n35tpF4nHkJAvxOHNDjiVWvF1PKUPHijQ9oFCc&usqp=CAc");
insert into products values(default, "Whiskas", 100, "З яловичиною, повнораціонний сухий корм для дорослих котів", 
20, 300, "whiskas", 0, "від 1 року", "для всіх", 1, "https://my-test-11.slatic.net/p/1d4fd3cf36fcc033461fe5fbb5b4d7a1.jpg_340x340q80.jpg_.webp");
insert into products values(default, "Vitakraft Menu Vital", 77, "Основной сбалансированный корм для ежедневного питания кроликов. Обеспечивает грызунов всеми необходимыми витаминами и минералами, а также отвечает их природному рациону в естественной среде обитания.",
30, 500, "Vitakraft", 0, "для будь-якого віку", default, 2, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS-DvnL70TmdvaLBh7tz6_GugT7KNNbd643Cd6TxgAcu_xFdx7y&usqp=CAU");
insert into products values(default, "Природа Колосок", 21, "Витаминизированное лакомство в виде подвесной палочки с фруктами и овощами для волнистых попугаев. Дополняет диету домашних питомцев, значительно обогащая их обычный рацион в условиях содержания в неволе.",
50, 140, "Природа", 2, default, default, 4,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTGdACdyCs4VmpJTY4-Q9yGxBr7AxVW9MBfRG-cdF-uL2bS1Tii&usqp=CAU");
insert into products values(default, "TetraMin", 86, "Основной корм для ежедневного питания аквариумных тропических рыб. Представляет собой тщательно подобранную смесь функциональных ингредиентов с витаминами, минералами и микроэлементами. Содержит более 40 видов высококачественного сырья, обеспечивает рыбам чистую воду и укрепляет их иммунную систему.",
30, 100, "TetraMin", 1, default, default, 3, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSm5Aqd5BeDHX67vzKurrv-zz4OAtPxO6PAyXo6je2_A8HP5Efl&usqp=CAU");

insert into orders values(default, 1, 1, 3);
insert into orders values(default, 2, 2, 8);
insert into orders values(default, 3, 3, 15);
insert into orders values(default, 4, 4, 23);
insert into orders values(default, 5, 5, 37);

