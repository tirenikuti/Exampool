package comp3350.exampool.tests.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.persistence.FlashcardPersistence;

public class AccessFlashcardsTest {
    private AccessFlashcards accessFlashcards;
    private FlashcardPersistence flashcardPersistence;

    @Before
    public void setUp(){
        flashcardPersistence = mock(FlashcardPersistence.class);
        accessFlashcards = new AccessFlashcards(flashcardPersistence);
    }

    @Test
    public void test(){
        final Flashcard flashcard;

        System.out.println("\nStarting test AccessCourses");
        final List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new TypedAnswerQuestion("2","100","How are you?","Well"));
        when(flashcardPersistence.getFlashcardsSequential()).thenReturn(flashcards);

        flashcard = accessFlashcards.getSequential();
        assertNotNull("first sequential course should not be null", flashcard);
        assertTrue("2".equals(flashcard.getFlashcardID()));

        verify(flashcardPersistence).getFlashcardsSequential();

        System.out.println("Finished test AccessNotes");
    }
}
