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
        super();
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

    public String getQuestion(){ return question;}

    public String getAnswer(){return answer;}

    public String getOptions(){return "";}

    public void editFlashcard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
}
