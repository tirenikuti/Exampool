package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;

public class FlashcardsQuizActivity extends Activity {
    private AccessFlashcards accessFlashcards;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<Flashcard> flashcardArrayAdapter;
    private int score = 0;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcardquiz);

        accessFlashcards = new AccessFlashcards();
        flashcardList = accessFlashcards.getFlashcards();

        resetAllFlashcards();

        TextView questionView = (TextView) findViewById(R.id.typed_question);
        Flashcard flashcard = flashcardList.get(position);

        questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
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
        if(position < flashcardList.size() - 1){
            position++;
            Flashcard flashcard = flashcardList.get(position);

            TextView questionView = (TextView) findViewById(R.id.typed_question);
            TextView answerEdit = (TextView) findViewById(R.id.editInputAnswer);

            questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
            answerEdit.setText("");
            Button submitButton = findViewById(R.id.submitButton);
            submitButton.setEnabled(true);
        }
        else{
            Intent completeIntent = new Intent(FlashcardsQuizActivity.this, QuizComplete.class);
            completeIntent.putExtra("Score", score);
            FlashcardsQuizActivity.this.startActivity(completeIntent);
        }
    }

    public void buttonSubmitOnClick(View view) {
        EditText answerEdit = (EditText) findViewById(R.id.editInputAnswer);
        Flashcard flashcard = flashcardList.get(position);
        if ((mark(answerEdit.getText().toString(), flashcard.getAnswer()) == 0)
            && (!flashcard.getAnswered()))
        {
            flashcard.answered();
            score++;
        }
        revealAnswer();
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setEnabled(false);
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("score = "  + score);
    }

    public int mark(String submittedAnswer, String correctAnswer){
        int correct = submittedAnswer.compareToIgnoreCase(correctAnswer);
        return correct;
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(FlashcardsQuizActivity.this, FlashcardsActivity.class);
        FlashcardsQuizActivity.this.startActivity(flashcardsReturnActivity);
    }
}
