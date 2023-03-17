package comp3350.exampool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import comp3350.exampool.objects.Notes;

public class NotesTest {

    private Notes noteWithTags;
    private Notes noteNoTags;
    private final ArrayList<String> noteTags = new ArrayList<>();

    private final static String CONTENT_W_TAGS = "Hello World";
    private final static String CONTENT_NO_TAGS = "Buy Bread";
    private final static String U_ID = "1";
    private final static String N_ID_WITH = "1";
    private final static String N_ID_NO = "2";
    @Before
    public void CreateNotes(){
        noteTags.add("Math");
        noteTags.add("Comp");
        noteNoTags = new Notes(U_ID, N_ID_NO, CONTENT_NO_TAGS);
    }

    @After
    public void cleanUp(){
        noteTags.clear();
    }

    @Test
    public void getTagsTest(){
        Collection<String> tags, noTags;
        noTags = noteNoTags.getTags();
        tags = noteWithTags.getTags();
        assertEquals("should be the same Collection of Tags", noteTags, tags);
        assertTrue("The Collection of Tags should be empty", noTags.isEmpty());
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
        assertEquals("Note should have User ID: 1", U_ID, noteNoTags.getUserID());
        assertEquals("Note should have Note ID: 2", N_ID_NO, noteNoTags.getNoteID());
    }

}