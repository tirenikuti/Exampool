// This class searches the contents of the Notes table in JDBC
package comp3350.exampool.Search;

import java.sql.*;
 
public class SearchInDBNotes {
 
    // Main driver method
    public static void main(String[] args)
    {
        //Establishing a connection
        ConnectionDatabaseNotes connection = new ConnectionDatabaseNotes();

        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        connect = connection.ConnectionDatabaseNotes();
 
        // Try block to check exceptions
        try {
 
            //Write  and process the statement
            String sql="select * from cuslogin where id="+Integer.parseInt(textfield.getText());
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
 
            //Checking for next() till empty
            if (rs.next()) {
               
                int id = rs.getInt("Id: ");
                String userName = rs.getString("User Name: ");
                String email = rs.getString("Email: ");
                String password = rs.getString("Password: ");
                 
              // Print and display name, emailID and password
              System.out.println(id + "\t\t" + userName + "\t\t" + email + "\t\t" + password);
            }
        }//try
        catch (SQLException e) {
 
            // Print the exception
            System.out.println(e);
        }//Catch
    }//main
}//SearchInDB
