# DbMigrationDemo
This is a project for learning Db Migration using Flyway schema. 

# Spring Boot Database Migration Project

This Spring Boot project focuses on database migration using Flyway and utilizes PostgreSQL as the underlying database. It includes various entity classes, migration files, and a searching mechanism class.

## Introduction

The project is designed to showcase the implementation of database migration in a Spring Boot application. It demonstrates the use of Flyway for version control of database schemas and utilizes PostgreSQL for persistent storage.

## Features

- **Database Migration:**
    - Seamless migration of database schema versions using Flyway.
    - Definition of entities such as Department, Employee, Address, Mission, and their relationships.

- **Entity Management:**
    - CRUD operations for Department, Employee, Address, and Mission entities.
    - Searching mechanism for efficient data retrieval.

## Technologies Used

- Spring Boot
- Flyway
- PostgreSQL
- Maven (Build Tool)

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone  https://github.com/Vishwajeet-29-pro/DbMigrationDemo.git
   ```
Build and Run the Application:

``` bash
cd DbMigrationDemo
./mvnw spring-boot:run
```
Database Configuration
Ensure that you have a PostgreSQL database instance running. Update the application.properties file with your database configuration:


# Database Configuration

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

Replace your-database, your-username, and your-password with your actual database details.

### Database Migration
The application utilizes Flyway for database migration. Migration files are located in the src/main/resources/db/migration directory.

## Contributing
Feel free to contribute to the project by opening issues or submitting pull requests. Your feedback and suggestions are highly appreciated!
