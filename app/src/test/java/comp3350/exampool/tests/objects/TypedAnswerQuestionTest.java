package comp3350.exampool.tests.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.exampool.objects.TypedAnswerQuestion;

public class TypedAnswerQuestionTest {
    private TypedAnswerQuestion flashcard;
    @Test
    public void CreateMCQTest(){
        System.out.println("\nStarting Create Typed Flashcards Test");

        flashcard = new TypedAnswerQuestion("2", "100", "What is love?", "No");
        assertNotNull(flashcard);
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("What is love?".equals(flashcard.getQuestion()));
        assertTrue("No".equals(flashcard.getAnswer()));

        System.out.println("Finished Create Typed Flashcards Test");
    }

    @Test
    public void getEditMCQ(){
        System.out.println("\nStarting Editing Typed Flashcards Test");

        flashcard.editFlashcard("Hey?", "Hello", "Hi", "Sup", "Noo");
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("Hey?".equals(flashcard.getQuestion()));
        assertTrue("Hello".equals(flashcard.getAnswer()));

        System.out.println("\nFinished Editing Typed Flashcards Test");
    }
}
