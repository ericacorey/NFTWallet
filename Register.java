package AccountModule;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * File Name: Register.java
 * Purpose: Allow user to register account with system, updating the user database
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 */
public class Register extends JFrame implements ActionListener {

    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame =  new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Creates the java swing UI for the register user page
     */
    public Register() {
        setTitle("Register Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(550, 550));
        setResizable(false);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
        GridBagConstraints c = new GridBagConstraints();

        // name label
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        nameLabel = new JLabel("Name ");
        nameLabel.setFont(new Font("Times", Font.PLAIN, 18));
        panel.add(nameLabel, c);

        // enter name text field
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField(7);
        nameField.setFont(new Font("Times", Font.PLAIN, 18));
        nameField.setBounds(0, 0, 281, 68);
        panel.add(nameField, c);

        // email label
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        emailLabel = new JLabel("Email ");
        emailLabel.setFont(new Font("Times", Font.PLAIN, 18));
        panel.add(emailLabel, c);

        // enter email text field
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        emailField = new JTextField(7);
        emailField.setFont(new Font("Times", Font.PLAIN, 18));
        emailField.setBounds(0, 0, 281, 68);
        panel.add(emailField, c);

        // password label
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        passwordLabel = new JLabel("Password ");
        passwordLabel.setFont(new Font("Times", Font.PLAIN, 18));
        panel.add(passwordLabel, c);

        // enter password text field
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField(7);
        passwordField.setFont(new Font("Times", Font.PLAIN, 18));
        passwordField.setBounds(0, 0, 281, 68);
        panel.add(passwordField, c);

        // confirm password label
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        confirmPasswordLabel = new JLabel("Confirm Password ");
        confirmPasswordLabel.setFont(new Font("Times", Font.PLAIN, 18));
        panel.add(confirmPasswordLabel, c);

        // confirm password email text field
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        confirmPasswordField = new JPasswordField(7);
        confirmPasswordField.setFont(new Font("Times", Font.PLAIN, 18));
        confirmPasswordField.setBounds(0, 0, 281, 68);
        panel.add(confirmPasswordField, c);


        // Register Button
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 0;
        c.gridheight = 0;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        panel.add(registerButton, c);;

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    /**
     * Provides main functionality for registering a user; prompts user for info and enters them
     * into database if proper info is supplied
     * @param e Action event representing the clicking of the Register button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your name.");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your email.");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a password.");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            } else {
                // Register the account action
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                            "root", "root");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select name, password, email from user_account");
                    ResultSet rs = st.executeQuery();
                    boolean userFound= false;
                    while (rs.next()){
                        if (name.equals(rs.getString("name"))){
                            userFound = true;
                            JOptionPane.showMessageDialog(this, "Username is already taken. Please choose a new username.");
                            break;
                        }
                    }
                    if (!userFound){
                        String query = "INSERT INTO user_account(name, password, email) VALUES(?, ?, ?)";
                        PreparedStatement st2 = connection.prepareStatement(query);
                        st2.setString(1, name);
                        st2.setString(2, password);
                        st2.setString(3, email);
                        st2.executeUpdate();
                        dispose();
                        UserHome screen = new UserHome(name);
                        screen.setTitle("Account");
                        screen.setVisible(true);
                        JButton newButton = new JButton();
                        JOptionPane.showMessageDialog(newButton, "You have successfully registered!");

                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }


}



