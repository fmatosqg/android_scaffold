package net.amazingdomain.sample.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import net.amazingdomain.sample.myapplication.ui.landing.LandingActivity
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(LandingActivity::class.java)

    @Test
    fun useAppContext() {

        val context = activityRule.activity
        assertTrue(context.packageName.startsWith("net.amazingdomain.sample.myapplication"))

    }
}
