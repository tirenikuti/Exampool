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
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class MultipleChoiceActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_multiple_choice_create);
        accessFlashcards = new AccessFlashcards();
    }

    /**
     * buttonClearOnClick()
     * This clears the edit fields for a new flashcard
     * @param view default value
     */
    public void buttonClearOnClick(View view) {
        String blank = "";
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        questionEdit.setText(blank);
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        answerEdit.setText(blank);
        EditText choice1Edit = (EditText) findViewById(R.id.createChoice1);
        choice1Edit.setText(blank);
        EditText choice2Edit = (EditText) findViewById(R.id.createChoice2);
        choice2Edit.setText(blank);
        EditText choice3Edit = (EditText) findViewById(R.id.createChoice3);
        choice3Edit.setText(blank);
    }

    /**
     * buttonCreateOnClick()
     * This implements the button to create a new flashcard
     * @param view default value
     */
    public void buttonCreateOnClick(View view) {
        MultipleChoiceQuestion mcqFlashcard = createFlashcardFromEditText();
        String result = validateFlashcard(mcqFlashcard);

        if(result == null) {
            Flashcard flashcard = accessFlashcards.insertMultipleChoiceFlashcard(mcqFlashcard);
            onBackPressed();
            Intent goBack = new Intent(MultipleChoiceActivity.this, FlashcardsActivity.class);
            MultipleChoiceActivity.this.startActivity(goBack);
        }
        else{
            Messages.warning(this,result);
        }
    }

    /**
     * createFlashcardFromEditText()
     * This creates a new flashcard
     * @return createFlashcardFromEditText Type: MultipleChoiceQuestion
     */
    private MultipleChoiceQuestion createFlashcardFromEditText(){
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        String question = questionEdit.getText().toString();
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        String answer = answerEdit.getText().toString();
        EditText choice1Edit = (EditText) findViewById(R.id.createChoice1);
        String choice1 = choice1Edit.getText().toString();
        EditText choice2Edit = (EditText) findViewById(R.id.createChoice2);
        String choice2 = choice2Edit.getText().toString();
        EditText choice3Edit = (EditText) findViewById(R.id.createChoice3);
        String choice3 = choice3Edit.getText().toString();
        String flashcardID = generateFlashcardID();

        return new MultipleChoiceQuestion(flashcardID, "100", question, answer, choice1, choice2, choice3);
    }

    /**
     * validateFlashcard()
     * Helper function to ensure appropriate fields of Flashcard edit have been filled
     * * @param flashcard this is the flashcard to be validated
     * * @return validateFlashcard Type: String
     */
    private String validateFlashcard(MultipleChoiceQuestion flashcard){
        if(flashcard.getQuestion().length() == 0){
           return "Question cannot be blank";
        }

        if(flashcard.getAnswer().length() == 0){
            return "Answer cannot be blank";
        }

        if((flashcard.getOption1().length() == 0) || (flashcard.getOption2().length() == 0) || (flashcard.getOption3().length() == 0)){
            return "All 3 options must be filled in";
        }
        return null;
    }

    /**
     * generateFlashcardID()
     * This generates a new ID for the created flashcard
     * * @return generateFlashcardID Type: String
     */
    private String generateFlashcardID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessFlashcards.getFlashcard(newID) != null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        System.out.println(newID);
        return newID;
    }

    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(MultipleChoiceActivity.this, HomeActivity.class);
        MultipleChoiceActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(MultipleChoiceActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed(){
        Intent goBack = new Intent(MultipleChoiceActivity.this, FlashcardsActivity.class);
        MultipleChoiceActivity.this.startActivity(goBack);
    }
}
