# Ecommerce Spring Boot Application

This project is an Ecommerce application built with Spring Boot. The application is configured to connect to a relational database, manage user authentication, and handle typical ecommerce operations.

## Documentation

ERD diagram for database schema and Code Structure Explanation can be found in __'documentation.zip'__ file

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- **Java Development Kit (JDK) 21+**: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Apache Maven**: [Download Maven](https://maven.apache.org/download.cgi)
- **Git**: [Download Git](https://git-scm.com/downloads)
- **Oracle Database**: Make sure you have installed Oracle database and the server is running.

## Clone the Repository

```bash
-git clone https://github.com/saw1232582000/TakeHomeEcommerce.git
-cd TakeHomeEcommerce
```

## Application Properties

Setup these properties in your __'application.properties'__ file or __'application.yml'__ file

- **spring.datasource.url** = [Your oracle database url]
- **spring.datasource.username** = [database username]
- **spring.datasource.password** = [database password]
- **spring.datasource.driver-class-name** = oracle.jdbc.OracleDriver
- **spring.jpa.hibernate.ddl-auto** = update


##  Running the Project

If all above requirements are met, you can start running your project.

Then, Access the application by navigating to __'http://localhost:8080/swagger-ui/index.html'__