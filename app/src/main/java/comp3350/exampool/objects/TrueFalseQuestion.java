package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import comp3350.exampool.objects.Flashcard;

public class TrueFalseQuestion extends Flashcard implements Parcelable {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;

    public TrueFalseQuestion(String flashCardID, String userID, String question, String answer) {
        super();
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
    }

    protected TrueFalseQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
    }

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

    public String getOptions(){return "\n True \n False";}

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){ return answer;}


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
    }

    public void editFlashcard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
}
