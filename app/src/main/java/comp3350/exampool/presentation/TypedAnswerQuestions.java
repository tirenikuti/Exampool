package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import comp3350.exampool.R;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.TypedAnswerQuestion;


public class TypedAnswerQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typed_answer_questions);

        //Placeholder data
        ArrayList<Flashcard> data = new ArrayList<Flashcard>();
        data.add(new TypedAnswerQuestion("1", "1", "Does this suck?", "Yes"));
        data.add(new TypedAnswerQuestion("2", "1", "Does this still suck?", "Yes"));

        //Set display text

        //Track curr position in data
        Iterator it = data.iterator();
        //Current flashcard
        Flashcard currCard = data.get(0);

        //Get the next flashcard that is a long answer question
        while (it.hasNext()) {
            currCard = (Flashcard) it.next();
        }
    }
}

