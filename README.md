# fab-backend
##Assumptions:
Assuming following sotfwares are installed on your machine:
Java 8
Port 8080 should be empty , if not please change server.port property in application.properties[src/main/resources]
MySQL is installed on the machine on port 3306(default port), if not please change server.port property in application.properties[src/main/resources]


##Build & Run:
To build the application
mvn clean install

Run the applicaiton :
mvn spring-boot:run
		OR 
nohup java -jar backend-0.0.1-SNAPSHOT.jar > faq.log



root@localhost: riw%G34geggX

ALTER USER 'root'@'localhost' IDENTIFIED BY '1';
create database fab;

sudo /usr/local/mysql/support-files/mysql.server start

https://stackoverflow.com/questions/14235362/mac-install-and-open-mysql-using-terminal
