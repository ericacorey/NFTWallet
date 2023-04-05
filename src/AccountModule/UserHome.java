package AccountModule;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JLabel homePanelLabel, managePanelLabel, viewPanelLabel, profilePanelLabel, homeImageLabel;

    private JPanel homePanel, managePanel, viewPanel, profilePanel;

    private ImageIcon imageIcon;

    private JButton connectButton, transactionButton, changePasswordButton, logoutButton;

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

        // create a new JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setForeground(new Color(0, 150,255));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // create four inner panels with different components and add them to the tabbedPane

        // Home page panel
        homePanel = new JPanel();
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.setSelectedIndex(0);

        // Manage NFT panel
        managePanel = new JPanel();
        tabbedPane.addTab("Manage NFT", managePanel);

        // View NFT panel
        viewPanel = new JPanel();
        tabbedPane.addTab("View NFT", viewPanel);

        // Profile panel
        profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
        tabbedPane.addTab("Profile", profilePanel);


        // ----------------------------------- Home panel design ---------------------------------------------------------------

        // Home panel label
        homePanelLabel = new JLabel("Connect and Protect your NFTs", SwingConstants.CENTER);
        homePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        homePanel.add(homePanelLabel);

        // Home panel image icon
        imageIcon = new ImageIcon("/Users/ruhuanliao/NFTWallet/NFTGuardian/NFTGuardian/src/image/HomePageImg.png");
        homeImageLabel = new JLabel(imageIcon);
        homeImageLabel.setSize( 550,400 );	// ImageIcon.getIconWidth(), ImageIcon.getIconHeight()
        homeImageLabel.setBounds(0,15,550, 400);
        homePanel.add(homeImageLabel, BorderLayout.CENTER);

        // Connect button
        connectButton = new JButton("Connect NFT");
        connectButton.setFont(new Font("Times", Font.PLAIN, 16));
        homePanel.add(connectButton, BorderLayout.EAST);

        // connect button action
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnectNFT obj = new ConnectNFT(userAccount);
                obj.setTitle("Connect NFT");
                obj.setVisible(true);

            }
        });


        // ----------------------------------- Manage panel design ---------------------------------------------------------------

        // Manage panel label
        managePanelLabel = new JLabel("Manage your NFTs", SwingConstants.CENTER);
        managePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        managePanel.add(managePanelLabel);


        // ----------------------------------- View panel design -----------------------------------------------------------------

        // View panel labedl
        viewPanelLabel = new JLabel("View your NFTs", SwingConstants.CENTER);
        viewPanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        viewPanel.add(viewPanelLabel);


        // ----------------------------------- Profile panel design --------------------------------------------------------------

        // Profile panel label
        profilePanelLabel = new JLabel("View your profile", SwingConstants.CENTER);
        profilePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        profilePanel.add(profilePanelLabel);

        // Transaction button
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
        c.insets = new Insets(10, 0, 0, 0); // Add some spacing
        connectButton = new JButton("Transactions");
        profilePanel.add(connectButton, c);

        // Transaction button action
        connectButton.addActionListener(new ActionListener() {
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
        profilePanel.add(changePasswordButton, c);

        // Change password button action
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePassword obj = new UpdatePassword(userAccount);
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
        profilePanel.add(logoutButton, c);

        // Logout button action
        logoutButton.addActionListener(new ActionListener() {
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


        // Add the tabbed pane to this panel.
        setLayout(new GridLayout(1, 1));
        add(tabbedPane);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);

    }

}




