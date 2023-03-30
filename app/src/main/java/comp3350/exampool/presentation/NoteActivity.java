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
    //Buttons
    Button buttonNext, buttonEdit;
    boolean edit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //Placeholder Data
        ArrayList<Notes> data = new ArrayList<Notes>();
        Notes dummy = new Notes("1", "1", "Testing");
        Notes dummy1 = new Notes("2", "1", "Testing1");
        data.add(dummy);
        data.add(dummy1);

        // Note text from object id
        TextView noteText = (TextView) findViewById(R.id.notesText);
        //Keep current place in data
        Iterator it = data.iterator();
        //Current Note
        final Notes[] currNote = new Notes[1];
        //Display note text
        currNote[0] = (Notes) it.next();
        noteText.setText(currNote[0].getNote());


        /**
         * On click move to the next Note
         */
        buttonNext = findViewById(R.id.nextNote);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (it.hasNext()) {
                    currNote[0] = (Notes) it.next();
                    //Display Note text
                    noteText.setText(currNote[0].getNote());



                } else {
                    //No more notes
                    noteText.setText("No more Notes!");
                }
                noteText.setEnabled(false);
                noteText.setClickable(false);
                buttonEdit.setText("Edit");
                edit = false;
            }

        });
        buttonEdit = findViewById(R.id.editNote);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!edit) {

                    noteText.setEnabled(true);
                    noteText.setClickable(true);
                    buttonEdit.setText("Save");
                    edit = true;
                }
                else{
                    noteText.setEnabled(false);
                    noteText.setClickable(false);
                    buttonEdit.setText("Edit");
                    edit = false;
                    currNote[0].editNote(noteText.getEditableText().toString());
                }
            }

        });

    }
}