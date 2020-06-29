package com.shakatreh.nytimes.ui;

import androidx.test.espresso.Espresso;
import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;


import com.shakatreh.nytimes.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void test_isActivityInView() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Espresso.onView(withId(R.id.container)).check(matches(isDisplayed()));
    }
}