import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

// Class for the login page
public class LoginPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        // Initialize the frame
        frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Username label and field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        frame.add(usernameField);

        // Password label and field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        frame.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle login logic here (authenticate user)
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    // Proceed to the next screen based on role
                    // Here you can instantiate the appropriate class (AdminView or StudentView)
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials");
                }
            }
        });
        frame.add(loginButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to authenticate user
    public boolean authenticate(String username, String password) {
        // Example user data (in practice, retrieve from a database or file)
        Map<String, String> users = new HashMap<>();
        users.put("admin", "adminpass");
        users.put("student1", "studentpass");

        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        new LoginPage(); // Launch the login page
    }
}
