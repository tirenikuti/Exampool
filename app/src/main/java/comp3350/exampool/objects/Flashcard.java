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
    public Flashcard(String flashcardID, String userID, String question, String answer){
        this.flashcardID = flashcardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
        this.answered = false;
    }

    public Flashcard() {
        this.answered = false;
    }

    protected Flashcard(Parcel in) {
        answered = in.readByte() != 0;
    }

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

    public String getFlashcardID(){ return flashcardID;}

    public String getUserID(){return userID;}

    public boolean getAnswered(){
        return answered;
    }
    public void resetAnswered(){
        answered = false;
    }

    public void answered(){
        answered = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (answered ? 1 : 0));
    }

    public String getOptions() {
        return "";
    }

    public String getQuestion() { return question;}

    public String getAnswer() { return answer;    }

    public abstract void editFlashcard(String question, String answer, String option1, String option2, String option3);

}
