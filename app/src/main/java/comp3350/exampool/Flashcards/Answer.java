//Answer Helper class for the Multiple Choice questions
public class Answer {
    //the option tag (A/B/C/D)
    private char tag;
    //the option list
    private String option;

    //Constructor
    public Answer(char tag, String option) {
        this.tag = tag;

        assert(option != null);
        this.option = option;
    }

    //Getters/Setters
    public String getOption() {
        return option;
    }

    public Character getTag() {
        return tag;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setTag(char tag) {
        this.tag = tag;
    }

    //toString method
    @Override
    public String toString() {
        return tag + ". " + option;
    }
}
