package com.example.heitorcolangelo.espressotests.test.utils

import com.example.heitorcolangelo.espressotests.test.common.ActivityFinisher
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickBack
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaViewPagerInteractions.swipeViewPagerForward
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.pt.Dado

class UtilsSteps {

    @Before
    fun setup() {

    }

    @After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities()
    }

    private val wait = WaitElements()

    @And("^Eu vejo o Texto: \"(.*)\"$")
    fun checkTxtOnScreen(text: String) {
        wait.waitForElementString(text)
        assertDisplayed(text)
    }

    @Dado("^Eu valido o texto:")
    @Throws(Throwable::class)
    fun see_text(arg1: String) {
        assertDisplayed(arg1)
    }

    @And("^Eu clico sobre o elemento: \"(.+)\"$")
    fun clickOnText(text: String) {
        wait.waitForElementString(text)
        clickOn(text)
    }

    @And("^Eu faco um swipe para a Esquerda$")
    fun swipeForLeft() {
        swipeViewPagerForward()
    }

    @And("^Eu clico no botão voltar$")
    fun clickToBack() {
        clickBack()
    }
}