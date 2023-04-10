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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;

/**
 * Summary: The presentation layer containing the Flashcard view home
 * Description: This controls the layout file that displays the flashcard view home
 * containing the list of flash cards in our database. On clicking a flashcard, you
 * gain the ability to edit the flashcard
 */

public class FlashcardsActivity extends AppCompatActivity {

    private AccessFlashcards accessFlashcards;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<Flashcard> flashcardArrayAdapter;
    private int selectedFlashcardPosition = -1;

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcardhome);
        accessFlashcards = new AccessFlashcards();

        //this block retrieves the Flashcards currently stored in our database
        try{
            flashcardList = new ArrayList<>();
            flashcardList.addAll(accessFlashcards.getFlashcards());

            //the listview adapter showing all the flashcards in our database
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


    /**
     * homeButtonOnClick()
     * This implements the home button returning the user to the homepage
     * @param v default value
     */
    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(FlashcardsActivity.this, HomeActivity.class);
        FlashcardsActivity.this.startActivity(goBack);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the
     * user feature was never implemented
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(FlashcardsActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * onBackPressed()
     * super defined function for returning tot he previously opened page
     */
    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * buttonFlashcardQuizOnClick()
     * This is the intial creation of the  layout page to be displayed
     * @param v default value
     */

    public void buttonFlashcardQuizOnClick(View v){
        Intent quizIntent = new Intent(FlashcardsActivity.this, FlashcardsQuizActivity.class);
        FlashcardsActivity.this.startActivity(quizIntent);
    }

    /**
     * CreateOnClick()
     * This is the intial creation of the  layout page to be displayed
     * @param v default value
     */
    public void CreateOnClick(View v){
        Intent createIntent = new Intent(FlashcardsActivity.this, FlashcardsCreatePromptActivity.class);
        FlashcardsActivity.this.startActivity(createIntent);
    }

    /**
     * selectedFlashcardAtPosition()
     * This returns the falshcad from the database at the specified position
     * @param  position the position in the database that the flashacrd resides
     */
    private void selectedFlashcardAtPosition(int position) {
        Flashcard selected = flashcardArrayAdapter.getItem(position);
        if (selected instanceof MultipleChoiceQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, MultipleChoiceEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        } else if (selected instanceof TrueFalseQuestion) {
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, TrueFalseEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        } else {
            Intent editFlashcardIntent = new Intent(FlashcardsActivity.this, TypedAnswerEditActivity.class);
            editFlashcardIntent.putExtra("theCard", selected);
            FlashcardsActivity.this.startActivity(editFlashcardIntent);
        }
    }
}
