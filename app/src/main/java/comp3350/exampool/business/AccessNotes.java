//used to access the notes from the database - using services to get the persistence.
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

    /**
     * Constructor for the class
     * Initiates getting the persistence
     */
    public AccessNotes()
    {
        notesPersistence = Services.getNotesPersistence();
        notes = null;
        note = null;
        currentNote = 0;
    }

    /**
     * constructor for testing
     * @param notesPersistence - the persistence
     */
    public AccessNotes(final NotesPersistence notesPersistence){
        this();
        this.notesPersistence = notesPersistence;
    }

    /**
     * Gets a list of all the notes from the persistence
     * @return the list of all notes
     */
    public List<Notes> getNotes()
    {
        notes = notesPersistence.getNotesSequential();
        return Collections.unmodifiableList(notes);
    }

    /**
     * Gets the first note in the sequence of notes in the database
     * @return the first note
     */
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

    /**
     * Gets a note from the database based on the notes ID
     * @param notesID Id of the note to be returned
     * @return note with id notesID
     */
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

    /**
     * Method to insert a note into the persistence layer
     * @param currentNote note to be inserted
     * @return The note if inserted successfully
     */
    public Notes insertNote(Notes currentNote)
    {
        return notesPersistence.insertNotes(currentNote);
    }

    /**
     * Method to update the note in the persistence layer
     * @param currentNote note to be updated
     * @return the note if it is updated successfully
     */
    public Notes updateNote(Notes currentNote)
    {
        return  notesPersistence.updateNotes(currentNote);
    }

    /**
     * Method to delete the note in the persistence layer
     * @param currentNote note to be deleted
     */
    public void deleteNote(Notes currentNote)
    {
        notesPersistence.deleteNotes(currentNote);
    }
}

