# 📚 Books API - Spring Boot Project

A simple and extensible RESTful API for managing books, built using Spring Boot and Spring Data JPA.  
Supports advanced features like pagination, sorting, validation, and caching.

## 🚀 Features

- ✅ Add, delete, and search books
- 🔍 Filter by author, title, and year
- 🧭 Pagination and sorting support for listing books
- ⚠️ Input validation with custom messages
- 🚀 Caching using Spring Cache (in-memory)
- 🧪 Error handling for bad inputs and constraint violations

## 📦 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate Validator
- H2 Database (or any other DB)
- Spring Cache (e.g. Ehcache or simple in-memory)

## 📡 Endpoints

### Get Books (with optional filters, pagination & sorting)

```http
GET /getBooks?author=John&title=Java&year=2020&page=0&size=5&sort=title,asc
