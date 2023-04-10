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
import comp3350.exampool.objects.MultipleChoiceQuestion;

/**
 * Summary: The presentation layer containing the Multiple choice Flashcard edit page
 * Description: This controls the layout file that allows users to edit multiple choice questions
 * as well as their new options and correct answer
 */

public class MultipleChoiceEditActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;

    MultipleChoiceQuestion flashcard;

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_multiple_choice_edit);
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
    /**
     * buttonDeleteOnClick()
     * This deletes the flahscard from the database
     * @param view default value
     */


    public void buttonDeleteOnClick(View view) {
        accessFlashcards.deleteMCQFlashcard(flashcard);
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
        EditText editOption1 = (EditText)findViewById(R.id.editChoice1);
        EditText editOption2 = (EditText)findViewById(R.id.editChoice2);
        EditText editOption3 = (EditText)findViewById(R.id.editChoice3);

        flashcard.editFlashcard(editQuestion.getText().toString(),editAnswer.getText().toString(), editOption1.getText().toString(), editOption2.getText().toString(), editOption3.getText().toString());
        accessFlashcards.updateMultipleChoiceFlashcard(flashcard);
        onBackPressed();
    }

    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(MultipleChoiceEditActivity.this, HomeActivity.class);
        MultipleChoiceEditActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(MultipleChoiceEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(MultipleChoiceEditActivity.this, FlashcardsActivity.class);
        MultipleChoiceEditActivity.this.startActivity(flashcardsReturnActivity);
    }
}
