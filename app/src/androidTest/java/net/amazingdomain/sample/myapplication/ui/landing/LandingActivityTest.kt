package net.amazingdomain.sample.myapplication.ui.landing

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
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

        Espresso.onView(ViewMatchers.withText("name kitty")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun landscapeOrientationTest() {

        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        getInstrumentation().waitForIdleSync()

        Espresso.onView(ViewMatchers.withText("name kitty")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}

