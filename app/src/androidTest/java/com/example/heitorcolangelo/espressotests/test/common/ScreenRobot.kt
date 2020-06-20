package com.example.heitorcolangelo.espressotests.test.common

import android.app.Activity
import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.view.View

import com.example.heitorcolangelo.espressotests.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressImeActionButton
import android.support.test.espresso.action.ViewActions.swipeDown
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.action.ViewActions.swipeRight
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.isClickable
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import android.support.test.espresso.matcher.ViewMatchers.withHint
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withTagValue
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.heitorcolangelo.espressotests.test.common.actions.CallOnClickAction.callOnClick
import org.hamcrest.Matchers.not
import org.hamcrest.core.Is.`is`

class ScreenRobot {

    private val activityContext: Activity? = null

    val context: Context
        get() = InstrumentationRegistry.getTargetContext()

    @Throws(InterruptedException::class)
    @JvmOverloads
    fun sleep(seconds: Int = 1) {
        Thread.sleep(seconds * 1000L)
    }

    fun checkIsDisplayed(@IdRes vararg viewIds: Int) {
        for (viewId in viewIds) {
            onView(withId(viewId)).check(matches(isDisplayed()))
        }
    }

    fun checkIsClickable(@IdRes vararg viewIds: Int) {
        for (viewId in viewIds) {
            onView(withId(viewId)).check(matches(isClickable()))
        }
    }

    fun checkIsHidden(@IdRes vararg viewIds: Int) {
        for (viewId in viewIds) {
            onView(withId(viewId)).check(matches(not(isDisplayed())))
        }
    }

    fun checkDoesNotExist(@IdRes vararg viewIds: Int) {
        for (viewId in viewIds) {
            onView(withId(viewId)).check(doesNotExist())
        }
    }

    fun checkViewHasText(@IdRes viewId: Int, @StringRes messageResId: Int) {
        onView(withId(viewId)).check(matches(withText(messageResId)))
    }

    fun checkViewHasDrawableAndTag(imageResId: Int) {
        onView(withTagValue(`is`(imageResId as Any))).check(matches(isDisplayed()))
    }

    fun scrollViewDown(@IdRes viewIds: Int) {
        onView(withId(viewIds)).perform(swipeUp(), click())
    }

    fun checkViewHasText(@IdRes viewId: Int, expected: String) {
        onView(withId(viewId)).check(matches(withText(expected)))
    }

    fun scrollViewUp(@IdRes viewIds: Int) {
        onView(withId(viewIds)).perform(swipeDown(), click())
    }

    fun checkViewContainsText(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }

    fun checkViewHasHint(@IdRes viewId: Int, @StringRes messageResId: String) {
        onView(withId(viewId)).check(matches(withHint(messageResId)))
    }

    fun callOnClickOnView(@IdRes viewId: Int) {
        // On small Views, click action isn't always detected.
        // To avoid this, use callOnClick().
        onView(withId(viewId)).perform(callOnClick())
    }

    fun clickOnView(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(click())
    }

    fun pressBack() {
        Espresso.pressBack()
    }

    fun goBackFromToolbar() {
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click())
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
    }

    fun pressImeAction(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(pressImeActionButton())
    }

    fun assertItTakeMeToScreen(targetClass: Class<*>) {
        intended(hasComponent(targetClass.name))
    }

    fun enterTextIntoView(@IdRes viewId: Int, text: String) {
        onView(withId(viewId)).perform(typeText(text))
        closeKeyboard()
    }

    fun checkDialogWithTextIsDisplayed(@StringRes messageResId: Int) {
        onView(withText(messageResId))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
    }

    fun checkDialogWithTextIsDisplayed(message: String) {
        onView(withText(message))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
    }

    fun swipeLeftOnView(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(swipeLeft())
    }

    fun swipeRightOnView(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(swipeRight())
    }

    fun clickOnCardForList(@IdRes viewId: Int, position: Int) {
        onView(withIndex(withId(viewId), position)).perform(click())
    }


    fun withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            internal var currentIndex = 0

            override fun describeTo(description: Description) {
                description.appendText("with index: ")
                description.appendValue(index)
                matcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                return matcher.matches(view) && currentIndex++ == index
            }
        }
    }
}

