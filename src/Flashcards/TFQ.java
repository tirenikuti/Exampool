import java.util.ArrayList;

//True or False questions
public class TFQ extends Question{

    //array list of the two option (True/False)
    private final ArrayList<String> options = new ArrayList<>();

    //COnstructor
    public TFQ(String quesTag, String corrAns){
        super(quesTag);

        //Adding the options to the arraylist
        options.add("TRUE");
        options.add("FALSE");

        //find a set correct answer
        if(corrAns.equalsIgnoreCase("true")){
            super.setAnswer(options.get(0));
        }
        else if(corrAns.equalsIgnoreCase("false")) {
            super.setAnswer(options.get(1));
        }
    }


    //toString() method
    @Override
    public String toString() {
        String retString = options.get(0) + "\t" +options.get(1) ;
        return super.toString() + "\n\t" + retString;
    }
}
