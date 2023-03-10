package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;

public class NoteActivity extends AppCompatActivity {
    Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //Get some data list NEED TO GET FROM DATABASE
        ArrayList<Notes> data = new ArrayList<Notes>();
        Notes dummy = new Notes("1","1","Testing");
        Notes dummy1 = new Notes("2","1","Testing1");
        data.add(dummy);
        data.add(dummy1);


        TextView noteText = (TextView) findViewById(R.id.notesText);
        Iterator it = data.iterator();
        Notes currNote = (Notes) it.next();
        noteText.setText(currNote.getNote());

        //Get next on button press

        /**
         * Button to move to next Note
         */
        buttonNext =findViewById(R.id.nextNote);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(it.hasNext()){
                    Notes out = (Notes) it.next();
                    noteText.setText(out.getNote());
                }
                else {
                    //No more notes
                    noteText.setText("No more Notes!");
                }
            }

        });


    }
}