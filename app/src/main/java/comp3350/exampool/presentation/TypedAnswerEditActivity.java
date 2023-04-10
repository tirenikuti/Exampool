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

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
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

    /**
     * buttonDeleteOnClick()
     * This deletes the flahscard from the database
     * @param view default value
     */

    public void buttonDeleteOnClick(View view) {
        accessFlashcards.deleteTypedFlashcard(flashcard);
        onBackPressed();
    }

    /**
     * buttonSaveOnClick()
     * This saves our changes for the edited flashcard
     * @param view default value
     */
    public void buttonSaveOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);
        EditText editAnswer = (EditText)findViewById(R.id.editAnswer);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), "", "", "");
        accessFlashcards.updateTypedAnswerFlashcard(flashcard);
        onBackPressed();
    }

    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(TypedAnswerEditActivity.this, HomeActivity.class);
        TypedAnswerEditActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(TypedAnswerEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TypedAnswerEditActivity.this, FlashcardsActivity.class);
        TypedAnswerEditActivity.this.startActivity(flashcardsReturnActivity);
    }

}
