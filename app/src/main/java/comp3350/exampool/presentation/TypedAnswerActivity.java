package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TypedAnswerQuestion;
/**
 * Summary: The presentation layer containing the Typed Flashcard create page
 * Description: This controls the layout file that allows users to input typed  questions
 * as well as their correct answer
 */
public class TypedAnswerActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_typed_answer_create);
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
    }

    /**
     * buttonCreateOnClick()
     * This implements the button to create a new flashcard
     * @param view default value
     */
    public void buttonCreateOnClick(View view) {
        TypedAnswerQuestion flashcard = createFlashcardFromEditText();
        String result = validateFlashcardData(flashcard);

        if(result == null){
            accessFlashcards.insertTypedAnswerFlashcard(flashcard);
            onBackPressed();
        }
        else{
            Messages.warning(this, result);
        }
    }

    /**
     * createFlashcardFromEditText()
     * This creates a new flashcard
     * @return validateFlashcard Type: TypedAnswerQuestion
     */
    private TypedAnswerQuestion createFlashcardFromEditText(){
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        String question = questionEdit.getText().toString();
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        String answer = answerEdit.getText().toString();
        String flashcardID = generateFlashcardID();

        return new TypedAnswerQuestion(flashcardID, "100", question, answer);
    }

    /**
     * validateFlashcardData()
     * Helper function to ensure appropriate fields of Flashcard edit have been filled
     * * @param flashcard this is the flashcard to be validated
     * * @return validateFlashcard Type: String
     */
    private String validateFlashcardData(TypedAnswerQuestion flashcard){
        if(flashcard.getQuestion().length() == 0){
            return "Question cannot be blank";
        }

        if(flashcard.getAnswer().length() == 0){
            return "Please pick an answer first";
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
        Intent goBack = new Intent(TypedAnswerActivity.this, HomeActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(TypedAnswerActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed(){
        Intent goBack = new Intent(TypedAnswerActivity.this, FlashcardsActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }
}
