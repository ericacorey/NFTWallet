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

    private JPanel homePanel, managePanel, viewPanel, profilePanel;

    private String userAccount;

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


    public UserHome(String userAccount) throws SQLException {
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
        homePanel = new HomePanel(userAccount);
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.setSelectedIndex(0);

        // Manage NFT panel
        managePanel = new ManagePanel(userAccount);
        tabbedPane.addTab("Manage NFT", managePanel);

        // View NFT panel
        viewPanel = new ViewNFT(userAccount);
        tabbedPane.addTab("View NFT", viewPanel);

        // Profile panel
        profilePanel = new ProfilePanel(userAccount);
        tabbedPane.addTab("Profile", profilePanel);


        // Add the tabbed pane to this panel.
        setLayout(new GridLayout(1, 1));
        add(tabbedPane);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);

    }

}




