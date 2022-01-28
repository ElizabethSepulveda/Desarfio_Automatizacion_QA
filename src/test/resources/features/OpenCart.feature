Feature: Poder realizar compras en OpenCart.

    @CompraConLogin
    Scenario Outline: Como usuario ya registrado, quiero poder comprar dos productos
        Given Navego a la pagina <url>
        And Busco el producto <productoUno>
        And Agrego el producto al carro
        And Busco el producto <productoDos>
        And Agrego el producto al carro
        When Valido que el Producto <productoUno> y el <productoDos> esten en el carro
        When Inicio proceso de checkout
        And Hago login con usuario
        And Valido Billing details
        And Valido Delivery details
        And Valido Delivery Methods
        When Acepto el Payment Method
        And Confirmo la orden y valido <shippingMethod>
        And Valido que el estado de la orden sea <status>
        And Valido direccion de usuario corresponda a la direccion de pago
        Then Cierro sesion

        Examples:
            | url                           | productoUno  | productoDos | shippingMethod             | status  |
            | https://opencart.abstracta.us | Ipod Classic | Imac        | Flat Shipping Rate - $5.00 | Pending |

    @CompraRegistrarCuenta
    Scenario Outline: Como usuario ya registrado, quiero poder comprar dos productos
        Given Navego a la pagina <url>
        And Busco el producto <productoUno>
        And Agrego el producto al carro
        And Busco el producto <productoDos>
        And Agrego el producto al carro
        When Valido que el Producto <productoUno> y el <productoDos> esten en el carro
        When Inicio proceso de checkout
        And Creo cuenta para nuevo usuario
        And Valido Delivery details
        And Valido Delivery Methods
        When Acepto el Payment Method
        And Confirmo la orden y valido <shippingMethod>
        And Valido que el estado de la orden sea <status>
        And Valido direccion de usuario corresponda a la direccion de pago
        Then Cierro sesion

        Examples:
            | url                           | productoUno  | productoDos | shippingMethod             | status  |
            | https://opencart.abstracta.us | Ipod Classic | Imac        | Flat Shipping Rate - $5.00 | Pending |

    @CompraCinema
    Scenario Outline: Como usuario ya registrado, quiero poder comprar un Apple Cinema 30
        Given Navego a la pagina <url>
        And Busco el producto <producto>
        When Veo el detalle del producto
        And Configuro el producto
        And Compro el producto
        Then Valido el mensaje

        Examples:
            | url                           | producto        |
            | https://opencart.abstracta.us | Apple Cinema 30 | 