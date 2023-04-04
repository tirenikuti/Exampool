//package comp3350.exampool.presentation;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import comp3350.exampool.objects.Flashcard;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import comp3350.exampool.R;
//import comp3350.exampool.objects.Notes;
//import comp3350.exampool.objects.QuestionType;
//
//
//public class multipleChoiceQuestions extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_multiple_choice_questions);
//        //Placeholder data
//        ArrayList<Flashcard> data = new ArrayList<Flashcard>();
//        data.add(new Flashcard("1", "1", QuestionType.MCQ, "Does this suck?", "Yes", 3, "Maybe", "Yes", "No"));
//        data.add(new Flashcard("2", "1", QuestionType.MCQ, "Does this still suck?", "Yes", 3, "Maybe", "Yes", "No"));
//
//        //Set display text from data
//        TextView cardText = (TextView) findViewById(R.id.questionMCQ);
//        TextView McqOptionText = (TextView) findViewById(R.id.optionsMCQ);
//        TextView answerText = (TextView) findViewById(R.id.answerMCQ);
//
//        //Keep current spot in data
//        Iterator it = data.iterator();
//        //Current flashcard
//        Flashcard currCard = data.get(0);
//
//        //Get the next flashcard that is a multiple choice question
//        while (it.hasNext() && (currCard.getQuestionType() != QuestionType.MCQ)) {
//            currCard = (Flashcard) it.next();
//        }
//
//        //Display the text of the curr flashcard
//        cardText.setText(currCard.getQuestion());
//        McqOptionText.setText(currCard.getOptions());
//        answerText.setText(currCard.getAnswer());
//
//        //Buttons
//        Button buttonNext;
//        buttonNext = findViewById(R.id.nextMCQ);
//        Button buttonReveal;
//        buttonReveal = findViewById(R.id.RevealMCQ);
//        /**
//         * On click get the next flashcard type MCQ and display it's text
//         */
//        buttonNext.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                //curr flashcard
//                Flashcard outCard = (Flashcard) it.next();
//
//                //Get the next flashcard that is a multiple choice question
//                while (it.hasNext() && (outCard.getQuestionType() != QuestionType.MCQ)) {
//                    outCard = (Flashcard) it.next();
//                }
//
//                //Set the display text
//                cardText.setText(outCard.getQuestion());
//                McqOptionText.setText(outCard.getOptions());
//                answerText.setVisibility(View.INVISIBLE);
//                answerText.setText(outCard.getAnswer());
//            }
//
//        });
//
//        /**
//         * On click reveal answer text
//         */
//        buttonReveal.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                answerText.setVisibility(View.VISIBLE);
//            }
//        });
//    }
//}