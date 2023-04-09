package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TypedAnswerQuestion;

public class TypedAnswerEditActivity extends AppCompatActivity {

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

    public void buttonDeleteOnClick(View view) {
        accessFlashcards.deleteTypedFlashcard(flashcard);
        onBackPressed();
    }

    public void buttonSaveOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.editAnswer);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), "", "", "");
        accessFlashcards.updateTypedAnswerFlashcard(flashcard);
        onBackPressed();
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(TypedAnswerEditActivity.this, HomeActivity.class);
        TypedAnswerEditActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(TypedAnswerEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButtonOnClick(View v) {
        Intent notesReturnIntent = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(notesReturnIntent);
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(flashcardsReturnActivity);
    }

}
