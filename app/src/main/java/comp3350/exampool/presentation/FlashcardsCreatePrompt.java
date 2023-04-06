package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.exampool.R;
import comp3350.exampool.objects.TypedAnswerQuestion;

public class FlashcardsCreatePrompt extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards_create_prompt);
    }

    public void buttonMultipleChoiceOnClick(View view) {
        Intent multipleChoiceIntent = new Intent(FlashcardsCreatePrompt.this, MultipleChoiceActivity.class);
        FlashcardsCreatePrompt.this.startActivity(multipleChoiceIntent);
    }

    public void buttonTrueFalseOnClick(View view) {
        Intent trueFalseIntent = new Intent(FlashcardsCreatePrompt.this, TrueFalseActivity.class);
        FlashcardsCreatePrompt.this.startActivity(trueFalseIntent);
    }

    public void buttonTypedAnswerOnClick(View view) {
        Intent typedAnswerIntent = new Intent(FlashcardsCreatePrompt.this, TypedAnswerActivity.class);
        FlashcardsCreatePrompt.this.startActivity(typedAnswerIntent);
    }

}
