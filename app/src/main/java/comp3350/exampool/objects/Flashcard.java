package comp3350.exampool.objects;
// import java.util.ArrayList;
import java.util.Scanner;

public class Flashcard {
    //add
    private final int flashcardID;
    private final int userID;
    //The question displayed on the front of the flashcard
    private Question front;

    //The answer displayed at the back of the flashcard
    private String back;

    //the list of Tags attached to the flashcard (Krupali)
    //private ArrayList <Tag> Tags;

    //Constructor
    public Flashcard(int flashCardID, int userID) {
        this.flashcardID = flashCardID;
        this.userID = userID;
        //default variable set to blank
        front = new Question("blank", "blank");
        assert(front.getAnswer()!= null);
        //the back is the answer from the front Question
        back = front.getAnswer();
    }

    //Displays Flashcards, acts also as a toString method although does not return String type
    public void displayFlashcard(){

        assert(front.getQuestTag() != null);
        assert(front.getAnswer() != null);
        String frontString = front.toString();
        System.out.println(frontString);
        System.out.println("Press any key to flip flash card, press N to quit");
        Scanner question = new Scanner(System.in);
        String resp = question.nextLine();

        assert(resp != null);

        while(!resp.equals("N")) {
            System.out.println(back);
            resp = question.nextLine();
            assert(resp != null);
            if(!resp.equals("N")) {
                System.out.println(frontString);
            }
            else{
                break;
            }
            resp = question.nextLine();
            assert(resp != null);
        }
    }

    //Getters and Setters

    //Getters Never Used, kept in case needed later
    public Question getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public void setFront(Question front) {
        this.front = front;
    }
    public void setBack(String back) {
        this.back = back;
    }
}
