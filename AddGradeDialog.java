import javax.swing.*;
import java.awt.event.*;

public class AddGradeDialog extends JDialog {
    private JTextField subjectField;
    private JTextField marksField;
    private JComboBox<String> gradeComboBox;
    private GradeManager gradeManager;
    private String studentName;
    private AdminView adminView; // Reference to AdminView

    public AddGradeDialog(AdminView adminView, GradeManager gradeManager, String studentName) {
        super(adminView, "Add Grade for " + studentName, true);
        this.gradeManager = gradeManager;
        this.studentName = studentName;
        this.adminView = adminView; // Initialize the adminView reference

        setSize(300, 200);
        setLayout(null);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(10, 20, 80, 25);
        add(subjectLabel);

        subjectField = new JTextField();
        subjectField.setBounds(100, 20, 165, 25);
        add(subjectField);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(10, 50, 80, 25);
        add(marksLabel);

        marksField = new JTextField();
        marksField.setBounds(100, 50, 165, 25);
        add(marksField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(10, 80, 80, 25);
        add(gradeLabel);

        String[] grades = {"A", "B", "C", "D", "F"};
        gradeComboBox = new JComboBox<>(grades);
        gradeComboBox.setBounds(100, 80, 165, 25);
        add(gradeComboBox);

        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 120, 80, 25);
        addButton.addActionListener(e -> {
            if (validateInputs()) {
                addGrade();
                adminView.refreshGradeTable(); // Refresh the table in AdminView
                dispose();
            }
        });
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 120, 80, 25);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private boolean validateInputs() {
        // Validate subject input
        if (subjectField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Subject cannot be empty.");
            return false;
        }

        // Validate marks input
        try {
            int marks = Integer.parseInt(marksField.getText());
            if (marks < 0 || marks > 100) {
                JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Marks.");
            return false;
        }

        return true;
    }

    private void addGrade() {
        String subject = subjectField.getText();
        int marks = Integer.parseInt(marksField.getText());
        String grade = (String) gradeComboBox.getSelectedItem();
        gradeManager.addGrade(new Grade(subject, marks, grade), studentName);
        JOptionPane.showMessageDialog(this, "Grade added successfully for " + studentName);
    }
}
