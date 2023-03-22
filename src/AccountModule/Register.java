package AccountModule;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


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
    public Register() {
        setTitle("Register Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new GridLayout(5, 2));


        setResizable(true);

        nameLabel = new JLabel("Name: ");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        emailLabel = new JLabel("Email: ");
        add(emailLabel);
        emailField = new JTextField();
        add(emailField);

        passwordLabel = new JLabel("Password: ");
        add(passwordLabel);
        passwordField = new JPasswordField();
        add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password: ");
        add(confirmPasswordLabel);
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        registerButton = new JButton("Register");
        add(registerButton);
        registerButton.addActionListener(this);

        setVisible(true);
    }

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
                // TODO: Register the account
            }
        }
    }


}



