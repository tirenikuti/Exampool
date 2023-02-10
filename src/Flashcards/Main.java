//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        SAQ newQuest = new SAQ("Tireni Kuti was born in 2000", 5);
        MCQ newQuest2 = new MCQ("What year was Tireni Kuti born?", "2000");
    //    TFQ newQuest3 = new TFQ("Tireni Kuti was born in 2002", "false");;
        newQuest2.addAnswers("2001");
        newQuest2.addAnswers("2002");
        newQuest2.addAnswers("1999");

        Flashcard newCard = new Flashcard();
        Flashcard newCard2 = new Flashcard();
        Flashcard newCard3 = new Flashcard();
//        newCard.setFront(newQuest);
//        newCard.setBack(newQuest.getAnswer());
//        newCard.displayFlashcard();

        newCard2.setFront(newQuest2);
        newCard2.setBack(newQuest2.getCorrect());
        newCard2.displayFlashcard();

//        newCard3.setFront(newQuest3);
//        newCard3.setBack(newQuest3.getAnswer());
//        newCard3.displayFlashcard();

//        System.out.println("Is this a typing or multiple choice question?");
//        String response1 = question.nextLine();
//        if (response1.equals("typing")) {
//            System.out.println("Is this a Short Answer or Long Answer question?");
//            String response2 = question.nextLine();
//            if (response2.equals("sa")) {
//                System.out.println("Input your Question: ");
//                String responseM = question.nextLine();
//                System.out.println("Input the position of thw word you want to eliminate from the above question: ");
//                int responseN = question.nextInt();
//                SAQ newQuest = new SAQ(responseM, responseN);
//
//                System.out.println(newQuest);
//            } else if (response2.equals("la")) {
//                System.out.println("Input your Question: ");
//                String responseM = question.nextLine();
//                System.out.println("Input the Answer to the above question: ");
//                String responseN = question.nextLine();
//                Question newQuest = new LAQ(responseM, responseN);
//                System.out.println(newQuest);
//            }

//        } else if (response1.equals("mc")) {
//            System.out.println("Great you've selected multiple choice");
//            System.out.println("First, Input your Question: ");
//            String responseM = question.nextLine();
//            System.out.println("Input the correct answer to the above question: ");
//            String responseN = question.nextLine();
//            System.out.println("Now select 3 other possible wrong answers ");
//            MCQ newQuest = new MCQ(responseM, responseN);
//            for (int i = 0; i < 3; i++) {
//                String response4 = question.nextLine();
//                newQuest.addAnswers(response4);
//            }
//            System.out.println(newQuest);
//        }
            // Flashcard newFlash = new Flashcard(false);
        }
   // }

}