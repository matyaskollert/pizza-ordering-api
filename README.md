# Pizza Ordering API (Software Engineering Methods)

## Introduction
This repository is a Pizza Ordering API backand that uses Java, Gradle and Spring Boot. It uses microservices
as its underlying architecture and takes advantage of Spring Security to make sure everything works securely.
The authentication is done using Java Web Tokens that grant you access to specific endpoints

## Overview

This project contains three microservices:
- authentication-microservice
- order-microservice
- menu-microservice

The `authentication-microservice` is responsible for authenticating and registering users. It also handles all
allergen information for customer, as well as the store id information for store owners.

The `order-microservice` is responsible for creating, editing, viewing, and canceling orders. On top of that this microservice
handles coupons, such as applying and creating a coupon, and stores, such as adding and viewing stores.

The `menu-microservice` contains all information and actions regarding the menu of the stores, such as adding
toppings and products, and viewing the menu.

## Installing

To use this repository, you need to first install Gradle
To build the project, run `gradle build`
To run the project, we used IntelliJ and the Services tabs which allowed us to run each microservice separately

## Running the microservices

We have several endpoints for each microservice. We are attaching a 
[postman collection](https://api.postman.com/collections/24609742-2815f8bb-6f01-491e-a9cf-a35bc44bc278?access_key=PMAT-01GKPYY8R4BCDHG7KWWQGWSN3S)
 that, when imported in postman, will have all of the relevant endpoints and their bodies. For more information on the endpoints
and the bodies that are associated to them, please look at the controllers for each microservice and their corresponding models.

## Populating Databases

The Stores, Products, and Toppings tables can be automatically populated using Jackson Populator. These tables can of
course also be populated manually. Population is not done by default
because since our databases persist, population must only be run once and then not again. If they are run several times with the
database persisting an error will be thrown since the database must be populated with unique entries.

To configure correctly, go to the H2-Config file of the corresponding microservice and uncomment the Jackson populator code,
as well as the imports for it. After that microservice has been run once, comment the code again. 

## Configuring Databases

Our databases are persistent, meaning they don't get wiped when the program is restarted. If it is desired that the database
is wiped, and thus does not persist, go to the application-dev.properties file in the resources folder of the microservice,
and change the spring.jpa.hibernate.ddl-auto field from 'update' to 'create'.

The databases should be configured automatically once the program is started. However, in the instance that the program
throws an SQL error about tables not being found, the tables are not configured properly. To fix this, change the database
from 'update' to 'create', as described in the above paragraph. 
