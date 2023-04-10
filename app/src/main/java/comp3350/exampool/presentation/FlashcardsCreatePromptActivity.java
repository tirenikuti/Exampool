package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;

/**
 * Summary: The presentation layer containing the create prompt
 * Description: This controls the layout file that displays the flashcard create
 * prompt giving the option between Multiple Choice, Typed and True or False flashcards to create.
 */

public class FlashcardsCreatePromptActivity extends AppCompatActivity {
    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards_create_prompt);
    }

    /**
     * buttonMultipleChoiceOnClick()
     * This creates a new Multiple Choice Question flashcard
     * @param view default value
     */
    public void buttonMultipleChoiceOnClick(View view) {
        Intent multipleChoiceIntent = new Intent(FlashcardsCreatePromptActivity.this, MultipleChoiceActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(multipleChoiceIntent);
    }

    /**
     * buttonTrueFalseOnClick()
     * This creates a new True/False Question flashcard
     * @param view default value
     */
    public void buttonTrueFalseOnClick(View view) {
        Intent trueFalseIntent = new Intent(FlashcardsCreatePromptActivity.this, TrueFalseActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(trueFalseIntent);
    }

    /**
     * buttonTrueFalseOnClick()
     * This creates a new Typed answer Question flashcard
     * @param view default value
     */
    public void buttonTypedAnswerOnClick(View view) {
        Intent typedAnswerIntent = new Intent(FlashcardsCreatePromptActivity.this, TypedAnswerActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(typedAnswerIntent);
    }

    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(FlashcardsCreatePromptActivity.this, HomeActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(FlashcardsCreatePromptActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(FlashcardsCreatePromptActivity.this, FlashcardsActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(flashcardsReturnActivity);
    }

}
