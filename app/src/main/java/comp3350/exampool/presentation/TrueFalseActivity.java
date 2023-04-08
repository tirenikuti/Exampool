package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.TrueFalseQuestion;

public class TrueFalseActivity extends Activity {

    private AccessFlashcards accessFlashcards;
    String answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_true_false_create);
        accessFlashcards = new AccessFlashcards();
        answer = null;
    }

    public void buttonClearOnClick(View view) {
        String blank = "";
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        questionEdit.setText(blank);
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        answerEdit.setText(blank);
    }

    public void buttonCreateOnClick(View view) {
        TrueFalseQuestion flashcard = createFlashcardFromEditText();
        String result = validateFlashcardData(flashcard);

        if(result == null){
            accessFlashcards.insertTrueFalseFlashcard(flashcard);
            onBackPressed();
        }
        else{
            Messages.warning(this, result);
        }
    }

    public void onTrueClick(View v){
        answer = "True";
    }

    public void onFalseClick(View v){
        answer = "false";
    }

    private TrueFalseQuestion createFlashcardFromEditText(){
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        String question = questionEdit.getText().toString();
        String flashcardID = generateFlashcardID();

        return new TrueFalseQuestion(flashcardID, "100", question, answer);
    }

    private String validateFlashcardData(TrueFalseQuestion flashcard){
        if(flashcard.getQuestion().length() == 0){
            return "Question cannot be blank";
        }

        if(answer == null){
            return "Please pick an answer first";
        }
        return null;
    }

    private String generateFlashcardID() {
        String newID = "" + (int) (Math.random() * 100 + 1);
        while (accessFlashcards.getFlashcard(newID) != null) {
            newID = "" + (int) (Math.random() * 100 + 1);
        }
        System.out.println(newID);
        return newID;
    }

    public void homeButttonOnClick(View v) {
        Intent goBack = new Intent(TrueFalseActivity.this, HomeActivity.class);
        TrueFalseActivity.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v) {
        Toast.makeText(TrueFalseActivity.this, "You clicked user", Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v) {
        Intent goBack = new Intent(TrueFalseActivity.this, FlashcardsActivity.class);
        TrueFalseActivity.this.startActivity(goBack);
    }

    @Override
    public void onBackPressed(){
        Intent goBack = new Intent(TrueFalseActivity.this, FlashcardsActivity.class);
        TrueFalseActivity.this.startActivity(goBack);
    }
}
