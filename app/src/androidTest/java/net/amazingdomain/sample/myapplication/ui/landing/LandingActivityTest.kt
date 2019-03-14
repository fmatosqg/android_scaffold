package net.amazingdomain.sample.myapplication.ui.landing

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.ui.common.BaseActivityTest
import net.amazingdomain.sample.myapplication.ui.common.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class LandingActivityTest : BaseActivityTest() {

    @get:Rule
    val activityRule = ActivityTestRule(LandingActivity::class.java)

    @Test
    fun defaultOrientationTest() {

        getInstrumentation().waitForIdleSync()
        assertListValues()
    }

    @Test
    fun landscapeOrientationTest() {

        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        getInstrumentation().waitForIdleSync()

        assertListValues()
    }

    private fun assertListValues() {

        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(5))

        assertPosition(0)
        assertPosition(4)

    }

    private fun assertPosition(position: Int) {

        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
                .check(matches(atPosition(position, hasDescendant(withText("Kitty # $position")))))

    }
}

