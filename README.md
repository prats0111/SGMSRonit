### Title Page ###

## Student Grade Management System ##
Developed by: Ronit Rao
Course: [Your Course Name]
Date: 31/10/2024

### Problem Statement ###

The objective of this project is to develop a GUI-based Student Grade Management System that facilitates the management of student grades by administrators while allowing students to view their own grades. The system includes role-based access, enabling administrators to add, edit, and delete grades, while providing students with a clear view of their academic performance.

### Methodology ###

The development of the Student Grade Management System follows these key steps:

**Requirement Analysis:** Identifying the essential features needed for both administrator and student roles.

**Design:** Creating user interfaces using Java Swing for seamless user interaction.

**Implementation:** Writing Java code for functionalities including login, grade management, and data display.

**Testing:** Verifying that each component functions correctly and meets the specified requirements.

**Documentation:** Providing comprehensive comments and documentation for code clarity and maintenance.


## Results and Screenshot ##

After completing the implementation, the application successfully allows:

**Administrator Login:** Secure access to grade management functions.

**Grade Management:** Ability to add, edit, and delete grades.

**Student View:** Easy access to view personal grades and GPA.

**Screenshots:** (You can insert screenshots of your application here)

  ###  Login Page ###

  ###  Administrator Grade Management ###

 ###   Student View ###

 ### How to Run the Program ###
 To run the Java code for the Student Grade Management System, follow these steps:

### Step 1: Set Up Your Development Environment

1. **Install Java Development Kit (JDK)**:
   - Download and install the JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/install/).
   - Ensure the installation path is added to your system's PATH environment variable.

2. **Choose an Integrated Development Environment (IDE)**:
   - You can use an IDE like **IntelliJ IDEA**, **Eclipse**, or **NetBeans**. Download and install one if you don’t have it already.

### Step 2: Create a New Java Project

1. **Open your IDE**:
   - Create a new Java project.

2. **Create Java Classes**:
   - In the project directory, create a package (e.g., `studentgradesystem`).
   - Create Java classes:
     - `LoginPage.java`
     - `Grade.java`
     - `GradeManager.java`
     - `StudentView.java`
   - Copy and paste the respective code snippets into each file.

### Step 3: Compile and Run the Program

1. **Main Class**:
   - Ensure your `LoginPage` class has the `main` method since it serves as the entry point of your application.

2. **Compile**:
   - If using an IDE, you can typically compile the project with a button click (e.g., "Build" or "Compile").
   - If using the command line, navigate to the project directory and compile with:
     ```bash
     javac LoginPage.java Grade.java GradeManager.java StudentView.java
     ```

3. **Run**:
   - Again, if using an IDE, run the main class (usually with a play button).
   - If using the command line, execute:
     ```bash
     java LoginPage
     ```

### Step 4: Test the Application

1. **Login Page**:
   - After running the program, the login window should appear.
   - Enter the username and password (e.g., `admin`/`adminpass` or `student1`/`studentpass`) to test the login functionality.

2. **Admin and Student Features**:
   - Depending on how you implement navigation after login, you should be able to access features for grade management or viewing grades.

### Troubleshooting

- **Java Not Found**: Ensure Java is installed and the PATH is correctly set.
- **Compilation Errors**: Check for typos or missing imports.
- **GUI Not Displaying**: Ensure that your main method is correctly calling the GUI classes.

By following these steps, you should be able to run the Student Grade Management System code successfully. If you encounter any issues or need further assistance, feel free to ask!
