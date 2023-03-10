package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;

public interface FlashCardsPersistence {
    List<Flashcard> getFlashcardsSequential();

    List<Flashcard> getFlashcard(Flashcard currentFlashcard); 

    List<Flashcard> getFlashcardUsers(User currentUser); 

    Flashcard insertFlashcard(Flashcard currentFlashcard);

    void deleteFlashcard(Flashcard currentFlashcard);
}
