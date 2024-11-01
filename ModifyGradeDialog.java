import javax.swing.*;
import java.awt.event.*;

public class ModifyGradeDialog extends JDialog {
    private JTextField subjectField;
    private JTextField marksField;
    private JComboBox<String> gradeComboBox;
    private GradeManager gradeManager;
    private String studentName;
    private Grade existingGrade;
    private AdminView adminView; // Reference to AdminView

    public ModifyGradeDialog(AdminView adminView, GradeManager gradeManager, String studentName, Grade existingGrade) {
        super(adminView, "Modify Grade for " + studentName, true);
        this.adminView = adminView; // Initialize the adminView reference
        this.gradeManager = gradeManager;
        this.studentName = studentName;
        this.existingGrade = existingGrade;

        setSize(300, 200);
        setLayout(null);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(10, 20, 80, 25);
        add(subjectLabel);

        subjectField = new JTextField(existingGrade.subject);
        subjectField.setBounds(100, 20, 165, 25);
        add(subjectField);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(10, 50, 80, 25);
        add(marksLabel);

        marksField = new JTextField(String.valueOf(existingGrade.marks));
        marksField.setBounds(100, 50, 165, 25);
        add(marksField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(10, 80, 80, 25);
        add(gradeLabel);

        String[] grades = {"A", "B", "C", "D", "F"};
        gradeComboBox = new JComboBox<>(grades);
        gradeComboBox.setSelectedItem(existingGrade.grade);
        gradeComboBox.setBounds(100, 80, 165, 25);
        add(gradeComboBox);

        JButton modifyButton = new JButton("Modify");
        modifyButton.setBounds(10, 120, 80, 25);
        modifyButton.addActionListener(e -> {
            modifyGrade();
            adminView.refreshGradeTable(); // Refresh the grade table after modification
            dispose();
        });
        add(modifyButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 120, 80, 25);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void modifyGrade() {
        String subject = subjectField.getText();
        int marks = Integer.parseInt(marksField.getText());
        String grade = (String) gradeComboBox.getSelectedItem();

        // Update the grade in the manager
        gradeManager.deleteGrade(studentName, existingGrade.subject); // Remove old grade
        gradeManager.addGrade(new Grade(subject, marks, grade), studentName); // Add updated grade
        JOptionPane.showMessageDialog(this, "Grade modified successfully for " + studentName);
    }
}
