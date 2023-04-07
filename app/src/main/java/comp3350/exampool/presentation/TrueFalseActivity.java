package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TrueFalseQuestion;

public class TrueFalseActivity extends Activity {

    private AccessFlashcards accessFlashcards;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_true_false);
        accessFlashcards = new AccessFlashcards();
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

        TrueFalseQuestion flashcard = new TrueFalseQuestion(flashcardID, "100", question, answer);
        accessFlashcards.insertTrueFalseFlashcard(flashcard);
        onBackPressed();
        Intent flashcardsReturnActivity = new Intent(TrueFalseActivity.this, FlashcardsActivity.class);
        TrueFalseActivity.this.startActivity(flashcardsReturnActivity);
    }

    private String generateFlashcardID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessFlashcards.getFlashcard(newID) == null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        return newID;
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TrueFalseActivity.this, FlashcardsActivity.class);
        TrueFalseActivity.this.startActivity(flashcardsReturnActivity);
    }
}
