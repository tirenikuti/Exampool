package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class MultipleChoiceEditActivity extends Activity {

    private AccessFlashcards accessFlashcards;

    MultipleChoiceQuestion flashcard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_multiple_choice_edit0);
        accessFlashcards = new AccessFlashcards();

        TextView questionView = (TextView) findViewById(R.id.editQuestion);
        TextView answerView = (TextView) findViewById(R.id.editAnswer);
        TextView option1View = (TextView) findViewById(R.id.editChoice1);
        TextView option2View = (TextView) findViewById(R.id.editChoice2);
        TextView option3View = (TextView) findViewById(R.id.editChoice3);

        Intent intent = getIntent();
        flashcard = intent.getParcelableExtra("theCard");

        questionView.setText(flashcard.getQuestion());
        answerView.setText(flashcard.getAnswer());
        option1View.setText(flashcard.getOption1());
        option2View.setText(flashcard.getOption2());
        option3View.setText(flashcard.getOption3());
    }

    public void buttonDeleteMCQOnClick(View view) {
        accessFlashcards.deleteMCQFlashcard(flashcard);
        onBackPressed();
    }

    public void buttonSaveMCQOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.editAnswer);
        EditText editOption1 = (EditText)findViewById(R.id.editChoice1);
        EditText editOption2 = (EditText)findViewById(R.id.editChoice2);
        EditText editOption3 = (EditText)findViewById(R.id.editChoice3);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), editOption1.getText().toString(), editOption2.getText().toString(), editOption3.getText().toString());
        accessFlashcards.updateMultipleChoiceFlashcard(flashcard);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(MultipleChoiceEditActivity.this, FlashcardsActivity.class);
        MultipleChoiceEditActivity.this.startActivity(flashcardsReturnActivity);
    }
}
