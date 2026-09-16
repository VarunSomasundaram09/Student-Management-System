# Student Management System

A console-based Student Management System built in Java, using Object-Oriented Programming, ArrayList, and File Handling. This project was built step-by-step as a learning exercise to understand core Java and OOP concepts in a real, working application.

## What It Does

This system is used to store student records — including their ID, name, age, and course. It allows adding, viewing, searching, updating, and deleting students, with each student's details accessible individually through their own fields (ID, name, age, course). All data is saved to a file, so it isn't lost when the program closes, and is automatically reloaded the next time the program runs.

## Features

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student
- Save Students to a File
- Load Students from a File on Startup
- Handles invalid input gracefully (no crashes on bad data)

## Technologies Used

- Java
- Object-Oriented Programming (Classes, Constructors, Getters/Setters)
- ArrayList (Java Collections)
- File Handling (FileWriter, BufferedReader)
- Exception Handling (try-catch)

## Project Structure

```
Student Management System/
├── src/
│   ├── Student.java          → Represents a single student (fields, constructor, getters/setters)
│   ├── StudentManager.java   → Manages the list of students (add, view, search, update, delete, save, load)
│   └── Main.java              → Runs the program, handles the menu and user input
├── .gitignore
└── README.md
```

## How to Run

1. Clone this repository
2. Open the project folder in VS Code (or any Java IDE)
3. Run `Main.java`
4. Follow the on-screen menu to manage students

## What I Learned

This was my first time building a multi-class Java project, connecting different files together (`Student`, `StudentManager`, `Main`) instead of writing everything in one place. Some of the concepts I found most challenging — and valuable to understand properly — were:

- How Java objects are passed by reference, and why updating a student inside a method actually changes the original data in the list
- Reading from and writing to files, and picking a clean data format that's easy for code (not just humans) to parse
- Handling invalid user input with exception handling, so the program doesn't crash
