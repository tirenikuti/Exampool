package comp3350.exampool.presentation;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FlashcardsViewActivity extends AppCompatActivity {
    private List<Flashcard> flashcardList;
    Flashcard flashcard;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_view);

        TextView questionView = (TextView) findViewById(R.id.typed_question);
        TextView answerView = (TextView) findViewById(R.id.revealed_answer);
        AccessFlashcards accessFlashcards = new AccessFlashcards();
        flashcardList = accessFlashcards.getFlashcards();

        Intent intent = getIntent();
        flashcard = intent.getParcelableExtra("theCard");


        questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
        answerView.setText(flashcard.getAnswer());
    }


    @Override
    protected void onDestroy() {super.onDestroy();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(FlashcardsViewActivity.this, HomeActivity.class);
        FlashcardsViewActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(FlashcardsViewActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButtonOnClick(View v) {
        Intent notesReturnIntent = new Intent(FlashcardsViewActivity.this, FlashcardsActivity.class);
        FlashcardsViewActivity.this.startActivity(notesReturnIntent);
    }

    public void editOnCLick(View v){
        if(flashcard instanceof MultipleChoiceQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsViewActivity.this, MultipleChoiceEditActivity.class);
            editFlashcardIntent.putExtra("theCard", flashcard);
            FlashcardsViewActivity.this.startActivity(editFlashcardIntent);
        }
        else if(flashcard instanceof TrueFalseQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsViewActivity.this, TrueFalseEditActivity.class);
            editFlashcardIntent.putExtra("theCard", flashcard);
            FlashcardsViewActivity.this.startActivity(editFlashcardIntent);
        }
        else {
            Intent editFlashcardIntent = new Intent(FlashcardsViewActivity.this, TypedAnswerEditActivity.class);
            editFlashcardIntent.putExtra("theCard", flashcard);
            FlashcardsViewActivity.this.startActivity(editFlashcardIntent);
        }
    }

    public void buttonNextOnClick(View view) {
        Flashcard flashcard;
        if(position < flashcardList.size() - 1){
            position++;
            flashcard = flashcardList.get(position);

            TextView questionView = (TextView) findViewById(R.id.typed_question);
            TextView answerView = (TextView) findViewById(R.id.revealed_answer);

            questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
            answerView.setText("");
        }
        else{
            Toast.makeText(FlashcardsViewActivity.this, "This is the last card ", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonPreviousOnClick(View view) {
        Flashcard flashcard;
        if(position > 0){
            position--;
            flashcard = flashcardList.get(position);

            TextView questionView = (TextView) findViewById(R.id.typed_question);
            TextView answerView = (TextView) findViewById(R.id.revealed_answer);

            questionView.setText(flashcard.getQuestion() + flashcard.getOptions());
            answerView.setText("");
        }
        else{
            Toast.makeText(FlashcardsViewActivity.this, "This is the first card ", Toast.LENGTH_SHORT).show();
        }
    }
}
