//used to access the flashcards from the database - using services to get the persistence.
package comp3350.exampool.business;

import java.util.Collections;
import java.util.List;

import comp3350.exampool.application.Services;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.persistence.FlashcardPersistence;

public class AccessFlashcards {
    private FlashcardPersistence flashcardPersistence;
    private List<Flashcard> flashcards;
    private Flashcard flashcard;
    private int currentFlashcard;

    public AccessFlashcards()
    {
        flashcardPersistence = Services.getFlashcardPersistence();
        flashcards = null;
        flashcard = null;
        currentFlashcard = 0;
    }

    public AccessFlashcards(final FlashcardPersistence flashcardPersistence)
    {
        this();
        this.flashcardPersistence = flashcardPersistence;
    }

    public List<Flashcard> getFlashcards()
    {
        flashcards = flashcardPersistence.getFlashcardsSequential();
        return Collections.unmodifiableList(flashcards);
    }

    public Flashcard getSequential()
    {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getFlashcardsSequential();
            currentFlashcard = 0;
        }
        if (currentFlashcard < flashcards.size())
        {
            flashcard = (Flashcard) flashcards.get(currentFlashcard);
            currentFlashcard++;
        }
        else
        {
            flashcards = null;
            flashcard = null;
            currentFlashcard = 0;
        }
        return flashcard;
    }

    public Flashcard getFlashcard(String flashcardID)
    {
        flashcards = flashcardPersistence.getFlashcard(flashcardID);
        currentFlashcard = 0;
        if (currentFlashcard < flashcards.size())
        {
            flashcard = flashcards.get(currentFlashcard);
            currentFlashcard++;
        }
        else
        {
            flashcards = null;
            flashcard = null;
            currentFlashcard = 0;
        }
        return flashcard;
    }

    public Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard)
    {
        return flashcardPersistence.insertMultipleChoiceFlashcard(currentFlashcard);
    }

    public Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard)
    {
        return flashcardPersistence.insertTrueFalseFlashcard(currentFlashcard);
    }

    public Flashcard insertTypedAnswerFlashcard(TypedAnswerQuestion currentFlashcard)
    {
        return flashcardPersistence.insertTypedFlashcard(currentFlashcard);
    }

    public Flashcard updateMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard){
        return flashcardPersistence.updateMCQFlashcard(currentFlashcard);
    }

    public Flashcard updateTrueFalseFlashcard(TrueFalseQuestion currentFlashcard){
        return flashcardPersistence.updateTFQFlashcard(currentFlashcard);
    }

    public Flashcard updateTypedAnswerFlashcard(TypedAnswerQuestion currentFlashcard){
        return flashcardPersistence.updateTypedFlashcard(currentFlashcard);
    }

    public void deleteMCQFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteMCQFlashcard(currentFlashcard);
    }

    public void deleteTFQFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteTFQFlashcard(currentFlashcard);
    }

    public void deleteTypedFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteTypedFlashcard(currentFlashcard);
    }

    public Flashcard getFirstMCQFlashcard() {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getMCQFlashcardsSequential();
            currentFlashcard = 0;
        }
        if (currentFlashcard < flashcards.size())
        {
            flashcard = (Flashcard) flashcards.get(currentFlashcard);
            currentFlashcard++;
        }
        else
        {
            flashcards = null;
            flashcard = null;
            currentFlashcard = 0;
        }
        return flashcard;
    }
    public Flashcard getFirstTFQFlashcard() {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getMCQFlashcardsSequential();
            currentFlashcard = 0;
        }
        if (currentFlashcard < flashcards.size())
        {
            flashcard = (Flashcard) flashcards.get(currentFlashcard);
            currentFlashcard++;
        }
        else
        {
            flashcards = null;
            flashcard = null;
            currentFlashcard = 0;
        }
        return flashcard;
    }
    public Flashcard getFirstTypedFlashcard() {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getMCQFlashcardsSequential();
            currentFlashcard = 0;
        }
        if (currentFlashcard < flashcards.size())
        {
            flashcard = (Flashcard) flashcards.get(currentFlashcard);
            currentFlashcard++;
        }
        else
        {
            flashcards = null;
            flashcard = null;
            currentFlashcard = 0;
        }
        return flashcard;
    }
}
