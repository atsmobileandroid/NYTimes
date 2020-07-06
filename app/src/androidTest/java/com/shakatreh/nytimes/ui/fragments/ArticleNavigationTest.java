package com.shakatreh.nytimes.ui.fragments;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.Utils;
import com.shakatreh.nytimes.ui.MainActivity;
import com.shakatreh.nytimes.util.EspressoIdlingResources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4ClassRunner.class)
public class ArticleNavigationTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.getIdlingResource());
    }


    @Test
    public void test_RecyclerViewInView() {
        Espresso.onView(withId(R.id.rvArticles)).check(matches(isDisplayed()));
    }

    @Test
    public void test_RecyclerViewItemsInView() {
        Espresso.onView(withId(R.id.rvArticles)).check(matches(Utils.withViewAtPosition(0, hasDescendant(allOf(withId(R.id.circleImageView), isDisplayed())))));
        Espresso.onView(withId(R.id.rvArticles)).check(matches(Utils.withViewAtPosition(0, hasDescendant(allOf(withId(R.id.title), isDisplayed())))));
        Espresso.onView(withId(R.id.rvArticles)).check(matches(Utils.withViewAtPosition(0, hasDescendant(allOf(withId(R.id.createdBy), isDisplayed())))));
    }

    @Test
    public void test_ArticleDetailsFragmentInView() {
        Espresso.onView(withId(R.id.rvArticles)).perform(RecyclerViewActions.actionOnItemAtPosition(15, click()));
        Espresso.onView(withId(R.id.fragment_article_details_parent)).check(matches(isDisplayed()));
    }

    @Test
    public void test_RecyclerViewScrolling() {
        Espresso.onView(withId(R.id.rvArticles)).check(matches(isDisplayed()));
        int count = Utils.getCountFromRecyclerView(R.id.rvArticles);
        Espresso.onView(withId(R.id.rvArticles)).perform(actionOnItemAtPosition(count-1, scrollTo()));
    }

    @Test
    public void test_PressBack() {
        Espresso.onView(withId(R.id.rvArticles)).perform(actionOnItemAtPosition(0, click()));
        pressBack();
        Espresso.onView(withId(R.id.fragment_articles_parent)).check(matches(isDisplayed()));
    }

}
