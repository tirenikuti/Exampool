package comp3350.exampool.objects;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestion extends Flashcard{
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;

    public MultipleChoiceQuestion(String flashCardID, String userID, String question, String theAnswer, String option1, String option2, String option3) {
        super(flashCardID,userID,question,theAnswer);
        this.answer = "Sup";
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public String getOptions(){
        ArrayList<String> theOptions = new ArrayList<>();
        theOptions.add(answer);
        theOptions.add(option1);
        theOptions.add(option2);
        theOptions.add(option3);

        Collections.shuffle(theOptions);

        String options = "";
//        for (int i = 0; i < theOptions.size(); i++) {
//            options = options + theOptions.get(i) + "\n";
//        }
        for (int i = 0; i < theOptions.size(); i++) {
            options = options + theOptions.get(i) + "      ";
        }
        return options;
    }

//    public String getAnswer(){
//        return "Hi";
//    }
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public String getOption3(){
        return option3;
    }
}
