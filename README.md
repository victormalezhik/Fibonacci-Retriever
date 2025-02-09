# 🚀 Fibonacci Retriever

Fibonacci Retriever is a REST API service built with Spring Boot that retrieves Fibonacci numbers from a PostgreSQL database. The database is pre-populated with the first 40 Fibonacci numbers using Liquibase.

## 📌 Features
- Retrieve all Fibonacci numbers from the database.
- Retrieve a specific Fibonacci number by its index (ID).

## 🛠️ Technologies
- **Java 17+**
- **Spring Boot** (Spring Web, Spring Data JPA, Liquibase)
- **PostgreSQL** (via Docker)
- **Maven** (for dependency management)
- **Liquibase** (for database migrations)

## 📦 Project Setup

### 1. Start PostgreSQL with Docker
If you are using a graphical interface for Docker management, create a new container with the following settings:
- **Image**: `postgres`
- **Environment Variables**:
  - `POSTGRES_USER=admin`
  - `POSTGRES_PASSWORD=0000`
  - `POSTGRES_DB=fibonacci`
- **Port Mapping**: `5432:5432`

### 2. Clone the Repository
```sh
git clone https://github.com/viktormalezhik/fibonacci-retriever.git
cd fibonacci-retriever
```

### 3. Configure Environment Variables
Ensure the `application.properties` file contains the correct database connection parameters:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/fibonacci
spring.datasource.username=admin
spring.datasource.password=0000
spring.jpa.hibernate.ddl-auto=validate
```

### 4. Run the Application
```sh
mvn spring-boot:run
```

## 🌍 REST API Endpoints

| Method | URL                   | Description |
|--------|-----------------------|-------------|
| GET    | `/fibonacci`          | Retrieve all Fibonacci numbers |
| GET    | `/fibonacci/{id}`     | Retrieve a specific Fibonacci number by index |

## 🔧 Deployment
To deploy the service using Docker:
```sh
docker build -t fibonacci-retriever .
docker run -p 8080:8080 fibonacci-retriever
```

