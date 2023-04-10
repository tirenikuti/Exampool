package comp3350.exampool;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import comp3350.exampool.objects.Notes;
import comp3350.exampool.persistence.NotesPersistence;
import comp3350.exampool.persistence.hsqldb.NotesPersistenceHSQLDB;
import comp3350.exampool.presentation.NotesActivity;
import comp3350.exampool.presentation.NotesCreateActivity;


import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;



@RunWith(AndroidJUnit4.class)
@LargeTest

public class NotesTest {
    @Rule
    public ActivityScenarioRule<NotesActivity> activityRule = new ActivityScenarioRule<>(NotesActivity.class);



    @Test
    public void createNote() {
        ActivityScenario<NotesActivity> scenario = activityRule.getScenario();
        onView(withId(R.id.buttonCreateNotes)).perform(click()); //Click Create Note
        System.out.println("Adding a Note");
        // Create New Note
        onView(withId(R.id.notesTitle )).perform(typeText("Test Title")); //Input note name
        onView(withId(R.id.notesText)).perform(typeText("Test Text")); //Input Note text
        onView(withId(R.id.buttonCreateNotes)).perform(click()); //Save
        closeSoftKeyboard();

        // Verify that it was added
        System.out.println("Verifying the Note was added");
        onData(withText("Test Title")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.notesTitle)).check(matches(withText("Test Title")));
        onView(withId(R.id.notesText)).check(matches(withText("Test Text")));
    }
    @Test
    public void deleteNote(){
        ActivityScenario<NotesActivity> scenario = activityRule.getScenario();
        createNote(); //Add a note
        pressBack();
        System.out.println("Note has been added successfully");

        //Find the Note
        System.out.println("Deleting the Note that was added");
        onData(withText("Test Title")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.notesTitle)).check(matches(withText("Test Title")));
        onView(withId(R.id.notesText)).check(matches(withText("Test Text")));

        //Delete the Note
        onView(withId(R.id.backButton)).perform(click()); //Click Delete button

        //Verify Delete
        System.out.println("Verifying Note was deleted");
        assertEquals(onData(withText("Test Title")).inAdapterView(withId(R.id.listNotes)),null);
        System.out.println("Note was deleted");

    }

    @Test
    public void updateNote(){
        ActivityScenario<NotesActivity> scenario = activityRule.getScenario();
        createNote(); //Add a note
        pressBack();
        System.out.println("Note has been added successfully");

        //Find the Note
        System.out.println("Editing the Note that was added");
        onData(withText("Test Title")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.notesTitle)).check(matches(withText("Test Title")));
        onView(withId(R.id.notesText)).check(matches(withText("Test Title")));

        //Edit Note
        onView(withId(R.id.notesTitle)).perform(clearText()); //Clear
        onView(withId(R.id.notesTitle)).perform(typeText("Edited Title")); //Edit note name

        onView(withId(R.id.notesText)).perform(clearText()); //Clear
        onView(withId(R.id.notesText)).check(matches(withText("Edited Text")));

        //Click Save
        onView(withId(R.id.backButton2)).perform(click()); //Click Save button


        //Check if its updated in the list
        System.out.println("Verifying Note was Updated");
        onData(withText("Test Title")).inAdapterView(withId(R.id.listNotes)).perform(click());
        onView(withId(R.id.notesTitle)).check(matches(withText("Edited Title")));
        onView(withId(R.id.notesText)).check(matches(withText("Edited Text")));


    }
}
