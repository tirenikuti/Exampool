package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.Notes;

public interface NotesPersistence {
    List<Notes> getNotesSequential();

    List<Notes> getNotes(Notes currentFlashcard); 

    List<Notes> getNotesUsers(User currentUser); 

    void deleteNotes(Notes currentFlashcard);
}