# Spring MVC Annotation MySQL Project

This is a basic Spring MVC project using annotations and connected to MySQL database.

## Features

- Spring MVC with annotation-based configuration (`@Controller`, `@Service`, `@Repository`, etc.)
- Java Config (`@Configuration`, `@EnableWebMvc`)
- MySQL database connection via JDBC
- Simple CRUD operations for user data
- JSP views under `/WEB-INF/views/`

## Requirements

- Java 8 or above
- Apache Tomcat (or any servlet container)
- MySQL Server
- Maven

## Setup

1. Clone the repo:
     git clone https://github.com/madhu-8888/Spring-MVC-Annotation-MySQL.git

2. Configure your MySQL database and update the datasource properties in your config file (WebConfig or XML).

3. Build the project:
      mvn clean install

4. Deploy the WAR to Tomcat webapps directory.

5. Access the app via http://localhost:8080/your-context-root.

Notes
   Database schema is expected to have a table named USERS with columns: STDID (int), STDNAME (varchar), and STDMOBILE (bigint).

   JSP files are located in /WEB-INF/views/.

License
  This project is open source under the MIT License.


