//Data Level Notes.java Class
package comp3350.exampool.objects;
import java.util.ArrayList;

public class Notes{
    private String content;
    private ArrayList<String> tags;
    private int creatorID; //currently unused, to identify who created the note
    private int noteID; //notes ID number

    //Create a new note without tags
    public Notes(int cID, int nID, String text){
        noteID = nID;
        creatorID = cID;
        tags = new ArrayList<String>();
        content = text;
    }

    //Create a new note with tags
    public Notes(int cID, int nID, String text, ArrayList<String> tagList){
        noteID = nID;
        creatorID = cID;
        tags = new ArrayList<String>(tagList); //tags already exist
        content = text;
    }

    //In the App, getNote would display the note in an editable text box and editNote would update
    //the note once the App says it has been "saved"

    //replace content of the note with new text
    public void editNote(String newText){
        content = newText;
    }
    //return content of the note
    public String getNote(){
        return content;
    }

    //return the note's ID number
    public int getNoteID(){
        return noteID;
    }
    //returns the Creator of the the Note's User ID
    public int getCreatorID(){
        return creatorID;
    }

    // For adding a new tag to the note
    public boolean addTag(String newTag){
        if(!newTag.equals("")){
            tags.add(newTag);
            return true; //tag was added
        }
        return false; //tag was not added
    }

    public boolean removeTag(String target){
        if(tags.contains(target)){
            tags.remove(target);
            return true;//tag removed successfully
        }
        return false;//no tag to remove
    }

    //returns the tags for this note as an ArrayList
    public ArrayList<String> getTags() {
        return tags;
    }

    //marks the note as Deleted, should be removed from the database later
    public void deleteNote(){
        tags.clear();
        noteID = -1;
        creatorID = -1;
        content = "";
    }
}
