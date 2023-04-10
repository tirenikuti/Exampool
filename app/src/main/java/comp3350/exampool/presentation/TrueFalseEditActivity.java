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
import comp3350.exampool.objects.TrueFalseQuestion;
/**
 * Summary: The presentation layer containing the True/False choice Flashcard edit page
 * Description: This controls the layout file that allows users to edit true/false questions
 * as well as change the correct answer
 */
public class TrueFalseEditActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    TrueFalseQuestion flashcard;
    String answer;

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_true_false_edit);
        accessFlashcards = new AccessFlashcards();

        TextView questionView = (TextView) findViewById(R.id.editQuestion);

        Intent intent = getIntent();
        flashcard = intent.getParcelableExtra("theCard");

        questionView.setText(flashcard.getQuestion());
        answer = flashcard.getAnswer();
    }

    /**
     * buttonDeleteOnClick()
     * This deletes the flahscard from the database
     * @param view default value
     */

    public void buttonDeleteOnClick(View view) {
        accessFlashcards.deleteTFQFlashcard(flashcard);
        onBackPressed();
    }

    /**
     * buttonSaveOnClick()
     * This saves our changes for the edited flashcard
     * @param view default value
     */
    public void buttonSaveOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);

        flashcard.editFlashcard(editQuestion.getText().toString(),answer, "", "", "");
        accessFlashcards.updateTrueFalseFlashcard(flashcard);
        onBackPressed();
    }

    /**
     * onTrueClick()
     * Sets the answer of the question to true
     * @param v default value
     */
    public void onTrueClick(View v){
        answer = "True";
    }

    /**
     * onFalseClick()
     * Sets the answer of the question to false
     * @param v default value
     */
    public void onFalseClick(View v){
        answer = "false";
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TrueFalseEditActivity.this, FlashcardsActivity.class);
        TrueFalseEditActivity.this.startActivity(flashcardsReturnActivity);
    }
    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(TrueFalseEditActivity.this, HomeActivity.class);
        TrueFalseEditActivity.this.startActivity(goBack);
    }
    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(TrueFalseEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }
}
