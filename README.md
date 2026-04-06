# 🚀 Student Management REST API using Spring Boot & JPA

## 📌 Overview

This project is a RESTful web service built using **Spring Boot** that allows users to manage student records efficiently. It supports complete CRUD operations along with custom search and update functionalities using **Spring Data JPA**.

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **ORM:** Hibernate (JPA)
* **Database:** MySQL
* **Build Tool:** Maven
* **Testing Tool:** Postman

---

## ✨ Features

* ✅ Add new student
* ✅ Fetch student by ID
* ✅ Fetch student by Email
* ✅ Fetch student by Mobile Number
* ✅ Get all student records
* ✅ Update Email using ID
* ✅ Update Mobile Number using Email
* ✅ Delete student by ID
* ✅ Exception handling using RuntimeException

---

## 🏗️ Architecture

This project follows a **layered architecture**:

* **Controller Layer** → Handles HTTP requests
* **Service Layer** → Business logic implementation
* **Repository Layer** → Database interaction using JPA
* **Entity Layer** → Represents database table
* **Exception Layer** → Handles errors

---

## 📂 Project Structure

```
com.demo
│── Controller
│     └── StudentController.java
│── Entity
│     └── Student.java
│── Service
│     ├── StudentServiceInterface.java
│     └── StudentServiceImple.java
│── Repository
│     └── StudentRepository.java
│── Exception
│     └── StudentNotFoundException.java (optional)
```

---

## 🔗 API Endpoints

| Method | Endpoint                              | Description                  |
| ------ | ------------------------------------- | ---------------------------- |
| POST   | /api/details                          | Add student                  |
| GET    | /api/detailsById/{id}                 | Get student by ID            |
| GET    | /api/detailsByEmail/{email}           | Get student by Email         |
| GET    | /api/detailsByMbno/{mbno}             | Get student by Mobile Number |
| GET    | /api/allStudentDetails                | Get all students             |
| PUT    | /api/updateEmailById/{email}/{id}     | Update email by ID           |
| PUT    | /api/updateMbnoByEmail/{mbno}/{email} | Update mobile by Email       |
| DELETE | /api/deleteById/{id}                  | Delete student               |

---

## ⚙️ Configuration

### application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/projectz?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root@123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 How to Run

### 1️⃣ Clone Repository

```
git clone https://github.com/your-username/student-management-api.git
```

### 2️⃣ Open in IDE

* Import as Maven Project in Eclipse/IntelliJ

### 3️⃣ Run Application

```
mvn spring-boot:run
```

### 4️⃣ Test APIs

* Use Postman
* Base URL:

```
http://localhost:8080/api
```

---

## 🧪 Example JSON

```
{
  "name": "Chaitanya",
  "address": "Hyderabad",
  "email": "chai@example.com",
  "mbno": 9876543210
}
```

---

## 📈 Future Enhancements

* 🔹 Add Global Exception Handling (@ControllerAdvice)
* 🔹 Implement Validation (@Valid, DTO)
* 🔹 Add JWT Authentication & Security
* 🔹 Swagger API Documentation
* 🔹 Deploy to Cloud (AWS / Render)

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork and submit pull requests.

---

## 📧 Contact

**Chaitanya**
🔗 LinkedIn: https://linkedin.com/in/your-profile

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
