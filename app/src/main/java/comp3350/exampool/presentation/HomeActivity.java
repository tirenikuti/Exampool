package comp3350.exampool.presentation;

import comp3350.exampool.R;
import comp3350.exampool.application.Services;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    /**
     * onCreate()
     * This is the initial creation of the  layout page to be displayed
     * @param savedInstanceState default value
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        copyDatabaseToDevice();
    }

    /**
     * onDestroy()
     * This is a deconstructor for the activity classes
     */
    @Override
    protected void onDestroy(){ super.onDestroy(); }

    /**
     * showPopup()
     * This creates a popup menu when the + button is clicked
     * @param v default value
     */
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.notes_or_flash);
        popup.show();
    }

    /**
     * onMenuItemClick()
     * This allows action to be implemented on the popup menu items
     * @param item default value
     * @return generateFlashcardID Type: boolean
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.notesCreate:
                Intent createNotes = new Intent(HomeActivity.this, NotesCreateActivity.class);
                HomeActivity.this.startActivity(createNotes);
                return true;
            case R.id.flashcardCreate:
                Intent createFlashCards = new Intent(HomeActivity.this, FlashcardsCreatePromptActivity.class);
                HomeActivity.this.startActivity(createFlashCards);
                return true;
        }
        return false;
    }

    /**
     * onCreateOptionsMenu()
     * Contains the menu inflater
     * @param menu default value
     * @return generateFlashcardID Type: boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    /**
     * onOptionsItemSelected()
     * This handles action bar item clicks
     * @param item default value
     * @return generateFlashcardID Type: boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /**
     * userButtonOnClick()
     * This implements the user button which just displays a message as the user button was never used
     * @param v default value
     */
    public void userButtonOnClick(View v){
        Toast.makeText(HomeActivity.this, "You clicked user",Toast.LENGTH_SHORT).show();
    }

    /**
     * buttonFlashcardsOnClick()
     * This open the page displaying already created flashcards
     * @param v default value
     */
    public void buttonFlashcardsOnClick(View v) {
        Intent flashcardsIntent = new Intent(HomeActivity.this, FlashcardsActivity.class);
        HomeActivity.this.startActivity(flashcardsIntent);
    }

    /**
     * buttonNotesOnClick()
     * This open the page displaying already created notes
     * @param v default value
     */
    public void buttonNotesOnClick(View v) {
        Intent notesIntent = new Intent(HomeActivity.this, NotesActivity.class);
        HomeActivity.this.startActivity(notesIntent);
    }

    private void copyDatabaseToDevice(){
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH,Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {
            assetNames = assetManager.list(DB_PATH);
            for(int i = 0; i < assetNames.length; i++){
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Services.setDBPathName(dataDirectory.toString() + "/" + Services.getDBPathName());

        } catch(final IOException ioe){
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    //
    private void copyAssetsToDirectory(String[] assets, File directory) throws IOException{
        AssetManager assetManager=getAssets();

        for(String asset : assets){
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length -1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if(!outFile.exists()){
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while(count != -1){
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}
