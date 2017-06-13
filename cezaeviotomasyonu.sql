

drop database if exists cezaeviotomasyonu ;
create database if not exists cezaeviotomasyonu;

use  cezaeviotomasyonu;
create table suclar(
	id int auto_increment primary key,
	ad varchar(20),
    suc_tanimi varchar(200)
    );

create table kogus(
	id int auto_increment primary key,
	ad varchar(),
    kat int,
   	numara int,
   	binaNo int
	);
create table adres(
	id int auto_increment primary key,
	ad varchar(20),
	binaNo int,
	mahalle varchar(20)
    );

create table yemek(
	id int auto_increment primary key,
    	ad varchar(20),
    	kalori int,
		resim_yolu varchar(100),
    );
create table yemek_menu(
	id int auto_increment primary key,
	ana_yemek_id int,
	yard_yemek_id int,
	tatli_id int,
	CONSTRAINT fk_ana_yemek_id FOREIGN KEY (ana_yemek_id) REFERENCES yemek(id),
	CONSTRAINT fk_yard_yemek_id FOREIGN KEY (yard_yemek_id) REFERENCES yemek(id),
	CONSTRAINT fk_tatli_id FOREIGN KEY (tatli_id) REFERENCES yemek(id)
	);

create table rutbe(
	id int auto_increment primary key,
	rütbe_adi varchar(20)
    );
    
create table gardiyan(
	id int auto_increment primary key,
	ad varchar(20),
    tc bigint unique,
   	rutbe_id int,
    CONSTRAINT fk_rutbe_id FOREIGN KEY (rutbe_id) REFERENCES rutbe(id)
    );    
create table suclu(
	id int auto_increment primary key,
	ad varchar(20) not null,
    suc_id int,
    tc bigint unique not null,
    giris_tarih date,
    cıkıs_tarih date,
    kogus_id int,
    kan_grubu varchar(2),
    resim_yolu varchar(100),
    CONSTRAINT fk_suc_id FOREIGN KEY (suc_id) REFERENCES suclar(id),
    CONSTRAINT fk_kogus_id FOREIGN KEY (kogus_id) REFERENCES kogus(id)
    );
create table revir_kaydi(
	suclu_id int,
    doktor_adi varchar(20),
    sikayet varchar(200),
    CONSTRAINT fk_suclu_id FOREIGN KEY (suclu_id) REFERENCES suclu(id)
    
    );
create table users(
	username varchar(20),
	password varchar(200)
	);




