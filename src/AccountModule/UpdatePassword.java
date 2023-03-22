package AccountModule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        setBounds(500, 500, 600, 450);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // new password label
        newPassword = new JLabel("New Password :");
        newPassword.setFont(new Font("Times", Font.PLAIN, 18));
        newPassword.setBounds(45, 37, 150, 67);
        contentPane.add(newPassword);

        // enter new password textfield
        textField = new JTextField();
        textField.setFont(new Font("Times", Font.PLAIN, 28));
        textField.setBounds(200, 35, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        // confirm label
        JButton btnSearch = new JButton("Confirm");
        btnSearch.addActionListener(new ActionListener() {
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
                    JOptionPane.showMessageDialog(btnSearch, "Password has been successfully changed");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        });

        btnSearch.setFont(new Font("Times", Font.PLAIN, 18));
        btnSearch.setBackground(new Color(240, 240, 240));
        btnSearch.setBounds(280, 120, 120, 50);
        contentPane.add(btnSearch);


    }
}




