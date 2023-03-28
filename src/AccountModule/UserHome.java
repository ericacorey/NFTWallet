package AccountModule;

//import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JButton connectButton, manageButton, transaction, changePassword, logOut;

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

    }


    public UserHome(String userAccount) {
        setTitle("Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(550, 550));
        setResizable(false);


        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Connect Button
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        connectButton = new JButton("Connect NFT");
        panel.add(connectButton, c);

        // connect button action
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnectNFT obj = new ConnectNFT(userAccount);
                obj.setTitle("Connect NFT");
                obj.setVisible(true);

            }
        });


        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        manageButton = new JButton("Manage NFT");
        panel.add(manageButton, c);

        // manage button action
        manageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        transaction = new JButton("Transactions");
        panel.add(transaction, c);

        // manage button action
        transaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        changePassword = new JButton("Change Password");
        panel.add(changePassword, c);

        // change password action
        changePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePassword obj = new UpdatePassword(userAccount);
                obj.setTitle("Change Password");
                obj.setVisible(true);

            }
        });



        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        logOut = new JButton("Logout");
        panel.add(logOut, c);

        // logOut action
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(UserHome.this,
                        "Are you sure you want to logout?", "Confirm Logout",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    Login obj = new Login();
                    obj.setVisible(true);
                }
            }

        });

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);



    }
}




