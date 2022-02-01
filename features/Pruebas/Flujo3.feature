# file: features/tests/flujo01.feature
# ----------------------------------------------------------------------------
# FEATURE 
# ----------------------------------------------------------------------------

Feature: Flujo 3 - Crear la cuenta y comprar
    flujo3
    @flujo3
        Scenario Outline: Flujo 3
        # Compro los articulos
        Given    Compro los articulos
        When     Continuo para registrar cuenta
        And      Registro los datos "<Nombre>, <Apellido>, <Direccion>, <Correo>, <Telefono>, <Ciudad>, <Codigo_Postal>, <Clave>"
        And      Ingreso el pais "<Pais>"
        And      Ingreso la region "<Region>"
        And      Acepto los termino y condiciones
        And      Finalizo el registro
        And      Confirmo la direccion de envio
        And      Verifico el descuento de envío
        Then     Confirmo descuento de envío
        And      Acepto los termino y condiciones
        And      Confirmar el pago
        And      Confirmar monto total de la orden
        And      Confirmar la compra
        #And      Ingresar a la cuenta
        And      Ingresar al Historial de la Compra
        And      Verificar compra pendiente
        And      Visualizar detalle de la compra

        #Then     Ingresar al Historial de la Compra "<Correo>, <Clave>"

   Examples: data_prueba_1.xlsx | Flujo1