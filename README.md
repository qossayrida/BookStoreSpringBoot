# BookStore Spring Boot - Generic Services

A simple and clean **Spring Boot** application demonstrating how to build a **BookStore** system using a powerful **Generic Services** architecture.

This project showcases best practices in:
- Building **Generic CRUD Services** (Create, Read, Update, Delete)
- Reducing code duplication across services
- Organizing a scalable, maintainable backend architecture

## 📅 Project Overview

Entities managed in this system:
- **Book** (title, price, etc.)
- **Category** (name, description, etc.)

Each entity has a standard set of CRUD operations provided **automatically** via **Generic Services**, without writing repeated service code for each model.

---

## 👥 Core Concept: Generic Services

**Generic Service** means that instead of writing the same CRUD methods again and again for each entity (Book, Category, etc.), you create **one service** that can handle **any entity type**.

The architecture includes:

### 1. `IGenericService<T, ID>` (Generic Service Interface)

Defines standard CRUD operations:
```java
public interface IGenericService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
    T update(T entity);
}
```
- `T` is the **Entity type** (e.g., Book, Category)
- `ID` is the **Primary Key type** (e.g., Long, Integer)

### 2. `GenericServiceImpl<T, ID>` (Generic Service Implementation)

Provides a **base implementation** for all CRUD operations:
```java
@Service
public class GenericServiceImpl<T, ID> implements IGenericService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }
}
```
- The service is injected with the entity's **JpaRepository**.
- All methods delegate directly to the repository.

### 3. Specific Services (e.g., `BookService`, `CategoryService`)

Concrete services simply **extend** the generic service:
```java
@Service
public class BookService extends GenericServiceImpl<Book, Long> {

    public BookService(BookRepository repository) {
        super(repository);
    }
}
```
No need to write CRUD methods again!

Same for Category:
```java
@Service
public class CategoryService extends GenericServiceImpl<Category, Long> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
```

---

## 🏙️ Project Structure

```
├── controller/
│   ├── BookController.java
│   └── CategoryController.java
├── model/
│   ├── Book.java
│   └── Category.java
├── repository/
│   ├── BookRepository.java
│   └── CategoryRepository.java
├── service/
│   ├── IGenericService.java
│   ├── GenericServiceImpl.java
│   ├── BookService.java
│   └── CategoryService.java
└── BookStoreApplication.java
```

- `controller/`: REST APIs
- `model/`: JPA Entity classes
- `repository/`: Spring Data JPA Repositories
- `service/`: Generic services + Entity-specific services

---

## 🌐 Running the Application

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

---

## 🔐 Example APIs

- `GET /books`
- `POST /books`
- `GET /categories`
- `POST /categories`

---

## 💡 Why Use Generic Services?

- **Avoid code duplication** across services.
- **Faster** when adding new entities: you only create model, repository, controller!
- **Easier to maintain**: fix logic once in `GenericServiceImpl`, affects all services.
- **Cleaner project structure**.

This pattern is especially useful for:
- CRUD-based systems (ERP, CMS, eCommerce, etc.)
- Microservices where many entities share similar logic.



## Contact

For any inquiries or further information, please contact the lab supervisor at

[![facebook](https://img.shields.io/badge/facebook-0077B5?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/qossay.rida?mibextid=2JQ9oc)

[![Whatsapp](https://img.shields.io/badge/Whatsapp-25D366?style=for-the-badge&logo=Whatsapp&logoColor=white)](https://wa.me/+972598592423)

[![linkedin](https://img.shields.io/badge/linkedin-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/qossay-rida-3aa3b81a1?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app )

[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/qossayrida)

