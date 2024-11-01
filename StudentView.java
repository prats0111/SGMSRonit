import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentView extends JFrame {
    private JTable gradeTable;
    private DefaultTableModel tableModel;
    private GradeManager gradeManager;
    private String studentName;
    private JLabel gpaLabel;

    public StudentView(GradeManager gradeManager, String studentName) {
        this.gradeManager = gradeManager;
        this.studentName = studentName;

        setTitle("Student Grade View");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String[] columnNames = {"Subject", "Marks", "Grade"};
        tableModel = new DefaultTableModel(columnNames, 0);
        gradeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(gradeTable);
        scrollPane.setBounds(10, 10, 360, 200);
        add(scrollPane);

        gpaLabel = new JLabel("GPA: " + calculateGPA());
        gpaLabel.setBounds(10, 220, 200, 25);
        add(gpaLabel);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(300, 220, 80, 25);
        logoutButton.addActionListener(e -> {
            dispose(); // Close the student view
            new LoginPage(gradeManager); // Return to login page
        });
        add(logoutButton);

        loadGrades();
    }

    private void loadGrades() {
        tableModel.setRowCount(0);
        List<Grade> grades = gradeManager.getGrades(studentName);
        for (Grade grade : grades) {
            tableModel.addRow(new Object[]{grade.subject, grade.marks, grade.grade});
        }
        gpaLabel.setText("GPA: " + calculateGPA());
    }

    private double calculateGPA() {
        List<Grade> grades = gradeManager.getGrades(studentName);
        if (grades.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        int totalSubjects = grades.size();

        for (Grade grade : grades) {
            totalPoints += convertGradeToPoint(grade.grade);
        }

        return totalPoints / totalSubjects;
    }

    private double convertGradeToPoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }
}
