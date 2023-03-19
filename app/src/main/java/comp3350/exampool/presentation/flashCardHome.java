package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comp3350.exampool.R;

public class flashCardHome extends AppCompatActivity {
    //Navigation Buttons
    Button buttonShortAnswerQuestions;
    Button buttonLongAnswerQuestions;
    Button buttonMultipleChoiceQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcardhome);

        /**
         * Button to move to short answer Questions page on click
         */
        buttonShortAnswerQuestions = findViewById(R.id.ShortAnswerQuestions);
        buttonShortAnswerQuestions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(flashCardHome.this, ShortAnswerQuestions.class);
                startActivity(intent);
            }

        });
        /**
         * Button to move to long answer Questions page on click
         */
        buttonLongAnswerQuestions = findViewById(R.id.LongAnswerQuestions);
        buttonLongAnswerQuestions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(flashCardHome.this, longAnswerQuestions.class);
                startActivity(intent);
            }

        });
        /**
         * Button to move to multiple choice questions page on click
         */
        buttonMultipleChoiceQuestions = findViewById(R.id.MultipleChoiceQuestions);
        buttonMultipleChoiceQuestions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(flashCardHome.this, multipleChoiceQuestions.class);
                startActivity(intent);
            }

        });

    }
}