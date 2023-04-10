package comp3350.exampool;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.exampool.presentation.FlashcardsQuizActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class QuizTest {
    @Rule
    public ActivityScenarioRule<FlashcardsQuizActivity> activityRule = new ActivityScenarioRule<>(FlashcardsQuizActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("comp3350.exampool", appContext.getPackageName());
    }

    @Test
    public void AnswerQuizCorrect() {

    }
    @Test
    public void AnswerQuizIncorrect() {

    }

}
