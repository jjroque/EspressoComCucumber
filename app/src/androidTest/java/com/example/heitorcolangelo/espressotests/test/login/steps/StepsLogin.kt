package com.example.heitorcolangelo.espressotests.test.login.steps
import android.support.test.rule.ActivityTestRule
import com.example.heitorcolangelo.espressotests.R
import com.example.heitorcolangelo.espressotests.test.login.robot.RobotLogin
import com.example.heitorcolangelo.espressotests.test.common.ActivityFinisher
import com.example.heitorcolangelo.espressotests.ui.activity.LoginActivity
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.After
import org.junit.Before
import java.net.PasswordAuthentication

class StepsLogin {

    private val activityRule = ActivityTestRule(LoginActivity::class.java, false, false)

    private val robot = RobotLogin()

    @cucumber.api.java.Before
    fun setup() {

    }

    @cucumber.api.java.After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities() // Se tiver mais de um caso de teste é necessário utilizar para finalizar a tela
    }

    @Given("^Que eu inicio a tela de Login$")
    fun abrirATelaDeLogin() {
        robot.launchLoginScreen(activityRule)
    }

    @And("^Eu vejo Hint e o campo de Email$")
    fun validarHintEmail() {
        robot.verificarCampoEmail()
    }

    @And("^Eu vejo Hint e o campo de Senha$")
    fun validarHintSenha() {
        robot.verificarCampoSenha()
    }

    @And("^Eu vejo o Botao de Login$")
    fun verBotaoDeLogin() {
        robot.verificarBotaoLogin()
    }

    @Then("^Eu vejo a imagem do Login$")
    fun verImagemNoLogin() {
        robot.verificarImagem()
    }

    @And("^Eu preencho o campo usuario$")
    fun preencherUsuario() {
        robot.escreverUsuario()
    }

    @And("^Eu preencho o campo senha$")
    fun preencherSenha() {
        robot.escreverSenha()
    }

    @When("^Clicar no botao login$")
    fun clicarBotaoLogin() {
        robot.clicarBotaoLogin()
    }

    @Then("^Eu vejo o titulo da tela$")
    fun verTituloTela() {
        robot.verificarTituloTela()
    }

    @Then("^Eu vejo uma pop-up de erro$")
    fun verPopUp() {
        robot.verificarPopUp()
    }

    @And("^Eu escrevo o E-mail com: \"(.*)\"$")
    fun escreverEmail(text: String) {
        writeTo(R.id.login_username, text)
    }

    @And("^Eu escrevo a senha com: \"(.*)\"$")
    fun escreverSenha(pass: String) {
        writeTo(R.id.login_password, pass)
    }

    @And("^Eu logo com sucesso$")
    fun logar() {
        robot.escreverUsuario()
        robot.escreverSenha()
        robot.clicarBotaoLogin()
    }
}