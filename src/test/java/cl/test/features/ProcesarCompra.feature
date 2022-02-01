@run
Feature: Procesar compra

  @TestKey=01 @todo
  Scenario: Iniciar Compra
    Given Ingresando al portal de compras
    When Agrego al carro de compras un "iPod Classic"
    And Agrego al carro de compras un "iMac"
    Then Procedo a realizar la compra
    And Inicio sesion
    And Continuo con la compra
    And Valido la orden completa
    Then Selecciono la opcion en el header "Order History"
    And Valido el resumen de la orden
    And Cierro sesion
