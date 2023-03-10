package comp3350.exampool.objects;
import androidx.annotation.NonNull;
/**
 * Summary: Super class for all Question types
 * Parameters: 2 Constructors one that takes Question literal and answer and one for just question literal
 * Returns: Getters for questTag and Answer, toString that returns question
 * Description: Super class for all the different question types
 */

public class Question {
    //The Question's tag, The question literal
    private String questTag;

    //The answer to the question
    private String Answer;

    /**
     * Question Constructor
     * @param questTag Question literal Type: String
     * @param answer Answer for the passed question Type: String
     */
    public Question(String questTag, String answer) {
        assert (questTag!= null);
        assert (answer != null);
        this.questTag = questTag;
        this.Answer = answer;
    }

    /**
     * Default Question Constructor (No answer given)
     * @param questTag Question literal Type: String
     */
    public Question (String questTag){
        assert (questTag!= null);
        this.questTag = questTag;
    }
    //Getters and Setters

    /**
     * Getter for the Question Tag
     * @return Literal Question Type: String
     */
    public String getQuestTag() {
        return questTag;
    }

    /**
     * Getter for answer
     * @return Answer for question Type: String
     */
    public String getAnswer() {
        return Answer;
    }

    /**
     * Setter for the Question Tag
     * @param questTag Literal Question Type: String
     */
    public void setQuestTag(String questTag) {
        this.questTag = questTag;
    }

    /**
     * Setter for the answer
     * @param answer Answer for question Type: String
     */
    public void setAnswer(String answer) {
        Answer = answer;
    }

    /**
     * toString method. Same used in Long Answer Questions class (LAQ) and Short Answer Question class (SAQ)
     * @return String of just the question with "Question: " added in front
     */
    @NonNull
    @Override
    public String toString() {
        return "Question: " + questTag;
    }
}
