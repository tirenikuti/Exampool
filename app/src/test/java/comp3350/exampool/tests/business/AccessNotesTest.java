package comp3350.exampool.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.persistence.NotesPersistence;
import comp3350.exampool.tests.persistence.NotesPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessNotesTest {
    private AccessNotes accessNotes;
    private NotesPersistence notesPersistence;

    @Before
    public void setUp(){
        notesPersistence = mock(NotesPersistence.class);
        accessNotes = new AccessNotes(notesPersistence);
    }

    @Test
    public void test(){
        final Notes note;

        System.out.println("\nStarting test AccessCourses");
        final List<Notes> notes = new ArrayList<>();
        notes.add(new Notes("2","Short Story","100","Here is a funny sort of story"));
        when(notesPersistence.getNotesSequential()).thenReturn(notes);

        note = accessNotes.getSequential();
        assertNotNull("first sequential course should not be null", note);
        assertTrue("2".equals(note.getNoteID()));

        verify(notesPersistence).getNotesSequential();

        System.out.println("Finished test AccessNotes");
    }
}
