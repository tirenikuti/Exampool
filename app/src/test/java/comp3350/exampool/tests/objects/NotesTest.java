package comp3350.exampool.tests.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import comp3350.exampool.objects.Notes;

import static org.junit.Assert.*;

public class NotesTest {
    private Notes note;
    @Test
    public void CreateNotesTest(){
        System.out.println("\nStarting Create Notes Test");

        note = new Notes("2", "Hello World", "100", "A basic learning program");
        assertNotNull(note);
        assertTrue("2".equals(note.getNoteID()));
        assertTrue("HelloWorld".equals(note.getNoteTitle()));
        assertTrue("100".equals(note.getUserID()));
        assertTrue("A basic learning program".equals(note.getNote()));

        System.out.println("Finished Create Notes Test");
    }

    @Test
    public void getEditTest(){
        assertEquals("Note should be unchanged", "A basic learning program", note.getNote());
        String newText = "I've been replaced";
        note.editNote(newText);
        assertEquals("Note should contain newText", newText, note.getNote());
    }

}