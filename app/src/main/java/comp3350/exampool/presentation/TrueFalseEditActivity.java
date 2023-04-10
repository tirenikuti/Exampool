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

public class TrueFalseEditActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    TrueFalseQuestion flashcard;
    String answer;

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

    public void buttonDeleteOnClick(View view) {
        accessFlashcards.deleteTFQFlashcard(flashcard);
        onBackPressed();
    }

    public void buttonSaveOnClick(View view) {
        EditText editQuestion = (EditText)findViewById(R.id.editQuestion);

        flashcard.editFlashcard(editQuestion.getText().toString(),answer, "", "", "");
        accessFlashcards.updateTrueFalseFlashcard(flashcard);
        onBackPressed();
    }

    public void onTrueClick(View v){
        answer = "True";
    }

    public void onFalseClick(View v){
        answer = "false";
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(TrueFalseEditActivity.this, FlashcardsActivity.class);
        TrueFalseEditActivity.this.startActivity(flashcardsReturnActivity);
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(TrueFalseEditActivity.this, HomeActivity.class);
        TrueFalseEditActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(TrueFalseEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }
}
