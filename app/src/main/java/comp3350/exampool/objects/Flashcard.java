package comp3350.exampool.objects;
public class Flashcard {
    //The question displayed on the front of the flashcard
    private Question front;

    //The answer displayed at the back of the flashcard
    private String back;

    //Constructor
    public Flashcard(int flashCardID, int userID) {
        //add
        //default variable set to blank
        front = new Question("blank", "blank");
        assert(front.getAnswer()!= null);
        //the back is the answer from the front Question
        back = front.getAnswer();
    }
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
