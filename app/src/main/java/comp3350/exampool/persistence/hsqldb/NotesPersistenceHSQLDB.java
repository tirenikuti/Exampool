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
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true;hsqldb.lock_file=false", "SA", "");
    }

    private Notes fromResultSet(final ResultSet rs) throws SQLException {
        final String notesID = rs.getString("notesID");
        final String notesTitle = rs.getString("notesTitle");
        final String userID = rs.getString("userID");
        final String content = rs.getString("content");

        return new Notes(notesID, notesTitle, userID, content);
    }

    @Override
    public List<Notes> getNotesSequential(){
        final List<Notes> notes = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM NOTES");
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
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Notes> getNotesRandom(Notes currentNote){
        final List<Notes> notes = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM notes WHERE notesID=?");
            st.setString(1, currentNote.getNoteID());

            final ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                final Notes note = fromResultSet(rs);
                notes.add(note);
            }
            rs.close();
            st.close();

            return notes;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Notes> getNotesOfUser(User currentUser){
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
            throw new PersistenceException(e);
        }
    }

    @Override
    public Notes insertNotes(Notes currentNotes)
    {
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO notes VALUES(?, ?, ?, ?)");
            st.setString(1, currentNotes.getNoteID());
            st.setString(2, currentNotes.getNoteTitle());
            st.setString(3, currentNotes.getUserID());
            st.setString(4,currentNotes.getNote());

            st.executeUpdate();

            return currentNotes;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public Notes updateNotes(Notes currentNotes)
    {
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE notes SET content = ? WHERE notesID = ?");
            st.setString(1, currentNotes.getNote());
            st.setString(2, currentNotes.getNoteID());

            st.executeUpdate();

            return currentNotes;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
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
            throw new PersistenceException(e);
        }
    }
   
}



