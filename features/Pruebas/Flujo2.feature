# file: features/tests/flujo01.feature
# ----------------------------------------------------------------------------
# FEATURE 
# ----------------------------------------------------------------------------

Feature: Flujo 2 - Revisar el carrito y comprar
    flujo2
    @flujo2
    Scenario Outline: Flujo 2
        # Ingreso al carrito de compras y verifico los articulos
        When    Ingreso al carrito de compras
        Then    Verifico que el articulo se agrego al carrito "<articulo>"


   Examples: data_prueba.xlsx | Flujo1