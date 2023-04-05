package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Flashcard implements Parcelable {
    private final String flashcardID;
    private final String userID;
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
        flashcardID = null;
        userID = null;
    }

    protected Flashcard(Parcel in) {
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
        answered = in.readByte() != 0;
    }

    public static final Creator<Flashcard> CREATOR = new Creator<Flashcard>() {
        @Override
        public Flashcard createFromParcel(Parcel in) {
            return new Flashcard(in);
        }

        @Override
        public Flashcard[] newArray(int size) {
            return new Flashcard[size];
        }
    };

    public String getFlashcardID(){
        return flashcardID;
    }
    public String getUserID(){
        return userID;
    }
    public void setQuestion(String theQuestion){
        question = theQuestion;
    }
    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String theAnswer){
        answer = theAnswer;
    }
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
        parcel.writeString(flashcardID);
        parcel.writeString(userID);
        parcel.writeString(question);
        parcel.writeString(answer);
        parcel.writeByte((byte) (answered ? 1 : 0));
    }

    public String getQuestion() {
        return question;
    }

    public String getOptions() {
        return "";
    }
}
