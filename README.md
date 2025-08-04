
# OpAPI

This Spring Boot demo app demonstrates usage of OpenAPI as a standard specification 
for describing API, and Swagger (a tool to create API documentation).
This demo app is only for demonstration and/or educational purposes.


### Context

Basic CRUD operations on Customer Management System API (CMS API). 
This application provides REST APIs for the CMS API. 
This REST API allows to manipulate with customers data in DB.


### Techstack

* [Spring Framework.](https://spring.io/)
* [Developer Tools.](https://docs.spring.io/spring-boot/reference/using/devtools.html)
* [Spring Data JPA.](https://spring.io/projects/spring-data-jpa)
* [Hibernate.](https://hibernate.org/)
* [H2 Database.](https://www.h2database.com/html/main.html)
* [Lombok.](https://projectlombok.org/)
* [springdoc-openapi.](https://springdoc.org/)


### Database

Run the app (if it's not running): in IDE (for example, IntelliJ IDEA), run

`com.example.Spring_Boot_OpAPI.OpApiApplication`.

In IDE console, among other information, should appear

`...: H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:test_db'`

The `test_db` is database for manual testing of the app. It's in in-memory mode.

**To check functionality of the database**, start in Web-browser

`localhost:8080/h2-console`

H2 console login page appears. The page has:

```text

JDBC URL: jdbc:h2:mem:test_db
User Name: root
Password: (empty field)

```

Click button `Connect`. H2 database console should appear.
This console already has table `CUSTOMERS`.

Click on the table `CUSTOMERS`. In SQL statement section should appear

```sql
SELECT * FROM CUSTOMERS 
```

Click `Run`. Beneath of the SQL statement section appears table `CUSTOMERS`.
It's empty for now.

Data of the table will be changed after each REST-request fulfilled. 
You can check it to perform above-mentioned `SELECT` query.


### REST API 

To test REST API you can use [Postman](https://www.postman.com/) as a testing tool.

This REST API allows to manipulate with customers data in DB:

| Method    | URL                      | Action                       |
|-----------|--------------------------|------------------------------|
| GET       | `/api/v1/customers`      | Get all customers list       | 
| GET       | `/api/v1/customers/{id}` | Get a customer by id         |
| POST      | `/api/v1/customers`      | Add new customer             |
| PUT       | `/api/v1/customers/{id}` | Update a customer by id      |
| DELETE    | `/api/v1/customers/{id}` | Delete a customer by id      |


Run the app (if it's not running). Test REST API URLs in Postman, 
for example, perform `GET` request to get all customers list

```text
http://localhost:8080/api/v1/customers
```

All REST API request and response examples can be understandable 
through their documenting with OpenAPI specifications.


### OpenAPI (Swagger)

Run the app (if it's not running). Go to the API documentation default page
by 
```text
http://localhost:8080/v3/api-docs
```
`JSON` format api docs data should appear.

`YAML` file can be got at
```text
http://localhost:8080/v3/api-docs.yaml
```

You can change the default api docs path from this

```text
http://localhost:8080/v3/api-docs
```

to, for example, this
```text
http://localhost:8080/api-docs
```

by adding

```text
springdoc.api-docs.path=/api-docs
```

to the `application.properties` file.

You can configure Swagger in the project 
(see [class OpenAPIConfig](src/main/java/com/example/Spring_Boot_OpAPI/config/OpenAPIConfig.java)).

[Swagger UI](https://swagger.io/tools/swagger-ui/) provides a user interface
for interaction with REST API endpoints.
It's no needs additionally configure Swagger UI, the `springdoc-openapi`
library already includes it.

You can get Swagger UI of this demo app through 
```text
http://localhost:8080/swagger-ui/index.html
```

This demo app uses some Swagger annotations to add information to API docs.
A description of these annotations can be found by following the links pointed 
in the Resources section of this README file.


### Resources

* https://www.openapis.org/
* https://swagger.io/
* https://swagger.io/tools/swagger-ui/
* https://springdoc.org/
* https://docs.swagger.io/swagger-core/v2.2.30/apidocs/io/swagger/v3/oas/annotations/package-summary.html
* https://docs.swagger.io/swagger-core/v2.2.30/apidocs/io/swagger/v3/oas/annotations/media/package-summary.html
* https://docs.swagger.io/swagger-core/v2.2.30/apidocs/io/swagger/v3/oas/annotations/responses/package-summary.html
* https://docs.swagger.io/swagger-core/v2.2.30/apidocs/io/swagger/v3/oas/annotations/tags/package-summary.html
* https://www.postman.com/


