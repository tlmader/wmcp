# wmcp – Workforce Management and Career Planning
**Data Models and Database Systems Project**

***wmcp*** is a web service supporting workforce management and career planning.

## File Structure

    .
    ├── doc                                   # diagrams and Postman collections
    ├── sql                                   # schema and test data scripts
    ├── src                                   # source root
    │   └── main
    │       ├── java/wmcp/api
    |       |   ├── config                    # configurations
    |       |   ├── controller                # REST controllers
    |       |   ├── model                     # entity models
    |       |   ├── repository                # data access
    |       |   └── service                   # service workflows
    │       └── resources
    │           └── application.properties    # Spring properties
    └── pom.xml                               # Maven project object model

## Getting Started

***NOTE: I will set up H2 eventually so this will be easier to see in action.***

Set up [Oracle Database](http://www.oracle.com/technetwork/database/enterprise-edition/downloads/index-092322.html).

Set `spring.datasource.driverClassName` in [application.properties](https://github.com/Tlmader/wmcp/blob/master/src/main/resources/application.properties) accordingly.

Set the following environment variables to match your database settings:
* `DATASOURCE_URL` — Defines URL used in spring.datasource.url
* `DATASOURCE_USERNAME` — Defines username used in spring.datasource.username
* `DATASOURCE_PASSWORD` — Defines password used in spring.datasource.password

Alternatively, replace the variables in [application.properties](https://github.com/Tlmader/wmcp/blob/master/src/main/resources/application.properties).

Import the Maven project via IntelliJ IDEA and run using the following configuration:
* Configuration Type: Spring Boot
* Main class: `wmcp.api.Application`
* JRE: 1.8

Alternatively, use your preferred IDE.

Using a tool such as [Oracle SQL Developer](http://www.oracle.com/technetwork/developer-tools/sql-developer/overview/index-097090.html), connect to the database and run the following scripts in the [sql](https://github.com/Tlmader/wmcp/blob/master/sql) directory:
* drop.sql - drops all tables!
* schema-v4.sql
* insert-v5.sql

Import [wmcp.api.postman_collection.json](https://github.com/Tlmader/wmcp/blob/master/doc/wmcp.api.postman_collection.json) into [Postman](https://www.getpostman.com/) for example API calls.

## Default Ports
* Server: 9000
