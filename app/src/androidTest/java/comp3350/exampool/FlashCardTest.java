package comp3350.exampool;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.exampool.presentation.FlashcardsActivity;
import comp3350.exampool.presentation.FlashcardsCreatePromptActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class FlashCardTest {
    @Rule
    public ActivityScenarioRule<FlashcardsCreatePromptActivity> CreateFlashcardRule = new ActivityScenarioRule<>(FlashcardsCreatePromptActivity.class);
    public ActivityScenarioRule<FlashcardsActivity> ViewFlashcardRule = new ActivityScenarioRule<>(FlashcardsActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("comp3350.exampool", appContext.getPackageName());
    }

    /**
     * Create a MCQ Flashcard and verify that it is created by starting at the create flashcard screen
     * Select MCQ
     * Type data
     * Save
     * Verify in list
     */
    @Test
    public void createMCQFlashCard() {
        useAppContext();
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

    }

    /**
     * Create a True or False Flashcard and verify that it is created by starting at the create flashcard screen
     * Select True or false
     * Type data and click true
     * Save
     * Verify in list
     */
    @Test
    public void createTFFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsCreatePromptActivity> scenario = CreateFlashcardRule.getScenario();
        onView(withId(R.id.buttonTrueFalse)).perform(click()); //Click Create Note
        //Fill data
        onView(withId(R.id.createQuestion)).perform(typeText("This should be true")); //Input Question
        onView(withId(R.id.button2)).perform(click()); //Input True
        onView(withId(R.id.buttonCreate)).perform(click()); //Click Create

        //Check if it was created
        System.out.println("Verifying the True or false was added");
        onData(withText("This should be true")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("This should be true /n True /n False ")));
    }

    /**
     * Create a Typed answer Flashcard and verify that it is created by starting at the create flashcard screen
     * Select Typed answer
     * Type data
     * Save
     * Verify in list
     */
    @Test
    public void createTAFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsCreatePromptActivity> scenario = CreateFlashcardRule.getScenario();
        onView(withId(R.id.buttonTypedAnswer)).perform(click()); //Click Create Note

        //Fill data
        onView(withId(R.id.createQuestion)).perform(typeText("Will this test succeed?")); //Input Question
        onView(withId(R.id.createAnswer)).perform(typeText("Yes it will!")); //Input Question
        onView(withId(R.id.buttonCreate)).perform(click()); //Click Create

        //Check if it was created
        System.out.println("Verifying the Typed answer was added");
        onData(withText("Will this test succeed?")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("Will this test succeed?")));
    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Edit the data
     * Save
     * Verify the data has been changed in the list
     */
    @Test
    public void editMCQFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createMCQFlashCard();

        //Find the MCQ
        System.out.println("Editing the MCQ that was added");
        onData(withText("Dummy Question?")).inAdapterView(withId(R.id.listNotes)).perform(click());


        onView(withId(R.id.createQuestion)).perform(typeText(" Edit?")); //Input Question
        onView(withId(R.id.createAnswer)).perform(clearText());
        onView(withId(R.id.createAnswer)).perform(typeText("This 1!")); //Input Answer
        //Input Options
        onView(withId(R.id.createChoice1)).perform(typeText("Not me"));
        onView(withId(R.id.createChoice2)).perform(typeText("Still not me"));
        onView(withId(R.id.createChoice3)).perform(typeText("Can't be me"));
        onView(withId(R.id.buttonNotesDelete)).perform(click()); //Click Save

        //Check if it was edited

        System.out.println("Verifying the MCQ was edited");
        onData(withText("Dummy Question Edit?")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("Dummy Question Edit? /n This 1! /n Not me /n Still not me /n Can't be me")));
    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Edit the data
     * Save
     * Verify the data has been changed in the list
     */
    @Test
    public void editTFFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createTFFlashCard();
        //Find the T of F
        System.out.println("Editing the True or false that was added");
        onData(withText("This should be true")).inAdapterView(withId(R.id.listNotes)).perform(click());


        onView(withId(R.id.createQuestion)).perform(clearText());
        onView(withId(R.id.createQuestion)).perform(typeText("This will be false"));
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.buttonNotesDelete)).perform(click()); //Click Save

        //Check if it was edited

        System.out.println("Verifying the True or false was edited");
        onData(withText("This will be false")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("This will be false")));

    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Edit the data
     * Save
     * Verify the data has been changed in the list
     */
    @Test
    public void editTAFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createTAFlashCard();
        System.out.println("Editing the Typed answer that was added");
        onData(withText("Will this test succeed?")).inAdapterView(withId(R.id.listNotes)).perform(click());


        onView(withId(R.id.createQuestion)).perform(clearText());
        onView(withId(R.id.createQuestion)).perform(typeText("Will this fail?"));
        onView(withId(R.id.createAnswer)).perform(clearText());
        onView(withId(R.id.createAnswer)).perform(typeText("It can't!")); //Input Answer

        onView(withId(R.id.buttonNotesDelete)).perform(click()); //Click Save

        //Check if it was edited

        System.out.println("Verifying the typed answer was edited");
        onData(withText("Will this test succeed?")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.typed_question)).check(matches(withText("Will this test succeed? /n It can't! ")));
    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Delete the card
     * Verify the data has been removed from the list
     */
    @Test
    public void deleteMCQFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createMCQFlashCard();
        System.out.println("Deleting the Multiple choice that was added");
        onData(withText("Dummy Question?")).inAdapterView(withId(R.id.listNotes)).perform(click());

        onView(withId(R.id.buttonNotesUpdate)).perform(click()); //click delete

        //Check if deleted
        System.out.println("Verifying flashcard was deleted");
        assertNull(onData(withText("Dummy Question?")).inAdapterView(withId(R.id.listNotes)));
        System.out.println("Flashcard was deleted");
    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Delete the card
     * Verify the data has been removed from the list
     */
    @Test
    public void deleteTFFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createTFFlashCard();
        System.out.println("Deleting the Typed answer that was added");
        onData(withText("This should be true")).inAdapterView(withId(R.id.listNotes)).perform(click());

        onView(withId(R.id.buttonNotesUpdate)).perform(click()); //click delete

        //Check if deleted
        System.out.println("Verifying flashcard was deleted");
        assertNull(onData(withText("This should be true")).inAdapterView(withId(R.id.listNotes)));
        System.out.println("Flashcard was deleted");
    }

    /**
     * Create the flashcard
     * Find the flashcard and select it
     * Delete the card
     * Verify the data has been removed from the list
     */
    @Test
    public void deleteTAFlashCard() {
        useAppContext();
        ActivityScenario<FlashcardsActivity> scenario = ViewFlashcardRule.getScenario();
        createTAFlashCard();
        System.out.println("Deleting the Typed answer that was added");
        onData(withText("Will this test succeed?")).inAdapterView(withId(R.id.listNotes)).perform(click());

        onView(withId(R.id.buttonNotesUpdate)).perform(click()); //click delete

        //Check if deleted
        System.out.println("Verifying flashcard was deleted");
        assertNull(onData(withText("Will this test succeed?")).inAdapterView(withId(R.id.listNotes)));
        System.out.println("Flashcard was deleted");

    }

}
