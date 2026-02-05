# Student Management & Attendance System (Core Java + DSA)

## Overview
This project is a console-based Student Management System built using Core Java and fundamental Data Structures (ArrayList). It demonstrates Object-Oriented Programming (OOP) concepts along with basic data management operations such as creating, updating, deleting, grouping students, and tracking attendance.

This project is intended as an academic exercise to apply Java OOP principles and DSA concepts in a practical scenario.

---

## Features

- Admin login authentication
- Add, update, delete student records
- Create and manage student groups/sections
- Assign students to groups
- Mark and view student attendance
- Menu-driven console interface
- Data stored in-memory using ArrayLists

---

## Technologies Used

- Java (Core Java)
- OOP Concepts
- ArrayList (Java Collections Framework)
- CLI (Console Based Interface)

---

## Project Structure
## Project Structure

| File Name              | Responsibility                          |
|------------------------|------------------------------------------|
| `Admin.java`          | Handles admin authentication             |
| `Student.java`        | Student data model                      |
| `Attendance.java`     | Attendance tracking                     |
| `Group.java`          | Group/Section model                     |
| `GroupManagment.java` | Group operations                        |
| `StudentManagment.java` | Student CRUD operations              |
| `MainWork.java`       | Program entry point & menu flow         |


---

## OOP Concepts Implemented

- Encapsulation
- Object composition (Group contains Students)
- Abstraction via class design
- Separation of concerns across classes

---

## DSA Concepts Used

- ArrayList for dynamic data storage
- Searching and iteration
- Basic grouping logic
- CRUD operations on collections

---

## How to Run

1. Open the project in any Java IDE (IntelliJ, Eclipse, VS Code)
2. Compile all `.java` files
3. Run `MainWork.java`
4. Follow the console menu

---

## Limitations

- No database (data lost after program ends)
- No GUI
- No file persistence
- No user roles apart from Admin
- Not scalable (academic project only)

---

## Learning Outcomes

This project helps in understanding:

- How to structure multi-class Java applications
- How to manage data using ArrayLists
- Real-world usage of OOP concepts
- Building menu-driven console applications

---

## Future Improvements

- Add file or database persistence
- Introduce GUI (JavaFX / Swing)
- Add multiple user roles
- Improve search & reporting
