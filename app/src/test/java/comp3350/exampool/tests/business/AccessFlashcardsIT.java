package comp3350.exampool.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.persistence.FlashcardPersistence;
import comp3350.exampool.persistence.hsqldb.FlashcardPersistenceHSQLDB;
import comp3350.exampool.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessFlashcardsIT {
    private AccessFlashcards accessFlashcards;

    private File tempDB;

    @Before
    public void setUP() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final FlashcardPersistence persistence = new FlashcardPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessFlashcards = new AccessFlashcards(persistence);
    }

    @Test
    public void testListFlashcards(){
        final Flashcard flashcard;

        flashcard = accessFlashcards.getSequential();
        assertNotNull("First sequential flashcard should not be null", flashcard);
        assertTrue("3".equals(flashcard.getFlashcardID()));

        System.out.println("Finished test AccessFlashcards");
    }

    @Test
    public void testGetFlashcards(){
        final List<Flashcard> flashcards = accessFlashcards.getFlashcards();
        assertEquals(15, flashcards.size());
    }

    @Test
    public void testDeleteMCQFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstMCQFlashcard();
        List<Flashcard> flashcards = accessFlashcards.getFlashcards();
        assertEquals(15, flashcards.size());
        accessFlashcards.deleteMCQFlashcard(flashcard);
        flashcards = accessFlashcards.getFlashcards();
        assertEquals(14, flashcards.size());
    }

    @Test
    public void testDeleteTFQFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstTFQFlashcard();
        List<Flashcard> flashcards = accessFlashcards.getFlashcards();
        assertEquals(15, flashcards.size());
        accessFlashcards.deleteTFQFlashcard(flashcard);
        flashcards = accessFlashcards.getFlashcards();
        assertEquals(14, flashcards.size());
    }

    @Test
    public void testDeleteTypedFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstTypedFlashcard();
        List<Flashcard> flashcards = accessFlashcards.getFlashcards();
        assertEquals(15, flashcards.size());
        accessFlashcards.deleteTypedFlashcard(flashcard);
        flashcards = accessFlashcards.getFlashcards();
        assertEquals(14, flashcards.size());
    }

    @Test
    public void testInsertMCQFlashcards(){
        final MultipleChoiceQuestion flashcard = new MultipleChoiceQuestion("16", "100", "What does the fox say?", "Squeek", "Moo", "Meow", "Nothing");
        accessFlashcards.insertMultipleChoiceFlashcard(flashcard);
        assertEquals(16, accessFlashcards.getFlashcards().size());
    }

    @Test
    public void testInsertTFQFlashcards(){
        final TrueFalseQuestion flashcard = new TrueFalseQuestion("16", "100", "What does the fox say?", "False");
        accessFlashcards.insertTrueFalseFlashcard(flashcard);
        assertEquals(16, accessFlashcards.getFlashcards().size());
    }

    @Test
    public void testInsertTypedFlashcards(){
        final TypedAnswerQuestion flashcard = new TypedAnswerQuestion("16", "100", "What does the fox say?", "Nothing");
        accessFlashcards.insertTypedAnswerFlashcard(flashcard);
        assertEquals(16, accessFlashcards.getFlashcards().size());
    }

    @Test
    public void testUpdateMCQFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstMCQFlashcard();
        final MultipleChoiceQuestion updateFlashcard = new MultipleChoiceQuestion(flashcard.getFlashcardID(), flashcard.getUserID(), "What does the fox say?", "Squeek", "Moo", "Meow", "Nothing");
        accessFlashcards.updateMultipleChoiceFlashcard(updateFlashcard);
        assertEquals(15, accessFlashcards.getFlashcards().size());
    }

    @Test
    public void testUpdateTFQFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstTFQFlashcard();
        final TrueFalseQuestion updateFlashcard = new TrueFalseQuestion(flashcard.getFlashcardID(), flashcard.getUserID(), "What does the fox say?", "False");
        accessFlashcards.updateTrueFalseFlashcard(updateFlashcard);
        assertEquals(15, accessFlashcards.getFlashcards().size());
    }

    @Test
    public void testUpdateTypedFlashcards(){
        final Flashcard flashcard = accessFlashcards.getFirstMCQFlashcard();
        final TypedAnswerQuestion updateFlashcard = new TypedAnswerQuestion(flashcard.getFlashcardID(), flashcard.getUserID(), "What does the fox say?", "Squeek");
        accessFlashcards.updateTypedAnswerFlashcard(updateFlashcard);
        assertEquals(15, accessFlashcards.getFlashcards().size());
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
