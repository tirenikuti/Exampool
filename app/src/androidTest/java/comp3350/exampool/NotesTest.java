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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.exampool.presentation.NotesActivity;


import static org.hamcrest.CoreMatchers.anything;

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
        //onView(withId(R.id.buttonNotesCreate)).perform(click()); //Click Create Note

        // Create New Note
        onView(withId(R.id.notesTitle )).perform(typeText("Test Title")); //Input note name
        onView(withId(R.id.notesText)).perform(typeText("Test Text")); //Input Note text
        //onView(withId(R.id.buttonNotesCreate)).perform(click()); //Save
        closeSoftKeyboard();

        // Verify that it was added
        pressBack();
        onData(anything()).inAdapterView(withId(R.id.listNotes)).atPosition(0).perform(click());
        onView(withId(R.id.notesTitle)).check(matches(withText("Test Title")));
        onView(withId(R.id.notesText)).check(matches(withText("Test Title")));
    }
    @Test
    public void deleteNote(){

    }

    @Test
    public void updateNote(){

    }
}
