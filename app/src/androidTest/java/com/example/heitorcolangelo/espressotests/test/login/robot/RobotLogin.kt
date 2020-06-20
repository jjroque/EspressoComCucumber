package com.example.heitorcolangelo.espressotests.test.login.robot

import android.support.test.rule.ActivityTestRule
import com.example.heitorcolangelo.espressotests.R
import com.example.heitorcolangelo.espressotests.test.common.ScreenRobot
import com.example.heitorcolangelo.espressotests.test.login.constants.LoginConstants.HINT_EMAIL
import com.example.heitorcolangelo.espressotests.test.login.constants.LoginConstants.HINT_SENHA
import com.example.heitorcolangelo.espressotests.ui.activity.LoginActivity

class RobotLogin {

    private val robot = ScreenRobot()

    fun launchLoginScreen(testRule: ActivityTestRule<LoginActivity>) {
        testRule.launchActivity(null)
    }

    fun verificarCampoEmail() {
        robot.checkViewHasHint(CAMPO_EMAIL, HINT_EMAIL)
    }

    fun verificarCampoSenha() {
        robot.checkViewHasHint(CAMPO_SENHA, HINT_SENHA)
    }

    fun verificarBotaoLogin() {
        robot.checkIsDisplayed(BOTAO_LOGIN)
    }

    fun verificarImagem() {
        robot.checkIsDisplayed(IMAGEM_LOGIN)
    }

    fun escreverUsuario() {
        robot.enterTextIntoView(CAMPO_EMAIL, "texuguera@gmail.com")
    }

    fun escreverSenha() {
        robot.enterTextIntoView(CAMPO_SENHA, "1234")
    }

    fun clicarBotaoLogin() {
        robot.clickOnView(BOTAO_LOGIN)
    }

    fun verificarTituloTela() {
        robot.checkViewContainsText("List of users")
    }

    fun verificarPopUp(){
        robot.checkDialogWithTextIsDisplayed("Important")
    }

    companion object {
        private val CAMPO_EMAIL = R.id.login_username
        private val CAMPO_SENHA = R.id.login_password
        private val BOTAO_LOGIN = R.id.login_button
        private val IMAGEM_LOGIN = R.id.login_image
    }
}