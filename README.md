# tokening-system

Spring Boot, MySQL, JPA, Hibernate , Junit5 , Swagger,flyway Rest API Tutorial

Build Restful  API for Bank Tokening-System using Spring Boot, Mysql, JPA and Hibernate. Requirements

Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

Steps to Setup

    Clone the application

git clone https://github.com/AkhileshPandey300/tokening-system.git

    Create Mysql database

create database "TokenSystem"

    Change mysql username and password as per your installation

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation.
    
    Table Schema used:
    
CREATE TABLE IF NOT EXISTS TokenSystem.customer 
(id integer AUTO_INCREMENT PRIMARY KEY,
name varchar(100) ,
mobile varchar(100) ,
address TEXT,
type varchar(20) ,
created_by varchar(200) DEFAULT 'SYS_ADMIN', 
update_by varchar (200) DEFAULT 'SYS_ADMIN', 
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
INDEX (MOBILE)
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS TokenSystem.services 
(id integer AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) ,
is_multi boolean,
type ENUM('PREMIUM','REGULAR') DEFAULT 'REGULAR',
created_by varchar(200) DEFAULT 'SYS_ADMIN', 
update_by varchar (200) DEFAULT 'SYS_ADMIN', 
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS TokenSystem.counter 
(id integer AUTO_INCREMENT PRIMARY KEY,
is_available boolean,
created_by varchar(200) DEFAULT 'SYS_ADMIN',
update_by varchar (200) DEFAULT 'SYS_ADMIN',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE InnoDB;


CREATE TABLE IF NOT EXISTS TokenSystem.token 
(id integer AUTO_INCREMENT PRIMARY KEY,
token_no varchar(20) NOT NULL,
counter_id integer NOT NULL,
customer_id integer NOT NULL,
service_id integer NOT NULL,
status ENUM('OPEN','COMPLETED','CANCELLED') DEFAULT 'OPEN',
comment TEXT,
created_by varchar(200) DEFAULT 'SYS_ADMIN',
update_by varchar (200) DEFAULT 'SYS_ADMIN',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (counter_id) REFERENCES TokenSystem.counter (id),
FOREIGN KEY (customer_id) REFERENCES TokenSystem.customer(id),
FOREIGN KEY (service_id) REFERENCES TokenSystem.services(id)
)ENGINE InnoDB;


CREATE TABLE IF NOT EXISTS TokenSystem.admin
(id integer auto_increment primary key ,
name varchar(50) ,
role enum('MANAGER','OPERATOR','OTHER') default 'OPERATOR'
);


     Build and run the app using maven

mvn package java -jar target/tokening-system-1.0.0.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at http://localhost:8888/Tokening. Explore Rest APIs

The app defines following End Points.

POST /customers

POST /services

GET /counters

PUT /counters/{counterId}

POST /tokens/{mobile}/{serviceId}

GET /counters/{counterId}/tokens

PUT /counters/tokens/{adminId}/{tokenId}

You can test them using postman or you can use swagger interface at given URL.

http://localhost:8888/Tokening/swagger-ui.html#

