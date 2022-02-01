# file: features/tests/flujo1.feature
# ----------------------------------------------------------------------------
# FEATURE 
# ----------------------------------------------------------------------------

Feature: Flujo 1 - Agregar Objeto al carrito y Pagar

    flujo1
    @flujo1
    Scenario Outline: Flujo 1
        # Abrir URL
        Given   Estoy en la pagina principal
      
        # Buscar el articulo
        And     Busco el articulo "<articulo>"
        # Añado articulo al carrito
        And     Agrego el articulo al carrito
        # Confirmo que se agrego
        And     Aparece el mensaje de confirmación
   Examples: data_prueba.xlsx | Flujo1