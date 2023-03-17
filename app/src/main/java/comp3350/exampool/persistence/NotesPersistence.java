package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.User;

public interface NotesPersistence {
    List<Notes> getNotesSequential();

    List<Notes> getNotesRandom(Notes currentNotes);

    List<Notes> getNotes(Notes currentFlashcard); 

    List<Notes> getNotesUsers(User currentUser);

    Notes insertNotes(Notes currentNotes);

    Notes updateNotes(Notes currentNotes);

    void deleteNotes(Notes currentFlashcard);
}
