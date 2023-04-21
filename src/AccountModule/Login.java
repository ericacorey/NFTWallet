package AccountModule;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * File name: Login.java
 * Purpose: Take username and password for login into the account
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */

public class Login extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel usernameLabel, passwordLabel, logoLabel;
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
                    SwingUtilities.invokeLater(()-> new Login());
//                    Login frame = new Login();
//                    frame.setVisible(true);

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
        setMinimumSize(new Dimension(550, 550));
        setResizable(false);

        ImageIcon ImageIcon = new ImageIcon("/Users/ruhuanliao/NFTWallet/NFTGuardian/NFTGuardian/src/image/logo.png");
        logoLabel = new JLabel(ImageIcon);
        logoLabel.setSize(170, 170 );	// ImageIcon.getIconWidth(), ImageIcon.getIconHeight()
        logoLabel.setLocation(210, 0);
        logoLabel.setBorder(new EmptyBorder(20,0,0,0));		// top, left bottom, right

        add(logoLabel, BorderLayout.CENTER);


        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
//        panel.setBackground(new Color(73,132,184));	// panel background color

        GridBagConstraints c = new GridBagConstraints();


        // username label
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        usernameLabel = new JLabel("Username ");
        usernameLabel.setFont(new Font("Times", Font.PLAIN, 20));
        panel.add(usernameLabel, c);

        // enter username text field
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(7);
        usernameField.setFont(new Font("Times", Font.PLAIN, 20));
        usernameField.setBounds(0, 0, 281, 68);
        panel.add(usernameField, c);

        // password label
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        passwordLabel = new JLabel("Password ");
        passwordLabel.setFont(new Font("Times", Font.PLAIN, 20));
        passwordLabel.setBounds(20, 0, 281, 68);
        panel.add(passwordLabel, c);

        // enter password text field
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        passwordField = new JPasswordField(7);
        passwordField.setFont(new Font("Times", Font.PLAIN, 20));
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
                        UserHome screen = new UserHome(username);
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

