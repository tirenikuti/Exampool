package comp3350.exampool.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import comp3350.exampool.R;

public class Testing2 extends AppCompatActivity {

    FloatingActionButton addResource;
    ImageView home;
    ImageView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing3);

        addResource =findViewById(R.id.addResources);
        home = findViewById(R.id.home);
        user = findViewById(R.id.user);

        addResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Testing2.this, "You clicked add", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Testing2.this, "You clicked home", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Testing2.this, "You clicked user", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });
    }
}
