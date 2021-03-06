package com.shakatreh.nytimes.ui.fragments;


import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.shakatreh.nytimes.R;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4ClassRunner.class)
public class ArticlesFragmentTest {

    @Test
    public void test_isArticleFragmentInView() {
        FragmentScenario.launchInContainer(ArticlesFragment.class);
        Espresso.onView(withId(R.id.fragment_articles_parent)).check(matches(isDisplayed()));
    }

}