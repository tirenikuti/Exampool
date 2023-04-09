package comp3350.exampool.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.exampool.tests.objects.MultipleChoiceQuestionTest;
import comp3350.exampool.tests.objects.TrueFalseQuestionTest;
import comp3350.exampool.tests.objects.TypedAnswerQuestionTest;
import comp3350.exampool.tests.objects.NotesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NotesTest.class,
        MultipleChoiceQuestionTest.class,
        TrueFalseQuestionTest.class,
        TypedAnswerQuestionTest.class,
})

public class AllTests {


}
