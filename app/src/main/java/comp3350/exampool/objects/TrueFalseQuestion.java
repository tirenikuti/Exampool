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
    private String wrongAnswer;

    public TrueFalseQuestion(String flashCardID, String userID, String question, String answer, String wrongAnswer) {
        super();
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
        this.wrongAnswer = wrongAnswer;
    }

    protected TrueFalseQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
        wrongAnswer = in.readString();
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
        parcel.writeString(wrongAnswer);
    }
}
