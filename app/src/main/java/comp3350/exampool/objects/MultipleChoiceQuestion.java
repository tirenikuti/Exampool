//object class for all Multiple choice questions - child of flashcards
package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestion extends Flashcard implements Parcelable {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;

    /**
     * Constructor for the class
     * @param flashCardID String
     * @param userID String
     * @param question String
     * @param theAnswer String
     * @param option1 String
     * @param option2 String
     * @param option3 String
     */
    public MultipleChoiceQuestion(String flashCardID, String userID, String question, String theAnswer, String option1, String option2, String option3) {
        super(flashCardID,userID,question,theAnswer);
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = theAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    /**
     * Parcel constructor
     * @param in parcel to be written to
     */
    protected MultipleChoiceQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
    }

    /**
     * create method to make parcel
     */
    public static final Creator<MultipleChoiceQuestion> CREATOR = new Creator<MultipleChoiceQuestion>() {
        @Override
        public MultipleChoiceQuestion createFromParcel(Parcel in) {
            return new MultipleChoiceQuestion(in);
        }

        @Override
        public MultipleChoiceQuestion[] newArray(int size) {
            return new MultipleChoiceQuestion[size];
        }
    };

    /**
     * Getter method for the options and the answer
     * @return shuffled list of MCQ options
     */
    public String getOptions(){
        ArrayList<String> theOptions = new ArrayList<>();
        theOptions.add(answer);
        theOptions.add(option1);
        theOptions.add(option2);
        theOptions.add(option3);

        Collections.shuffle(theOptions);

        String options = "\n";
        for (int i = 0; i < theOptions.size(); i++) {
            options = options + theOptions.get(i) + "\n";
        }
        return options;
    }

    /**
     * Getter method for the flashcard ID
     * @return flashcardID
     */
    public String getFlashcardID(){ return flashcardID;}

    /**
     * Getter method for the userID
     * @return userID
     */
    public String getUserID(){return userID;}

    /**
     * Getter method for the answer
     * @return answer
     */
    public String getAnswer(){
        return answer;
    }

    /**
     * Getter method for the question
     * @return question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * Getter method for the first option
     * @return option1
     */
    public String getOption1(){
        return option1;
    }

    /**
     * Getter method for the second option
     *  @return option2
     */
    public String getOption2(){
        return option2;
    }

    /**
     * Getter method for the last option
     * @return option3
     */
    public String getOption3(){
        return option3;
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
        parcel.writeString(flashcardID);
        parcel.writeString(userID);
        parcel.writeString(question);
        parcel.writeString(answer);
        parcel.writeString(option1);
        parcel.writeString(option2);
        parcel.writeString(option3);
    }

    /**
     * Method to implement any updates to this Multiple Choice Question
     * @param question String
     * @param answer String
     * @param option1 String
     * @param option2 String
     * @param option3 String
     */
    @Override
    public void editFlashcard(String question, String answer, String option1, String option2, String option3){
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}
