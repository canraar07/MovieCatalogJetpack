package com.canra.jetpackmovie


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
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
class SaveFavoritandDeletMovieTest {

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
    fun saveFavoritandDeletMovieTest() {
        val constraintLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recyleviewmenu),
                        childAtPosition(
                            withId(R.id.main),
                            3
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        constraintLayout.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.imageFavorit),
                childAtPosition(
                    allOf(
                        withId(R.id.parent_content_header),
                        childAtPosition(
                            withId(R.id.linear_view),
                            0
                        )
                    ),
                    5
                )
            )
        )
        appCompatImageView.perform(scrollTo(), click())

        pressBack()

        val tabView = onView(
            allOf(
                withContentDescription("Favorit Movie"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabmenu),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        tabView.perform(click())

        val constraintLayout3 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recyleviefavorit),
                        childAtPosition(
                            withId(R.id.main),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        constraintLayout3.perform(click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.imageFavorit),
                childAtPosition(
                    allOf(
                        withId(R.id.parent_content_header),
                        childAtPosition(
                            withId(R.id.linear_view),
                            0
                        )
                    ),
                    5
                )
            )
        )
        appCompatImageView2.perform(scrollTo(), click())

        pressBack()
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
