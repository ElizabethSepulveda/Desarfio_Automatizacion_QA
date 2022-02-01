@run
Feature: Registrar Usuario en Tienda Online

  @TestKey=02 @todo
  Scenario: Registro de Usuario
    Given Ingresando al portal de compras
    When Ingreso a la pagina de registrar usuario
    And Ingreso los datos personales
    And Ingreso password
    And Me suscribo a noticias
    And Acepto la politica de privacidad
    Then Registro de forma exitosa
    And Registro una direccion en el libro
    And Cierro sesion