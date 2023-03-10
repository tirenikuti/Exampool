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


public class longAnswerQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_answer_questions);
        //Get data from somewhere
        ArrayList<Flashcard> data = new ArrayList<Flashcard>();
        data.add(new Flashcard("1", "1", QuestionType.LAQ, "Does this suck?", "Yes", 0));
        data.add(new Flashcard("2", "1", QuestionType.LAQ, "Does this still suck?", "Yes", 0));

        TextView cardText = (TextView) findViewById(R.id.questionLAQ);
        TextView answerText = (TextView) findViewById(R.id.answerLAQ);
        Iterator it = data.iterator();
        Flashcard currCard = data.get(0);
        while ((it.hasNext()) && (currCard.getQuestionType() != QuestionType.LAQ)) {
            currCard = (Flashcard) it.next();
        }
            cardText.setText(currCard.getQuestion());
            answerText.setText(currCard.getAnswer());

            Button buttonNext;
            buttonNext = findViewById(R.id.nextLAQ);
            Button buttonReveal;
            buttonReveal = findViewById(R.id.RevealLAQ);
            buttonNext.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Flashcard outCard = (Flashcard) it.next();
                    while ((it.hasNext()) && (outCard.getQuestionType() != QuestionType.LAQ)) {
                        outCard = (Flashcard) it.next();
                    }
                    cardText.setText(outCard.getQuestion());

                    answerText.setVisibility(View.INVISIBLE);
                    answerText.setText(outCard.getAnswer());
                }

            });
            buttonReveal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    answerText.setVisibility(View.VISIBLE);
                }
            });
        }
    }

