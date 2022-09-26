# 🚖 <a href="https://servlets-taxi.herokuapp.com/">**TAXI-SERVICE (web servlets)**</a> 🚖

##  Description
Very simplified application of the taxi service.

##  Project structure
**The project has an N-Tier Architecture**
- Controller layer - allows to user to work with this application through browser.
- Service layer - is responsible for the business logic of the application.
- DAO layer - is responsible for communicating with the database.

## Features
- register a new driver

![driver_register](https://user-images.githubusercontent.com/16079430/192092248-a058db57-f5a6-4cf4-b8b8-36237d45f158.jpg)

- authentication

![login](https://user-images.githubusercontent.com/16079430/192093492-71ab79c8-2709-4d05-a4f6-3ab880776bfa.jpg)

- display list of all manufacturers, create, update, delete manufacturers

![manufacturer_create](https://user-images.githubusercontent.com/16079430/192093849-16c9f2d3-ccdd-4c5c-b182-50f523776062.jpg)

![manufacturers](https://user-images.githubusercontent.com/16079430/192092254-ee54c328-d03a-4643-a786-236cbca1c9b4.jpg)

- display list of all cars, create, update, delete cars

![car_create](https://user-images.githubusercontent.com/16079430/192092246-13389277-2675-4a2e-916d-6d40dfa61470.jpg)

![cars](https://user-images.githubusercontent.com/16079430/192092247-029cfbbb-b27d-47e0-9d21-ebfabaa5d85d.jpg)

- add driver to car / remove driver from car

![car_drivers_can_add](https://user-images.githubusercontent.com/16079430/192093125-dfec9663-e944-4569-9aef-5214cfe88f8b.jpg)

![car_drivers_add_full_can_not_add](https://user-images.githubusercontent.com/16079430/192093123-5a69ff65-8206-40db-b29d-36af6d49eccf.jpg)

![car_drivers_add_empty_can_add](https://user-images.githubusercontent.com/16079430/192093124-35075e02-12ad-4437-97cd-ee3d0be1a25f.jpg)

- display list of all drivers, cars of current driver

![drivers](https://user-images.githubusercontent.com/16079430/192092250-e7531aa3-5e02-4789-afba-0eca8101b900.jpg)

![my_cars](https://user-images.githubusercontent.com/16079430/192093495-5e0641fc-531f-47e1-823c-6247fd5057e7.jpg)

## Technologies
- Java 11
- Maven
- MySQL
- JDBC
- Tomcat v9.0.50
- JSP

## Quickstart
1. Fork this repository
2. Copy link of project
3. Create new project from Version Control
4. Edit ConnectionUtil.class - set the necessary parameters
``` java
    private static final String URL = "URL";
    private static final String USERNAME = "USERNAME"; 
    private static final String PASSWORD = "PASSWORD";
    private static final String JDBC_DRIVER = "JDBC_DRIVER";
```
5. Create the necessary tables in your database using the file init_db.sql
6. Install [Tomcat](https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.50/bin/)
7.  Configure Tomcat in your IDEA

![config](https://user-images.githubusercontent.com/16079430/192093121-3b7b7e06-a758-4e98-b425-deaf35e2c419.jpg)
 
8. Run project

##  <a href="https://servlets-taxi.herokuapp.com/">**The link of this project on Heroku**</a>
