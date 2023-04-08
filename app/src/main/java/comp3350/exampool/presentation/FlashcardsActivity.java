package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;

import androidx.appcompat.app.AppCompatActivity;

public class FlashcardsActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<Flashcard> flashcardArrayAdapter;
    private int selectedFlashcardPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcardhome);
        accessFlashcards = new AccessFlashcards();

        try{
            flashcardList = new ArrayList<>();
            flashcardList.addAll(accessFlashcards.getFlashcards());

            flashcardArrayAdapter = new ArrayAdapter<Flashcard>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, flashcardList){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(flashcardList.get(position).getQuestion());

                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listFlashcards);
            listView.setAdapter(flashcardArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position == selectedFlashcardPosition) {
                        listView.setItemChecked(position, false);
                        selectedFlashcardPosition = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        selectedFlashcardPosition = position;
                        selectedFlashcardAtPosition(position);
                    }
                }
            });
        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(FlashcardsActivity.this, HomeActivity.class);
        FlashcardsActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(FlashcardsActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButtonOnClick(View v){
        Intent goBack = new Intent(FlashcardsActivity.this, HomeActivity.class);
        FlashcardsActivity.this.startActivity(goBack);
    }

    public void buttonFlashcardQuizOnClick(View v){
        Intent quizIntent = new Intent(FlashcardsActivity.this, FlashcardsQuizActivity.class);
        FlashcardsActivity.this.startActivity(quizIntent);
    }

    public void buttonCreateOnClick(View v){
        Intent createIntent = new Intent(FlashcardsActivity.this, FlashcardsCreatePromptActivity.class);
        FlashcardsActivity.this.startActivity(createIntent);
    }

    private void selectedFlashcardAtPosition(int position) {
        Flashcard selected = flashcardArrayAdapter.getItem(position);
        if(selected instanceof MultipleChoiceQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, MultipleChoiceEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        }
        else if(selected instanceof TrueFalseQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, TrueFalseEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        }
        else{
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, TypedAnswerEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        }
    }

    @Override
    public void onBackPressed() {
        Intent flashcardsReturnActivity = new Intent(FlashcardsActivity.this, HomeActivity.class);
        FlashcardsActivity.this.startActivity(flashcardsReturnActivity);
    }
}
