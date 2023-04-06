package AccountModule;

import javax.swing.*;
import java.awt.*;

public class ManagePanel extends JPanel {

    private JLabel managePanelLabel;

    public ManagePanel(String name){
        // Manage panel label
        managePanelLabel = new JLabel("Manage your NFTs", SwingConstants.CENTER);
        managePanelLabel.setFont(new Font("Times", Font.BOLD, 18));
        add(managePanelLabel);
    }
}
