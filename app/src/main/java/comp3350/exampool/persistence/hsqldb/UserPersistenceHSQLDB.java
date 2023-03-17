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

    public UserPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file" + dbPath + "; shutdown=true", "User", "");
    }

    private User fromResultSet(final ResultSet rs) throws SQLException {
        final String userID = rs.getString("userID");
        final String userName = rs.getString("name");
        final String type = rs.getString("accountType");
        
        return new User(userID, type, userName);
    }

    @Override
    public List<User> getUserSequential() {
        final List<User> users = new ArrayList<>();
        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("Select * from users");
            while (rs.next()) {
                final User user = fromResultSet(rs);
                users.add(user);
            }
            rs.close();
            st.close();

            return users;
        } catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

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
            throw new android.database.SQLException();
        }
    }

    @Override
    public User insertUser(User currentUser){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO users VALUES(?, ?, ?)");
            st.setString(1, currentUser.getUserID());
            st.setString(2, currentUser.getAccountType());
            st.setString(3, currentUser.getUserName());
            st.executeUpdate();

            return currentUser;
        } catch (final SQLException e) {
            throw new android.database.SQLException();
        }
    }

    @Override
    public User updateUser(User currentUser) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE users SET accountType = ?, userName = ? WHERE userID = ?)");
            st.setString(1, currentUser.getAccountType());
            st.setString(2, currentUser.getUserName());
            st.setString(3, currentUser.getUserID());
            st.executeUpdate();

            return currentUser;
        } catch (final SQLException e) {
            throw new android.database.SQLException();
        }
    }

    @Override
    public void deleteUser(User currentUser) {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM flashcards WHERE userID = ?");
            sc.setString(1, currentUser.getUserID());
            sc.executeUpdate();

            final PreparedStatement st = c.prepareStatement("DELETE FROM notes WHERE userID = ?");
            st.setString(1, currentUser.getUserID());
            st.executeUpdate();

            final PreparedStatement sp = c.prepareStatement("DELETE FROM users WHERE userID = ?");
            st.setString(1, currentUser.getUserID());
            st.executeUpdate();
            
        } catch (final SQLException e) {
            throw new android.database.SQLException();
        }

    }
}
