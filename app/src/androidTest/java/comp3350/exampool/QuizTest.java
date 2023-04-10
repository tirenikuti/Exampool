package comp3350.exampool;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import comp3350.exampool.presentation.FlashcardsCreatePromptActivity;
import comp3350.exampool.presentation.FlashcardsQuizActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class QuizTest {
    @Rule
    public ActivityScenarioRule<FlashcardsQuizActivity> activityRule = new ActivityScenarioRule<>(FlashcardsQuizActivity.class);
    @Rule
    public ActivityScenarioRule<FlashcardsCreatePromptActivity> CreateFlashcardRule = new ActivityScenarioRule<>(FlashcardsCreatePromptActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("comp3350.exampool", appContext.getPackageName());
    }

    /**
     * Insert a MCQ flashcard
     * Start the quiz
     * Answer the question correctly
     * Check that the answer is recorded
     * Check the final score is correct (1)
     */
    @Test
    public void AnswerQuizCorrect() {
        useAppContext();
        //Insert MCQ flashcard
        ActivityScenario<FlashcardsCreatePromptActivity> scenario = CreateFlashcardRule.getScenario();
        onView(withId(R.id.buttonMultipleChoice)).perform(click()); //Click Create Note
        //Fill data
        onView(withId(R.id.createQuestion)).perform(typeText("Dummy Question?")); //Input Question
        onView(withId(R.id.createAnswer)).perform(typeText("This one!")); //Input Answer
        //Input Options
        onView(withId(R.id.createChoice1)).perform(typeText("Not me"));
        onView(withId(R.id.createChoice2)).perform(typeText("Still not me"));
        onView(withId(R.id.createChoice3)).perform(typeText("Can't be me"));
        onView(withId(R.id.buttonCreate)).perform(click()); //Click Create

        //Check if it was created
        System.out.println("Verifying the MCQ was added");
        onData(withText("Dummy Question?")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("Dummy Question? /n This one! /n Not me /n Still not me /n Can't be me")));

        pressBack();
        //Go to quiz
        onView(withId(R.id.buttonTypedDelete)).perform(click()); //Click Quiz
        //Answer correctly
        onView(withId(R.id.editInputAnswer)).perform(typeText("This one!"));
        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click()); //Click submit answer
        onView(withId(R.id.imageView3)).perform(click()); //Next
        //Check that it was scored correctly
        onView(withId(R.id.scoreTotal)).check(matches(withText("Score = 1")));

    }

    /**
     * Insert a MCQ flashcard
     * Start the quiz
     * Answer the question incorrectly
     * Check that the answer is recorded
     * Check the final score is correct (0)
     */
    @Test
    public void AnswerQuizIncorrect() {
        useAppContext();
        //Insert MCQ flashcard
        ActivityScenario<FlashcardsCreatePromptActivity> scenario = CreateFlashcardRule.getScenario();
        onView(withId(R.id.buttonMultipleChoice)).perform(click()); //Click Create Note
        //Fill data
        onView(withId(R.id.createQuestion)).perform(typeText("Dummy Question?")); //Input Question
        onView(withId(R.id.createAnswer)).perform(typeText("This one!")); //Input Answer
        //Input Options
        onView(withId(R.id.createChoice1)).perform(typeText("Not me"));
        onView(withId(R.id.createChoice2)).perform(typeText("Still not me"));
        onView(withId(R.id.createChoice3)).perform(typeText("Can't be me"));
        onView(withId(R.id.buttonCreate)).perform(click()); //Click Create

        //Check if it was created
        System.out.println("Verifying the MCQ was added");
        onData(withText("Dummy Question?")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("Dummy Question? /n This one! /n Not me /n Still not me /n Can't be me")));
        pressBack();
        //Go to quiz
        onView(withId(R.id.buttonTypedDelete)).perform(click()); //Click Quiz

        //Answer incorrectly
        onView(withId(R.id.editInputAnswer)).perform(typeText("Not this one!"));
        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click()); //Click submit answer
        onView(withId(R.id.imageView3)).perform(click()); //Next
        //Check that it was answered correctly
        onView(withId(R.id.scoreTotal)).check(matches(withText("Score = 0")));

    }

}
