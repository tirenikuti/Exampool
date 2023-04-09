package comp3350.exampool.tests.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.exampool.objects.TrueFalseQuestion;

public class TrueFalseQuestionTest {
    @Test
    public void CreateMCQTest(){
        System.out.println("\nStarting Create TFQ Flashcards Test");

        TrueFalseQuestion flashcard = new TrueFalseQuestion("2", "100", "What is love?", "False");
        assertNotNull(flashcard);
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("What is love?".equals(flashcard.getQuestion()));
        assertTrue("False".equals(flashcard.getAnswer()));

        System.out.println("Finished Create TFQ Flashcards Test");
    }

    @Test
    public void getEditMCQ(){
        TrueFalseQuestion flashcard = new TrueFalseQuestion("2", "100", "What is love?", "False");
        System.out.println("\nStarting Editing TFQ Flashcards Test");

        flashcard.editFlashcard("Hey?", "Hello", "Hi", "Sup", "Noo");
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("Hey?".equals(flashcard.getQuestion()));
        assertTrue("Hello".equals(flashcard.getAnswer()));

        System.out.println("\nFinished Editing TFQ Flashcards Test");
    }
}
