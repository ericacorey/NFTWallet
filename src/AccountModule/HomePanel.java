package AccountModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {

    private JLabel homePanelLabel, homeImageLabel;

    private ImageIcon imageIcon;

    private JButton connectButton;
    public HomePanel(String name){
        // Home panel label
        homePanelLabel = new JLabel("Connect and Protect your NFTs", SwingConstants.CENTER);
        homePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(homePanelLabel);

        // Home panel image icon
        imageIcon = new ImageIcon("/Users/ruhuanliao/NFTWallet/NFTGuardian/NFTGuardian/src/image/HomePageImg.png");
        homeImageLabel = new JLabel(imageIcon);
        homeImageLabel.setSize( 550,400 );	// ImageIcon.getIconWidth(), ImageIcon.getIconHeight()
        homeImageLabel.setBounds(0,15,550, 400);
        add(homeImageLabel, BorderLayout.CENTER);

        // Connect button
        connectButton = new JButton("Connect NFT");
        connectButton.setFont(new Font("Times", Font.PLAIN, 16));
        add(connectButton, BorderLayout.EAST);

        // connect button action
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnectNFT obj = new ConnectNFT(name);
                obj.setTitle("Connect NFT");
                obj.setVisible(true);

            }
        });


    }
}
