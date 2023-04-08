package comp3350.exampool.presentation;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp3350.exampool.R;

public class QuizComplete extends Activity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_completed0);

        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);

        TextView noteView = (TextView) findViewById(R.id.scoreTotal);
        noteView.setText("Score = " + score);
    }

    public void buttonRestartQuizOnClick(View view) {
        Intent quizIntent = new Intent(QuizComplete.this, FlashcardsQuizActivity.class);
        QuizComplete.this.startActivity(quizIntent);
    }
}