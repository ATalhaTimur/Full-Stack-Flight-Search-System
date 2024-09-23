

# Full-Stack-Flight-Search-System

This project is developed using Java Spring Boot for backend, MySQL for database management, and Docker for containerization. The aim is to build a scalable and robust application. In future iterations, I plan to integrate React for the frontend, providing a full-stack solution with a modern and responsive UI.

---

## Backend Part

This is the backend implementation of the Flight Search API built using **Spring Boot**, **MySQL**, and **Hibernate**. It provides a RESTful API for managing and retrieving flight and airport information.

### Technologies Used

- **Java 22**
- **Spring Boot 3.4.0-M2**
- **Hibernate 6.4.2**
- **MySQL** (Running in Docker)
- **Swagger** for API documentation
- **Docker** for containerization

### Getting Started

To get the backend part of this project running, you'll need to have **Docker** and **Java 22** installed on your machine.

#### Prerequisites

- [Install Docker](https://docs.docker.com/get-docker/)
- [Install Java 22](https://jdk.java.net/22/)

#### Cloning the Repository

```bash
git clone <your-repository-url>
cd FlightSearchAPI
```

### How to Run

1. **Step 1:** Build the project using Maven

```bash
./mvnw clean install
```

2. **Step 2:** Run the application using Docker

```bash
docker compose up --build
```

3. **Step 3:** Open the application in your browser and login.

   - Navigate to: `http://localhost:8080/login`
   - Login credentials:
     - **Username:** Talha
     - **Password:** 1234

4. **Step 4:** After login, you can access the Swagger UI for API documentation:

   - URL: `http://localhost:8080/swagger-ui/index.html#/`

From here, you can test the available API endpoints, perform CRUD operations, and interact with the database.

### Authentication

The API uses Spring Security to manage authentication. To access any of the secured endpoints, you must first log in using the credentials provided above. Once logged in, you can interact with the API and perform CRUD operations on the flights and airports.

### API Documentation

The API is documented using Swagger, which provides an interactive interface for testing the endpoints.

- **Swagger UI:** `http://localhost:8080/swagger-ui/index.html#/`
  
You can view all available endpoints, see the structure of requests and responses, and test them directly from the Swagger interface.

### Endpoints

Here are some of the key endpoints:

- **GET /api/airports:** Get all airports
- **POST /api/airports:** Add a new airport
- **GET /api/flights:** Get all flights
- **POST /api/flights:** Add a new flight
