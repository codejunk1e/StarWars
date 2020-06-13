package com.project.valhallastudio.starwars.views.activities


import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.viewpager.widget.ViewPager
import com.project.valhallastudio.starwars.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Robin
 * Created on 5/6/20
 * A simple Instrumented [Test] done with the expresso recorder and modified to poke a little at Automated testing.
 * This test just scrolls through the tab in speed.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {

        Thread.sleep(4000)
        scrollUp()
        scrollDown()


        onView(
            allOf(
                withContentDescription("Planets"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        ).perform(click())
        Thread.sleep(4000)
        scrollUp()
        Thread.sleep(4000)
        scrollDown()


        onView(
            allOf(
                withContentDescription("Films"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        ).perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()


        val tabView3 = onView(
            allOf(
                withContentDescription("Species"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        tabView3.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()


        val tabView4 = onView(
            allOf(
                withContentDescription("Vehicles"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        tabView4.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView5 = onView(
            allOf(
                withContentDescription("Starships"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        tabView5.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView6 = onView(
            allOf(
                withContentDescription("Vehicles"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        tabView6.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView7 = onView(
            allOf(
                withContentDescription("Species"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        tabView7.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView8 = onView(
            allOf(
                withContentDescription("Films"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        tabView8.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView9 = onView(
            allOf(
                withContentDescription("Planets"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView9.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()

        val tabView10 = onView(
            allOf(
                withContentDescription("Characters"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout_main),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        tabView10.perform(click())
        Thread.sleep(2400)
        scrollUp()
        Thread.sleep(2400)
        scrollDown()
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

    private  fun scrollUp(){
        onView(withId(R.id.coordinator_root)).perform(swipeUp())
    }

    private  fun scrollDown(){
        onView(withId(R.id.viewpager_main)).perform(swipeDown())
    }
}
