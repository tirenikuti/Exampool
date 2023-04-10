package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TypedAnswerQuestion extends Flashcard implements Parcelable {
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
    public TypedAnswerQuestion(String flashCardID, String userID, String question, String answer) {
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
    protected TypedAnswerQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
    }

    /**
     * create method to make parcel
     */
    public static final Creator<TypedAnswerQuestion> CREATOR = new Creator<TypedAnswerQuestion>() {
        @Override
        public TypedAnswerQuestion createFromParcel(Parcel in) {
            return new TypedAnswerQuestion(in);
        }

        @Override
        public TypedAnswerQuestion[] newArray(int size) {
            return new TypedAnswerQuestion[size];
        }
    };

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
     * Getter method for the flashcard ID
     * @return flashcard ID
     */
    public String getFlashcardID(){ return flashcardID;}

    /**
     * Getter method for the userID
     * @return userID
     */
    public String getUserID(){return userID;}

    /**
     * Getter method for the question
     * @return question
     */
    public String getQuestion(){ return question;}

    /**
     * Getter method for the answer
     * @return answer
     */
    public String getAnswer(){return answer;}

    /**
     * Method to implement any updates to this Multiple Choice Question
     * @param question String
     * @param answer String
     * @param option1 String - no effect since options are not needed
     * @param option2 String - no effect since options are not needed
     * @param option3 String - no effect since options are not needed
     */
    @Override
    public void editFlashcard(String question, String answer, String option1, String option2, String option3) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Getter for options - blank since Typed answer questions have no options
     * @return blank string
     */
    public String getOptions(){return "";}
}
