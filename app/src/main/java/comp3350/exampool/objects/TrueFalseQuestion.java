package comp3350.exampool.objects;
import androidx.annotation.NonNull;
/**
 * Summary: True or false question that holds the answer and a tag to identify the category for the question
 * Parameters: One constructor (String questionTag and String CorrectAnswer (true or false)
 * Returns: One toString method that returns a String
 * Description: Child of Question, more specific question type
 */
public class TrueFalseQuestion extends Question{
    //array list of the two option (True/False)
    private final String[] options = new String [2];

    /**
     * Constructor for TrueFalseQuestion
     * @param quesTag Literal question Type:String
     * @param corrAns Type: String (either "true" or "false")
     */
    public TrueFalseQuestion(String quesTag, String corrAns){
        super(quesTag);
        //Adding the options to the arraylist
        options[0] = "TRUE";
        options[1] = "FALSE";

        assert(corrAns != null);

        //Check corrAns for either true or false
        if(corrAns.equalsIgnoreCase("true")){
            super.setAnswer(options[0]);
        }
        else if(corrAns.equalsIgnoreCase("false")) {
            super.setAnswer(options[1]);
        }
        //Passed value not ("true" or "false")
    }

    /**
     * toString for TrueFalseQuestion
     * @return String with question and the option for answers (True or false)
     */
    @NonNull
    @Override
    public String toString() {
        String retString = options[0] + "\t" +options[1] ;
        return super.toString() + "\n\t" + retString;
    }
}
