package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.User;

public interface NotesPersistence {
    /**
     * Gets all the notes in the database
     * @return list of notes
     */
    List<Notes> getNotesSequential();

    /**
     * Gets a specific note from the database
     * @param currentNote note needed from DB
     * @return note if it exists
     */
    List<Notes> getNotesRandom(Notes currentNote);

    /**
     * Gets a list of all notes of a specific user
     * @param currentUser user whose notes are being accessed
     * @return list of notes
     */
    List<Notes> getNotesOfUser(User currentUser);

    /**
     * Method to insert a new note to the database
     * @param currentNotes note to be inserted
     * @return note if it is inserted successfully
     */
    Notes insertNotes(Notes currentNotes);

    /**
     * Method to update a note in the database
     * @param currentNotes note to be updated
     * @return note if it is updated successfully
     */
    Notes updateNotes(Notes currentNotes);

    /**
     * Method to delete note from the database
     * @param currentNotes note to be deleted
     */
    void deleteNotes(Notes currentNotes);
}
