package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class testing extends AppCompatActivity {
    private List<Flashcard> flashcardList;
    private int score = 0;
    private int position = 0;
    private AnimatorSet front_animation;
    private AnimatorSet back_animation;
    private boolean isFront = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing3);

        AccessFlashcards accessFlashcards = new AccessFlashcards();
        flashcardList = accessFlashcards.getFlashcards();

        resetAllFlashcards();

        TextView questionView = (TextView) findViewById(R.id.typed_question);
        Flashcard flashcard = flashcardList.get(position);
        questionView.setText(flashcard.getQuestion() + flashcard.getOptions());

        TextView answerView = (TextView) findViewById(R.id.revealed_answer);
        answerView.setText(flashcard.getAnswer());

        // Now Create Animator Object
        // For this we add animator folder inside res
        // Now we will add the animator to our card
        // we now need to modify the camera scale
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        TextView front = findViewById(R.id.typed_question);
        TextView back = findViewById(R.id.revealed_answer);
        Button flip = findViewById(R.id.submitButton);

        front.setCameraDistance(8000 * scale);
        back.setCameraDistance(8000 * scale);

        // Now we will set the front animation
        front_animation = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.front_animator);
        back_animation = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.back_animator);

        // Now we will set the event listener
        flip.setOnClickListener(view -> {
            if(isFront) {
                front_animation.setTarget(front);
                back_animation.setTarget(back);
                front_animation.start();
                back_animation.start();
                isFront = false;
            } else {
                front_animation.setTarget(back);
                back_animation.setTarget(front);
                back_animation.start();
                front_animation.start();
                isFront = true;
            }
        });

    }
    public void resetAllFlashcards(){
        for(int i = 0; i < flashcardList.size(); i++){
            Flashcard flashcard = flashcardList.get(i);
            flashcard.resetAnswered();
        }
        score = 0;
        position = 0;
    }

    public void revealAnswer() {
        //flip animation with reveal: use flashcard.getAnswer()
        Flashcard flashcard = flashcardList.get(position);
        TextView questionView = (TextView) findViewById(R.id.typed_question);
        questionView.setText(flashcard.getAnswer());
        flashcard.answered();
    }

    public void buttonNextOnClick(View view) {
        EditText answerEdit = (EditText) findViewById(R.id.editInputAnswer);
        Flashcard flashcard = flashcardList.get(position);
        String submission = answerEdit.getText().toString();
        scored(flashcard, submission);
        if(position < flashcardList.size() - 1){
            position++;
            flashcard = flashcardList.get(position);

            TextView questionView = (TextView) findViewById(R.id.typed_question);
            TextView answer = (TextView) findViewById(R.id.editInputAnswer);

            questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
            answer.setText("");
            Button submitButton = findViewById(R.id.submitButton);
            submitButton.setEnabled(true);
        }
        else{
            Intent completeIntent = new Intent(testing.this, QuizComplete.class);
            completeIntent.putExtra("Score", score);
            testing.this.startActivity(completeIntent);
        }
    }

    public void buttonSubmitOnClick(View view) {
        EditText answerEdit = (EditText) findViewById(R.id.editInputAnswer);
        Flashcard flashcard = flashcardList.get(position);
        String submission = answerEdit.getText().toString();
        scored(flashcard, submission);
        revealAnswer();
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setEnabled(false);
    }

    private void scored(Flashcard flashcard, String answer){
        if ((answer.compareToIgnoreCase(flashcard.getAnswer()) == 0) && (!flashcard.getAnswered()))
        {
            flashcard.answered();
            score++;
        }
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("score = "  + score);
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(testing.this, FlashcardsActivity.class);
        testing.this.startActivity(flashcardsReturnActivity);
    }
    
}
