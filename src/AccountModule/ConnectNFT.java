package AccountModule;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * File name: ConnectNFT.java
 * Purpose: Take NFT token from user input and make connection of NFT to the user account
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */


public class ConnectNFT extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel tokenEnter;
    private JButton connectButton;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ConnectNFT(String name) {
        setTitle("Connect NFT");
        setMinimumSize(new Dimension(550, 550));
        setResizable(false);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Enter token label
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        tokenEnter = new JLabel("Enter Token :");
        tokenEnter.setFont(new Font("Times", Font.PLAIN, 22));
        panel.add(tokenEnter, c);

        // enter token text field
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        textField = new JTextField(7);
        textField.setFont(new Font("Times", Font.PLAIN, 22));
        textField.setBounds(0, 0, 281, 68);
        panel.add(textField, c);

        // confirm Button
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        connectButton = new JButton("Connect");
        panel.add(connectButton, c);

        // confirm button action
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // database action

                String token = getTokenFromUser(); // gets the token from the user
                try {

                    System.out.println("NFT connection name " + name);
                    System.out.println("Connecting");


                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                            "root", "root");
                    System.out.println("user id: " + getUserId(con, name));

                    // search for the token in the nftTokens table
                    String query = "SELECT * FROM nftTokens WHERE NFT_Token=?";

                    PreparedStatement stmt = con.prepareStatement(query);
                    stmt.setString(1, token);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        // token exists, modify the NFTs table owner_id to the user's id
                        int nftId = rs.getInt("id");
                        int userId = getUserId(con, name); // gets the user's id
//
                        String checkOwnerQuery = "SELECT owner_id FROM NFTs WHERE id=?";
                        PreparedStatement checkOwnerStmt = con.prepareStatement(checkOwnerQuery);
                        checkOwnerStmt.setInt(1, nftId);
                        ResultSet checkOwnerRs = checkOwnerStmt.executeQuery();

                        if (checkOwnerRs.next()) {
                            int ownerId = checkOwnerRs.getInt("owner_id");
                            if (ownerId == 0) {
                                // NFT owner is null, update owner_id to the user's id
                                String updateQuery = "UPDATE NFTs SET owner_id=? WHERE id=?";
                                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                                updateStmt.setInt(1, userId);
                                updateStmt.setInt(2, nftId);
                                int rowsAffected = updateStmt.executeUpdate();
                                if (rowsAffected > 0) {
                                    System.out.println("NFT ownership updated successfully.");
                                    JOptionPane.showMessageDialog(connectButton, "NFT ownership updated successfully.");
                                } else {
                                    System.out.println("Error updating NFT ownership.");
                                    JOptionPane.showMessageDialog(connectButton, "Error updating NFT ownership.");
                                }
                            } else {
                                System.out.println("NFT already has an owner.");
                                JOptionPane.showMessageDialog(connectButton, "NFT already has an owner.");

                            }
                        } else {
                            System.out.println("Error checking NFT owner.");
                        }
                    } else {
                        System.out.println("Token not found.");
                        JOptionPane.showMessageDialog(connectButton, "Token not found.");

                    }
                } catch (SQLException ex) {
                    System.out.println("Error searching for token: " + ex.getMessage());
                }


            }
        });

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);


    }


    private int getUserId(Connection con, String name) {
        // replace this with code that gets the user's id from the user_account table

        int userId = -1;
        try {
            String query = "SELECT id FROM user_account WHERE name=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error getting user ID: " + ex.getMessage());
        }
        return userId;
    }

    private String getTokenFromUser() {
        // replace this with code that gets the token from the user
        return textField.getText();
    }


}
