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

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_completed);

        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);

        TextView noteView = (TextView) findViewById(R.id.scoreTotal);
        noteView.setText("Score = " + score);
    }

    /**
     * buttonRestartQuizOnClick()
     * This restarts the quiz from the beginning on press
     * @param view default value
     */

    public void buttonRestartQuizOnClick(View view) {
        Intent quizIntent = new Intent(QuizComplete.this, FlashcardsQuizActivity.class);
        QuizComplete.this.startActivity(quizIntent);
    }

    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(QuizComplete.this, HomeActivity.class);
        QuizComplete.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */

    public void userButtonOnClick(View v){
        Toast.makeText(QuizComplete.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        Intent notesReturnIntent = new Intent(QuizComplete.this, FlashcardsQuizActivity.class);
        QuizComplete.this.startActivity(notesReturnIntent);
    }
}