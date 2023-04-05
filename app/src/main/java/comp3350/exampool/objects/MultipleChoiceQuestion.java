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

    public MultipleChoiceQuestion(String flashCardID, String userID, String question, String theAnswer, String option1, String option2, String option3) {
        super();
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.question = question;
        this.answer = theAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

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

    public String getAnswer(){
        return answer;
    }

    public String getQuestion(){
        return question;
    }
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public String getOption3(){
        return option3;
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
        parcel.writeString(option1);
        parcel.writeString(option2);
        parcel.writeString(option3);
    }
}
