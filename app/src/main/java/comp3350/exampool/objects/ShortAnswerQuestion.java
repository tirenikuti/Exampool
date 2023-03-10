package comp3350.exampool.objects;
import java.util.ArrayList;
/**
 * Summary: Short answer question is a specialization of the Question class which is a "fill in the blank" type question
 * Parameters: One constructor takes the whole question String and the position (Int) of the answer in that question string
 * Returns: No returns
 * Description: Short answer question takes a string that is for example a complete statement or definition and given the position of the
 * word in the string to be replaced by a blank and be held as the answer for the question
 */
public class ShortAnswerQuestion extends Question{

    /**
     * Constructor for shortAnswerQuestion
     * Takes the original question tag and a position supplied by the user and eliminates the word
     * at that position from the question tag (To be used for "fill in the blank")
     * @param questTag Question literal Type: String
     * @param pos Position in the string of where the blank should be placed Type: int
     */
    public ShortAnswerQuestion(String questTag, int pos){
        //calls super's default constructor (Question)
        super(questTag);

        assert (pos >=0);
        //CreateAns() function creates the new Short Answer Question

        //The first element in the new array is the new question with word replaced with blank space
        super.setQuestTag(createAns(questTag,pos).get(0));

        //The second element in the array is the new answer
        super.setAnswer(createAns(questTag,pos).get(1));
    }

    /**
     * createAns creates a new Question tag and it's answer
     * @param questionTag Full question before the answer has been removed and replaced with a blank
     *                    Type: String
     * @param pos Position in the string of the word that needs to be replaced by a blank and stored as the answer
     *            Type: int
     * @return The question string array list with answer in the question replaced by a blank and the answer
     */
    private static ArrayList<String> createAns(String questionTag, int pos){
        assert(pos >=0);
        assert(questionTag != null);
        //The return array of strings containing the new question tag and its answer
        ArrayList <String> retString = new ArrayList<>();

        //Split the current question tag by space with each array element being a word from the original question
        String [] wordsInLine = questionTag.split(" ");
        assert(pos < wordsInLine.length);

        //Remove the word at the user-supplied position and store it in a string
        String removed = wordsInLine[pos];
        assert( removed != null);
        assert(!removed.equals(" "));

        //Creates a new string (The new Question)
        StringBuilder newWord = new StringBuilder();

        //Loop through array list to create a the question with blank added
        for (int i = 0; i < wordsInLine.length; i++) {
            //loop until you get to the position of the removed word
            if (i == pos) {
                //replace word in the question with spaces and continue from there
                newWord.append("________");
                continue;
            }
            //Adding words from the previous question to the new question
            newWord.append(wordsInLine[i]);

            //Separate the words with a space
            newWord.append(" ");
        }
        //Stores new question in position [0]
        retString.add(0, newWord.toString());
        //stores removed word (answer) in position [1]
        retString.add(1,removed);

        return retString;
    }

}

