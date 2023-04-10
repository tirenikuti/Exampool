package comp3350.exampool.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.Math;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.objects.Notes;

public class NotesCreateActivity extends AppCompatActivity {
    private AccessNotes accessNotes;
    private Notes note;

    /**
     * prepares the app for adding a new note and gets the notes accessor ready and makes sure that
     * at least a title is inputted allowing the user to create their new note
     * @param savedInstanceState (default android param)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_create);

        accessNotes = new AccessNotes();

        Button create = (Button) findViewById(R.id.buttonCreateNotes);
        EditText title = (EditText) findViewById(R.id.notesTitleInput);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               create.setEnabled(!charSequence.toString().trim().equals(""));
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * calls the superclass onDestroy()
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

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

    /**
     * gathers all inputted values from the current activity to make a new Note object and adds it
     * to the database
     * @param view (default android param)
     */
    public void buttonNotesCreateOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        TextView noteViewTitle = (TextView) findViewById(R.id.notesTitleInput);
        String newID = getValidateNotesID();
        note = new Notes(newID, noteViewTitle.getEditableText().toString().trim(), "100", noteView.getEditableText().toString());
        accessNotes.insertNote(note);
        onBackPressed();
        Intent goBack = new Intent(NotesCreateActivity.this, NotesActivity.class);
        NotesCreateActivity.this.startActivity(goBack);
    }

    /**
     * generates NoteIDs until there is an unused one found
     * @return returns unique NoteID
     */
    private String getValidateNotesID(){
        String newID = ""+(int)(Math.random() * 100 + 1);
        while(accessNotes.getNote(newID) != null){
            newID = ""+(int)(Math.random() * 100 + 1);
        }
        return newID;
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(NotesCreateActivity.this, HomeActivity.class);
        NotesCreateActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(NotesCreateActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * Clears all text boxes so the user can start over
     * @param view (default android param)
     */
    public void buttonNotesClearOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        TextView noteViewTitle = (TextView) findViewById(R.id.notesTitleInput);
        noteView.setText("");
        noteViewTitle.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent notesReturnIntent = new Intent(NotesCreateActivity.this, NotesActivity.class);
        NotesCreateActivity.this.startActivity(notesReturnIntent);
    }
}
