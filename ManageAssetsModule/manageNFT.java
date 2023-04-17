package ManageAssetsModule;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class manageNFT {

    public static void main(String[] args) {
        Scanner Console = new Scanner(System.in);
        String choice = "";
        while (choice.equals("0") == false) {
            System.out.println(
                    "1. Show Table\n2. Lock NFT\n3. UnLock\n4. Toggle Lock State\n5. Show Table\n0. Close Program.");
            choice = Console.nextLine();
            switch (choice) {
                case "1":
                    Showtable();
                    break;
                case "2":
                    lockNFT();
                    break;
                case "3":
                    unlockNFT();
                    break;
                case "4":
                    Button btn = new Button();
                    btn.push();
                    break;
                case "5":
                    Showtable();
                    break;
            }
        }
    }

    public static String Showtable() {
        String data = "";// Data was created to hold values from the NFT
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
                String creator = resultSet.getString("creator");
                String locked = resultSet.getString("lock_status");
                // System.out.println(resultSet.getString("lock_status"));
                System.out.println("Name: " + Name);
                System.out.println("Creator: " + creator);
                System.out.println("Locked: " + verifyNFT(locked, Name));
                System.out.println("-------------------");
                data += "Name: " + Name + "\n";// Stores values in the NFT
                data += "Creator: " + creator + "\n";
                data += "Locked: " + verifyNFT(locked, Name) + "\n";
                data += "\n";
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static boolean verifyNFT(String locked, String Name) {
        boolean result = false;
        if (locked != null) {
            System.out.println("Locked: " + locked);
            if (locked.equals("1")) {
                System.out.println(Name + " is locked");
                result = true;
            } else {
                System.out.println(Name + " is not locked");
            }
        }
        return result;
    }

    public static void lockNFT() {
        System.out.println("Type the name of the nft you want to lock");
        Scanner console = new Scanner(System.in);
        String nftName = console.nextLine();
        String com = "update nfttokens set lock_status = 1 where name = \"" + nftName + "\";";
        System.out.println(com);
        connectToDataBase(com);
    }

    public static void lockNFT(String nftName) {
        System.out.println("Type the name of the nft you want to lock");
        String com = "update nfttokens set lock_status = 1 where name = \"" + nftName + "\";";
        System.out.println(com);
        connectToDataBase(com);
    }

    public static void unlockNFT()// Set to 0 if locked
    {
        System.out.println("Type the name of the nft you want to unlock");
        Scanner console = new Scanner(System.in);
        String nftName = console.nextLine();
        String com = "update nfttokens set lock_status = 0 where name = \"" + nftName + "\";";
        System.out.println(com);
        connectToDataBase(com);
    }

    public static void unlockNFT(String nftName)// Set to 0 if locked
    {
        System.out.println("Type the name of the nft you want to unlock");
        String com = "update nfttokens set lock_status = 0 where name = \"" + nftName + "\";";
        System.out.println(com);
        connectToDataBase(com);
    }

    public static void connectToDataBase(String com) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root",
                    "taco");
            System.out.println("Connection Sucessful!.......");

            PreparedStatement state = connection.prepareStatement(com);
            state.executeUpdate();
            state.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}