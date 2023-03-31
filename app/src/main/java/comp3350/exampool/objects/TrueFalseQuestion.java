package comp3350.exampool.objects;

import comp3350.exampool.objects.Flashcard;

public class TrueFalseQuestion extends Flashcard {
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;
    private String wrongAnswer;

    public TrueFalseQuestion(String flashCardID, String userID, String question, String answer, String wrongAnswer) {
        super(flashCardID,userID,question,answer);
        this.wrongAnswer = wrongAnswer;
    }
    public String getOptions(){return "(A) TRUE \n (B) FALSE";}
}
