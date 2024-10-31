import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main class for the Student Grade Management System
public class StudentGradeManagementSystem {
    // Class to represent a grade
    static class Grade {
        String subject;
        int marks;
        String grade;

        public Grade(String subject, int marks, String grade) {
            this.subject = subject;
            this.marks = marks;
            this.grade = grade;
        }
    }

    // Class to manage grades
    static class GradeManager {
        private List<Grade> grades = new ArrayList<>();

        public void addGrade(Grade grade) {
            grades.add(grade);
        }

        public void editGrade(int index, Grade newGrade) {
            if (index >= 0 && index < grades.size()) {
                grades.set(index, newGrade);
            }
        }

        public void deleteGrade(int index) {
            if (index >= 0 && index < grades.size()) {
                grades.remove(index);
            }
        }

        public List<Grade> getGrades() {
            return grades;
        }
    }

    // Class for the login page
    static class LoginPage {
        private JFrame frame;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private GradeManager gradeManager;

        public LoginPage(GradeManager gradeManager) {
            this.gradeManager = gradeManager;
            frame = new JFrame("Login");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setBounds(10, 20, 80, 25);
            frame.add(usernameLabel);

            usernameField = new JTextField();
            usernameField.setBounds(100, 20, 165, 25);
            frame.add(usernameField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setBounds(10, 50, 80, 25);
            frame.add(passwordLabel);

            passwordField = new JPasswordField();
            passwordField.setBounds(100, 50, 165, 25);
            frame.add(passwordField);

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(10, 80, 80, 25);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (authenticate(username, password)) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                        new StudentView(gradeManager.getGrades()).setVisible(true);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Credentials");
                    }
                }
            });
            frame.add(loginButton);
            frame.setVisible(true);
        }

        // Method to authenticate user
        private boolean authenticate(String username, String password) {
            Map<String, String> users = new HashMap<>();
            users.put("admin", "adminpass");
            users.put("student1", "studentpass");

            return users.containsKey(username) && users.get(username).equals(password);
        }
    }

    // Class for viewing student grades
    static class StudentView {
        private JFrame frame;

        public StudentView(List<Grade> grades) {
            frame = new JFrame("Student Grades");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            for (Grade grade : grades) {
                JLabel label = new JLabel(grade.subject + ": " + grade.marks + " (" + grade.grade + ")");
                frame.add(label);
            }
        }
    }

    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        // Add some sample grades
        gradeManager.addGrade(new Grade("Math", 95, "A"));
        gradeManager.addGrade(new Grade("Science", 88, "B"));
        new LoginPage(gradeManager); // Launch the login page
    }
}
