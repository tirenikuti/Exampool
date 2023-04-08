package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;

public class FlashcardsCreatePromptActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards_create_prompt);
    }

    public void buttonMultipleChoiceOnClick(View view) {
        Intent multipleChoiceIntent = new Intent(FlashcardsCreatePromptActivity.this, MultipleChoiceActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(multipleChoiceIntent);
    }

    public void buttonTrueFalseOnClick(View view) {
        Intent trueFalseIntent = new Intent(FlashcardsCreatePromptActivity.this, TrueFalseActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(trueFalseIntent);
    }

    public void buttonTypedAnswerOnClick(View view) {
        Intent typedAnswerIntent = new Intent(FlashcardsCreatePromptActivity.this, TypedAnswerActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(typedAnswerIntent);
    }
    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(FlashcardsCreatePromptActivity.this, HomeActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(FlashcardsCreatePromptActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(FlashcardsCreatePromptActivity.this, HomeActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(goBack);
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(FlashcardsCreatePromptActivity.this, FlashcardsActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(flashcardsReturnActivity);
    }

}
