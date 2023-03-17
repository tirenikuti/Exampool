package comp3350.exampool.objects;
/**
 * Summary: Flashcard class used to pair and hold the Front (Type: Question) and the answer/ back of card
 * (Type: String)
 * Parameters: One constructor takes in a flashcardId(Int) and userId(Int) which then creates a blank question
 * Returns: Two getters which return the front and back of the flashcard
 * Description: Flashcard uses and holds Question objects
 */

import java.util.*;

public class Flashcard {
    //Class Variables
    private String flashcardID; 
    private String userID;
    private QuestionType questionType;
    private String question; 
    private String answer; 
    private int optionsNum; //the number of choices there are outside of the answer(3 = MCQ, 1 = TFQ else 0)
    private String option1; //null for SAQ and LAQ
    private String option2; //null for TFQ, SAQ and LAQ
    private String option3; //null for FTQ, SAQ and LAQ

    private String front; //The question (an options if present) displayed on the front of the flashcard
    private String back; //The answer displayed at the back of the flashcard

    /**
     *
     */
    public Flashcard(){

    }
    /**
     * Constructor for flashcard
     */
     public Flashcard(String newID){
         flashcardID = newID;
         userID = null;
         questionType = null;

         question = null;
         answer = null;

         option1 = null;
         option2 = null;
         option3 = null;
         //empty constructor;
     }

    /**
     * Constructor for flashcard with Question Type MCQ
     * @param flashCardID
     * @param userID
     * @param initQuestionType
     * @param question
     * @param answer
     * @param optionsNum
     * @param option1
     * @param option2
     * @param option3
     */
    public Flashcard(String flashCardID, String userID, QuestionType initQuestionType, String question, String answer, int optionsNum, String option1, String option2, String option3) {
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.questionType = initQuestionType;

        this.question = question;
        this.answer = answer;

        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;

        setCard();
    }

    /**
     * constructor for flashcard with Question Type TFQ
     * @param flashCardID
     * @param userID
     * @param questionType
     * @param question
     * @param answer
     * @param optionsNum
     * @param option1
     */
     public Flashcard(String flashCardID, String userID, QuestionType questionType, String question, String answer, int optionsNum, String option1) {
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.questionType = questionType;

        this.question = question;
        this.answer = answer;
        this.option1 = option1;

        setCard();
    }

    /**
     * Constructor for flashcard with Question Type SAQ and LAQ
     * @param flashCardID
     * @param userID
     * @param questionType
     * @param question
     * @param answer
     * @param optionsNum
     */
     public Flashcard(String flashCardID, String userID, QuestionType questionType, String question, String answer, int optionsNum) {
        this.flashcardID = flashCardID;
        this.userID = userID;
        this.questionType = questionType;

        this.question = question;
        this.answer = answer;

        setCard();
    }

    /**
    * Function to set the options so that front and the back of the card is catered accordingly
    */
    private void setCard() {
        if (questionType == QuestionType.MCQ){
            ArrayList<String> theOptions = new ArrayList<String>();
            theOptions.add(answer);
            theOptions.add(option1);
            theOptions.add(option2);
            theOptions.add(option3);

            Collections.shuffle(theOptions);

            front = question+"/n";
            for (int i = 0; i < theOptions.size(); i++) {
                front = front + theOptions.get(i) + "/n";
            }
        }
        else if (questionType == QuestionType.TFQ){
            ArrayList<String> theOptions = new ArrayList<String>();
            theOptions.add(answer);
            theOptions.add(option1);

            Collections.shuffle(theOptions);

            front = question+"/n";
            for (int i = 0; i < theOptions.size(); i++) {
                front = front + theOptions.get(i) + "/n";
            }
        }
        else {
            front = question;
        }
        
        back = answer;
    }

    /**
     * Getter for User ID
     * @return userID Type: Int
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Getter for Flashcard ID
     * @return userID Type: Int
     */
    public String getFlashcardID() {
        return flashcardID;
    }

    /**
     * Getter for question type
     * @return questionType Type: QuestionType
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Setter for question Type

     */
    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * Getter for question
     * @return question Type: String
     */
    public String getQuestion() {
        return question;
    }

    public String getOptions() {
        return ("A: "+this.option1+" B: "+this.option2+" C:"+this.option3);
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    /**
     * Setter for question
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for answer
     * @return answer Type: String
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter for Answer
     * @param answer Type: String
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }


    /**
     * Getter for front of card
     * @return front Type: Question
     */
    public String getFront() {
        return front;
    }

    /**
     * Getter for back of card
     * @return Back Type: String
     */
    public String getBack() {
        return back;
    }

    /**
     * Setter for front of card
     * @param front Type: Question
     */
    public void setFront(String front) {
        this.front = front;
    }

    /**
     * Setter for back of card
     * @param back Type: Question
     */
    public void setBack(String back) {
        this.back = back;
    }
}
