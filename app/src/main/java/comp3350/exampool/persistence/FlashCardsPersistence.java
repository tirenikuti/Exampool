package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;

public interface FlashCardsPersistence {
    List<Flashcard> getFlashCardsSequential();

    List<Flashcard> getFlashCard(Flashcard currentFlashcard); 

    Flashcard insertFlashcard(Flashcard currentFlashcard);

    Flashcard updateFlashcard(Flashcard currentFlashcard);

    void deleteFlashcard(Flashcard currentFlashcard);
}
