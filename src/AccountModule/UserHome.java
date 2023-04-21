package AccountModule;

import javax.swing.*;

import java.awt.*;
import java.sql.SQLException;

/**
 * File name: UserHome.java
 * Purpose: Display user account content panel and sub panel tabs
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */

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

    /**
     * UserHome Class constructor.
     */
    public UserHome() {

    }


    /**
     * UserHome Class constructor specifying user account.
     * * @throws SQLException  If an input or output
     * *                      exception occurred
     * *                      with getting SQL database.
     */
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
        viewPanel = new ViewPanel(userAccount);
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




