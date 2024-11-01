import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class AdminView extends JFrame {
    private JTable gradeTable;
    private DefaultTableModel tableModel;
    private GradeManager gradeManager;

    // Filter components
    private JTextField studentFilterField;
    private JTextField subjectFilterField;
    private JComboBox<String> gradeFilterComboBox;

    public AdminView(GradeManager gradeManager) {
        this.gradeManager = gradeManager;

        setTitle("Admin Grade Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Filter components
        JLabel studentFilterLabel = new JLabel("Filter by Student:");
        studentFilterLabel.setBounds(10, 10, 150, 25);
        add(studentFilterLabel);

        studentFilterField = new JTextField();
        studentFilterField.setBounds(150, 10, 150, 25);
        add(studentFilterField);

        JLabel subjectFilterLabel = new JLabel("Filter by Subject:");
        subjectFilterLabel.setBounds(320, 10, 150, 25);
        add(subjectFilterLabel);

        subjectFilterField = new JTextField();
        subjectFilterField.setBounds(450, 10, 150, 25);
        add(subjectFilterField);

        JLabel gradeFilterLabel = new JLabel("Filter by Grade:");
        gradeFilterLabel.setBounds(10, 40, 150, 25);
        add(gradeFilterLabel);

        String[] grades = {"All", "A", "B", "C", "D", "F"};
        gradeFilterComboBox = new JComboBox<>(grades);
        gradeFilterComboBox.setBounds(150, 40, 150, 25);
        add(gradeFilterComboBox);

        JButton filterButton = new JButton("Filter");
        filterButton.setBounds(320, 40, 80, 25);
        filterButton.addActionListener(e -> applyFilters());
        add(filterButton);

        // Table setup
        String[] columnNames = {"Student", "Subject", "Marks", "Grade"};
        tableModel = new DefaultTableModel(columnNames, 0);
        gradeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(gradeTable);
        scrollPane.setBounds(10, 80, 560, 200);
        add(scrollPane);

        JButton addButton = new JButton("Add Grade");
        addButton.setBounds(10, 300, 100, 25);
        addButton.addActionListener(e -> addGrade());
        add(addButton);

        JButton modifyButton = new JButton("Modify Grade");
        modifyButton.setBounds(120, 300, 120, 25);
        modifyButton.addActionListener(e -> modifyGrade());
        add(modifyButton);

        JButton deleteButton = new JButton("Delete Grade");
        deleteButton.setBounds(250, 300, 120, 25);
        deleteButton.addActionListener(e -> deleteGrade());
        add(deleteButton);

        loadAllGrades();
    }

    public void refreshGradeTable() {
        loadAllGrades();
    }

    private void loadAllGrades() {
        tableModel.setRowCount(0);
        for (String student : gradeManager.getAllStudents()) {
            List<Grade> grades = gradeManager.getGrades(student);
            for (Grade grade : grades) {
                tableModel.addRow(new Object[]{student, grade.subject, grade.marks, grade.grade});
            }
        }
    }

    private void applyFilters() {
        String studentFilter = studentFilterField.getText().toLowerCase();
        String subjectFilter = subjectFilterField.getText().toLowerCase();
        String gradeFilter = (String) gradeFilterComboBox.getSelectedItem();

        tableModel.setRowCount(0); // Clear current table data

        for (String student : gradeManager.getAllStudents()) {
            List<Grade> grades = gradeManager.getGrades(student);
            for (Grade grade : grades) {
                boolean matchesStudent = studentFilter.isEmpty() || student.toLowerCase().contains(studentFilter);
                boolean matchesSubject = subjectFilter.isEmpty() || grade.subject.toLowerCase().contains(subjectFilter);
                boolean matchesGrade = "All".equals(gradeFilter) || grade.grade.equals(gradeFilter);

                if (matchesStudent && matchesSubject && matchesGrade) {
                    tableModel.addRow(new Object[]{student, grade.subject, grade.marks, grade.grade});
                }
            }
        }
    }

    private void addGrade() {
        int selectedRow = gradeTable.getSelectedRow();
        if (selectedRow >= 0) {
            String studentName = (String) tableModel.getValueAt(selectedRow, 0);
            new AddGradeDialog(this, gradeManager, studentName).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select a student to add a grade.");
        }
    }

    private void modifyGrade() {
        int selectedRow = gradeTable.getSelectedRow();
        if (selectedRow >= 0) {
            String studentName = (String) tableModel.getValueAt(selectedRow, 0);
            String subject = (String) tableModel.getValueAt(selectedRow, 1);
            Grade existingGrade = gradeManager.getGrade(studentName, subject);
            if (existingGrade != null) {
                new ModifyGradeDialog(this, gradeManager, studentName, existingGrade).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No grade found to modify.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a grade to modify.");
        }
    }

    private void deleteGrade() {
        int selectedRow = gradeTable.getSelectedRow();
        if (selectedRow >= 0) {
            String studentName = (String) tableModel.getValueAt(selectedRow, 0);
            String subject = (String) tableModel.getValueAt(selectedRow, 1);
            gradeManager.deleteGrade(studentName, subject);
            refreshGradeTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a grade to delete.");
        }
    }
}
