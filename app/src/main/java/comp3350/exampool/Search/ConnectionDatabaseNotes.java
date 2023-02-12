// The connectionDatabase browses through the Notes
//database
 
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConnectionDatabaseNotes{
 
    final String URL = "";//  We do not have the database credentials yet
     
    // The Root to access the database
    final String USER = "root";
     
    // The Password to access the database
    final String PASSWORD = "pass";
 
    // Connection class for our database connectivity
   public Connection ConnectionDatabaseNotes()
    {
        Connection connect = null;
 
        // Try and Catch block to check and handle exceptions
        try {
 
            // Loading database drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Registering SQL drivers
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // if class not found
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connect;
    }
}