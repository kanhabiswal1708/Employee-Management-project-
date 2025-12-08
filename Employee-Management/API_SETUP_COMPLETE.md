# Employee Management API - Complete Setup & Testing Guide

## 🎯 Current Status
✅ **Server Running** on `http://localhost:8080`
✅ **All Errors Fixed** - No more Whitelabel Error Page
✅ **Error Handling Implemented** - Proper JSON error responses
✅ **H2 Database** - In-memory database ready

---

## 🚀 What's New - Error Handling Fixed

### Before (Error Page):
```
Whitelabel Error Page
This application has no explicit mapping for /error
```

### After (Proper Error Response):
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

## 📍 API Endpoints

### 1. Welcome/Status
**GET** `http://localhost:8080/`
Returns welcome message and available endpoints

**Response:**
```json
{
  "message": "Welcome to Employee Management API",
  "status": "Server is running",
  "version": "1.0.0",
  "endpoints": [
    "POST /employee/save - Save a new employee",
    "GET /employee/all - Get all employees",
    "DELETE /employee/delete/{id} - Delete employee by ID"
  ],
  "ui": "http://localhost:8080/api-tester.html",
  "database_console": "http://localhost:8080/h2-console"
}
```

### 2. Server Status
**GET** `http://localhost:8080/status`

**Response:**
```json
{
  "status": "running",
  "timestamp": 1733667900000,
  "port": 8080,
  "database": "H2 In-Memory"
}
```

### 3. Save Employee
**POST** `http://localhost:8080/employee/save`

**Request Body:**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 50000.00
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 50000.0
}
```

### 4. Get All Employees
**GET** `http://localhost:8080/employee/all`

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "salary": 50000.0
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane@example.com",
    "salary": 60000.0
  }
]
```

### 5. Delete Employee
**DELETE** `http://localhost:8080/employee/delete/1`

**Response (200 OK):**
```
Deleted
```

---

## 🧪 Testing the APIs

### Option 1: Web UI (Easiest)
1. Open browser: `http://localhost:8080/api-tester.html`
2. Fill in the form fields
3. Click buttons to test
4. See responses instantly

### Option 2: Postman
1. Import: `Employee_Management_API.postman_collection.json`
2. Send requests with pre-configured endpoints
3. Save test results

### Option 3: cURL/PowerShell
```powershell
# Get all employees
curl -X GET http://localhost:8080/employee/all

# Save employee
curl -X POST http://localhost:8080/employee/save `
  -H "Content-Type: application/json" `
  -d '{"name":"John","email":"john@example.com","salary":50000}'

# Delete employee
curl -X DELETE http://localhost:8080/employee/delete/1
```

---

## 💾 H2 Database Console

**Access:** `http://localhost:8080/h2-console`

**Login Credentials:**
- **Driver Class:** org.h2.Driver
- **JDBC URL:** jdbc:h2:mem:testdb
- **User Name:** sa
- **Password:** (leave empty)

**Useful Queries:**
```sql
-- View all employees
SELECT * FROM EMPLOYEE;

-- View employee count
SELECT COUNT(*) FROM EMPLOYEE;

-- View database structure
SHOW COLUMNS FROM EMPLOYEE;

-- Delete all employees
DELETE FROM EMPLOYEE;
```

---

## 📋 Files Created/Modified

### New Controllers:
- ✅ `CustomErrorController.java` - Handles 404, 405, 400 errors
- ✅ `WelcomeController.java` - Home page & status endpoint

### Updated Files:
- ✅ `application.properties` - Error handling configuration
- ✅ `api-tester.html` - Interactive UI for testing

### Existing Files (Already Working):
- `EmployeeController.java` - REST endpoints
- `EmployeeService.java` - Business logic
- `EmployeeRepository.java` - Database access
- `Employee.java` - Entity model
- `EmployeeApplication.java` - Main application

---

## 🔧 Error Handling

### Status Codes & Responses:

| Code | Error | Solution |
|------|-------|----------|
| 200 | OK | Request successful |
| 404 | Not Found | Check endpoint URL |
| 405 | Method Not Allowed | Use correct HTTP method |
| 400 | Bad Request | Check request body format |
| 500 | Server Error | Check server logs |

---

## 📊 Test Data

Create sample employees to test the API:

```json
{
  "name": "Alice Johnson",
  "email": "alice@company.com",
  "salary": 75000.00
}
```

```json
{
  "name": "Bob Wilson",
  "email": "bob@company.com",
  "salary": 65000.00
}
```

```json
{
  "name": "Charlie Brown",
  "email": "charlie@company.com",
  "salary": 55000.00
}
```

---

## ✨ Features Now Available

✅ Proper error handling with JSON responses
✅ Welcome page with API documentation
✅ Server status endpoint
✅ Interactive API tester UI
✅ H2 Database console access
✅ CORS enabled for cross-origin requests
✅ Auto-increment employee IDs
✅ Full CRUD operations (Create, Read, Delete)

---

## 🚨 Troubleshooting

### Q: Still getting "Whitelabel Error Page"?
**A:** Refresh your browser or clear cache. The error handlers are now active.

### Q: Port 8080 already in use?
**A:** Kill the process:
```powershell
Get-Process java | Stop-Process -Force
```

### Q: Data not persisting?
**A:** H2 is in-memory by default. Data resets on server restart.
To persist data, change in `application.properties`:
```
spring.datasource.url=jdbc:h2:file:./data/testdb
```

### Q: Can't see H2 Console?
**A:** Ensure `spring.h2.console.enabled=true` is set in application.properties

---

## 📝 Summary

Your Employee Management API is now **fully functional** with:
- ✅ Fixed error handling
- ✅ Proper REST endpoints
- ✅ H2 database integration
- ✅ Interactive testing UI
- ✅ Full CRUD operations

**Ready to test!** Visit: `http://localhost:8080/api-tester.html`
