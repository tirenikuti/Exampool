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
import comp3350.exampool.objects.QuestionType;

public class ShortAnswerQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_short_answer_questions);

        ArrayList<Flashcard> data = new ArrayList<Flashcard>();

        TextView cardText = (TextView) findViewById(R.id.questionSAQ);
        TextView answerText = (TextView) findViewById(R.id.answerSAQ);
        Iterator it = data.iterator();
        Flashcard currCard = (Flashcard) it.next();
        while (it.hasNext()) {
            currCard = (Flashcard) it.next();
        }
        cardText.setText(currCard.getQuestion());
        answerText.setText(currCard.getAnswer());

        Button buttonNext;
        buttonNext = findViewById(R.id.nextSAQ);
        Button buttonReveal;
        buttonReveal = findViewById(R.id.RevealSAQ);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Flashcard outCard = (Flashcard) it.next();
                while (it.hasNext()) {
                    outCard = (Flashcard) it.next();
                }
                cardText.setText(outCard.getQuestion());

                answerText.setVisibility(View.INVISIBLE);
                answerText.setText(outCard.getAnswer());
            }

        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                answerText.setVisibility(View.VISIBLE);
            }
        });
    }
}
    }
}