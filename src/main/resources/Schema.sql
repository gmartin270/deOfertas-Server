
    alter table OFFERS 
        drop 
        foreign key FK_ck16f5377fejk9vgpf87tivyf;

    alter table OFFER_IMAGES 
        drop 
        foreign key FK_khoh6we7m5j5tacxi2dswlbpm;

    alter table SUGGESTED_OFFERS 
        drop 
        foreign key FK_70bgc9g958vd8ek804ly7af9t;

    drop table if exists OFFERS;

    drop table if exists OFFER_IMAGES;

    drop table if exists STORES;

    drop table if exists SUGGESTED_OFFERS;

    create table OFFERS (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        DESCRIPTION varchar(255),
        FAVORITE bit not null,
        HASH_ID varchar(255) not null,
        LINK varchar(255),
        PRICE double precision not null,
        TITLE varchar(255) not null,
        STORE_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table OFFER_IMAGES (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        HASH_ID varchar(255) not null,
        IMAGE longblob not null,
        OFFER_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table STORES (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        BUSINESS_NAME varchar(255) not null,
        LOGO tinyblob,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SUGGESTED_OFFERS (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        IMAGE longblob,
        SUGGESTION_DATE datetime not null,
        OFFER_ID bigint not null,
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

    alter table SUGGESTED_OFFERS 
        add constraint FK_70bgc9g958vd8ek804ly7af9t 
        foreign key (OFFER_ID) 
        references OFFERS (ID);
