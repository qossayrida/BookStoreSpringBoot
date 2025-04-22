# Gradle Project with Spring Boot

This project is a Spring Boot application built using Gradle. It demonstrates a basic structure for a RESTful API with services, controllers, and utility classes. The application is designed to handle entities, perform CRUD operations, and provide API responses.

## Features

- **Spring Boot Framework**: Simplifies application development with built-in configurations.
- **Gradle Build Tool**: Manages dependencies and builds the project.
- **RESTful API**: Provides endpoints for managing resources.
- **Service Layer**: Implements business logic.
- **DTO and Entity Mapping**: Converts entities to DTOs and vice versa.
- **Error Handling**: Demonstrates the use of error codes with `ResourceBundle`.

## Project Structure

### Key Directories and Files

- `src/main/java/org/example/gradleproject/controller/`
    - Contains REST controllers like `SaleController` to handle HTTP requests.

- `src/main/java/org/example/gradleproject/service/`
    - Contains service interfaces and implementations like `BaseServiceImpl` and `SaleService`.

- `src/main/java/org/example/gradleproject/dto/`
    - Contains Data Transfer Objects (DTOs) for transferring data between layers.

- `src/main/java/org/example/gradleproject/entity/`
    - Contains entity classes representing database tables.

- `src/main/java/org/example/gradleproject/mapper/`
    - Contains mappers for converting entities to DTOs and vice versa.

- `src/main/resources/`
    - Contains configuration files and resource bundles (e.g., `errorcodes.properties`).

- `gradlew.bat`
    - Windows batch script for running Gradle commands.

## Endpoints

### SaleController

1. **Get All Sales**
    - **URL**: `/api/get-sale/all`
    - **Method**: `GET`
    - **Response**: List of all sales.

2. **Get Sale by ID**
    - **URL**: `/api/get-sale/{id}`
    - **Method**: `GET`
    - **Response**: Sale details for the given ID.

3. **Get Error Codes**
    - **URL**: `/api/try-error-codes/{id}`
    - **Method**: `GET`
    - **Response**: List of error codes with dynamic placeholders.

## Prerequisites

- **Java 17 or higher**: Ensure `JAVA_HOME` is set correctly.
- **Gradle**: Included in the project via the wrapper (`gradlew`).

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

3. Run the application:
   ```bash
   ./gradlew bootRun
   ```

4. Access the API at `http://localhost:8080`.

## Error Handling

The project uses a `ResourceBundle` to manage error codes. Example error codes include:
- `NOT_FOUND`: Indicates a resource was not found.
- `NOT_FOUND_DETAIL`: Provides detailed information about the missing resource.

