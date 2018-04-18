# Product_Spring_Boot
Project for Products in Spring Boot

Hi,

To run the project, Please follow the instructions: 

1) Install Spring Tool Suite from Eclipse Market Place to install Spring Boot since this application runs on Spring Boot.

Instructions on how to install within the IDE: http://www.codejava.net/ides/eclipse/install-spring-tool-suite-for-existing-eclipse-ide

2) Import the project onto your eclipse IDE

Right Click on Package Explorer->Import->Maven->Import Existing Maven Projects

3) Once project is successfully imported, Right click on the project as Spring Boot App

4) Once the app is successfully deployed in the spring boot container, We can test it by hitting the following endpoint :

localhost:8080/restws/productservice/products

Note: To test this Project, We would also need to create a Database in MySQL since we use it to retrieve products.

We can create by executing the following script: 

CREATE TABLE `products` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8

5) Once Table is created, We can populate few rows for testing

insert into products(name,description,cost) values("Apple", "Smartphone", 1100);
insert into products(name,description,cost) values("Samsung", "TV", 1600);
insert into products(name,description,cost) values("Nvidia", "Graphics", 2000);

