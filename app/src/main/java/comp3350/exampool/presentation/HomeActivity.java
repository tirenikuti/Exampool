package comp3350.exampool.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.exampool.R;
import comp3350.exampool.application.Main;

public class HomeActivity extends AppCompatActivity {
    //Navigation Buttons
    Button buttonFlashcards;
    Button buttonNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        copyDatabaseToDevice();
        //Assign button from ID
        buttonFlashcards = findViewById(R.id.flashcards);
        buttonNotes = findViewById(R.id.Notes);


        /**
         * Check if the button is clicked and navigate to flashcards
         */
        buttonFlashcards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, flashCardHome.class);
                startActivity(intent);
            }

        });


        /**
         * Check if the button is clicked and navigate to notes
         */
        buttonNotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NoteActivity.class);
                startActivity(intent);
            }

        });
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

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch(final IOException ioe){
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

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
