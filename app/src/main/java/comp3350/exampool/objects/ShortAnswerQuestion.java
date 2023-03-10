package comp3350.exampool.objects;
import java.util.ArrayList;

public class ShortAnswerQuestion extends Question{

    //Constructor
    //This constructor takes the original question tag and a position supplied by the user and eliminates the word
    // at that position from the question tag
    public ShortAnswerQuestion(String questTag, int pos){
        //calls super's default constructor
        super(questTag);

        assert (pos >=0);
        //call static createAns() function to create the new Short Answer Question

        //The first element in the new array is the new question tag
        super.setQuestTag(createAns(questTag,pos).get(0));

        //the second element in the array is the new answer
        super.setAnswer(createAns(questTag,pos).get(1));
    }

    //The Function creates a new Question tag and its answer
    private static ArrayList<String> createAns(String questionTag, int pos){
        assert(pos >=0);
        assert(questionTag != null);
        //the return array of strings containing the new question tag and its answer
        ArrayList <String> retString = new ArrayList<>();

        //split the current question tag by space with each array element being a word from the original question
        String [] wordsInLine = questionTag.split(" ");
        assert(pos < wordsInLine.length);

        //removes the word at the user-supplied position and stores it in a string
        String removed = wordsInLine[pos];
        assert( removed != null);
        assert(!removed.equals(" "));

        //creates a new string (the new Question)
        StringBuilder newWord = new StringBuilder();

        //loop to create a new question
        for (int i = 0; i < wordsInLine.length; i++) {
            //loop until you get to the position of the removed word
            if (i == pos) {
                //replace word in the question with spaces and continue from there
                newWord.append("________");
                continue;
            }
            //continues adding words from the previous question to the new question
            newWord.append(wordsInLine[i]);

            //separates them with a space
            newWord.append(" ");
        }
        //stores new question in position [0]
        retString.add(0, newWord.toString());
        //stores removed word (answer) in position [1]
        retString.add(1,removed);

        return retString;
    }

}

