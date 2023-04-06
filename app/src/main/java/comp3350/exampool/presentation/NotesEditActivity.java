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

import java.util.List;

public class NotesEditActivity extends Activity {
    private AccessNotes accessNotes;
    private List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_edit);

        TextView titleView = (TextView) findViewById(R.id.notesTitle);
        TextView noteView = (TextView) findViewById(R.id.notesText);

        Intent intent = getIntent();
        Notes note = intent.getParcelableExtra("theNote");

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

    public void buttonNotesSaveOnClick(View view) {

    }

    public void buttonNotesDeleteOnClick(View view) {
    }
}