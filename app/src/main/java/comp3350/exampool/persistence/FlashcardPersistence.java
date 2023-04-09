package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.objects.User;

public interface FlashcardPersistence {
    List<Flashcard> getFlashcardsSequential();

    List<Flashcard> getMCQFlashcardsSequential();

    List<Flashcard> getTFQFlashcardsSequential();

    List<Flashcard> getTypedFlashcardsSequential();

    List<Flashcard> getFlashcard(String currentFlashcardID);

    List<Flashcard> getFlashcardOfUser(User currentUser);

    Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard);

    Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard);

    Flashcard insertTypedFlashcard(TypedAnswerQuestion currentFlashcard);

    void deleteMCQFlashcard(Flashcard currentFlashcard);

    void deleteTFQFlashcard(Flashcard currentFlashcard);

    void deleteTypedFlashcard(Flashcard currentFlashcard);

    Flashcard updateMCQFlashcard(MultipleChoiceQuestion currentFlashcard);

    Flashcard updateTFQFlashcard(TrueFalseQuestion currentFlashcard);

    Flashcard updateTypedFlashcard(TypedAnswerQuestion currentFlashcard);
}
