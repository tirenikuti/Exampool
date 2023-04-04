package comp3350.exampool.presentation;

import android.app.Activity;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.business.AccessNotes;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class NotesActivity extends Activity {
    private AccessNotes accessNotes;
    private List<Notes> notesList;
    private ArrayAdapter<Notes> notesArrayAdapter;
    private int selectedNotesPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_home);

        accessNotes = new AccessNotes();

        try{
            notesList = new ArrayList<>();
            notesList.addAll(accessNotes.getNotes());

            notesArrayAdapter = new ArrayAdapter<Notes>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, notesList){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                    text1.setText(notesList.get(position).getNoteTitle());
                    text2.setText(notesList.get(position).getNoteID());

                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listNotes);
            listView.setAdapter(notesArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Button updateButton = (Button)findViewById(R.id.buttonNotesUpdate);
                    Button deleteButton = (Button)findViewById(R.id.buttonNotesDelete);

                    if (position == selectedNotesPosition) {
                        listView.setItemChecked(position, false);
                        updateButton.setEnabled(false);
                        deleteButton.setEnabled(false);
                        selectedNotesPosition = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        updateButton.setEnabled(true);
                        deleteButton.setEnabled(true);
                        selectedNotesPosition = position;
                        selectedNotesAtPosition(position);
                    }
                }
            });

            final EditText editNotesID = (EditText)findViewById(R.id.editNotesID);
            final Button buttonNotes = (Button)findViewById(R.id.buttonNotes);

            editNotesID.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int count, int after) {}
                @Override
                public void afterTextChanged(Editable editable) {
                    buttonNotes.setEnabled(editNotesID.getText().toString().length() > 0);
                }
            });
        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }
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

    public void selectedNotesAtPosition(int position){
        Notes selected = notesArrayAdapter.getItem(position);
    }

    public void buttonNotesUpdateOnClick(View v){
        Intent notesEditIntent = new Intent(NotesActivity.this, NotesEditActivity.class);
        NotesActivity.this.startActivity(notesEditIntent);
    }

    public void buttonNotesCreateOnClick(View v) {
        Intent editNotesIntent = new Intent(NotesActivity.this, NotesEditActivity.class);
        NotesActivity.this.startActivity(editNotesIntent);
        Notes notes = createNotesFromEditText();
        String result;

        Intent notesEditIntent = new Intent(NotesActivity.this, NotesEditActivity.class);
        NotesActivity.this.startActivity(notesEditIntent);

        result = validateNotesData(notes, true);
        if (result == null) {
//            try {
//                notes = accessNotes.insertNote(notes);
//
//                notesList = accessNotes.getNotes();
//                notesArrayAdapter.notifyDataSetChanged();
//                int pos = notesList.indexOf(notes);
//                if (pos >= 0) {
//                    ListView listView = (ListView)findViewById(R.id.listNotes);
//                    listView.setSelection(pos);
//                }
//            } catch (final Exception e) {
//                Messages.fatalError(this, e.getMessage());
//            }
        } else {
            Messages.warning(this, result);
        }
    }

    private Notes createNotesFromEditText(){
        EditText editID = (EditText) findViewById(R.id.editNotesID);
        EditText editName = (EditText) findViewById(R.id.editNotesTitle);

        Notes note = new Notes(editID.getText().toString());

        return note;
    }

    private String validateNotesData(Notes note, boolean isNewCourse){
        if (note.getNoteID().length() == 0){
            return "Notes ID required";
        }

        if (note.getNoteTitle().length() == 0){
            return "Note Title required";
        }

        if(isNewCourse && accessNotes.getRandom(note.getNoteID()) != null){
            return "Note ID " + note.getNoteID() + " already exists.";
        }

        return null;
    }

    public void buttonNotesDeleteOnClick(View view) {
    }
}