package comp3350.exampool.objects;

//True or False questions
public class TrueFalseQuestion extends Question{

    //array list of the two option (True/False)
    private final String[] options = new String [2];

    //Constructor
    public TrueFalseQuestion(String quesTag, String corrAns){
        super(quesTag);

        //Adding the options to the arraylist
        options[0] = "TRUE";
        options[1] = "FALSE";

        assert(corrAns != null);
        //find a set correct answer
        if(corrAns.equalsIgnoreCase("true")){
            super.setAnswer(options[0]);
        }
        else if(corrAns.equalsIgnoreCase("false")) {
            super.setAnswer(options[1]);
        }
    }


    //toString() method
    @Override
    public String toString() {
        String retString = options[0] + "\t" +options[1] ;
        return super.toString() + "\n\t" + retString;
    }
}
