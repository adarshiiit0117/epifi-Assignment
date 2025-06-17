# 🧾 FiMoney Inventory Management Backend

A secure, role-based Inventory Management System built with **Spring Boot**, **JWT authentication**, and **MySQL/H2**, fully **Dockerized**, **Swagger-documented**, and **cloud deployed**.

---

## 🚀 Live Demo

- 🌐 **Base URL**: https://epifi-assignment-3.onrender.com
- 📘 **Swagger UI**: https://epifi-assignment-3.onrender.com/swagger-ui.html

Use the "Authorize" button in Swagger to test secured endpoints by pasting a valid JWT token:

```
Bearer <your_token_here>
```

---

## ✅ Features

- 🔐 JWT-based authentication (register/login)
- 👥 Role-based access: `ADMIN` vs `USER`
- 📦 Product APIs: Add, Update Quantity, Get (paginated)
- 🧪 Tested via automated Python script
- 📘 Swagger UI documentation
- 🐳 Dockerized deployment
- 💾 MySQL integration (or H2 fallback)



## 📦 API Overview

### 🔐 Auth APIs

| Method | Endpoint     | Description            |
|--------|--------------|------------------------|
| POST   | `/register`  | Register user          |
| POST   | `/login`     | Login + receive token  |

### 📦 Product APIs

| Method | Endpoint                          | Access    | Description                  |
|--------|-----------------------------------|-----------|------------------------------|
| GET    | `/products?page=0&size=10`        | USER/ADMIN | List products (paginated)    |
| POST   | `/products`                       | ADMIN     | Add a new product            |
| PUT    | `/products/{id}/quantity`         | ADMIN     | Update product quantity      |

---

## 🔧 Local Setup Instructions

### ✅ Prerequisites

- Java 21
- Maven 3.9+
- MySQL (or use H2 for testing)
- Docker (optional)

### ✅ 1. Clone the project

```bash
git clone https://github.com/your-repo/epifi-Assignment.git
cd epifi-Assignment
```

### ✅ 2. Configure `application.properties`

```properties
# For MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/finventory
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

_or use H2 for local testing:_

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### ✅ 3. Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🐳 Docker Deployment

### ✅ Build & Run Docker Image

```bash
mvn clean package
docker build -t fimoney-app .
docker run -p 8080:8080 fimoney-app
```

_Visit: `http://localhost:8080/swagger-ui.html`_

---

## 🧪 API Test Script (Python)

### ✅ Run Automated API Test

This script tests:

- Register
- Login
- Add Product
- Update Quantity
- Fetch Products

### 1. Install `requests`

```bash
pip install requests
```

### 2. Run the script

```bash
python test_script.py
```

### 🟢 Actual Output (Live Deployment)

```
User Registration: PASSED
Login Test: PASSED
Add Product: PASSED
Update Quantity: PASSED, Updated quantity: 15
Get Products: PASSED (Quantity = 15)
```

✅ Confirms all endpoints work correctly with authentication and business logic.

---

## 🔍 Project Structure

```
epifi-Assignment/
├── src/
│   ├── controller/
│   ├── service/
│   ├── model/
│   ├── repository/
│   ├── config/
│   ├── request/
│   ├── response/
│   └── FiMoneyApplication.java
├── test_script.py        # Python API tester
├── Dockerfile
├── pom.xml
└── README.md
```

---

## 🛠 Tech Stack

- ✅ Java 21 + Spring Boot 3.4.1
- ✅ Spring Security + JWT
- ✅ MySQL / H2
- ✅ Swagger (OpenAPI 3 via Springdoc)
- ✅ Docker (multi-stage)
- ✅ Postman / Python (`requests`)

---

## 📬 Deliverables Summary

| Item                  | Included |
|-----------------------|----------|
| Source Code           | ✅       |
| Swagger UI            | ✅       |
| Dockerfile            | ✅       |
| Database Schema       | ✅       |
| Python Test Script    | ✅       |
| Postman Collection    | ✅       |
| Live URL              | ✅ `https://epifi-assignment-3.onrender.com` |
| README.md             | ✅ This file |

---

## ✨ Author

**Adarsh Dubey**  


