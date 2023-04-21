package AccountModule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.Vector;

/**
 * File name: ViewPanel.java
 * Purpose: Displays NFTs connected to user account in the ViewNFT tab panel
 * @author Ruhuan Liao, Erica Corey, Stefan Mitrovic, Sean Butler, Aaron Montenegro
 * @version 1.1
 * */
public class ViewPanel extends JPanel {
//    private JLabel viewPanelLabel;

    public ViewPanel(String name) throws SQLException {
        // Display NFT action

        // Connect to the SQL database
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                "root", "root");


        // Retrieve the relevant data from the SQL database using SQL queries
        String query = "SELECT id, name, floor_price FROM NFTs WHERE owner_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, getUserId(con, name));
        ResultSet rs = stmt.executeQuery();

        // Create a new JTable with the ResultSet as its model
        JTable table = new JTable(buildTableModel(rs));

        // Add the JTable to a JScrollPane and add the JScrollPane to the panel
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Close the ResultSet, statement, and connection
        rs.close();
        stmt.close();
        con.close();

    }


    private TableModel buildTableModel (ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // Get the column names
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        // Get the data rows
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }

        // Create a new TableModel with the column names and data rows
        return new DefaultTableModel(data, columnNames);
    }

    private int getUserId(Connection con, String name) {
        // replace this with code that gets the user's id from the user_account table

        int userId = -1;
        try {
            String query = "SELECT id FROM user_account WHERE name=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error getting user ID: " + ex.getMessage());
        }
        return userId;
    }



}
