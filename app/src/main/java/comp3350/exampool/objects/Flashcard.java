package comp3350.exampool.objects;
/**
 * Summary: Flashcard class used to pair and hold the Front (Type: Question) and the answer/ back of card
 * (Type: String)
 * Parameters: One constructor takes in a flashcardId(Int) and userId(Int) which then creates a blank question
 * Returns: Two getters which return the front and back of the flashcard
 * Description: Flashcard uses and holds Question objects
 */
public class Flashcard {
    //Class Variables
    //The question displayed on the front of the flashcard
    private Question front;
    //The answer displayed at the back of the flashcard
    private String back;

    /**
     * Constructor for flashcard
     * @param flashCardID Int to identify the Flashcard
     * @param userID Int to identify the User
     */
    public Flashcard(int flashCardID, int userID) {
        //add
        //default variable set to blank
        front = new Question("blank", "blank");
        assert(front.getAnswer()!= null);
        //the back is the answer from the front Question
        back = front.getAnswer();
    }

    /**
     * Getter for front of card
     * @return front Type: Question
     */
    public Question getFront() {
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
    public void setFront(Question front) {
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
