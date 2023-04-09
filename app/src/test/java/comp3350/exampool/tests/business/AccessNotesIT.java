package comp3350.exampool.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.persistence.NotesPersistence;
import comp3350.exampool.persistence.hsqldb.NotesPersistenceHSQLDB;
import comp3350.exampool.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessNotesIT {
    private AccessNotes accessNotes;
    private File tempDB;

    @Before
    public void setUp() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final NotesPersistence persistence = new NotesPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessNotes = new AccessNotes(persistence);
    }

    @Test
    public void testListNotes() {
        final Notes note;

        note = accessNotes.getSequential();
        assertNotNull("first sequential note should not be null", note);
        assertTrue("2".equals(note.getNote()));

        System.out.println("Finished test AccessNotes");
    }

    @Test
    public void testGetNotes(){
        final List<Notes> notes = accessNotes.getNotes();
        assertEquals(6, notes.size());
    }

    @Test
    public void testDeleteNote(){
        final Notes note = accessNotes.getSequential();
        List<Notes> notes = accessNotes.getNotes();
        assertEquals(6, notes.size());
        accessNotes.deleteNote(note);
        notes = accessNotes.getNotes();
        assertEquals(5, notes.size());
    }

    @Test
    public void testInsertNotes(){
        final Notes note = new Notes("3", "Humming Bird", "100", "Is a humming bird the same as a mocking bird?");
        accessNotes.insertNote(note);
        assertEquals(7, accessNotes.getNotes().size());
    }

    @Test
    public void testUpdateNotes(){
        final Notes note = accessNotes.getSequential();
        final Notes noteUpdate = new Notes(note.getNoteID(), note.getNoteTitle(), note.getUserID(), "a new message");
        accessNotes.updateNote(noteUpdate);
        assertEquals(6, accessNotes.getNotes().size());
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
