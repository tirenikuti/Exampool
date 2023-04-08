package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TrueFalseQuestion;

public class TrueFalseEditActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    TrueFalseQuestion flashcard;
    String answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_true_false_edit);
        accessFlashcards = new AccessFlashcards();

        TextView questionView = (TextView) findViewById(R.id.editQuestion);
        TextView answerView = (TextView) findViewById(R.id.editAnswer);

        Intent intent = getIntent();
        flashcard = intent.getParcelableExtra("theCard");

        questionView.setText(flashcard.getQuestion());
        answerView.setText(flashcard.getAnswer());
        answer = null;
    }

    public void buttonDeleteTFQOnClick(View view) {
        accessFlashcards.deleteTFQFlashcard(flashcard);
        onBackPressed();
    }

    public void buttonSaveTFQOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.editAnswer);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), "", "", "");
        accessFlashcards.updateTrueFalseFlashcard(flashcard);
        onBackPressed();
    }

    public void onTrueClick(View v){
        answer = "True";
    }

    public void onFalseClick(View v){
        answer = "false";
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TrueFalseEditActivity.this, FlashcardsActivity.class);
        TrueFalseEditActivity.this.startActivity(flashcardsReturnActivity);
    }
}
