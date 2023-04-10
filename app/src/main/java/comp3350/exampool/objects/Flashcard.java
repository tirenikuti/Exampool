//Parent class for all flashcards -abstract, flashcard must be of one of the child types
package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public abstract class Flashcard implements Parcelable {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;
    private boolean answered;

    /**
     * Constructor for flashcards
     * @param flashcardID
     * @param userID
     * @param question
     * @param answer
     */
    public Flashcard(String flashcardID, String userID, String question, String answer){
        this.flashcardID = flashcardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
        this.answered = false;
    }

    /**
     * Blank constructor for inheritence and parcels
     */
    public Flashcard() {
        this.answered = false;
    }

    /**
     * Constructor for parcel - when sending object between instances
     * @param in parcel to hold flashcard
     */
    protected Flashcard(Parcel in) {
        answered = in.readByte() != 0;
    }

    /**
     * Method to create the parcel with the flashcard
     */
    public static final Creator<Flashcard> CREATOR = new Creator<Flashcard>() {
        @Override
        public Flashcard createFromParcel(Parcel in) {
            return new Flashcard(in) {
                @Override
                public void editFlashcard(String question, String answer, String option1, String option2, String option3) {

                }
            };
        }

        @Override
        public Flashcard[] newArray(int size) {
            return new Flashcard[size];
        }
    };

    /**
     * Getter for the flashcard ID
     * @return flashcardID
     */
    public String getFlashcardID(){ return flashcardID;}

    /**
     * Getter for userID
     * @return userID
     */
    public String getUserID(){return userID;}

    /**
     * Getter for answered
     * @return boolean answered
     */
    public boolean getAnswered(){
        return answered;
    }

    /**
     * Method to reset the answered boolean
     */
    public void resetAnswered(){
        answered = false;
    }

    /**
     * Getter for the answered boolean
     */
    public void answered(){
        answered = true;
    }

    /**
     * parcel default method
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Parcel Method to write to the parcel
     * @param parcel parcel being written to
     * @param i boolean value of answered
     */
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (answered ? 1 : 0));
    }

    /**
     * Method to get Options - should be overwritten by child classes
     * @return blank string if no options - default is blank
     */
    public String getOptions() {
        return "";
    }

    /**
     * Getter method for question
     * @return String question
     */
    public String getQuestion() { return question;}

    /**Getter method for answer
     * @return String answer
     */
    public String getAnswer() { return answer;    }

    /**
     * Method to implement any updates to flashcards
     * @param question
     * @param answer
     * @param option1
     * @param option2
     * @param option3
     */
    public abstract void editFlashcard(String question, String answer, String option1, String option2, String option3);

}
