package comp3350.exampool.objects;

public class Flashcard {
    private final String flashcardID;
    private final String userID;
    private String question;
    private String answer;
    public Flashcard(String flashcardID, String userID, String question, String answer){
        this.flashcardID = flashcardID;
        this.userID = userID;
        this.question = question;
        this.answer = answer;
    }
    public String getFlashcardID(){
        return flashcardID;
    }
    public String getUserID(){
        return userID;
    }
    public String getQuestion(){
        return question;
    }
    public void setQuestion(String theQuestion){
        question = theQuestion;
    }
    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String theAnswer){
        answer = theAnswer;
    }
    public String getOptions() {
        return "";
    }
}
