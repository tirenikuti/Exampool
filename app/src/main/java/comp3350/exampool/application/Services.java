package comp3350.exampool.application;

import comp3350.exampool.persistence.NotesPersistence;
import comp3350.exampool.persistence.UserPersistence;
import comp3350.exampool.persistence.FlashcardsPersistence;
import comp3350.exampool.persistence.hsqldb.NotesPersistenceHSQLDB;
import comp3350.exampool.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.exampool.persistence.hsqldb.FlashCardPersitenceHSQLDB;

public class Services
{
	private static FlashcardsPersistence flashcardPersistence = null;
	private static UserPersistence userPersistence = null;
	private static NotesPersistence notesPersistence = null;

	public static synchronized UserPersistence getUserPersistence()
    {
		if (userPersistence == null)
		{
            userPersistence = new UserPersistenceHSQLDB(Main.getDBPathName());
        }

        return userPersistence;
	}

    public static synchronized FlashcardsPersistence getFlashcardPersistence()
    {
        if (flashcardPersistence == null)
        {
            flashcardPersistence = new FlashCardPersitenceHSQLDB(Main.getDBPathName());
        }

        return flashcardPersistence;
    }

	public static synchronized NotesPersistence getNotesPersistence() {
        if (notesPersistence == null) {
            notesPersistence = new NotesPersistenceHSQLDB(Main.getDBPathName());
        }

        return notesPersistence;
    }
}

