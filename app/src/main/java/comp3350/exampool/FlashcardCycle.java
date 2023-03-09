//package comp3350.exampool;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import comp3350.exampool.Flashcards.Flashcard;
//
//public class flashcardcyle extends AppCompatActivity {private TextView mTextView;
//    private String cardText;
//    private int mIndex = 0;
//
//
//    @SuppressLint("WrongViewCast")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_flashcardcyle);
//
//        Button cycleCard = findViewById(R.id.button);
//        //Get flashcard front
//        cardText.setText(Flashcard.getFront());
//
//        cycleCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mIndex++;
//                //If flashcard front being displayed show back
//                if (mIndex == 0) {
//                    cardText.setText(Flashcard.getBack());
//                    mIndex = 1;
//                //Show the answer
//                }else{
//                    cardText.setText(Flashcard.getFront());
//                    mIndex = 0;
//
//                }
//
//            }
//        });
//    }
//}