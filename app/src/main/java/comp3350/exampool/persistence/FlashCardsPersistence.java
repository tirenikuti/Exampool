package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;

public interface FlashCardsPersistence {

    List<Flashcard> getFlashCards(final int userID);

}
