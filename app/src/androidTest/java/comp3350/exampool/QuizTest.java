package comp3350.exampool;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
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
    public void AnswerQuizCorrect() {

    }
    @Test
    public void AnswerQuizIncorrect() {

    }

}
