package ManageAssetsModule;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

//  Event - push
// 1. The "wrapper" class                    //  State   ----
class Button { // ON OFF
    // 2. The "current" state object // OFF ON
    private boolean ToggleSwitch; // clicks on and off based off switch case. State Toggle
    private String command;
    // private State current;

    public Button() {
        // current = OFF.instance();
        int value = ((int) (Math.random() * (2)));
        System.out.println(value);
        if (value == 1) {
            ToggleSwitch = true;
        } else if (value == 0) {
            ToggleSwitch = false;
        }
    }
    // public void setCurrent( State s ) { current = s; }

    public void push() { // Reading Toggle switch and setting based off what's being read

        // "update nfttokens set lock_status = 1 where name = \""+nftName+"\";"
        System.out.println("Value: " + ToggleSwitch);
        if (ToggleSwitch == true) {
            RunCommand("update nfttokens set lock_status = 0 where name = ");
        } else if (ToggleSwitch == false) {
            RunCommand("update nfttokens set lock_status = 1 where name = ");
        }
        // current.push(this);
    }

    public void RunCommand(String com) // Relogs into the SQl table to update the table for every NFT
    {
        ArrayList<String> Names = GetNFTNames();

        try {
            for (int i = 0; i < Names.size(); i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root",
                        "taco");

                PreparedStatement state = connection.prepareStatement(com + "\"" + Names.get(i) + "\""); // update
                                                                                                         // nftable set
                                                                                                         // locked=0
                                                                                                         // where name =
                state.executeUpdate();
                state.close();
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> GetNFTNames() // Returns the names of the NFT as an Arraylist
    {
        ArrayList<String> Names = new ArrayList<>();
        try {
            // connectToDataBase();
            // System.out.println("Connection Sucessful!.......");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root",
                    "taco");

            System.out.println("Connection Sucessful!.......");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from nfttokens");

            while (resultSet.next()) {
                String Name = resultSet.getString("name");
                Names.add(Name);

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Names;
    }
}

public class StateToggle {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        int ch;
        Button btn = new Button();
        while (true) {
            System.out.print("Press 'Enter'");
            ch = is.read();
            ch = is.read();
            btn.push();
        }
    }
}