package comp3350.exampool.business;

import java.util.Collections;
import java.util.List;

import comp3350.exampool.application.Services;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.User; //--to do Krupali
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

    public Flashcard getFlashcardRandom(String flashcardID)
    {
        flashcards = flashcardPersistence.getFlashcardRandom(new Flashcard(flashcardID));
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

    public Flashcard insertFlashcard(Flashcard currentFlashcard)
    {
        return flashcardPersistence.insertFlashcard(currentFlashcard);
    }

    public void deleteFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteFlashcard(currentFlashcard);
    }
}
