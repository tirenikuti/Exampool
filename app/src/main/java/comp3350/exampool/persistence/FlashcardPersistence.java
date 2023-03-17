package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.User;

public interface FlashcardPersistence {
    List<Flashcard> getFlashcardsSequential();

    List<Flashcard> getFlashcardRandom(Flashcard currentFlashcard);

    List<Flashcard> getFlashcardUsers(User currentUser);

    Flashcard insertFlashcard(Flashcard currentFlashcard);

    void deleteFlashcard(Flashcard currentFlashcard);
}
