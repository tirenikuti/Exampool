package comp3350.exampool.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.persistence.UserPersistence;

public class UserPersistenceHSQLDB implements UserPersistence {

    private final String dbPath;

    public UserPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file" + dbPath + "; shutdown=true", "User", "");
    }

    private void fromResultSet(final ResultSet rs) throws SQLException {
        final String userID = rs.getString("userID");
        final String userName = rs.getString("name");
        final String type = rs.getString("accountType");
        
    }
}
