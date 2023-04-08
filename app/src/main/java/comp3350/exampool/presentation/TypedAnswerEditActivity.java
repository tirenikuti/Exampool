package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;

public class TypedAnswerEditActivity extends Activity {

    private AccessFlashcards accessFlashcards;
    TypedAnswerQuestion flashcard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_typed_answer_edit);

        accessFlashcards = new AccessFlashcards();
        TextView questionView = (TextView) findViewById(R.id.editQuestion);
        TextView answerView = (TextView) findViewById(R.id.editAnswer);

        Intent intent = getIntent();
        flashcard = intent.getParcelableExtra("theCard");

        questionView.setText(flashcard.getQuestion());
        answerView.setText(flashcard.getAnswer());
    }

    public void buttonDeleteTypedOnClick(View view) {
        accessFlashcards.deleteTypedFlashcard(flashcard);
        onBackPressed();
        Intent flashcardsReturnActivity = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(flashcardsReturnActivity);
    }

    public void buttonSaveTypedOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.createQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.createAnswer);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), "", "", "");
        accessFlashcards.updateTypedAnswerFlashcard(flashcard);
        onBackPressed();
        Intent flashcardsReturnActivity = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(flashcardsReturnActivity);
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(flashcardsReturnActivity);
    }

}
