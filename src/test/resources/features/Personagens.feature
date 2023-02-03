#language: pt
#encoding: utf-8
@PERSONAGENS
Funcionalidade: Verificar as funcionalidades de personagens

  Contexto: 
    Dado parametrizar um usuario
      | NOME        | STATUS | ESPECIE | TIPO | GENERO | EPISODIO       | URL       |
      | Morty Smith | Alive  | Human   |      | Male   | https:episodio | https:url |
    E criar um personagem

  @RETORNAR_TODOS_PERSONAGENS
  Cenario: Deve retornar todos personagens
    Dado retornar todos personagens
    Entao validar o status code 200

  @RETORNAR_PERSONAGEM
  Cenario: Deve retornar um personagem
    Dado retornar um personagem "1"
    Entao validar o status code 200

  @CRIAR_PERSONAGEM
  Cenario: Deve criar um personagem
    Dado criar um personagem
    Quando retornar um personagem "2"
    Entao validar o status code 200

  @ALTERAR_PERSONAGEM
  Cenario: Deve alterar um personagem
    Dado alterar um personagem "1"
    Entao validar o status code 200

  @DELETAR_PERSONAGEM
  Cenario: Deve deletar um personagem
    Dado deletar um personagem "1"
    Entao validar o status code 200
