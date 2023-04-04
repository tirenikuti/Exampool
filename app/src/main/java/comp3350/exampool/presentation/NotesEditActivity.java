package comp3350.exampool.presentation;

import android.app.Activity;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.business.AccessNotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

public class NotesEditActivity extends Activity {
    private AccessNotes accessNotes;
    private List<Notes> notesList;

    Button buttonNext, buttonEdit;
    boolean edit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //Placeholder Data
        ArrayList<Notes> data = new ArrayList<Notes>();
        Notes dummy = new Notes("1", "title", "1", "Testing");
        Notes dummy1 = new Notes("2", "title", "1", "Testing1");
        data.add(dummy);
        data.add(dummy1);

        // Note text from object id
        TextView noteText = (TextView) findViewById(R.id.notesText);
        //Keep current place in data
        final Iterator[] it = {data.iterator()};
        //Current Note
        final Notes[] currNote = new Notes[1];
        //Display note text
        currNote[0] = (Notes) it[0].next();
        noteText.setText(currNote[0].getNote());


        /**
         * On click move to the next Note
         */
        buttonNext = findViewById(R.id.nextNote);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (it[0].hasNext()) {
                    //get next note
                    currNote[0] = (Notes) it[0].next();
                } else {
                    //No more notes, reset
                    it[0] = data.iterator();
                    currNote[0] = (Notes) it[0].next();
                }
                //Display Note text
                noteText.setText(currNote[0].getNote());
                noteText.setFocusableInTouchMode(false);
                noteText.clearFocus();
                noteText.setClickable(false);
                buttonEdit.setText("Edit");
                edit = false;
            }

        });
        buttonEdit = findViewById(R.id.editNote);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!edit) {

                    noteText.setFocusableInTouchMode(true);
                    noteText.setClickable(true);
                    buttonEdit.setText("Save");
                    edit = true;
                }
                else{
                    noteText.setFocusableInTouchMode(false);
                    noteText.clearFocus();
                    noteText.setClickable(false);
                    buttonEdit.setText("Edit");
                    edit = false;
                    currNote[0].editNote(noteText.getEditableText().toString());
                }
            }

        });


    }

    @Override
    protected void onDestroy() {super.onDestroy();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void buttonNotesEditOnClick(View view) {
    }

    public void buttonNotesBackOnClick(View view) {
    }
}
