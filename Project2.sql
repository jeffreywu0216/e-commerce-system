CREATE TABLE USERS(
    USERID NUMBER,
    EMAIL VARCHAR2(32) UNIQUE NOT NULL,
    PASSWORD VARCHAR2(32) NOT NULL,
    STREET VARCHAR2(128),
    CITY VARCHAR2(64),
    STATE VARCHAR2(32),
    PHONE NUMBER,
    CREDITCARD NUMBER,
    USERROLE VARCHAR2(16) NOT NULL,
    CONSTRAINT PK_USERID PRIMARY KEY (USERID)
);

CREATE TABLE ITEMS(
    ITEMID NUMBER,
    SELLERID NUMBER,
    BUYERID NUMBER,
    PRODUCTNAME VARCHAR2(64) NOT NULL,
    DESCRIPTION VARCHAR2(128),
    PRICE NUMBER NOT NULL,
    TIMETOSELL DATE NOT NULL,
    STATUSID NUMBER NOT NULL,
    CONSTRAINT PK_ITEMID PRIMARY KEY (ITEMID)
);

ALTER TABLE ITEM MODIFY PRODUCTNAME VARCHAR2(128);

CREATE TABLE PICTURE(
    PICTUREID NUMBER,
    ITEMID NUMBER NOT NULL,
    PICTUREURL VARCHAR2(128),
    CONSTRAINT PK_PICTUREID PRIMARY KEY (PICTUREID)
);

CREATE TABLE ITEMSTATUS(
    STATUSID NUMBER,
    STATUS VARCHAR2(128),
    CONSTRAINT PK_STATUSID PRIMARY KEY (STATUSID)
);

CREATE TABLE PRODUCTREVIEW(
    PRODUCTREVIEWID NUMBER,
    ITEMID NUMBER NOT NULL,
    PRODUCTREVIEW VARCHAR2(256),
    CONSTRAINT PK_PRODUCTREVIEW PRIMARY KEY (PRODUCTREVIEWID)
);

CREATE TABLE USERREVIEW(
    USERREVIEWID NUMBER,
    USERID NUMBER NOT NULL,
    USERREVIEW VARCHAR2(256),
    CONSTRAINT PK_USERREVIEWID PRIMARY KEY (USERREVIEWID)
);

CREATE TABLE SHOPPINGCART(
    SHOPPINGCARTID NUMBER,
    BUYERID NUMBER,
    ITEMID NUMBER,
    CONSTRAINT PK_SHOPPINGCARTID PRIMARY KEY (SHOPPINGCARTID)
);

ALTER TABLE ITEM ADD CONSTRAINT FK_SELLERID FOREIGN KEY (SELLERID) REFERENCES 
USERS(USERID);
ALTER TABLE ITEM ADD CONSTRAINT FK_BUYERID FOREIGN KEY (BUYERID) REFERENCES 
USERS(USERID);
ALTER TABLE ITEM ADD CONSTRAINT FK_STATUSID FOREIGN KEY (STATUSID) REFERENCES ITEMSTATUS(STATUSID);
ALTER TABLE PICTURE ADD CONSTRAINT FK_ITEMID FOREIGN KEY (ITEMID) REFERENCES ITEMS(ITEMID);
ALTER TABLE PRODUCTREVIEW ADD CONSTRAINT FK_ITEMIDPV FOREIGN KEY (ITEMID) REFERENCES ITEMS(ITEMID);
ALTER TABLE SHOPPINGCART ADD CONSTRAINT FK_BUYERIDSC FOREIGN KEY (BUYERID) REFERENCES USERS(USERID);
ALTER TABLE SHOPPINGCART ADD CONSTRAINT FK_ITEMIDSC FOREIGN KEY (ITEMID) REFERENCES ITEMS(ITEMID);
ALTER TABLE USERREVIEW ADD CONSTRAINT FK_USERID FOREIGN KEY (USERID) REFERENCES USERS (USERID);
ALTER TABLE USERS MODIFY USERROLE DEFAULT 'user';

CREATE SEQUENCE userCount
START WITH 1
INCREMENT BY 1
MAXVALUE 5000
CACHE 5
CYCLE;
/

CREATE OR REPLACE TRIGGER beforeUserInsert
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN
    :new.USERID:=usercount.nextval;
END;
/


CREATE SEQUENCE itemCount
START WITH 1
INCREMENT BY 1
MAXVALUE 500000
CACHE 10
CYCLE;
/

CREATE SEQUENCE productReviewCount
START WITH 1
INCREMENT BY 1
MAXVALUE 500000
CACHE 10
CYCLE;
/

CREATE OR REPLACE TRIGGER beforeItemInsert
BEFORE INSERT ON ITEMS
FOR EACH ROW
BEGIN
    :new.itemid:=itemcount.nextval;
END;
/

insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('sdonnison0@gmpg.org', 'LUzL7e0B', '3572 Laurel Plaza', 'Saint Louis', 'Missouri', '6362836734', '560224799148024730', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('jklimontovich1@phoca.cz', 'PvTqfbF', '901 8th Park', 'Springfield', 'Illinois', '2174015865', '3571839188170215', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('cposse2@utexas.edu', 'BdRkc6kHzM', '9300 Brentwood Road', 'Tulsa', 'Oklahoma', '9182737093', '4905901133878790', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('yjansa3@ow.ly', 'MBMN78B4EqE', '7212 Sachtjen Terrace', 'Delray Beach', 'Florida', '5619962319', '6759099469810209712', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('hcrosthwaite4@prnewswire.com', 'RGf8rjOU1w7', '24 Claremont Point', 'Milwaukee', 'Wisconsin', '4145841034', '3530495624019241', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('aivakhnov5@apache.org', 'd0j3o0', '9 Corben Road', 'El Paso', 'Texas', '9159216500', '337941670709327', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('tcansfield6@bloglines.com', 'B0s6Su8Ir2Jo', '49023 Eastlawn Junction', 'Manchester', 'New Hampshire', '6034283165', '6334465701915769176', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('astreet7@accuweather.com', 'rMXOw7AI0', '35 Magdeline Alley', 'Mc Keesport', 'Pennsylvania', '4122656365', '5020470619462101370', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('fshowt8@reference.com', 'HOmOBJU02j', '3484 Messerschmidt Circle', 'Tulsa', 'Oklahoma', '9181810635', '5460212130176186', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('bspriddle9@google.es', 'DA63SF', '0 West Place', 'Raleigh', 'North Carolina', '9199260934', '4244166154419', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('dwallbrooka@foxnews.com', 'Dw5Fu073', '346 Merrick Road', 'Providence', 'Rhode Island', '4014838195', '5595008815299923', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('adumbrallb@un.org', 'Y6W5q2', '530 Colorado Alley', 'Birmingham', 'Alabama', '2053278588', '5602232290118652', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('cboysec@storify.com', '1grOa7uZysQ', '86272 Ohio Junction', 'Phoenix', 'Arizona', '6024601332', '3582366514411995', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('klibbisd@free.fr', 'cP4Oi53HXoI', '44619 Sauthoff Park', 'Tacoma', 'Washington', '2532833544', '4026314419380545', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('oadamee@phpbb.com', 'vyzsFa0P453e', '3 Stone Corner Hill', 'Fayetteville', 'North Carolina', '9107518193', '5048370194096269', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('cwalmsleyf@bing.com', 'zOKYXQt', '555 Nobel Avenue', 'Saint Louis', 'Missouri', '3148806270', '3557819642031318', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('tosipovg@reuters.com', '4AGS1i', '39585 School Road', 'Tallahassee', 'Florida', '8506760208', '5007664592588961', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('eclewlowh@tinyurl.com', 'IXPxvm0qyw2', '86454 Daystar Junction', 'Lincoln', 'Nebraska', '4028789015', '3587612368601073', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('cstolleryi@cbslocal.com', 'LitsUEX3VDKx', '5 Muir Hill', 'Valley Forge', 'Pennsylvania', '4843872933', '201957969352242', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('mbartlej@irs.gov', 'SqQ5Fj74', '9 Roxbury Plaza', 'Portland', 'Oregon', '5038064623', '5505509731277819', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('dceeleyk@google.de', '7TAZdB8', '804 Knutson Lane', 'Galveston', 'Texas', '2817746757', '3538627764597956', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('wmattssonl@blogtalkradio.com', 'MlOjZg2n', '738 Bonner Lane', 'Berkeley', 'California', '5108846191', '6709364121017504', 'admin');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('mparringtonm@xrea.com', 'dHWKZo5T', '6538 Spohn Parkway', 'Lansing', 'Michigan', '5178225558', '3547383771634544', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('jbrignalln@oakley.com', 'UIKblLl', '62705 Warner Road', 'Minneapolis', 'Minnesota', '7637903971', '6767450280950855', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('agudemano@auda.org.au', '8kPrKjne', '649 Center Terrace', 'Los Angeles', 'California', '5622982168', '5100135261799185', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('cedmundsonp@w3.org', '1keED2T9Ghl', '30101 Briar Crest Terrace', 'El Paso', 'Texas', '9159150928', '6395032232294382', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('mhimsworthq@ehow.com', 'haLwIvk', '89 Anthes Avenue', 'Pittsburgh', 'Pennsylvania', '4128274764', '4413454259324582', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('dlorainr@wired.com', 'Ws4sezB', '21 Towne Trail', 'Baltimore', 'Maryland', '4108243134', '3570903287243298', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('trainys@google.fr', 'EKh2UdIDcDkp', '9 Mandrake Alley', 'Atlanta', 'Georgia', '4042823807', '3562627971380815', 'user');
insert into USERS (email, password, Street, City, State, phone, creditcard, userrole) values ('bjocict@yahoo.com', 'gPsZPc', '79929 Russell Point', 'Los Angeles', 'California', '3235207221', '3547977917940184', 'admin');
