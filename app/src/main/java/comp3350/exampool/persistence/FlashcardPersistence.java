// interface for persistence layer to access the Database
package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.objects.User;

public interface FlashcardPersistence {
    /**
     * Gets all the flashcards in the database
     * @return list of flashcards
     */
    List<Flashcard> getFlashcardsSequential();

    /**
     * Gets all the multiple choice questions in the database
     * @return list of all multiple choice questions
     */
    List<Flashcard> getMCQFlashcardsSequential();

    /**
     * Gets all the true or false questions in the database
     * @return list of all true and false questions
     */
    List<Flashcard> getTFQFlashcardsSequential();

    /**
     * Gets all the typed questions in the database
     * @return list of all typed questions
     */
    List<Flashcard> getTypedFlashcardsSequential();

    /**
     * Gets a specific flashcard from the database
     * @param currentFlashcardID flashcard needed from DB
     * @return flashcard if it exists
     */
    List<Flashcard> getFlashcard(String currentFlashcardID);

    /**
     * Gets a list of all flashcards of a specific user
     * @param currentUser user whose flashcards are being accessed
     * @return list of flashcards
     */
    List<Flashcard> getFlashcardOfUser(User currentUser);

    /**
     * Method to insert a new MCQ flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard);

    /**
     * Method to insert a new TFQ flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard);

    /**
     * Method to insert a new Typed Answer flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    Flashcard insertTypedFlashcard(TypedAnswerQuestion currentFlashcard);

    /**
     * Method to delete a MCQ flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    void deleteMCQFlashcard(Flashcard currentFlashcard);

    /**
     * Method to delete a TFQ flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    void deleteTFQFlashcard(Flashcard currentFlashcard);

    /**
     * Method to delete a Typed Answer flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    void deleteTypedFlashcard(Flashcard currentFlashcard);

    /**
     * Method to update a MCQ flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    Flashcard updateMCQFlashcard(MultipleChoiceQuestion currentFlashcard);

    /**
     * Method to update a TFQ flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    Flashcard updateTFQFlashcard(TrueFalseQuestion currentFlashcard);

    /**
     * Method to update a Typed flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    Flashcard updateTypedFlashcard(TypedAnswerQuestion currentFlashcard);
}
