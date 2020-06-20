#language: pt

Funcionalidade: Login do usuario

  @login-validando
  @Fluxo-Basico
  Cenario: Validar elementos do Login
    Dado Que eu inicio a tela de Login
    E Eu vejo Hint e o campo de Email
    E Eu vejo Hint e o campo de Senha
    Quando Eu vejo o Botao de Login
    Então Eu vejo a imagem do Login

  @login-sucesso
  @Fluxo-Basico
  Cenario: Validar login na aplicacao com sucesso
    Dado Que eu inicio a tela de Login
    E Eu escrevo o E-mail com: "texuguera@gmail.com"
    E Eu escrevo a senha com: "1234"
    Quando Eu clico sobre o elemento: "Login"
    Então Eu vejo o titulo da tela
    Então Eu vejo o Texto: "List of users"

  @login-insucesso
  @Fluxo-Alternativo
  Cenario: Validar login sem sucesso
    Dado Que eu inicio a tela de Login
    Quando Clicar no botao login
    Então Eu vejo uma pop-up de erro

  @login-sucesso2
  Esquema do Cenário: Validar login na aplicacao com sucesso
    Dado Que eu inicio a tela de Login
    E Eu escrevo o E-mail com: "<Email>"
    E Eu escrevo a senha com: "<Senha>"
    Quando Eu clico sobre o elemento: "Login"
    Então Eu vejo o titulo da tela
    Então Eu vejo o Texto: "<Mensagem>"

    Exemplos:
      | Email               | Senha  | Mensagem               |
      | SEUEMAIL1@gmail.com | 112234 | Bem Vindo Adminstrador |
      | SEUEMAIL2@gmail.com | 112235 | Bem Vindo Moderador    |
      | SEUEMAIL3@gmail.com | 112236 | Bem Vindo Texugo       |
      | SEUEMAIL4@gmail.com | 112237 | Bem Vindo Funcionario  |
