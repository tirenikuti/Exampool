package comp3350.exampool.objects;

public class TypedAnswerQuestion extends Flashcard{
    private String flashcardID;
    private String userID;
    private String question;
    private String answer;

    public TypedAnswerQuestion(String flashCardID, String userID, String question, String answer) {
        super(flashCardID,userID,question,answer);
    }
}
