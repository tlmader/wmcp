# wmcp – Workforce Management and Career Planning
**Data Models and Database Systems Project**

***wmcp*** is a web service supporting workforce management and career planning.

## IntelliJ IDEA Run Configuration
* Configuration Type: Spring Boot
* Main class: `wmcp.api.Application`
* JRE: 1.8

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


## Environment Variables:
* `DATASOURCE_URL` — Defines URL used in spring.datasource.url
* `DATASOURCE_USERNAME` — Defines username used in spring.datasource.username
* `DATASOURCE_PASSWORD` — Defines password used in spring.datasource.password

## Default Ports
* Server: 9000

## Additional Info
* Use the [SQL scripts](https://github.com/Tlmader/wmcp/blob/master/sql) for building a database for wmcp.
* Set spring.datasource.driverClassName in application.properties accordingly.
* Import [wmcp.api.postman_collection.json](https://github.com/Tlmader/wmcp/blob/master/doc/wmcp.api.postman_collection.json) into Postman for example API calls.
