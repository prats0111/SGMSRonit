Sure! Here’s a user documentation guide for running the Student Grade Management System JAR file on their system:

---

# User Documentation for Student Grade Management System

## Introduction
The Student Grade Management System is a Java-based application that allows administrators to manage student grades and provides students with a way to view their grades and GPA through a graphical user interface (GUI).

## Prerequisites
1. **Java Runtime Environment (JRE)**: Ensure you have JRE installed on your system. You can download it from the [official Java website](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

2. **Download the JAR File**: Obtain the `StudentGradeManagementSystem.jar` file.

## Running the Application

### Step 1: Open a Terminal or Command Prompt
- **Windows**: Press `Win + R`, type `cmd`, and hit `Enter`.
- **Mac/Linux**: Open the Terminal application.

### Step 2: Navigate to the JAR File Directory
Use the `cd` command to change the directory to where the `StudentGradeManagementSystem.jar` file is located. For example:

```bash
cd path/to/your/jar/file
```

### Step 3: Run the JAR File
Execute the following command to run the application:

```bash
java -jar StudentGradeManagementSystem.jar
```

### Step 4: Login
1. You will see a login interface. 
2. Enter the username and password:
   - For **admin** access: 
     - Username: `admin`
     - Password: `adminpass`
   - For **student** access: use any registered student username (e.g., `student1` or `student2`) and their respective password (you can check the `grades.csv` file for usernames).

### Step 5: Navigating the Application
- **Admin Functions**: After logging in as an administrator, you can add, modify, or delete student grades. You can also filter grades based on student name, subject, or grade.
- **Student Functions**: After logging in as a student, you can view your grades and GPA.

## Exiting the Application
To exit the application, you can close the window or use the `Exit` option from the application menu (if available).

## Troubleshooting
- If you encounter any issues, ensure that:
  - You have Java installed correctly.
  - You are using the correct commands in the terminal.
  - The JAR file is not corrupted.

## Support
For any further assistance, please contact the developer or the support team.

---

