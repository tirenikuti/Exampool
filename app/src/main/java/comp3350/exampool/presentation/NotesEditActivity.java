package comp3350.exampool.presentation;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.business.AccessNotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;

public class NotesEditActivity extends Activity {
    private AccessNotes accessNotes;

    private Notes note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        accessNotes = new AccessNotes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_edit);

        TextView titleView = (TextView) findViewById(R.id.notesTitle);
        TextView noteView = (TextView) findViewById(R.id.notesText);

        Intent intent = getIntent();
        note = intent.getParcelableExtra("theNote");

        titleView.setText(note.getNoteTitle());
        noteView.setText(note.getNote());
        onBackPressed();
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

    public void buttonNotesSaveOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        note.editNote(noteView.getEditableText().toString());
        accessNotes.updateNote(note);
    }

    public void buttonNotesDeleteOnClick(View view) {
        accessNotes.deleteNote(note);
        onBackPressed();
    }

    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(NotesEditActivity.this, HomeActivity.class);
        NotesEditActivity.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(NotesEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(NotesEditActivity.this, NotesActivity.class);
        NotesEditActivity.this.startActivity(goBack);
    }

    @Override
    public void onBackPressed() {
        Intent notesReturnIntent = new Intent(NotesEditActivity.this, NotesActivity.class);
        NotesEditActivity.this.startActivity(notesReturnIntent);
    }
}
