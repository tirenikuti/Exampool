package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;
import comp3350.exampool.objects.Flashcard;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.QuestionType;


public class multipleChoiceQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_questions);
        //Get data from somewhere
        ArrayList<Flashcard> data = new ArrayList<Flashcard>();
        data.add(new Flashcard("1","1", QuestionType.MCQ,"Does this suck?","Yes",3,"Maybe","Yes","No"));
        data.add(new Flashcard("2","1", QuestionType.MCQ,"Does this still suck?","Yes",3,"Maybe","Yes","No"));

        TextView cardText = (TextView) findViewById(R.id.questionMCQ);
        TextView McqOptionText = (TextView) findViewById(R.id.optionsMCQ);
        TextView answerText = (TextView) findViewById(R.id.answerMCQ);
        Iterator it = data.iterator();
        Flashcard currCard = data.get(0);
        while (it.hasNext()&&(currCard.getQuestionType() != QuestionType.MCQ)) {
            currCard = (Flashcard) it.next();
        }
        cardText.setText(currCard.getQuestion());
        McqOptionText.setText(currCard.getOptions());
        answerText.setText(currCard.getAnswer());

        Button buttonNext;
        buttonNext = findViewById(R.id.nextMCQ);
        Button buttonReveal;
        buttonReveal = findViewById(R.id.RevealMCQ);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Flashcard outCard = (Flashcard) it.next();
                while (it.hasNext()&&(outCard.getQuestionType() != QuestionType.MCQ)) {
                    outCard = (Flashcard) it.next();
                }
                cardText.setText(outCard.getQuestion());
                McqOptionText.setText(outCard.getOptions());
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