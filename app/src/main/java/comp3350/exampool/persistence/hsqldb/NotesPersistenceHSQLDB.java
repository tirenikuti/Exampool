package comp3350.exampool.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.NotesPersistence;

public class NotesPersistenceHSQLDB implements NotesPersistence {

    private final String dbPath;
    
    public NotesPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "USer", "");
    }

    private Notes fromResultSet(final ResultSet rs) throws SQLException {
        final String notesID = rs.getString("notesID");
        final String userID = rs.getString("userID");
        final String content = rs.getString("content");

        return new Notes(notesID, userID, content);
    }


    public List<Notes> getNotesSequiential(){
        final List<Notes> notes = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM notes");
            while(rs.next())
            {
                final Notes note = fromResultSet(rs);
                notes.add(note);
            }
            rs.close();
            st.close();

            return notes;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public List<Notes> getNotesSequential() {
        return null;
    }

    @Override
    public List<Notes> getNotes(Notes currentNotes){
        final List<Notes> notes = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM notes WHERE flashCardID = ?");
            st.setString (1, currentNotes.getNoteID());

            final ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Notes note = fromResultSet(rs);
                notes.add(note);
            }
            rs.close();
            st.close();

            return notes;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public List<Notes> getNotesUsers(User currentUser){
        final List<Notes> notes = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM notes WHERE userID = ?");
            st.setString (1, currentUser.getUserID());

            final ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Notes note = fromResultSet(rs);
                notes.add(note);
            }
            rs.close();
            st.close();

            return notes;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public void deleteNotes(Notes currentNotes){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM notes WHERE notesID = ?");
            st.setString (1, currentNotes.getNoteID());
            st.executeUpdate();
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }
   
}



