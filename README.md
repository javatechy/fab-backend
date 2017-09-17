# fab-backend
This project is backend of the fab wallet system.

web UI for this project is:

https://github.com/javatechy/fab-ui

This application uses maven as build tool and MySQL as database.

Assumptions:
-----------------------------

Assuming following softwares are installed on your machine:
 * Java 8 is installed
 * Port 8080 is empty , if not please change server.port property in `application.properties` in `src/main/resources`
 * MySQL is installed on the machine on port 3306(default port), if not please change port in application.properties[src/main/resources]
 * DB credentials are same as mentioned in `application.properties`


Running the application
-----------------------------
Follow these steps to run this project:

#### Cloning:
Clone the project `git clone https://github.com/javatechy/fab-backend.git`

#### Database:
Create a database in MySQL :
`create database fab;`

#### Build : 
To build the application `mvn clean install`

#### Run : 

Run the application using `mvn spring-boot:run`

Database Structure
-----------------------------
Following tables are created:
* `Transaction`: all transactions data for recharge, bill payment and movie.
* `User`:  for user info
* `Balance`: for storing users wallet balance

**Note**: Each time you run this application it will 
delete all data from all tables and adds new data. 
To avoid this functionality comment `@PostConstruct` in `SetupServiceImpl`
   
Adding New User
-----------------------------
Update `SetupServiceImpl` and add your user.


Others:
-----------------------------
All java files are well documented for clarification.