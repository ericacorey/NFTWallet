package ManageAssetsModule;

import javax.swing.*;
import java.sql.*;

public class manageNFT {

    public static void main(String[] args) {
        try {
            connectToDataBase();
            // Line 20 is a custom based on your local database. Remove "airportdb" and
            // replace with the db that your using. Likewise, use the username and password
            // you used when setting up your database connection.

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

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Connection conn = null;
         * try {
         * String myConnectionString =
         * "jdbc:mysql://localhost:3306?" +
         * "useUnicode=yes&characterEncoding=UTF-8";
         * conn = DriverManager.getConnection(myConnectionString, "root", "taco");
         * Statement stmt = conn.createStatement();
         * stmt.execute("SHOW DATABASES");
         * ResultSet rs = stmt.getResultSet();
         * while (rs.next()) {
         * System.out.println(rs.getString(1));
         * }
         * rs.close();
         * stmt.close();
         * conn.close();
         * } catch (SQLException ex) {
         * ex.printStackTrace();
         * }
         * }
         **/
    }

    /**
     * // need to get NFT from other file.
     * 
     * //NFT NFT1 = new NFT("Magic_Mike", 100, true);
     * 
     * public void printNFT() {
     * 
     * 
     * System.out.println("-------------------------");
     * }
     * 
     * 
     * public boolean verifyNFT(NFT NFT1) { // if NFT is locked, return 1, else
     * return 2.
     * if (NFT1.lock_status == true) {
     * return true;
     * } else {
     * return false;
     * }
     * 
     * }
     * 
     * public boolean LockNFT(NFT NFT1) {
     * this.NFT1.lock_status = false;
     * return (this.NFT1.lock_status);
     * }
     * 
     * 
     **/

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

    }

    public static void unlockNFT()//Set to 0 if locked
    {
        //update nfttokens set lock_status = 0 where name = "BORED APE #2"
        System.out.println("Type the name of the nft you want to unlock");
        String nftName = "";
        connectToDataBase(String com);
    }

    public static void connectToDataBase(String com) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root",
                    "taco");
            System.out.println("Connection Sucessful!.......");

            Statement statement = connection.createStatement();

            // ResultSet resultSet = statement.executeQuery("select * from nfttokens");
            PreparedStatement state = connection.prepareStatement(com);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}