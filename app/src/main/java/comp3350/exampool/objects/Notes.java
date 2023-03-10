package comp3350.exampool.objects;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Summary: Notes holds a string of content
 * Parameters: 2 Constructors one with tags one without
 * Returns: Getters for all class variables
 * Description: Notes has some string of content, ID number for the user who made it and the note itself
 * as well as tags that describe the category of the notes.
 */

public class Notes{
    //Class Variables
    private String notesID;
    private String userID;
    private String content;
    private final ArrayList<String> tags;

    /**
     * Constructor: Create a new note without tags
     * @param uID UserID Type: String
     * @param nID NoteaID Type: String
     * @param text Content Type: String
     */
    public Notes(String nID, String cID, String text){
        notesID = nID;
        userID = cID;
        content = text;
    }

    /**
     * Constructor: Create a new note with tags
     * @param uID CreatorID Type: int
     * @param nID NoteID Type: int
     * @param text Content Type: String
     * @param tagList List of categories for the notes Type: ArrayList <String>
     */
    public Notes(String nID, String uID, String text, ArrayList<String> tagList){
        notesID = nID;
        userID = uID;
        tags = new ArrayList<>(tagList); //tags already exist
        content = text;
    }

    //In the App, getNote would display the note in an editable text box and editNote would update
    //the note once the App says it has been "saved"

    /**
     * Setter for note Content
     * Replace content of the note with new text
     * @param newText Text to replace content with Type: String
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
     * @return noteID Type: Int
     */
    public int getNoteID(){
        return noteID;
    }

    /**
     * Getter for the UserID
     * @return UserID Type: String
     */
    public int getUserID(){
        return userID;
    }

    /**
     * For adding a new tag to the note
     * @param newTag Type: String
     * @return Tag was added? Type: Boolean
     */
    public boolean addTag(String newTag){
        if(!newTag.equals("")){
            tags.add(newTag);
            return true; //tag was added
        }
        return false; //tag was not added
    }

    /**
     * Removes tag from list of tags
     * @param target Tag to remove Type: String
     * @return Tag was removed? Type: Boolean
     */
    public boolean removeTag(String target){
        if(tags.contains(target)){
            tags.remove(target);
            return true;//tag removed successfully
        }
        return false;//no tag to remove
    }


    /**
     * Getter returns the tags for this note as an ArrayList
     * @return tags Type: ArrayList <String>
     */
    public Collection getTags() {
        return tags;
    }
}
