package comp3350.exampool.presentation;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.exampool.R;

public class QuizComplete extends Activity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_completed);

        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);

        TextView noteView = (TextView) findViewById(R.id.scoreTotal);
        noteView.setText("Score = " + score);
    }

    public void buttonRestartQuizOnClick(View view) {
        Intent quizIntent = new Intent(QuizComplete.this, FlashcardsQuizActivity.class);
        QuizComplete.this.startActivity(quizIntent);
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(QuizComplete.this, HomeActivity.class);
        QuizComplete.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(QuizComplete.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButtonOnClick(View v) {
        Intent notesReturnIntent = new Intent(QuizComplete.this, FlashcardsQuizActivity.class);
        QuizComplete.this.startActivity(notesReturnIntent);
    }
}