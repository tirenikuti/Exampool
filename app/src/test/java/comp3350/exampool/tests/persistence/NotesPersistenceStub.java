package comp3350.exampool.tests.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.exampool.objects.Notes;
import comp3350.exampool.persistence.NotesPersistence;

public class NotesPersistenceStub {
    private List<Notes> notes;

    public NotesPersistenceStub(){
        this.notes = new ArrayList<>();

        notes.add(new Notes("2", "Short Story", "100", "Here is a short story"));
    }
}
