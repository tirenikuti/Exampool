package comp3350.exampool.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.exampool.R;

public class Testing extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageView homeButton;
    ImageView userButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        homeButton = findViewById(R.id.homeIcon);
        userButton = findViewById(R.id.userIcon);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Testing.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Testing.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showPopup(View v){
        PopupMenu popup= new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.notes_or_flash);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notesCreate:
                Toast.makeText(this, "Tried creating a note", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.flashcardCreate:
                Toast.makeText(this, "Tried creating a flashcard", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

}
