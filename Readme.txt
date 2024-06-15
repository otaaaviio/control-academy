# Control Academy

## Project Structure

This project follows the Spring Boot design pattern, with the following directories:

- **controller**
- **dto**
- **entity**
- **factory**
- **repository**
- **service**
- **tests**

## Dependencies

In addition to the standard Spring Boot dependencies, a few additional plugins were used to handle all the required requests for the project.

## Database

- **PostgreSQL**: The primary database, connected via `application.properties`. A Docker setup is provided for easy execution of the project. Hibernate is used for table creation.
- **H2 Database**: Used for testing to prevent modifications to the primary database.

### Database Tables

- `credit_cards`
- `exercise_muscles`
- `exercise_weight_history`
- `exercises`
- `muscles`
- `plan_types`
- `plans`
- `training_exercises`
- `training_users`
- `trainings`
- `users`

The database schema is modeled using the Third Normal Form (3NF).

## Tests

The project includes tests for all controllers and endpoints. These tests are performed using the H2 database, where mock objects are created. JUnit and Mockito are used for testing.

## Entity

Contains classes representing the database entities. Each class corresponds to a database table and includes necessary attributes, along with getters and setters.

## DTO

Contains classes representing Data Transfer Objects. Each class represents an object used for data transfer to the API, including necessary attributes, getters, setters, and input data validations.

## Repository

Contains interfaces extending the `JpaRepository` from Spring Data JPA. Each interface represents a database table and includes methods for performing database operations like insert, update, delete, and data retrieval. Specific data retrieval methods are also included.

## Service

Contains classes implementing business logic. Each class corresponds to a database table and includes methods for performing database operations like insert, update, delete, and data retrieval. Services use repositories for database operations. A `BaseService` class provides generic database operation methods, extended by some services.

## Controller

Contains classes implementing the API endpoints. Each class represents an endpoint and includes methods for performing database operations like insert, update, delete, and data retrieval. Controllers use services for database operations.

## Factory

Contains classes implementing object creation, including methods for creating DTOs and entities using the Faker plugin. These are used in tests for creating unique mock objects.

## Code Style

The project follows the Google Java Style code format, using the `google-java-format` plugin in IntelliJ IDEA. English is used as the standard language for code (classes, methods, variables, etc.).

## Execution

To run the project:

1. Install Maven dependencies.
2. Configure the `application.properties` file with your database information.
3. Create a database.
4. Execute the `Application.java` class.

You can use Postman to test the API endpoints.

## Final Considerations

The project was developed using Spring Boot. It is straightforward and concise, with potential for additional functionalities such as improved tests and endpoint returns with DTOs. Since the focus of the project is the API, no graphical interface was implemented, but Postman can be used for testing the API endpoints. Additionally, Object-Oriented Programming (OOP) and SOLID principles were utilized in the project implementation.
