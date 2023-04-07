package comp3350.exampool.presentation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.lang.Math;

import comp3350.exampool.R;
import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.objects.Notes;

public class NotesCreateActivity extends Activity {
    private AccessNotes accessNotes;

    private Notes note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        accessNotes = new AccessNotes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_create);
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
        String newID = ""+(int)(Math.random() * 100 + 1);
        List<String> ids = accessNotes.getNoteIDs();
        while(ids.contains(newID) && ids.size() != 100){
            newID = ""+(int)(Math.random() * 100 + 1);
        }

        note = new Notes(newID, noteViewTitle.getEditableText().toString(), "100", noteView.getEditableText().toString());
        accessNotes.insertNote(note);
        onBackPressed();
    }

    public void buttonNotesCancelOnClick(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent notesReturnIntent = new Intent(NotesCreateActivity.this, NotesActivity.class);
        NotesCreateActivity.this.startActivity(notesReturnIntent);
    }
}
