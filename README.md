# Project 1 - Custom Object Relational Mapping Framework

## Description

This project will involve creating a custom object relational mapping (ORM) framework and using it to create a web application that utilized this custom ORM.

## Tech Stack

- [ ] Java 8
- [ ] Apache Maven
- [ ] Java EE Servlet API (v4.0+)
- [ ] PostGreSQL deployed on AWS RDS
- [ ] Git SCM (on GitHub)

## Features

- [ ] Custom ORM source code should be included within the web application as a Maven dependency
- [ ] CRUD operations are supported for domain objects via the web application's exposed endpoints
- [ ] JDBC logic is abstracted away by the custom ORM
- [ ] Programmatic persistence of entities (basic CRUD support) using custom ORM
- [ ] File-based or programmatic configuration of entities

## To-Do

- [ ] 80% line coverage of all service layer classes
- [ ] Generate Jacoco reports that display coverage metrics
- [ ] Usage of the java.util.Stream API

## Getting Started
- [ ] To start off, git clone the project with the command: git clone https://github.com/210726-Enterprise/Douglas_Ramirez_P1.git
- [ ] Create a database and a schema
- [ ] In your environment variables, create 3 variables with your database information under the names db_url, db_username, and db_password
- [ ] Run your application in an IDE such as IntelliJ
 
- [ ] Download and open the program Postman to test http commands
- [ ] All testing will be done to localhost:8080
- [ ] Under the /employees endpoint, run a GET to receive all users registered in your database.
 
- [ ] For registering a user, we will be running a POST instead of a GET.
- [ ] Under the body section, select the RAW type and in JSON format, give information for employee_id, first_name, last_name, and email.
- [ ] Run the POST command and look for a successful status code.

- [ ] For updating an existing user's information, we will be running a PUT isntead of a POST.
- [ ] Under the body section, select the RAW type and in JSON format, give information for employee_id, first_name, last_name, and email.
- [ ] Run the PUT command and look for a JSON response with the update information.
 
- [ ] For deleting an existing user, we will be running a DELETE instead of a PUT
- [ ] Under the body section, select the RAW type and in JSON format, give information for employee_id.
- [ ] Run the DELETE command and look for a successful response code.

## Init Instructions

- Create a new repository within this organization for your custom ORM (naming convention: `orm_name_p1`; with `orm_name` being replaced by the name of your custom library)
- Create another new repostory within this organization for your web application

## Presentation

- Finalized version of custom ORM and web application must be pushed to personal repository within this organization by the presentation date (August 24th, 2021)
- 10-15 minute live demonstration of the web application (that leverages your custom ORM); demonstration will be performed using PostMan to query your API's endpoints

### Resources for researching ORMs

- [What is an ORM?](https://blog.bitsrc.io/what-is-an-orm-and-why-you-should-use-it-b2b6f75f5e2a)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/5.4/)
- [JavaLite ActiveJDBC Documentation](https://javalite.io/documentation)
- [Using Java Reflection](https://www.oracle.com/technical-resources/articles/java/javareflection.html)
