package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TypedAnswerQuestion;

public class TypedAnswerActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_question_input);
    }

    public void buttonClearOnClick(View view) {
        String blank = "";
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        questionEdit.setText(blank);
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        answerEdit.setText(blank);
    }

    public void buttonCreateOnClick(View view) {
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        String question = questionEdit.toString();
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        String answer = answerEdit.toString();
        String flashcardID = generateFlashcardID();

        TypedAnswerQuestion flashcard = new TypedAnswerQuestion(flashcardID, "100", question, answer);
        accessFlashcards.insertTypedAnswerFlashcard(flashcard);
        onBackPressed();
        Intent flashcardsReturnActivity = new Intent(TypedAnswerActivity.this, FlashcardsActivity.class);
        TypedAnswerActivity.this.startActivity(flashcardsReturnActivity);
    }

    private String generateFlashcardID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessFlashcards.getFlashcard(newID) == null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        return newID;
    }

    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(TypedAnswerActivity.this, HomeActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(TypedAnswerActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(TypedAnswerActivity.this, FlashcardsCreatePromptActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }

    public void nextButtonOnCLick(View view) {
        Intent goBack2 = new Intent(TypedAnswerActivity.this, TypedAnswer.class);
        TypedAnswerActivity.this.startActivity(goBack2);
    }
}
