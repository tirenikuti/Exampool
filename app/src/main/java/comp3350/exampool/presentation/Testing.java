package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;

public class Testing extends AppCompatActivity {

    Button buttonFlashcards;
    Button buttonNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing3);
        ImageView homeIcon = findViewById(R.id.homepage);


        homeIcon.bringToFront();
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Testing.this, "You clicked home", Toast.LENGTH_LONG).show();
            }
        });
//        userIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Testing.this, "You clicked user", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

