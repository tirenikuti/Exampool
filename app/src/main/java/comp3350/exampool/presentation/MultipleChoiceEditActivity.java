package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class MultipleChoiceEditActivity extends Activity {

    private AccessFlashcards accessFlashcards;

    MultipleChoiceQuestion flashcard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_multiple_choice_edit);
        accessFlashcards = new AccessFlashcards();


    }

    public void buttonDeleteMCQOnClick(View view) {
        accessFlashcards.deleteFlashcard(flashcard);
    }

    public void buttonSaveMCQOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.createQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.createAnswer);
        EditText editOption1 = (EditText)findViewById(R.id.createChoice1);
        EditText editOption2 = (EditText)findViewById(R.id.createChoice2);
        EditText editOption3 = (EditText)findViewById(R.id.createChoice3);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), editOption1.getText().toString(), editOption2.getText().toString(), editOption3.getText().toString());
        accessFlashcards.updateMultipleChoiceFlashcard(flashcard);
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(MultipleChoiceEditActivity.this, FlashcardsActivity.class);
        MultipleChoiceEditActivity.this.startActivity(flashcardsReturnActivity);
    }
}
