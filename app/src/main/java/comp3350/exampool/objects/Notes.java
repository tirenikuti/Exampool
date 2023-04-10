package comp3350.exampool.objects;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * Summary: Notes holds a string of content
 * Parameters: 2 Constructors one with only noteID and one with all parameters defined
 * Returns: Getters for all class variables
 * Description: Notes has some Strings for content, ID of the user who made it and ID of the note itself
 */

public class Notes implements Parcelable {
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
     * Parcel constructor
     * @param in parcel to be written to
     */
    protected Notes(Parcel in) {
        noteID = in.readString();
        noteTitle = in.readString();
        userID = in.readString();
        content = in.readString();
    }

    /**
     * create method to make parcel
     */
    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    /**
     * Setter for note Content
     * Replace the contents of the note with new text
     * @param newText Text to replace content with, Type: String
     * @param newTitle Text to replace the title with, Type: String
     */
    public void editNote(String newText, String newTitle){
        content = newText;
        noteTitle = newTitle;
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

    /**
     * Getter for the Title of the Note
     * @return noteTitle Type String
     */
    public String getNoteTitle() {
        return noteTitle;
    }

    /**
     * Default method for parcel
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method to write to parcel
     * @param parcel parcel being written to
     * @param i boolean value of answered
     */
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(noteID);
        parcel.writeString(noteTitle);
        parcel.writeString(userID);
        parcel.writeString(content);
    }
}
