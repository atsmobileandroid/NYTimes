package com.shakatreh.nytimes.ui.fragments;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.ui.MainActivity;
import com.shakatreh.nytimes.viewmodel.ArticlesViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ArticleNavigationTest {

    @Test
    public void test_ArticleFragmentsNavigation() {
        // Setup
        ActivityScenario.launch(MainActivity.class);

        CountingIdlingResource componentIdlingResource = ArticlesViewModel.getIdlingResourceInTest();
        Espresso.registerIdlingResources(componentIdlingResource);

        // Nav to ArticleDetailsFragment
        Espresso.onView(withId(R.id.rvArticles)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Verify
        Espresso.onView(withId(R.id.fragment_article_details_parent)).check(matches(isDisplayed()));

        pressBack();

        // Verify
        Espresso.onView(withId(R.id.fragment_articles_parent)).check(matches(isDisplayed()));
    }
}
