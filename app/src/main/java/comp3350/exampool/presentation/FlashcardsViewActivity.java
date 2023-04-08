//package comp3350.exampool.presentation;
//
//import comp3350.exampool.R;
//import comp3350.exampool.business.AccessFlashcards;
//import comp3350.exampool.objects.Flashcard;
//import comp3350.exampool.objects.Notes;
//import comp3350.exampool.business.AccessNotes;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class FlashcardsViewActivity extends AppCompatActivity {
//    private AccessFlashcards accessFlashcards;
//
//    private Flashcard flashcard;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        accessFlashcards = new AccessFlashcards();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notes_edit);
//
//        TextView question = (TextView) findViewById(R.id.notesTitle);
//        TextView answer = (TextView) findViewById(R.id.notesText);
//
//        Intent intent = getIntent();
//        flashcard = intent.getParcelableExtra("theNote");
//
//        question.setText(flashcard.getQuestion());
//        answer.setText(flashcard.getAnswer());
//    }
//
//    @Override
//    protected void onDestroy() {super.onDestroy();}
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_notes, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        return super.onOptionsItemSelected(item);
//
//
////    public void homeButttonOnClick(View v){
////        Intent goBack = new Intent(NotesEditActivity.this, HomeActivity.class);
////        NotesEditActivity.this.startActivity(goBack);
////    }
////
////    public void userButttonOnClick(View v){
////        Toast.makeText(NotesEditActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
////    }
////
////    @Override
////    public void onBackPressed() {
////        Intent notesReturnIntent = new Intent(NotesEditActivity.this, NotesActivity.class);
////        NotesEditActivity.this.startActivity(notesReturnIntent);
////    }
//}
