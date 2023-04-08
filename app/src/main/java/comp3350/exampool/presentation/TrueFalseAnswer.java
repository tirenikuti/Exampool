package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class TrueFalseAnswer extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_true_false);
        accessFlashcards = new AccessFlashcards();
    }

/*    public void buttonClearOnClick(View view) {
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

    public void buttonCreateOnClick(View view) {
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

        MultipleChoiceQuestion flashcard = new MultipleChoiceQuestion(flashcardID, "100", question, answer, choice1, choice2, choice3);
        accessFlashcards.insertMultipleChoiceFlashcard(flashcard);
        onBackPressed();
        Intent flashcardsReturnActivity = new Intent(MultipleChoiceActivity.this, FlashcardsActivity.class);
        MultipleChoiceActivity.this.startActivity(flashcardsReturnActivity);
    }
*/
    private String generateFlashcardID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessFlashcards.getFlashcard(newID) == null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        return newID;
    }

    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(TrueFalseAnswer.this, HomeActivity.class);
        TrueFalseAnswer.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(TrueFalseAnswer.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(TrueFalseAnswer.this, FlashcardsCreatePromptActivity.class);
        TrueFalseAnswer.this.startActivity(goBack);
    }

    public void nextButtonOnCLick(View view) {
        Intent goBack2 = new Intent(TrueFalseAnswer.this, TrueFalseActivity.class);
        TrueFalseAnswer.this.startActivity(goBack2);
    }
}
