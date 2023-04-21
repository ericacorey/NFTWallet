package AccountModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File name: ProfilePanel.java
 * Purpose: Displays Profile tab panel layout
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */

public class ProfilePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel profilePanelLabel;
    private JButton transactionButton, changePasswordButton, logoutButton;

    public ProfilePanel(String name){

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Profile panel label
        profilePanelLabel = new JLabel("View your profile", SwingConstants.CENTER);
        profilePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(profilePanelLabel);


        // Transaction button
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        transactionButton = new JButton("Transactions");
        add(transactionButton, c);

        // Transaction button action
        transactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        // Change password button
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        changePasswordButton = new JButton("Change password");
        add(changePasswordButton, c);

        // Change password button action
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePassword obj = new UpdatePassword(name);
                obj.setTitle("Change Password");
                obj.setVisible(true);
            }
        });

        // Logout button
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(50, 0, 0, 0); // Add some spacing
        logoutButton = new JButton("Logout");
        // Add the ActionListener to the logout button
        logoutButton.addActionListener(new logoutAction());
        add(logoutButton, c);
    }

    private class logoutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(ProfilePanel.this,
                        "Are you sure you want to logout?", "Confirm Logout",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Dispose of the main panel
                    Window window = SwingUtilities.windowForComponent(ProfilePanel.this);
                    window.dispose();
                    Login obj = new Login();
                    obj.setVisible(true);
                }
        }
    }

}


