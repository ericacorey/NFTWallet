package AccountModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton, loginButton, newButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 600, 450);
        setResizable(true);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // username label
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        usernameLabel = new JLabel("Username ");
        usernameLabel.setFont(new Font("Times", Font.PLAIN, 24));
        panel.add(usernameLabel, c);

        // enter username text field
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(10);
        usernameField.setFont(new Font("Times", Font.PLAIN, 24));
        usernameField.setBounds(0, 0, 281, 68);
        panel.add(usernameField, c);

        // password label
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        passwordLabel = new JLabel("Password ");
        passwordLabel.setFont(new Font("Times", Font.PLAIN, 24));
        passwordLabel.setBounds(20, 0, 281, 68);
        panel.add(passwordLabel, c);

        // enter password text field
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        passwordField = new JPasswordField(10);
        passwordField.setFont(new Font("Times", Font.PLAIN, 24));
        panel.add(passwordField, c);

        // Login Button
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton, c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        panel.add(registerButton, c);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            dispose();
            Register screen = new Register();
        } else if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your username.");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your password.");
            } else {
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                            "root", "root");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select name, password from user_account where name=? and password=?");

                    st.setString(1, username);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHome screen = new UserHome();
                        screen.setTitle("Account");
                        screen.setVisible(true);
                        JOptionPane.showMessageDialog(newButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(newButton, "Wrong Username or Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }



}

