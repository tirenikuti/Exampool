package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.objects.Notes;

public class NotesCreateActivity extends AppCompatActivity {
    private AccessNotes accessNotes;
    private Notes note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_create);

        accessNotes = new AccessNotes();
    }

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

    public void buttonNotesCreateOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        TextView noteViewTitle = (TextView) findViewById(R.id.notesTitleInput);
        String newID = getValidateNotesID();
        note = new Notes(newID, noteViewTitle.getEditableText().toString(), "100", noteView.getEditableText().toString());
        accessNotes.insertNote(note);
        onBackPressed();
        Intent goBack = new Intent(NotesCreateActivity.this, NotesActivity.class);
        NotesCreateActivity.this.startActivity(goBack);
    }

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
