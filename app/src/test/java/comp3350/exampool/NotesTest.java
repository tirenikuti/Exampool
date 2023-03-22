package comp3350.exampool;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import comp3350.exampool.objects.Notes;

public class NotesTest {

    private Notes note;
    private Notes note2;

    private final static String CONTENT_1 = "Hello World";
    private final static String CONTENT_2 = "Buy Bread";
    private final static String U_ID = "1";
    private final static String N_ID_1 = "1";
    private final static String N_ID_2 = "2";
    @Before
    public void CreateNotes(){
        note = new Notes(U_ID, N_ID_1, CONTENT_1);
        note2 = new Notes(U_ID, N_ID_2, CONTENT_2);
    }

    @Test
    public void getEditTest(){
        assertEquals("Note should be unchanged", CONTENT_1, note.getNote());
        String newText = "I've been replaced";
        note.editNote(newText);
        assertEquals("Note should contain newText", newText, note.getNote());
    }

    @Test
    public void getIDTest(){
        assertEquals("Note should have User ID: 1", U_ID, note2.getUserID());
        assertEquals("Note should have Note ID: 2", N_ID_2, note2.getNoteID());
    }

}