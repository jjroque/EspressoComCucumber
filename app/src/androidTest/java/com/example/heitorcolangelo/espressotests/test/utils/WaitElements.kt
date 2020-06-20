package com.example.heitorcolangelo.espressotests.test.utils

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed

class WaitElements {

    fun waitForElementInt(element: Int): Boolean {
        var i = 0
        while (i++ < 5) {
            try {
                assertDisplayed(element)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
                try {
                    Thread.sleep(1000)
                } catch (e1: Exception) {
                    e.printStackTrace()
                }

            }

        }
        return false
    }

    fun waitForElementString(element: String): Boolean {
        var i = 0
        while (i++ < 5) {
            try {
                assertDisplayed(element)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
                try {
                    Thread.sleep(1000)
                } catch (e1: Exception) {
                    e.printStackTrace()
                }

            }

        }
        return false
    }
}