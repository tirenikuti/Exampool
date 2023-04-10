package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TrueFalseQuestion extends Flashcard implements Parcelable {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;

    /**
     * Constructor for the class
     * @param flashCardID String
     * @param userID String
     * @param question String
     * @param answer String
     **/
    public TrueFalseQuestion(String flashCardID, String userID, String question, String answer) {
        super(flashCardID,userID,question,answer);
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
    }

    /**
     * Parcel constructor
     * @param in parcel to be written to
     */
    protected TrueFalseQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
    }

    /**
     * create method to make parcel
     */
    public static final Creator<TrueFalseQuestion> CREATOR = new Creator<TrueFalseQuestion>() {
        @Override
        public TrueFalseQuestion createFromParcel(Parcel in) {
            return new TrueFalseQuestion(in);
        }

        @Override
        public TrueFalseQuestion[] newArray(int size) {
            return new TrueFalseQuestion[size];
        }
    };

    /**
     * Getter method for the flashcard ID
     * @return flashcard ID
     */
    public String getFlashcardID(){ return flashcardID;}

    /**
     * Getter method for the userID
     * @return userID
     */
    public String getUserID(){ return  userID;}

    /**
     * Getter method for the options in TFQ
     * @return true or false string
     */
    public String getOptions(){return "\n True \n False";}

    /**
     * Getter method for the question
     * @return question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * Getter method for the answer
     * @return answer
     */
    public String getAnswer(){ return answer;}

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
        parcel.writeString(flashcardID);
        parcel.writeString(userID);
        parcel.writeString(question);
        parcel.writeString(answer);
    }

    /**
     * Method to implement any updates to this Multiple Choice Question
     * @param question String
     * @param answer String
     * @param option1 String - no effect since options are not needed
     * @param option2 String - no effect since options are not needed
     * @param option3 String - no effect since options are not needed
     */
    @Override
    public void editFlashcard(String question, String answer, String option1, String option2, String option3){
        this.question = question;
        this.answer = answer;
    }
}
