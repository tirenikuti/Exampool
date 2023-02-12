package comp3350.exampool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.exampool.Notes.*;

public class NotesTest {

    private Notes noteWithTags;
    private Notes noteNoTags;
    private ArrayList<String> noteTags = new ArrayList<>();

    private final static String CONTENT_W_TAGS = "Hello World";
    private final static String CONTENT_NO_TAGS = "Buy Bread";
    private final static int C_ID = 1;
    private final static int N_ID_WITH = 1;
    private final static int N_ID_NO = 2;
    @Before
    public void CreateNotes(){
        noteTags.add("Math");
        noteTags.add("Comp");
        noteWithTags = new Notes(C_ID, N_ID_WITH, CONTENT_W_TAGS, noteTags);
        noteNoTags = new Notes(C_ID, N_ID_NO, CONTENT_NO_TAGS);
    }

    @After
    public void cleanUp(){
        noteTags.clear();
    }

    @Test
    public void getTagsTest(){
        ArrayList<String> tags, noTags;
        noTags = noteNoTags.getTags();
        tags = noteWithTags.getTags();
        assertEquals("should be the same ArrayList", noteTags, tags);
        assertTrue("ArrayList should be empty", noTags.isEmpty());
    }

    @Test
    public void addTagsTest(){
        assertFalse("fails to add empty tag", noteNoTags.addTag(""));
        assertTrue("succeeds adding a new tag", noteWithTags.addTag("Test1"));
    }

    @Test
    public void removeTagsTest(){
        assertFalse("fails to delete tag from empty list", noteNoTags.removeTag("test"));
        assertTrue("succeeds deleting a tag", noteWithTags.removeTag("Math"));
        assertFalse("fails to delete tag not in the list", noteWithTags.removeTag("test"));
    }

    @Test
    public void getEditTest(){
        assertEquals("Note should be unchanged", CONTENT_W_TAGS, noteWithTags.getNote());
        String newText = "I've been replaced";
        noteWithTags.editNote(newText);
        assertEquals("Note should contain newText", newText, noteWithTags.getNote());
    }

    @Test
    public void getIDTest(){
        assertEquals("Note should have Creator ID: 1", C_ID, noteNoTags.getCreatorID());
        assertEquals("Note should have Note ID: 2", N_ID_NO, noteNoTags.getNoteID());
    }

    @Test
    public void deleteTest(){
        assertEquals("Note should have a valid Note ID", N_ID_WITH, noteWithTags.getNoteID());
        noteWithTags.deleteNote();
        assertEquals("Note should no longer be valid", -1, noteWithTags.getNoteID());
    }
}