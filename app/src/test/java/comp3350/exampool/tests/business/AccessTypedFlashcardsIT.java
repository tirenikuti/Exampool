package comp3350.exampool.tests.business;

import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.persistence.FlashcardPersistence;
import comp3350.exampool.persistence.hsqldb.FlashcardPersistenceHSQLDB;
import comp3350.exampool.tests.utils.TestUtils;

public class AccessTypedFlashcardsIT {
    private AccessFlashcards accessFlashcards;

    private File tempDB;

    @Before
    public void setUP() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final FlashcardPersistence persistence = new FlashcardPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessFlashcards = new AccessFlashcards(persistence);
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
