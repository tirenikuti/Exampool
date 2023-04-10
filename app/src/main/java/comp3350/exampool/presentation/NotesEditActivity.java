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

    /**
     * initializes the activity with all of the stored content for the selected note for the user
     * to view and/or make changes to
     * @param savedInstanceState (default android param)
     */
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

    /**
     * saves the current Note overwriting the contents with the new contents of the Note the User changed
     * also verifies that the user Still has a Title otherwise gives them a Warning
     * @param view (default android param)
     */
    public void buttonSaveOnClick(View view) {
        TextView noteView = (TextView) findViewById(R.id.notesText);
        TextView noteViewTitle = (TextView) findViewById(R.id.notesTitle);

        if(noteViewTitle.getEditableText().toString().trim().equals("")){
            Messages.warning(this, "Please Input a new Title");
        }
        else {
            note.editNote(noteView.getEditableText().toString(), noteViewTitle.getEditableText().toString().trim());
            accessNotes.updateNote(note);
            onBackPressed();
        }
    }

    /**
     * deletes the current note from the database and returns to the Notes homepage
     * @param view (default android param)
     */
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
