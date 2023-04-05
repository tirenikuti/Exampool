package comp3350.exampool.presentation;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.Notes;

public class FlashcardsActivity extends Activity {

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
        }
    }

    public void buttonFlashcardQuizOnClick(View v){

        Flashcard theSelectedCard = flashcardList.get(0);

        Intent quizIntent = new Intent(FlashcardsActivity.this, FlashcardsQuizActivity.class);

        quizIntent.putExtra("card", theSelectedCard);

        FlashcardsActivity.this.startActivity(quizIntent);
    }

    public void buttonFlashcardCreateOnClick(View view) {
        //FlashcardEditActivity
    }

    private void selectedFlashcardAtPosition(int position) {
        Flashcard selected = flashcardArrayAdapter.getItem(position);
//        Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, //FlashcardEditActivity.class);
//        editFlashcardIntent.putExtra("flashcard", selected);
//        FlashcardsActivity.this.startActivity(editFlashcardIntent);
    }
}
