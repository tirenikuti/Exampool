package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comp3350.exampool.R;

public class HomeActivity extends AppCompatActivity {
    //Navigation Buttons
    Button buttonFlashcards;
    Button buttonNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Assign button from ID
        buttonFlashcards = findViewById(R.id.flashcards);
        buttonNotes = findViewById(R.id.Notes);


        /**
         * Check if the button is clicked and navigate to flashcards
         */
        buttonFlashcards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, flashCardHome.class);
                startActivity(intent);
            }

        });


        /**
         * Check if the button is clicked and navigate to notes
         */
        buttonNotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NoteActivity.class);
                startActivity(intent);
            }

        });

    }
}
