package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.User;

public interface NotesPersistence {
    List<Notes> getNotesSequential();

    List<Notes> getNotes(String currentNote);

    List<Notes> getNotesOfUser(User currentUser);

    Notes insertNotes(Notes currentNotes);

    Notes updateNotes(Notes currentNotes);

    void deleteNotes(Notes currentFlashcard);
}
