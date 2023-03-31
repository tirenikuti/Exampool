package comp3350.exampool.business;

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

    public AccessNotes(final NotesPersistence notesPersistence){
        this();
        this.notesPersistence = notesPersistence;
    }

    public List<Notes> getNotes()
    {
        notes = notesPersistence.getNotesSequential();
        return Collections.unmodifiableList(notes);
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

    public Notes getRandom(String notesID)
    {
        notes = notesPersistence.getNotes(notesID);
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

    public Notes insertNotes(Notes currentNote)
    {
        return notesPersistence.insertNotes(currentNote);
    }

    public Notes updateNotes(Notes currentNote)
    {
        return  notesPersistence.updateNotes(currentNote);
    }

    public void deleteNotes(Notes currentNote)
    {
        notesPersistence.deleteNotes(currentNote);
    }
}

