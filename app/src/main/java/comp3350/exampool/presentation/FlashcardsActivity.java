package comp3350.exampool.presentation;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;

public class FlashcardsActivity extends Activity {

    private AccessFlashcards accessFlashcards;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<Flashcard> flashcardArrayAdapter;

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
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                    text1.setText(flashcardList.get(position).getFlashcardID());
                    text2.setText(flashcardList.get(position).getQuestion());

                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listFlashcards);
            listView.setAdapter(flashcardArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //set to open to "create/edit flashcard page"
                    }
                }
            );
        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }
    }

    public void buttonFlashcardQuizOnClick(View v){
        Intent createIntent = new Intent(FlashcardsActivity.this, FlashcardsQuizActivity.class);
        FlashcardsActivity.this.startActivity(createIntent);
    }


    public void buttonFlashcardCreateOnClick(View view) {
        //create/edit page
    }

    public void buttonOnClick(View view) {
        Intent flashcardsIntent = new Intent(FlashcardsActivity.this, multipleChoiceQuestions.class);
        FlashcardsActivity.this.startActivity(flashcardsIntent);
    }
}