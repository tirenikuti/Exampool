package comp3350.exampool.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.persistence.FlashcardPersistence;
import comp3350.exampool.persistence.hsqldb.FlashcardPersistenceHSQLDB;
import comp3350.exampool.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessMCQFlashcardsIT {
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
