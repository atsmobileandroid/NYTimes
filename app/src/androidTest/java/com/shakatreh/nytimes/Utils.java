package com.shakatreh.nytimes;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class Utils {

    public static Matcher<View> withViewAtPosition(final int position, final Matcher<View> itemMatcher) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                final RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

    public static int getCountFromRecyclerView(@IdRes int RecyclerViewId) {
        final int[] COUNT = {0};
        Matcher matcher = new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                COUNT[0] = ((RecyclerView) item).getAdapter().getItemCount();
                return true;
            }
            @Override
            public void describeTo(Description description) {}
        };
        Espresso.onView(allOf(withId(RecyclerViewId),isDisplayed())).check(matches(matcher));
        return COUNT[0];
    }
}
