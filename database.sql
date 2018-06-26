
create table roles (
        id INT(11) not null AUTO_INCREMENT,
        role VARCHAR(255)
        );
        create table users(
        id INT(11) NOT NULL AUTO_INCREMENT UNIQUE,
        name VARCHAR(25) NOT NULL ,
        mail VARCHAR(25) NOT NULL,
        password CHAR(60) NOT NULL ,
        date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );
        alter TABLE users ADD PRIMARY KEY (id);
        alter TABLE roles ADD PRIMARY KEY (id);

        CREATE TABLE user_role (
        user_id INT(11),
        role_id INT(11) DEFAULT 1
        );
        ALTER TABLE user_role ADD PRIMARY KEY (user_id,role_id);
        ALTER TABLE user_role ADD CONSTRAINT FK_UserRoleUser FOREIGN KEY (user_id) REFERENCES users(id);
        ALTER TABLE user_role ADD CONSTRAINT FK_UserRoleRole FOREIGN KEY (role_id) REFERENCES roles(id);

        INSERT INTO roles (id, role) VALUES (1,"USER");
        INSERT INTO roles (id, role) VALUES (2,"ADMIN");

        CREATE TABLE product (
        id bigint(20) NOT NULL AUTO_INCREMENT,
        amount int(11) DEFAULT NULL,
        available int(11) DEFAULT NULL,
        name varchar(255) DEFAULT NULL,
        price decimal(19,2) DEFAULT NULL,
        type int(11) DEFAULT NULL
        );
        ALTER TABLE product ADD PRIMARY KEY (id);



