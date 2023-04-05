package comp3350.exampool.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;

public class FlashcardsQuizActivity extends Activity {
    private AccessFlashcards accessFlashcards;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<Flashcard> flashcardArrayAdapter;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcardquiz);

        accessFlashcards = new AccessFlashcards();

        flashcardList = accessFlashcards.getFlashcards();

        for(int i = 0; i < flashcardList.size(); i++){
            Flashcard theSelectedCard = flashcardList.get(i);
        }
    }
}
