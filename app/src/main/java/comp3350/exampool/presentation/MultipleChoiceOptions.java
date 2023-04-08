package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;

public class MultipleChoiceOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_multiple_choice_answer);

    }
    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(MultipleChoiceOptions.this, HomeActivity.class);
        MultipleChoiceOptions.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(MultipleChoiceOptions.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(MultipleChoiceOptions.this, MultipleChoiceActivity.class);
        MultipleChoiceOptions.this.startActivity(goBack);
    }
}

