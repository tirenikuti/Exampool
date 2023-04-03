package comp3350.exampool.objects;


import android.widget.TextView;

/**
 * Summary: Notes holds a string of content
 * Parameters: 2 Constructors one with only noteID and one with all parameters defined
 * Returns: Getters for all class variables
 * Description: Notes has some Strings for content, ID of the user who made it and ID of the note itself
 */

public class Notes{
    //Class Variables
    private String noteID;
    private String noteTitle;
    private String userID;
    private String content;

    /**
     * Constructor: Create a new note with only a noteID, used for AccessNotes
     * @param notesID noteID Type: String
     */
    public Notes(String notesID){
        noteID = notesID;
        userID = null;
        content = null;
    }
    /**
     * Constructor: Create a new note with all parameters defined
     * @param uID userID Type: String
     * @param nID noteID Type: String
     * @param text content Type: String
     */
    public Notes(String nID, String notesTitle, String uID, String text){
        noteID = nID;
        noteTitle = notesTitle;
        userID = uID;
        content = text;
    }

    /**
     * Setter for note Content
     * Replace the contents of the note with new text
     * @param newText Text to replace content with, Type: String
     */
    public void editNote(String newText){
        content = newText;
    }

    /**
     * Getter for note content
     * @return Content Type: String
     */
    public String getNote(){
        return content;
    }

    /**
     * Getter for the note's ID number
     * @return noteID Type: String
     */
    public String getNoteID(){
        return noteID;
    }

    /**
     * Getter for the UserID
     * @return userID Type: String
     */
    public String getUserID(){
        return userID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }
}
