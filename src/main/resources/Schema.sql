
    alter table OFFERS 
        drop 
        foreign key FK_ck16f5377fejk9vgpf87tivyf;

    alter table OFFER_IMAGES 
        drop 
        foreign key FK_khoh6we7m5j5tacxi2dswlbpm;

    drop table if exists OFFERS;

    drop table if exists OFFER_IMAGES;

    drop table if exists STORES;

    create table OFFERS (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        DESCRIPTION varchar(255) not null,
        FAVORITE bit not null,
        HASH_ID varchar(255) not null,
        PRICE double precision not null,
        STORE_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table OFFER_IMAGES (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        HASH_ID varchar(255) not null,
        IMAGE tinyblob not null,
        OFFER_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table STORES (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        BUSINESS_NAME varchar(255) not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table OFFERS 
        add constraint FK_ck16f5377fejk9vgpf87tivyf 
        foreign key (STORE_ID) 
        references STORES (ID);

    alter table OFFER_IMAGES 
        add constraint FK_khoh6we7m5j5tacxi2dswlbpm 
        foreign key (OFFER_ID) 
        references OFFERS (ID);
