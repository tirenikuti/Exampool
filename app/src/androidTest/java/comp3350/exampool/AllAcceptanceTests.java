package comp3350.exampool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


public class AllAcceptanceTests {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            NotesTest.class,QuizTest.class, FlashCardTest.class

    })

    public class AllUnitTests {

    }

}
