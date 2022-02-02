@PruebaSelenium @CompraProducto

  Feature: Compra Producto

    @PruebaSeleniumPrevired
    Scenario: descripcion prueba
      Given ingreso a pagina opencart y busco producto "ipod classic"
      And lo agrego al carrito de compras y tambien agrego producto "imac"
      And ingreso al carrito de compras y creo una cuenta nueva
      And continuo con la compra hasta completar la orden
      When valido los datos de la compra en el historial de ordenes
      Then cierro sesion
