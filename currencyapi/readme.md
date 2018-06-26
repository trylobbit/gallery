
Create mysql-DB:

1. create user
2. mysql -u username -p
3. mysql> CREATE DATABASE yourdatabasename ;
4. mysql> SHOW DATABASES;
5. mysql> USE yourdatabasename; 
3. a) mysql> SOURCE {yourpath}/solsoft/praktyki/database.sql
    or
   b) copy script from database.sql and paste to terminal

Modify application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabasename
spring.datasource.username= yourusername
spring.datasource.password=yourpassword

Run project:
1. cd praktyki 
2. mvn clean install
3. cd mvc
4. mvn spring-boot:run




