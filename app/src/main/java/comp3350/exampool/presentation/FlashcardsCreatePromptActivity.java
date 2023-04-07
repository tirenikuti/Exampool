package comp3350.exampool.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.exampool.R;

public class FlashcardsCreatePromptActivity extends Activity {
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

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(FlashcardsCreatePromptActivity.this, FlashcardsActivity.class);
        FlashcardsCreatePromptActivity.this.startActivity(flashcardsReturnActivity);
    }

}
