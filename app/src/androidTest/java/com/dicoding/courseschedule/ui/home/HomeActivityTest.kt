package com.dicoding.courseschedule.ui.home

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.dicoding.courseschedule.R
import com.dicoding.courseschedule.ui.add.AddCourseActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadAddCourse() {
        onView(withId(R.id.action_add)).apply {
            check(matches(isDisplayed()))
            perform(click())
        }

        val addCourse = getResumedActivity()
        Assert.assertTrue(addCourse is AddCourseActivity)

        onView(withId(R.id.add_start_time))
            .check(matches(isDisplayed()))
        onView(withId(R.id.add_name_course))
            .check(matches(isDisplayed()))
        onView(withId(R.id.add_spinner_day))
            .check(matches(isDisplayed()))
        onView(withId(R.id.add_end_time))
            .check(matches(isDisplayed()))
        onView(withId(R.id.add_name_lecturer))
            .check(matches(isDisplayed()))
        onView(withId(R.id.add_note))
            .check(matches(isDisplayed()))
    }

    private fun getResumedActivity(): Activity? {
        var activity: Activity? = null
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            activity = ActivityLifecycleMonitorRegistry.getInstance()
                .getActivitiesInStage(Stage.RESUMED).elementAtOrNull(0)
        }
        return activity
    }
}