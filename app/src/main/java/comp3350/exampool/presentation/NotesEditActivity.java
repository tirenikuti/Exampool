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

import androidx.appcompat.app.AppCompatActivity;

public class NotesEditActivity extends AppCompatActivity {
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

    public void buttonSaveOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        TextView noteViewTitle = (TextView) findViewById(R.id.notesTitle);
        note.editNote(noteView.getEditableText().toString(), noteViewTitle.getEditableText().toString());
        accessNotes.updateNote(note);
        onBackPressed();
    }

    public void buttonDeleteOnClick(View view) {
        accessNotes.deleteNote(note);
        onBackPressed();
    }

    public void homeButtonOnClick(View v){
        Intent goBack = new Intent(NotesEditActivity.this, HomeActivity.class);
        NotesEditActivity.this.startActivity(goBack);
    }

    public void userButtonOnClick(View v){
        Toast.makeText(NotesEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent notesReturnIntent = new Intent(NotesEditActivity.this, NotesActivity.class);
        NotesEditActivity.this.startActivity(notesReturnIntent);
    }
}
