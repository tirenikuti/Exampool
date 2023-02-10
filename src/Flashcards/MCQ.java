import java.util.ArrayList;
import java.util.Random;

public class MCQ extends Question{
    //the correct answer
        private final Answer correct;

        //an arrayList of possible options
        private final ArrayList<Answer> answers = new ArrayList<>();

        //counter
        private int i =1;

        //an arraylist of option tags (A, B, C, D)
        private final ArrayList<Character> tags = new ArrayList<>();

        //an array used to store ***************
        private final Answer [] tempArr = new Answer [4];

        //Constructor
    //This constructor takes the question tag and the correct answer
    //the user will supply their own possible (wrong options)
        public MCQ(String quesTag, String corrAns) {

            //calls super's default constructor
            super(quesTag);

            //the tags for the options are created and added to the arraylist for tags
            tags.add('A');
            tags.add('B');
            tags.add('C');
            tags.add('D');

            //sets the correct answer and assigns it a random tag (so that users don't know what option it will be)
            correct = new Answer(setRandTag(tags), corrAns);

            //makes the first element in our temporary array the correct answer
            tempArr[0] = correct;
        }

        //Getters and Setter (Never used)
    /*
        public ArrayList<Answer> getAnswers() {
            return answers;
        }

        public char getCorrectTag() {
            return correct.getTag();
        }

        public void setCorrect(String correctA) {
            correct = new Answer(' ', correctA);
            for (int j = 0; j < answers.size(); j++) {
                if((answers.get(j).getOption()).equals(correct.getOption())){
                    correct.setTag(answers.get(j).getTag());
                    break;
                }
            }
        }

     */

    //returns the correct answer and its randomly assigned tag
    public String getCorrect() {
        return correct.getTag() + "." + correct.getOption();
    }

    //adds answers to the answers array list
        public void addAnswers(String ans1) {
            Answer newAns = new Answer(setRandTag(tags), ans1);
            tempArr[i] = newAns;
            i++;
            if(i == tempArr.length) {
                sortAnswers(tempArr);
            }
        }

        //Sorts the randomly assigned answer tags from A to D
        private void sortAnswers(Answer[] tempVal){
            for (Answer answer : tempVal) {
                if (answer.getTag().equals('A')) {
                    answers.add(answer);
                    break;
                }
            }
            for (Answer answer : tempVal) {
                if (answer.getTag().equals('B')) {
                    answers.add(answer);
                    break;
                }
            }
            for (Answer answer : tempVal) {
                if (answer.getTag().equals('C')) {
                    answers.add(answer);
                    break;
                }
            }
            for (Answer answer : tempVal) {
                if (answer.getTag().equals('D')) {
                    answers.add(answer);
                    break;
                }
            }
            setCorrAns(correct);
        }

        //sets the correct answer to the assigned tag
        private void setCorrAns(Answer corr){
            for (Answer answer : answers) {
                if ((answer.getOption()).equals(corr.getOption())) {
                    corr.setTag(answer.getTag());
                    break;
                }
            }
        }

//sets random tags to answers as they enter the array
        private char setRandTag(ArrayList<Character>possTags){
            int n = possTags.size();
            int rnd = new Random().nextInt(n);
            char retString = possTags.get(rnd);
            possTags.remove(rnd);
            return retString;
        }

        //toString() method

            @Override
      public String toString() {
             String retString = "";
                for (Answer answer : answers) {
                    retString += ("\n" + answer);
                }
             return super.getQuestTag() + retString;
         }

}
