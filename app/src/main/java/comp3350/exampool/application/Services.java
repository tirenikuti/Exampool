//create initiate persistence variables and get Database path name set into the persistence variables to be used to access files.
package comp3350.exampool.application;

import comp3350.exampool.persistence.NotesPersistence;
import comp3350.exampool.persistence.UserPersistence;
import comp3350.exampool.persistence.FlashcardPersistence;
import comp3350.exampool.persistence.hsqldb.NotesPersistenceHSQLDB;
import comp3350.exampool.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.exampool.persistence.hsqldb.FlashcardPersistenceHSQLDB;

public class Services
{
    private static String dbName = "DB";
	private static FlashcardPersistence flashcardPersistence = null;
	private static UserPersistence userPersistence = null;
	private static NotesPersistence notesPersistence = null;

    /**
     * Method to initiate user persistence
     * @return User persistence that's initiated
     */
	public static synchronized UserPersistence getUserPersistence()
    {
		if (userPersistence == null)
		{
            userPersistence = new UserPersistenceHSQLDB(getDBPathName());
        }

        return userPersistence;
	}

    /**
     * Method to initiate flashcard persistence
     * @return Flashcard persistence that's initiated
     */
    public static synchronized FlashcardPersistence getFlashcardPersistence()
    {
        if (flashcardPersistence == null)
        {
            flashcardPersistence = new FlashcardPersistenceHSQLDB(getDBPathName());
        }

        return flashcardPersistence;
    }

    /**
     * Method to initiate notes persistence
     * @return Notes persistence that's initiated
     */
	public static synchronized NotesPersistence getNotesPersistence() {
        if (notesPersistence == null) {
            notesPersistence = new NotesPersistenceHSQLDB(getDBPathName());
        }

        return notesPersistence;
    }

    /**
     * Setting up Database
     * @param name database path name
     */
    public static void setDBPathName(final String name)
    {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    /**
     * Getter
     * @return path name
     */
    public static String getDBPathName() {
        return dbName;
    }
}

