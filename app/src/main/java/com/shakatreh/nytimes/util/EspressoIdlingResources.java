package com.shakatreh.nytimes.util;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;


public class EspressoIdlingResources {

    private static CountingIdlingResource mIdlingRes = new CountingIdlingResource("Global");;

    public static void increment() {
        if (mIdlingRes != null)
            mIdlingRes.increment();
    }

    public static void decrement() {
        if (mIdlingRes != null)
            mIdlingRes.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return mIdlingRes;
    }

}
