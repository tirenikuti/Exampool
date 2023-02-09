/* TODO List:
    *Note() - constructors
    EditNote() - change the text stored within the note
    GetNote() - return the text currently stored in the note
    DeleteNote() - remove the note from the DB(not currently implemented)
 */
//Data Level Notes.java Class
package Notes;

import java.util.ArrayList;

public class Notes{
    private String content;
    private ArrayList<String> tags;
    private int creatorID; //currently unused, to identify who created the note
    private int noteID; //notes ID number

    public Notes(int cID, int nID, String text){
        noteID = nID;
        creatorID = cID;
        tags = new ArrayList<String>();
        content = text;
    }

    public Notes(int cID, int nID, String text, ArrayList<String> tagList){
        noteID = nID;
        creatorID = cID;
        tags = new ArrayList<String>(tagList); //tags already exist
        content = text;
    }


    // For editing an existing tag - returns the new value of tag
    public boolean addTag(String newTag){
        tags.add(newTag);
        return true; //tag added successfully
    }

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
    //returns the tags for this note as an ArrayList
    public ArrayList<String> getTags() {
        return tags;
    }

    public void deleteNote(){
        tags.clear();
        noteID = -1;
        creatorID = -1;
        content = "";
    }
}