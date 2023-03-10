package comp3350.exampool.objects;
import androidx.annotation.NonNull;

import java.util.*;
/**
 * Summary: Multiple choice question that specializes from the Question class
 * Parameters: Constructor that takes in the question and the right answer
 * Returns: Getters for every class variable
 * Description: Multiple choice question that has the question and different options for the answers
 * with char identifiers (ex. a,b,c)
 */

public class MultipleChoiceQuestion extends Question{
    //Class Variables

    //The correct answer
    private final Answer correct;

    //An arrayList of possible options
    private final ArrayList<Answer> answers = new ArrayList<>();
    //An arraylist of option tags (A, B, C, D)
    private final ArrayList<Character> tags = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));

    //Counter
    private int i =1;

    /**
     * Constructor: This constructor takes the question tag and the correct answer
     * the user will supply their own possible (wrong options)
     * @param quesTag Question literal Type: String
     * @param corrAns Answer Type: String
     */
    public MultipleChoiceQuestion(String quesTag, String corrAns) {
        //Calls Question default constructor
        super(quesTag);

        assert(tags.size()>0);
        //Sets the correct answer and assigns it a random tag (so that users don't know what option it will be)
        correct = (setRandTag(corrAns));

        answers.add(correct);
    }

    /**
     * Getter for the correct answers tag (ex. 'A")
     * @return The answer tag Type: Char
     */
    public char getCorrectTag() {
        return correct.getIdentifier() ;
    }

    /**
     * Setter for the Answer
     * @param correctA Answer for question Type: String
     */
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

    /**
     * Getter that returns the correct answer and its randomly assigned tag
     * @return The identifier and the correct answer together Type: String
     */
    @Override
    public String getAnswer() {
        return correct.getIdentifier() + "." + correct.getOption();
    }

    /**
     * Adds answers to the answers array list
     * @param ansToAdd answer to add Type: String
     */
    public void addAnswers(String ansToAdd) {
        assert(ansToAdd != null);
        assert(tags.size() >0);
        assert(optionInAnswers(ansToAdd));
        if(optionInAnswers(ansToAdd)) {
            Answer newAns = (setRandTag(ansToAdd));
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

    /**
     * Setter that sets the correct answer to the assigned tag
     * @param option The correct answer Type: String
     * @return Success? Type: Boolean
     */
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

    /**
     * Setter that sets random tags to answers as they enter the array
     * @param option Answer Type: String
     * @return the Answer object Type: Answer
     */
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

    /**
     * toString() method
     * @return String
     */
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

/**
 * Helper class for comparing tags
 */
class TagComparator implements Comparator<Answer> {
    /**
     * Compare answers
     * @param identifier1 First Answer to compare
     * @param identifier2 Second Answer to compare
     * @return int result from I1 identifier - I2 identifier
     */
    public int compare(Answer identifier1, Answer identifier2) {
        return identifier1.getIdentifier() - identifier2.getIdentifier();
    }
}

/**
 * Answer Helper class for the Multiple Choice questions
 * Holds the option tag and the answer
 */
class Answer {
    //Class variables
    //The option tag (Ex. A/B/C/D)
    private char identifier;
    //The option list
    private String option;

    /**
     * Constructor
     * @param identifier the tag for the answer Type: Char
     * @param option the answer Type: String
     */
    public Answer(char identifier, String option) {
        this.identifier = identifier;

        assert(option != null);
        this.option = option;
    }

    //Getters/Setters

    /**
     * Getter for Option
     * @return Answer text Type: String
     */
    public String getOption() {
        return option;
    }

    /**
     * Getter for Identifier
     * @return Letter identifier Type: Char
     */
    public Character getIdentifier() {
        return identifier;
    }

    /**
     * Setter for Option
     * @param option Answer text Type: String
     */
    public void setOption(String option) {
        this.option = option;
    }

    /**
     * Setter for identifier
     * @param identifier Letter identifier Type: Char
     */
    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }


    /**
     * toString method
     * @return Char identifier + answer text
     */
    @NonNull
    @Override
    public String toString() {
        return identifier + ". " + option;
    }
}

