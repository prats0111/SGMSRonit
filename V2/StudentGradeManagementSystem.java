import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main class for the Student Grade Management System
public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();

        // Add some sample grades for students
        gradeManager.addGrade(new Grade("Math", 95, "A"), "student1");
        gradeManager.addGrade(new Grade("Science", 88, "B"), "student1");
        gradeManager.addGrade(new Grade("Math", 76, "C"), "student2");
        gradeManager.addGrade(new Grade("Science", 85, "B"), "student2");

        // Launch the login page
        new LoginPage(gradeManager);
    }
}
