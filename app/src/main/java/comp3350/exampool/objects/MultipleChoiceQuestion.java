package comp3350.exampool.objects;
import androidx.annotation.NonNull;

import java.util.*;

public class MultipleChoiceQuestion extends Question{
    //the correct answer
    private final Answer correct;

    //an arrayList of possible options
    private final ArrayList<Answer> answers = new ArrayList<>();
    //an arraylist of option tags (A, B, C, D)
    private final ArrayList<Character> tags = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));

    //counter
    private int i =1;

    //Constructor
    // This constructor takes the question tag and the correct answer
    // the user will supply their own possible (wrong options)
    public MultipleChoiceQuestion(String quesTag, String corrAns) {
        //calls super's default constructor
        super(quesTag);

        assert(tags.size()>0);
        //sets the correct answer and assigns it a random tag (so that users don't know what option it will be)
        correct = (setRandTag(corrAns));

        answers.add(correct);
    }
    public char getCorrectTag() {
        return correct.getIdentifier() ;
    }
    @Override
    public void setAnswer(String correctA) {
        correct.setOption(correctA);
        for (Answer answer : answers) {
            if ((answer.getOption()).equals(correct.getOption())) {
                correct.setIdentifier(answer.getIdentifier());
                break;
            }
        }
    }

    //returns the correct answer and its randomly assigned tag
    @Override
    public String getAnswer() {
        return correct.getIdentifier() + "." + correct.getOption();
    }
    //adds answers to the answers array list
    public void addAnswers(String ans1) {
        assert(ans1 != null);
        assert(tags.size() >0);
        assert(optionInAnswers(ans1));
        if(optionInAnswers(ans1)) {
            Answer newAns = (setRandTag(ans1));
            assert (i <= answers.size());
            answers.add(newAns);
            i++;
        }
        else{
            System.out.println("This option has already been put in (NO DUPLICATES)");
        }
        if(i == answers.size()) {
            Collections.sort(answers, new TagComparator());
        }
    }

    //sets the correct answer to the assigned tag
    private boolean optionInAnswers(String option) {
        boolean alreadyIn = false;
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).getOption().equals(option)){
                alreadyIn = true;
                break;
            }
        }
        return !alreadyIn;
    }
    //sets random tags to answers as they enter the array
    private Answer setRandTag(String option){
        assert(tags.size() > 0);
        int n = tags.size();

        //get the random char
        int rnd = new Random().nextInt(n);

        assert (rnd <= tags.size());

        Answer retAnswer  = new Answer(tags.get(rnd), option);
        tags.remove(rnd);
        return retAnswer;
    }

    //toString() method
    @NonNull
    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        for (Answer answer : answers) {
            retString.append("\n").append(answer);
        }
        return super.getQuestTag() + retString;
    }
}

class TagComparator implements Comparator<Answer> {
    public int compare(Answer identifier1, Answer identifier2) {
        return identifier1.getIdentifier() - identifier2.getIdentifier();
    }
}
//Answer Helper class for the Multiple Choice questions
class Answer {
    //the option tag (A/B/C/D)
    private char identifier;
    //the option list
    private String option;

    //Constructor
    public Answer(char identifier, String option) {
        this.identifier = identifier;

        assert(option != null);
        this.option = option;
    }

    //Getters/Setters
    public String getOption() {
        return option;
    }

    public Character getIdentifier() {
        return identifier;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }

    //toString method
    @NonNull
    @Override
    public String toString() {
        return identifier + ". " + option;
    }
}

