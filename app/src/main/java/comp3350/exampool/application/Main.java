package comp3350.exampool.application;
//import java.util.Scanner;

//Obj Imports
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class Main {
    public static void main(String[] args) {

        MultipleChoiceQuestion newQuest2 = new MultipleChoiceQuestion("What year was Tireni Kuti born?", "2000");
        newQuest2.addAnswers("2001");
        newQuest2.addAnswers("2002");
        newQuest2.addAnswers("1999");

      //  Flashcard newCard = new Flashcard();
        Flashcard newCard2 = new Flashcard();
       // Flashcard newCard3 = new Flashcard();

        newCard2.setFront(newQuest2);
        newCard2.setBack(newQuest2.getAnswer());
        newCard2.displayFlashcard();
    }
}
