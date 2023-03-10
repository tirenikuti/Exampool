package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;

public interface FlashcardsPersistence {
    List<Flashcard> getFlashcardsSequential();

    List<Flashcard> getFlashcard(Flashcard currentFlashcard); 

    List<Flashcard> getFlashcardUsers(User currentUser); 

    void deleteFlashcard(Flashcard currentFlashcard);
}
