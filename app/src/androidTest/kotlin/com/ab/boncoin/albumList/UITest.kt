package com.ab.boncoin.albumList

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ab.boncoin.MainActivity
import com.ab.boncoin.R
import org.hamcrest.core.AllOf
import org.hamcrest.core.StringEndsWith
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class UITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.album_list)).check(matches(isDisplayed()))
    }

    @Test
    fun test1() {
        onView(withId(R.id.album_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AlbumListAdapter.ViewHolder>(
                    0,
                    click()
                )


            )
        onView(AllOf.allOf(withId(R.id.photo_list), isDisplayed()))
        onView(withId(R.id.photo_list)).perform(swipeUp())
       // ;
        onView(withId(R.id.photo_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AlbumListAdapter.ViewHolder>(
                    0,
                    click()
                )


            )
        onView(withText(StringEndsWith.endsWith("accusamus beatae ad facilis cum similique qui sunt"))).check(matches(isDisplayed()))
        pressBack()
        pressBack()


    }




    @Test
    fun test2() {

        onView(withId(R.id.album_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AlbumListAdapter.ViewHolder>(
                    2,
                    click()
                )


            )
        onView(AllOf.allOf(withId(R.id.photo_list), isDisplayed()))
        onView(withId(R.id.photo_list)).perform(swipeUp())
        // ;
        onView(withId(R.id.photo_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AlbumListAdapter.ViewHolder>(
                    2,
                    click()
                )


            )
        onView(withText(StringEndsWith.endsWith("officia porro iure quia iusto qui ipsa ut mod"))).check(matches(isDisplayed()))




    }


}
