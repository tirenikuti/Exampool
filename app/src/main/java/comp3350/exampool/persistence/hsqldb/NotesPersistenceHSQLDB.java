//Used to create and execute queries regarding creation, deletion and editing of notes in the Database
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

    /**
     * Constructor for the class
     * @param dbPath path to Database
     */
    public NotesPersistenceHSQLDB(final String dbPath) {
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
     * Method to create note from a result set from a query in SQL
     * @param rs result set
     * @return note from database
     * @throws SQLException if creation from database was unsuccessful
     */
    private Notes fromResultSet(final ResultSet rs) throws SQLException {
        final String notesID = rs.getString("notesID");
        final String notesTitle = rs.getString("notesTitle");
        final String userID = rs.getString("userID");
        final String content = rs.getString("content");

        return new Notes(notesID, notesTitle, userID, content);
    }

    /**
     * Gets all the notes in the database
     * @return list of notes
     */
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

    /**
     * Gets a specific note from the database
     * @param currentNote note needed from DB
     * @return note if it exists
     */
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

    /**
     * Gets a list of all notes of a specific user
     * @param currentUser user whose notes are being accessed
     * @return list of notes
     */
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

    /**
     * Method to insert a new note to the database
     * @param currentNotes note to be inserted
     * @return note if it is inserted successfully
     */
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

    /**
     * Method to update a note in the database
     * @param currentNotes note to be updated
     * @return note if it is updated successfully
     */
    @Override
    public Notes updateNotes(Notes currentNotes)
    {
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE notes SET content = ?, notestitle = ? WHERE notesID = ?");
            st.setString(1, currentNotes.getNote());
            st.setString(2, currentNotes.getNoteTitle());
            st.setString(3, currentNotes.getNoteID());

            st.executeUpdate();

            return currentNotes;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to delete note from the database
     * @param currentNotes note to be deleted
     */
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



