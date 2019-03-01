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
created_by varchar(200) DEFAULT 'SYS_ADMIN', 
update_by varchar (200) DEFAULT 'SYS_ADMIN', 
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS TokenSystem.counter 
(id integer AUTO_INCREMENT PRIMARY KEY,
service_id integer ,
type ENUM('PREMIUM','REGULAR') DEFAULT 'REGULAR',
is_available boolean,
created_by varchar(200) DEFAULT 'SYS_ADMIN',
update_by varchar (200) DEFAULT 'SYS_ADMIN',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (service_id)
REFERENCES TokenSystem.services (id))ENGINE InnoDB;



CREATE TABLE IF NOT EXISTS TokenSystem.token 
(id integer AUTO_INCREMENT PRIMARY KEY,
token_no varchar(20) NOT NULL,
counter_id integer NOT NULL,
customer_id integer NOT NULL,
status ENUM('OPEN','COMPLETED','CANCELLED') DEFAULT 'OPEN',
comment TEXT,
created_by varchar(200) DEFAULT 'SYS_ADMIN',
update_by varchar (200) DEFAULT 'SYS_ADMIN',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (counter_id) REFERENCES TokenSystem.counter (id),
FOREIGN KEY (customer_id) REFERENCES TokenSystem.customer(id)
)ENGINE InnoDB;