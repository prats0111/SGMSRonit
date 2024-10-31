import javax.swing.*;
import java.util.List;

// Class for viewing student grades
class StudentView {
    private JFrame frame;

    public StudentView(List<Grade> grades) {
        frame = new JFrame("Student Grades");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Display grades
        for (Grade grade : grades) {
            JLabel label = new JLabel(grade.subject + ": " + grade.marks + " (" + grade.grade + ")");
            frame.add(label);
        }

        // Make the frame visible
        frame.setVisible(true);
    }
}
