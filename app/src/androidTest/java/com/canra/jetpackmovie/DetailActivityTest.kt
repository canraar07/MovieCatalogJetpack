package com.canra.jetpackmovie


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun detailActivityTest() {
        val itemMovie = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recyleviewmenu),
                        childAtPosition(
                            withId(R.id.main),
                            2
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        itemMovie.perform(click())

        Thread.sleep(3000)
        pressBack()

        val tabView = onView(
            allOf(
                withContentDescription("Tv Show"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabmenu),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(3000)
        tabView.perform(click())

        val itemTvshow = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recyleviewmenu),
                        childAtPosition(
                            withId(R.id.main),
                            2
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        itemTvshow.perform(click())
        Thread.sleep(5000)
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
