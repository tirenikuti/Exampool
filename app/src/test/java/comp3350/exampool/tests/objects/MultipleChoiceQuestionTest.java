package comp3350.exampool.tests.objects;

import org.junit.Test;

import comp3350.exampool.objects.MultipleChoiceQuestion;

import static org.junit.Assert.*;

public class MultipleChoiceQuestionTest
{
    @Test
    public void CreateMCQTest(){
        System.out.println("\nStarting Create MCQ Flashcards Test");

        MultipleChoiceQuestion flashcard = new MultipleChoiceQuestion("2", "100", "What is love?", "Baby don't love me", "Ow", "Oof", "Wow");
        assertNotNull(flashcard);
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("What is love?".equals(flashcard.getQuestion()));
        assertTrue("Baby don't love me".equals(flashcard.getAnswer()));
        assertTrue("Ow".equals(flashcard.getOption1()));
        assertTrue("Oof".equals(flashcard.getOption2()));
        assertTrue("Wow".equals(flashcard.getOption3()));

        System.out.println("Finished Create MCQ Flashcards Test");
    }

    @Test
    public void getEditMCQ(){
        MultipleChoiceQuestion flashcard = new MultipleChoiceQuestion("2", "100", "What is love?", "Baby don't love me", "Ow", "Oof", "Wow");
        System.out.println("\nStarting Editing MCQ Flashcards Test");

        flashcard.editFlashcard("Hey?", "Hello", "Hi", "Sup", "Noo");
        assertTrue("2".equals(flashcard.getFlashcardID()));
        assertTrue("100".equals(flashcard.getUserID()));
        assertTrue("Hey?".equals(flashcard.getQuestion()));
        assertTrue("Hello".equals(flashcard.getAnswer()));
        assertTrue("Hi".equals(flashcard.getOption1()));
        assertTrue("Sup".equals(flashcard.getOption2()));
        assertTrue("Noo".equals(flashcard.getOption3()));

        System.out.println("\nFinished Editing MCQ Flashcards Test");
    }
}
