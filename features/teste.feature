Feature: teste smoke na pagina facebook
  
  Scenario: testar login com uma credencial valida
  Given que abro o firefox/chrome e inicio a aplicacao
  When eu entrar com "miketyson@teste.com" e valido "seleniumMike"
  Then devera ser logado com sucesso