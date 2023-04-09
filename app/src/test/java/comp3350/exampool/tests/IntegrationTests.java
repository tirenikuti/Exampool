package comp3350.exampool.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.exampool.tests.business.AccessUsersIT;
import comp3350.exampool.tests.business.AccessFlashcardsIT;
import comp3350.exampool.tests.business.AccessNotesIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessFlashcardsIT.class,
        AccessUsersIT.class,
        AccessNotesIT.class
})
public class IntegrationTests {
}