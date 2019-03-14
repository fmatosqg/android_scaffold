package net.amazingdomain.sample.myapplication.ui.landing

import android.content.pm.ActivityInfo
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import net.amazingdomain.sample.myapplication.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class LandingActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(LandingActivity::class.java)

    @Test
    fun defaultOrientationTest() {

        assertListValues()
    }

    @Test
    fun landscapeOrientationTest() {

        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        getInstrumentation().waitForIdleSync()

        assertListValues()
    }

    private fun assertListValues() {


        onView(withId(net.amazingdomain.sample.myapplication.R.id.recycler_view))
                .check(matches(atPosition(0, hasDescendant(withText("Kitty # 0")))))

        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
                .check(matches(atPosition(10, hasDescendant(withText("Kitty # 10")))))

    }


    // TODO move to parent class
    //    https://stackoverflow.com/questions/31394569/how-to-assert-inside-a-recyclerview-in-espresso
    private fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        checkNotNull(itemMatcher)
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                        ?: // has no item on such position
                        return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}