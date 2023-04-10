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

    /**
     * Constructor for the class - initiates the persistence and the lists to access flashcards
     */
    public AccessFlashcards()
    {
        flashcardPersistence = Services.getFlashcardPersistence();
        flashcards = null;
        flashcard = null;
        currentFlashcard = 0;
    }

    /**
     * constructor for testing
     * @param flashcardPersistence - the persistence
     */
    public AccessFlashcards(final FlashcardPersistence flashcardPersistence) {
        this();
        this.flashcardPersistence = flashcardPersistence;
    }

    /**
     * Method to get flashcards from the persistence layer
     * @return list of all flashcards
     */
    public List<Flashcard> getFlashcards()
    {
        flashcards = flashcardPersistence.getFlashcardsSequential();
        return Collections.unmodifiableList(flashcards);
    }

    /**
     * get the first flashcard in the sequence of flashcards generated
     * @return flashcard
     */
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

    /**
     * Method to get a specific flashcard using its flashcard ID from the persistence
     * @param flashcardID the id of the flashcard that is being searched for in persistence
     * @return flashcard if found
     */
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

    /**
     * Method to insert a multiple choice question into the persistence
     * @param currentFlashcard flashcard to be inserted
     * @return the flashcard being returned if it is inserted successfully
     */
    public Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard)
    {
        return flashcardPersistence.insertMultipleChoiceFlashcard(currentFlashcard);
    }

    /**
     * Method to insert a true or false question into the persistence
     * @param currentFlashcard flashcard to be inserted
     * @return the flashcard being returned if it is inserted successfully
     */
    public Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard)
    {
        return flashcardPersistence.insertTrueFalseFlashcard(currentFlashcard);
    }

    /**
     * Method to insert a multiple choice question into the persistence
     * @param currentFlashcard flashcard to be inserted
     * @return the flashcard being returned if it is inserted successfully
     */
    public Flashcard insertTypedAnswerFlashcard(TypedAnswerQuestion currentFlashcard)
    {
        return flashcardPersistence.insertTypedFlashcard(currentFlashcard);
    }

    /**
     * Method to update a multiple choice flashcards in the persistence
     * @param currentFlashcard flashcard to be updated
     * @return Flashcard if updated successfully
     */
    public Flashcard updateMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard){
        return flashcardPersistence.updateMCQFlashcard(currentFlashcard);
    }

    /**
     * Method to update a true or false flashcards in the persistence
     * @param currentFlashcard flashcard to be updated
     * @return Flashcard if updated successfully
     */
    public Flashcard updateTrueFalseFlashcard(TrueFalseQuestion currentFlashcard){
        return flashcardPersistence.updateTFQFlashcard(currentFlashcard);
    }

    /**
     * Method to update a typed answer flashcard in the persistence
     * @param currentFlashcard flashcard to be updated
     * @return Flashcard if updated successfully
     */
    public Flashcard updateTypedAnswerFlashcard(TypedAnswerQuestion currentFlashcard){
        return flashcardPersistence.updateTypedFlashcard(currentFlashcard);
    }

    /**
     * Method to delete multiple choice flashcard from the persistence
     * @param currentFlashcard flashcard to be deleted
     */
    public void deleteMCQFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteMCQFlashcard(currentFlashcard);
    }

    /**
     * Method to delete true or false flashcard from the persistence
     * @param currentFlashcard flashcard to be deleted
     */
    public void deleteTFQFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteTFQFlashcard(currentFlashcard);
    }

    /**
     * Method to delete typed answer flashcard from the persistence
     * @param currentFlashcard flashcard to be deleted
     */
    public void deleteTypedFlashcard(Flashcard currentFlashcard)
    {
        flashcardPersistence.deleteTypedFlashcard(currentFlashcard);
    }

    /**
     * Method to get the first Multiple choice question in the database
     * @return the flashcard with the first MCQ
     */
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

    /**
     * Method to get the first True or false question in the database
     * @return the flashcard with the first TFQ
     */
    public Flashcard getFirstTFQFlashcard() {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getTFQFlashcardsSequential();
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

    /**
     * Method to get the first Typed ansert question in the database
     * @return the flashcard with the first Typed Answer Question
     */
    public Flashcard getFirstTypedFlashcard() {
        String result = null;
        if (flashcards == null)
        {
            flashcards = flashcardPersistence.getTypedFlashcardsSequential();
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
