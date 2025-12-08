# Quick Reference - Employee Management API

## 🎯 Quick Start

### Start the Server
```bash
cd c:\Users\Hutech\OneDrive\Desktop\Employee-Management
mvn spring-boot:run
```

### Access the API
- **Web UI Tester:** http://localhost:8080/api-tester.html
- **API Root:** http://localhost:8080/
- **H2 Console:** http://localhost:8080/h2-console
- **Server Status:** http://localhost:8080/status

---

## 📌 Endpoint Cheat Sheet

### 1. Save Employee
```
POST http://localhost:8080/employee/save
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 50000
}
```

### 2. Get All Employees
```
GET http://localhost:8080/employee/all
```

### 3. Delete Employee
```
DELETE http://localhost:8080/employee/delete/1
```

---

## 🧪 Postman Import

1. File → Import
2. Select: `Employee_Management_API.postman_collection.json`
3. Click Import
4. Run requests from the collection

---

## 💾 H2 Database

**URL:** http://localhost:8080/h2-console
- **Username:** sa
- **Password:** (empty)
- **JDBC URL:** jdbc:h2:mem:testdb

```sql
-- See all employees
SELECT * FROM EMPLOYEE;

-- Count employees
SELECT COUNT(*) FROM EMPLOYEE;
```

---

## 🔥 Common Issues & Fixes

| Issue | Fix |
|-------|-----|
| Port 8080 in use | `Get-Process java \| Stop-Process -Force` |
| Whitelabel Error | Refresh browser or restart server |
| 404 Not Found | Check endpoint spelling |
| Data not saving | Check H2 console, verify database connection |

---

## 📊 API Response Format

**Success (200/201):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 50000.0
}
```

**Error (404):**
```json
{
  "timestamp": 1733667900000,
  "status": 404,
  "error": "Not Found",
  "message": "Endpoint not found. Please check the URL and try again.",
  "path": "/wrong-endpoint",
  "hint": "Available endpoints: POST /employee/save, GET /employee/all, DELETE /employee/delete/{id}"
}
```

---

## 🎨 Web UI Features

✅ Save Employee form
✅ View all employees button
✅ Delete employee by ID
✅ Real-time JSON responses
✅ H2 console quick link
✅ Server status indicator

---

## 📁 Project Structure

```
Employee-Management/
├── src/
│   ├── main/
│   │   ├── java/Employee/Management/
│   │   │   ├── Employee.java (Entity)
│   │   │   ├── EmployeeController.java (REST)
│   │   │   ├── EmployeeService.java (Logic)
│   │   │   ├── EmployeeRepository.java (DB)
│   │   │   ├── EmployeeApplication.java (Main)
│   │   │   ├── CustomErrorController.java (Errors)
│   │   │   └── WelcomeController.java (Home)
│   │   └── resources/
│   │       ├── application.properties (Config)
│   │       └── static/api-tester.html (UI)
│   └── test/
├── pom.xml
├── Employee_Management_API.postman_collection.json
├── POSTMAN_TESTING_GUIDE.md
└── API_SETUP_COMPLETE.md
```

---

## ✨ Next Steps

1. ✅ Start server (`mvn spring-boot:run`)
2. ✅ Open http://localhost:8080/api-tester.html
3. ✅ Test Save Employee endpoint
4. ✅ Test Get All Employees endpoint
5. ✅ View data in H2 Console
6. ✅ Test Delete endpoint

---

## 🎓 Learning Resources

- Spring Boot Docs: https://spring.io/projects/spring-boot
- REST API: https://restfulapi.net/
- H2 Database: https://www.h2database.com/
- Postman: https://www.postman.com/

---

**Last Updated:** December 8, 2025
**Status:** ✅ All systems operational
**Support:** Check API_SETUP_COMPLETE.md for detailed guide
