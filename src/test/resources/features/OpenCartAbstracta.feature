 @test
Feature: Probar funcionalidades del sitio opencartabstracta.us

   
    Scenario Outline: Scenario Outline name: Agregar productos al carrito de compras

        Given navego al sitio web
        When hago click en la barra de busqueda
        And ingreso el <product> en la barra de busqueda
        And agrego el producto al carro de compras
        Then valido que el producto haya sido agredado al carro de compras

        Examples:
            | product      |
            | Ipod Classic |
            | Imac         |

   
    Scenario: Realizar compra de productos desde el carrito de compras

        Given ingreso al carrito de compras
        When hago click en boton checkout
        And realizo creacion de cuenta y envio de compra
        And reviso el historial de ordenes
        

