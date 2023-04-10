//Used to create and execute queries regarding creation, deletion and editing of users in the Database - currently not connected to the flashcards and notes, but will be in the future iteration
package comp3350.exampool.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.UserPersistence;

public class UserPersistenceHSQLDB implements UserPersistence {

    private final String dbPath;

    /**
     * Constructor for the class
     * @param dbPath path to Database
     */
    public UserPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    /**
     * Method to establish connection to the databse
     * @return the connection
     * @throws SQLException if the connection was unsuccessful
     */
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true;hsqldb.lock_file=false", "SA", "");
    }

    /**
     * Method to create user from a result set from a query in SQL
     * @param rs result set
     * @return user from database
     * @throws SQLException if creation from database was unsuccessful
     */
    private User fromResultSet(final ResultSet rs) throws SQLException {
        final String userID = rs.getString("userID");
        final String userName = rs.getString("name");
        
        return new User(userID, userName);
    }

    /**
     * Gets all the users in the database
     * @return list of users
     */
    @Override
    public List<User> getUserSequential() {
        final List<User> users = new ArrayList<>();
        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                final User user = fromResultSet(rs);
                users.add(user);
            }
            rs.close();
            st.close();

            return users;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Gets a specific user from the database
     * @param currentUser user needed from DB
     * @return user if it exists
     */
    @Override
    public List<User> getUserRandom(User currentUser) {
        final List<User> users = new ArrayList<>();
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("Select * FROM users WHERE userID = ?");
            st.setString(1, currentUser.getUserID());

            final ResultSet rs = st.executeQuery();
            while(rs.next()) {
                final User user = fromResultSet(rs);
                users.add(user);
            }
            rs.close();
            st.close();

            return users;
        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to insert a new user to the database
     * @param currentUser user to be inserted
     * @return user if it is inserted successfully
     */
    @Override
    public User insertUser(User currentUser){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO USERS VALUES(?, ?, ?)");
            st.setString(1, currentUser.getUserID());
            st.setString(2, currentUser.getUserName());
            st.executeUpdate();

            return currentUser;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to update a user in the database
     * @param currentUser user to be updated
     * @return user if it is updated successfully
     */
    @Override
    public User updateUser(User currentUser) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE USERS SET  name = ? WHERE userID = ?");
            st.setString(1, currentUser.getUserName());
            st.setString(2, currentUser.getUserID());
            st.executeUpdate();

            return currentUser;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to delete user from the database
     * @param currentUser user to be deleted
     */
    @Override
    public void deleteUser(User currentUser) {
        try (final Connection c = connection()) {

            final PreparedStatement sp = c.prepareStatement("DELETE FROM users WHERE userID = ?");
            sp.setString(1, currentUser.getUserID());
            sp.executeUpdate();
            
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
