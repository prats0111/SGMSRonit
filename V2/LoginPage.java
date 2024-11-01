import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {
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
                login(username, password);
            }
        });
        frame.add(loginButton);
        frame.setVisible(true);
    }

    private void login(String username, String password) {
        if (isAdmin(username, password)) {
            new AdminView(gradeManager).setVisible(true);
            frame.dispose();
        } else if (isStudent(username, password)) {
            new StudentView(gradeManager, username).setVisible(true);
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid login");
        }
    }

    private boolean isAdmin(String username, String password) {
        // Replace with actual admin credentials check
        return "admin".equals(username) && "adminpass".equals(password);
    }

    private boolean isStudent(String username, String password) {
        // Replace with actual student credentials check
        return gradeManager.getAllStudents().contains(username);
    }
}
