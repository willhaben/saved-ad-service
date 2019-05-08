create table advert_folder
(
    folder_id long primary key auto_increment,
    user_id   long,
    folder_name varchar
);


insert into advert_folder (folder_id, user_id, folder_name)
values (1, 1, 'name1');
insert into advert_folder (folder_id, user_id, folder_name)
values (2, 1, 'name2');
insert into advert_folder (folder_id, user_id, folder_name)
values (3, 1, 'name2');

create table advert_folder_item
(
    item_id     long primary key auto_increment,
    ad_id       long,
    title       varchar,
    description varchar,
    price       long,
    location    varchar,
    image_url   varchar,
    folder_id   long
);


insert into advert_folder_item (ad_id, title, description, price, location, image_url, folder_id)
values (1, 'test', 'desc', 1000, 'Wien', 'http://', 1);

insert into advert_folder_item (ad_id, title, description, price, location, image_url, folder_id)
values (1, 'test', 'desc', 1000, 'Wien', 'http://', 1);

insert into advert_folder_item (ad_id, title, description, price, location, image_url, folder_id)
values (1, 'test', 'desc', 1000, 'Wien', 'http://', 2);