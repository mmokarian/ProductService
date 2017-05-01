 --------------------------------
 --        create tables
 --------------------------------
CREATE TABLE  product (
    id             INTEGER NOT NULL AUTO_INCREMENT,
    name           VARCHAR(30),
    price          DOUBLE PRECISION,
    description   TEXT,
    PRIMARY KEY (id)
     );

CREATE TABLE user (
    id             INTEGER NOT NULL AUTO_INCREMENT,
    username       VARCHAR(30),
    password       VARCHAR(50),
    PRIMARY KEY (id)
 );

 CREATE TABLE cart (
    id        INTEGER NOT NULL AUTO_INCREMENT,
    productid     INTEGER NOT NULL,
    userid        INTEGER NOT NULL,
    PRIMARY KEY (id)
 );
