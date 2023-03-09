package comp3350.exampool.objects;
//import java.util.Arrays;
//import java.util.Scanner;
public class ShortAnswerQuestion extends Question{

    //The transformed question is stored in an array with its answer
    final String [] shortAnswerQuestion;
    //Constructor
    //This constructor takes the original question tag and a position supplied by the user and eliminates the word
    // at that position from the question tag
    public ShortAnswerQuestion(String questTag, int pos){
        //calls super's default constructor
        super(questTag);

        assert (pos >=0);
        //call static createAns() function to create the new Short Answer Question
        shortAnswerQuestion = createAns(questTag, pos);

        //The first element in the new array is the new question tag
        super.setQuestTag(shortAnswerQuestion[0]);

        //the second element in the array is the new answer
        super.setAnswer( shortAnswerQuestion[1]);
    }
    //The Function creates a new Question tag and its answer
    private static String[] createAns(String questionTag, int pos){

        assert(pos >=0);
        assert(questionTag != null);
        //the return array of strings containing the new question tag and its answer
        String [] retString = new String[2];

        //split the current question tag by space with each array element being a word from the original question
        String [] wordsInLine = questionTag.split(" ");
        assert(pos < wordsInLine.length);
        assert (wordsInLine.length > 0);

        //removes the word at the user-supplied position and stores it in a string
        String removed = wordsInLine[pos];
        assert( removed != null);
        assert(!removed.equals(" "));

        //creates a new string (the new Question)
        String newWord = "";

        //loop to create a new question
        for (int i = 0; i < wordsInLine.length; i++) {
            //loop until you get to the position of the removed word
            if (i == pos) {
                //replace word in the question with spaces and continue from there
                newWord += "________";
                continue;
            }
            //continues adding words from the previous question to the new question
            newWord += wordsInLine[i];

            //separates them with a space
            newWord += " ";
        }
        //stores new question in position [0]
        retString[0] = newWord;
        //stores removed word (answer) in position [1]
        retString[1] = removed;

        return retString;
    }

}
