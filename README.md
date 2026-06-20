# Student Management System

A web application built using Java Servlets, JDBC and Oracle Database.

## Features
- Admin Login
- Add Student
- View Students
- Delete Student
- Update Student

## Technologies Used
- Java Servlets
- Oracle Database
- Apache Tomcat 9.0
- HTML/CSS
- JDBC

## How to Run
1. Install JDK, Eclipse, Apache Tomcat, Oracle DB
2. Clone this repository
3. Import project in Eclipse
4. Create Students table in Oracle:
   CREATE TABLE Students (
       sid VARCHAR2(10) PRIMARY KEY,
       sname VARCHAR2(50),
       email VARCHAR2(50),
       phone NUMBER(15),
       course VARCHAR2(30),
       addr VARCHAR2(100)
   );
5. Update DBConnection.java with your Oracle password
6. Run on Tomcat Server
7. Open: localhost:8082/StudentProjects/Login.html
8. Login: username=admin, password=admin123

## Author
SivaTejaReddy
