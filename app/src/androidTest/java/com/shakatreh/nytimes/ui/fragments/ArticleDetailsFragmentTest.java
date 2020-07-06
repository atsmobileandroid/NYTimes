package com.shakatreh.nytimes.ui.fragments;


import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.shakatreh.nytimes.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ArticleDetailsFragmentTest {

    @Test
    public void test_isArticleDetailsFragmentInView() {
        FragmentScenario.launchInContainer(ArticleDetailsFragment.class);

        Espresso.onView(withId(R.id.fragment_article_details_parent)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.article_image)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.article_title)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.article_description)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.article_reporter)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.article_publisher)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.publishedDate)).check(matches(isDisplayed()));
    }




}