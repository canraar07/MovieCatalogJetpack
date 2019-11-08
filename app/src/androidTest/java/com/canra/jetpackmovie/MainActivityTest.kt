package com.canra.jetpackmovie


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.canra.jetpackmovie.espreso.EsspresoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EsspresoIdlingResource.getEspressoIdlingResourcey())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EsspresoIdlingResource.getEspressoIdlingResourcey())
    }

    @Test
    fun mainActivityTest() {
        val tabViewTvshow = onView(
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

        tabViewTvshow.perform(click())

        val tabViewMovie = onView(
            allOf(
                withContentDescription("Movie"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabmenu),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )

        tabViewMovie.perform(click())
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
