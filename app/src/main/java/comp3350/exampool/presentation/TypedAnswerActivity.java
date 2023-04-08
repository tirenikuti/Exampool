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

public class TypedAnswerActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_typed_answer_create);
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

    private TypedAnswerQuestion createFlashcardFromEditText(){
        EditText questionEdit = (EditText) findViewById(R.id.createQuestion);
        String question = questionEdit.getText().toString();
        EditText answerEdit = (EditText) findViewById(R.id.createAnswer);
        String answer = answerEdit.getText().toString();
        String flashcardID = generateFlashcardID();

        return new TypedAnswerQuestion(flashcardID, "100", question, answer);
    }

    private String validateFlashcardData(TypedAnswerQuestion flashcard){
        if(flashcard.getQuestion().length() == 0){
            return "Question cannot be blank";
        }

        if(flashcard.getAnswer().length() == 0){
            return "Please pick an answer first";
        }
        return null;
    }

    private String generateFlashcardID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessFlashcards.getFlashcard(newID) != null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        System.out.println(newID);
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
        Intent goBack = new Intent(TypedAnswerActivity.this, FlashcardsActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }

    @Override
    public void onBackPressed(){
        Intent goBack = new Intent(TypedAnswerActivity.this, FlashcardsActivity.class);
        TypedAnswerActivity.this.startActivity(goBack);
    }
}
