package comp3350.exampool.presentation;

import comp3350.exampool.R;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.business.AccessNotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends Activity {
    private List<Notes> notesList;
    private ArrayAdapter<Notes> notesArrayAdapter;
    private int selectedNotesPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_home);
        AccessNotes accessNotes = new AccessNotes();
        ImageView homeIcon = findViewById(R.id.homepage);
        ImageView userIcon = findViewById(R.id.userPage);
        ImageView back = findViewById(R.id.backButton);
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
                    text2.setText(notesList.get(position).getUserID());

                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listNotes);
            listView.setAdapter(notesArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position == selectedNotesPosition) {
                        listView.setItemChecked(position, false);
                        selectedNotesPosition = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        selectedNotesPosition = position;
                        selectedNotesAtPosition(position);
                    }
                }
            });
        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }
    }

    public void homeButttonOnClick(View v){
        Intent goBack = new Intent(NotesActivity.this, HomeActivity.class);
        NotesActivity.this.startActivity(goBack);
    }

    public void userButttonOnClick(View v){
        Toast.makeText(NotesActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    public void backButttonOnClick(View v){
        Intent goBack = new Intent(NotesActivity.this, HomeActivity.class);
        NotesActivity.this.startActivity(goBack);
    }

    public void CreateOnClick(View v) {
        Intent editNotesIntent = new Intent(NotesActivity.this, NotesCreateActivity.class);
        NotesActivity.this.startActivity(editNotesIntent);
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

        Intent editNotesIntent = new Intent(NotesActivity.this, NotesEditActivity.class);
        editNotesIntent.putExtra("theNote", selected);
        NotesActivity.this.startActivity(editNotesIntent);
    }
}