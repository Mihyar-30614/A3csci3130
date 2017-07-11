package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    /*
    * Test data input and save
    * */
    public void createBusinessContact() throws Exception {
        onView(withId(R.id.newBusiness)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Mihyar Al Masalma"));
        onView(withId(R.id.number)).perform(typeText("123456789"));
        onView(withId(R.id.address)).perform(typeText("6221 Coburg Rd."));
        onView(withId(R.id.business)).perform(typeText("Fisher"));
        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.createBusiness)).perform(click());
    }
    /*
    Test Update Existing data
     */
    @Test
    public void editData() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.address)).perform(clearText());
        onView(withId(R.id.address)).perform(typeText("New Address AVE."), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }
    /*
    Test Deleting data
     */
    @Test
    public void deleteData() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
