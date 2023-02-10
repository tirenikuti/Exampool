public class Question {   //Super class for all the remaining question types
    //the Question's tag, like the actual question
    private String questTag;

    //The answer to the question
    private String Answer;

    //Constructor
    public Question(String questTag, String answer) {
        assert (questTag!= null);
        assert (answer != null);
        this.questTag = questTag;
        this.Answer = answer;
    }

    //default Constructor
    public Question (String questTag){
        assert (questTag!= null);
        this.questTag = questTag;
    }

    //Getters and Setters
    public String getQuestTag() {
        return questTag;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setQuestTag(String questTag) {
        this.questTag = questTag;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    //toString method. Same used in Long Answer Questions class (LAQ) and Short Answer Question class (SAQ)
    @Override
    public String toString() {
        return "Question: " + questTag;
    }
}
