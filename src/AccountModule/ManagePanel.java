package AccountModule;
import ManageAssetsModule.manageNFT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * File name: ManagePanel.java
 * Purpose: Allows lock and unlock functionality
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */

public class ManagePanel extends JPanel {
    private JLabel managePanelLabel;
    private JButton manageLockNFTLabel;
    private JButton manageUnLockLabel;

    private JTextArea textField;
    private JTextField textField1;

    //private JLabel NFTLabel;

    public ManagePanel(String name)
    {
        // Manage panel label
        managePanelLabel = new JLabel("Manage your NFTs", SwingConstants.CENTER);
        managePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(managePanelLabel);

        manageLockNFTLabel = new JButton("Lock NFTs");
        manageLockNFTLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(manageLockNFTLabel);

        manageUnLockLabel = new JButton("UnLock NFTs");
        manageUnLockLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(manageUnLockLabel);

        textField = new JTextArea();
        textField.setText("");
        add(textField);

        manageLockNFTLabel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = manageNFT.Showtable();
                textField.setText(s);
                String text = JOptionPane.showInputDialog("Type name of NFT to lock");
                manageNFT.lockNFT(text);
                s = manageNFT.Showtable();
                textField.setText(s);
                //System.out.println("Name of NFT to lock: "+text);
            }
        });

        manageUnLockLabel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s = manageNFT.Showtable();
                textField.setText(s);
                String text = JOptionPane.showInputDialog("Type name of NFT to lock");
                manageNFT.unlockNFT(text);
                s = manageNFT.Showtable();
                textField.setText(s);
            }
        });
        /*tring nftData = "";
        NFTLSabel = new JLabel(nftData, SwingConstants.CENTER);
        NFTLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(NFTLabel);*/
    }
}