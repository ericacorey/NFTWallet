package AccountModule;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserHome extends JFrame implements ActionListener {

    private JButton connectButton, manageButton, changePassword, logOut;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame =  new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public UserHome() {
        setTitle("Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 700));
        setResizable(false);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Connect Button
        GridBagConstraints c = new GridBagConstraints();
        // Login Button
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        connectButton = new JButton("Connect NFT");
        connectButton.addActionListener(this);
        panel.add(connectButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        manageButton = new JButton("Manage NFT");
        manageButton.addActionListener(this);
        panel.add(manageButton, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        changePassword = new JButton("Change Password");
        changePassword.addActionListener(this);
        panel.add(changePassword, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        logOut = new JButton("Logout");
        logOut.addActionListener(this);
        panel.add(logOut, c);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connectButton) {
            // action


        } else if (e.getSource() == manageButton) {
            // action


        } else if (e.getSource() == changePassword) {
            // action
//            UpdatePassword up = new UpdatePassword();
//            up.setTitle("Change Password");
//            up.setVisible(true);


        } else if (e.getSource() == logOut){
            // action
            int a = JOptionPane.showConfirmDialog(logOut, "Are you sure?");
            JOptionPane.setRootFrame(null);
            if (a == JOptionPane.YES_OPTION) {
                dispose();
                Login obj = new Login();
                obj.setTitle("User-Login");
                obj.setVisible(true);
            }
            dispose();
            Login obj = new Login();

            obj.setTitle("User-Login");
            obj.setVisible(true);


        }

    }





}



