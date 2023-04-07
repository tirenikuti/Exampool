package comp3350.exampool.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.exampool.application.Services;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.persistence.NotesPersistence;

public class AccessNotes
{
    private NotesPersistence notesPersistence;
    private List<Notes> notes;
    private Notes note;
    private int currentNote;

    public AccessNotes()
    {
        notesPersistence = Services.getNotesPersistence();
        notes = null;
        note = null;
        currentNote = 0;
    }

    public List<Notes> getNotes()
    {
        notes = notesPersistence.getNotesSequential();
        return Collections.unmodifiableList(notes);
    }

    public List<String> getNoteIDs() {
        notes = notesPersistence.getNotesSequential();
        ArrayList<String> ids = new ArrayList<>();
        for(Notes n:notes){
            ids.add(n.getNoteID());
        }
        return Collections.unmodifiableList(ids);
    }

    public Notes getSequential()
    {
        String result = null;
        if (notes == null)
        {
            notes = notesPersistence.getNotesSequential();
            currentNote = 0;
        }
        if (currentNote < notes.size())
        {
            note = (Notes) notes.get(currentNote);
            currentNote++;
        }
        else
        {
            notes = null;
            note = null;
            currentNote = 0;
        }
        return note;
    }

    public Notes getNote(String notesID)
    {
        notes = notesPersistence.getNotesRandom(new Notes(notesID));
        currentNote = 0;
        if(currentNote < notes.size())
        {
            note = notes.get(currentNote);
            currentNote++;
        }
        else
        {
            notes = null;
            note = null;
            currentNote = 0;
        }
        return note;
    }

    public Notes insertNote(Notes currentNote)
    {
        return notesPersistence.insertNotes(currentNote);
    }

    public Notes updateNote(Notes currentNote)
    {
        return  notesPersistence.updateNotes(currentNote);
    }

    public void deleteNote(Notes currentNote)
    {
        notesPersistence.deleteNotes(currentNote);
    }
}

