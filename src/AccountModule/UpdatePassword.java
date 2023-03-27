package AccountModule;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

public class UpdatePassword extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel newPassword;
    private JButton confirmButton;


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
    public UpdatePassword(String name) {
        setTitle("Update Password");
        setMinimumSize(new Dimension(400, 700));
        setResizable(false);

//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // mew password label
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        newPassword = new JLabel("New Password :");
        newPassword.setFont(new Font("Times", Font.PLAIN, 22));
        panel.add(newPassword, c);

        // enter username text field
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
        confirmButton = new JButton("Confirm");
        panel.add(confirmButton, c);

        // confirm button action
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pstr = textField.getText();
                try {
                    System.out.println("update password name " + name);
                    System.out.println("update password");

                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                            "root", "root");

                    PreparedStatement st = (PreparedStatement) con
                            .prepareStatement("Update user_account set password=? where name=?");

                    st.setString(1, pstr);
                    st.setString(2, name);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(confirmButton, "Password has been successfully changed");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
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



//public class ChangePassword implements ActionListener {

//private final String DB_URL = "jdbc:mysql://localhost/mydatabase";
//private final String DB_USER = "myuser";
//private final String DB_PASSWORD = "mypassword";
//private final String SELECT_QUERY = "SELECT * FROM users WHERE username=?";
//private final String UPDATE_QUERY = "UPDATE users SET password=? WHERE username=?";
//
//private String username;
//
//public ChangePassword(String username) {
//  this.username = username;
//}

//@Override
//public void actionPerformed(ActionEvent e) {
//  // Get the new password from the user input
//  String newPassword = getPasswordFromUserInput();
//
//  // Establish a connection to the SQL database
//  try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//      // Check if the user account exists
//      PreparedStatement selectStatement = conn.prepareStatement(SELECT_QUERY);
//      selectStatement.setString(1, username);
//      if (selectStatement.executeQuery().next()) {
//          // Update the user account password
//          PreparedStatement updateStatement = conn.prepareStatement(UPDATE_QUERY);
//          updateStatement.setString(1, newPassword);
//          updateStatement.setString(2, username);
//          updateStatement.executeUpdate();
//      } else {
//          // Handle the case where the user account doesn't exist
//          handleNonexistentUserAccount();
//      }
//  } catch (SQLException ex) {
//      // Handle SQL exceptions
//      handleSQLException(ex);
//  }
//}
//
//private String getPasswordFromUserInput() {
//	return DB_PASSWORD;
//  // Implement this method to get the new password from the user input
//}
//
//private void handleNonexistentUserAccount() {
//  // Implement this method to handle the case where the user account doesn't exist
//}
//
//private void handleSQLException(SQLException ex) {
//  // Implement this method to handle SQL exceptions
//}

//}



