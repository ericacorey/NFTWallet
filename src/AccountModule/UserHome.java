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

    private JButton connectButton;

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

//        // Create a JPanel to hold the content
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Add some padding

        // create a new JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setForeground(new Color(0, 150,255));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");

        // create four inner panels with different components and add them to the tabbedPane

        // Home page panel
        homePanel = new JPanel();
        homePanelLabel = new JLabel("Connect and Protect your NFTs", SwingConstants.CENTER);
        homePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        homePanel.add(homePanelLabel);
        tabbedPane.addTab("Home", icon, homePanel);
        tabbedPane.setSelectedIndex(0);

        // Manage NFT panel
        managePanel = new JPanel();
        managePanelLabel = new JLabel("Manage your NFTs", SwingConstants.CENTER);
        managePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        managePanel.add(managePanelLabel);
        tabbedPane.addTab("Manage NFT", icon, managePanel);

        // View NFT panel
        viewPanel = new JPanel();
        viewPanelLabel = new JLabel("View your NFTs", SwingConstants.CENTER);
        viewPanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        viewPanel.add(viewPanelLabel);
        tabbedPane.addTab("View NFT", icon, viewPanel);

        // Profile panel
        profilePanel = new JPanel();
        profilePanelLabel = new JLabel("View your profile", SwingConstants.CENTER);
        profilePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        profilePanel.add(profilePanelLabel);
        tabbedPane.addTab("Profile", icon, profilePanel);
        
//        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
//            JLabel tabLabel = new JLabel(tabbedPane.getTitleAt(i), SwingConstants.CENTER);
//            tabLabel.setPreferredSize(new Dimension(100, 50));
//            tabbedPane.setTabComponentAt(i, tabLabel);
//        }

        // Home panel design

        // Home page image icon
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


        // Add the tabbed pane to this panel.
        setLayout(new GridLayout(1, 1));
        add(tabbedPane);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);




/*
        // manage button action
        manageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        transaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        // change password action
        changePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePassword obj = new UpdatePassword(userAccount);
                obj.setTitle("Change Password");
                obj.setVisible(true);

            }
        });

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

 */



    }

    /*
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeButton) {
            // Home button action
//            dispose();
//            Register screen = new Register();

        } else if (e.getSource() == manageButton) {
            // Manage button action

        } else if (e.getSource() == viewButton) {
            // View button action

        }
    }
    */

}




