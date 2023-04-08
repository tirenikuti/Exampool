package comp3350.exampool.objects;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TypedAnswerQuestion extends Flashcard implements Parcelable {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;

    public TypedAnswerQuestion(String flashCardID, String userID, String question, String answer) {
        super(flashCardID,userID,question,answer);
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
    }

    protected TypedAnswerQuestion(Parcel in) {
        super();
        flashcardID = in.readString();
        userID = in.readString();
        question = in.readString();
        answer = in.readString();
    }

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

    public String getFlashcardID(){ return flashcardID;}

    public String getUserID(){return userID;}

    public String getQuestion(){ return question;}

    public String getAnswer(){return answer;}

    @Override
    public void editFlashcard(String question, String answer, String option1, String option2, String option3) {
        this.question = question;
        this.answer = answer;
    }

    public String getOptions(){return "";}
}
