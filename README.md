# BookStore Spring Boot - Generic Services

A simple and clean **Spring Boot** application demonstrating how to build a **BookStore** system using a powerful **Generic Services** architecture.

This project showcases best practices in:
- Building **Generic CRUD Services** (Create, Read, Update, Delete)
- Reducing code duplication across services
- Organizing a scalable, maintainable backend architecture


## Core Concept: Generic Services

**Generic Service** means that instead of writing the same CRUD methods again and again for each entity (Book, Category, etc.), you create **one service** that can handle **any entity type**.

### Architecture include `GenericServiceImpl<Request extends BaseEntity, Response, Identifier >` (Generic Service Implementation)

Provides a **base implementation** for all CRUD operations:
```java
@Service
public abstract class BaseServiceImpl<Request extends BaseEntity, Response, Identifier > implements BaseService<Request, Response, Identifier > {


    abstract JpaRepository<Request, Identifier> getRepository();

    abstract Converter<Request,Response> getConverter();

    @Override
    public List<Response> getAll() {
        List<Request> data =  getRepository().findAll();
        return data.stream()
                .map(getConverter()::convertToDTO)
                .collect(Collectors.toList());
    }
    
    .
    .
    .
    
}

```
- The service is injected with the entity's **JpaRepository**.
- All methods delegate directly to the repository.


## Project Structure

```
org.example.gradleproject
├── controller        # REST API endpoints
├── dto               # Data Transfer Objects
├── entity            # JPA entities
├── exception         # Custom exception handling
├── mapper            # Entity-DTO conversion
├── repository        # Spring Data JPA repositories
├── service           
│   └── impl          # Service implementations
└── utilities         # Helper classes and utilities
```


## Running the Application

Make sure you have:
- Java 17+
- Maven installed

Then:
```bash
git clone https://github.com/qossayrida/BookStoreSpringBoot-GenericServices.git
cd BookStoreSpringBoot-GenericServices
mvn spring-boot:run
```

App runs by default on:
```
http://localhost:8080
```

You can access Swagger UI for API documentation (if configured) at:
```
http://localhost:8080/swagger-ui/index.html
```


## Contact

For any inquiries or further information, please contact the lab supervisor at

[![facebook](https://img.shields.io/badge/facebook-0077B5?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/qossay.rida?mibextid=2JQ9oc)

[![Whatsapp](https://img.shields.io/badge/Whatsapp-25D366?style=for-the-badge&logo=Whatsapp&logoColor=white)](https://wa.me/+972598592423)

[![linkedin](https://img.shields.io/badge/linkedin-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/qossay-rida-3aa3b81a1?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app )

[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/qossayrida)
