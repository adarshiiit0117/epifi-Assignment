# FiMoney Inventory Backend API

✅ JWT Auth + Role-based Access  
✅ Product CRUD  
✅ Swagger UI  
✅ Dockerized + Deployed

## 🔗 Live Demo
- Swagger UI: https://epifi-assignment-3.onrender.com/swagger-ui.html

## 🧪 Test Users
- Register as ADMIN or USER via `/register`
- Login via `/login`, then authorize in Swagger

## 🐳 Run Locally

```bash
mvn clean package
docker build -t fimoney .
docker run -p 8080:8080 fimoney
