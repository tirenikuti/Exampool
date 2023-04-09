package comp3350.exampool.tests.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import comp3350.exampool.objects.Notes;

import static org.junit.Assert.*;

public class NotesTest {
    @Test
    public void CreateNotesTest(){
        System.out.println("\nStarting Create Notes Test");

        Notes note = new Notes("2", "Hello World", "100", "A basic learning program");
        assertNotNull(note);
        assertTrue("2".equals(note.getNoteID()));
        assertTrue("Hello World".equals(note.getNoteTitle()));
        assertTrue("100".equals(note.getUserID()));
        assertTrue("A basic learning program".equals(note.getNote()));

        System.out.println("Finished Create Notes Test");
    }

    @Test
    public void getEditTest(){
        Notes note = new Notes("2", "Hello World", "100", "A basic learning program");
        String newText = "I've been replaced";
        String newTitle = "better title";
        note.editNote(newText, newTitle);
        assertEquals("Note should contain newText", newText, note.getNote());
        assertEquals("Note Title should be newTitle", newTitle, note.getNoteTitle());
    }

}