 
# Localizadores de los elementos web
 
input_busqueda = {"locator_type": "name",
                    "locator": "search"}
                    
carrito = {"locator_type": "xpath",
               "locator": "/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button[1]"}

mensaje_exito = {"locator_type": "class",
                    "locator": "alert-success"}
                    
cart_total = {"locator_type": "xpath",
                    "locator": "/html/body/nav/div/div[2]/ul/li[4]/a/span"}

elemento_en_el_carrito = {"locator_type": "xpath",
                         "locator": "//td[contains(.,'producto')]"}

checkout = {"locator_type": "xpath",
                         "locator": "/html/body/div[2]/div/div/div[3]/div[2]/a"}

# login
input_username = {"locator_type": "id",
                      "locator": "input-payment-email"}

input_password = {"locator_type": "id",
                      "locator": "input-payment-password"}

boton_login = {"locator_type": "xpath",
                   "locator": "/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a"}

# registro de usuario
registrar_cuenta = {"locator_type": "xpath",
                       "locator": "/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[1]/label/input"}
continuar_registrar_cuenta = {"locator_type": "id",
                       "locator": "button-account"}
nombre = {"locator_type": "name",
                       "locator": "firstname"}
apellido = {"locator_type": "name",
                       "locator": "lastname"}
direccion = {"locator_type": "name",
                       "locator": "address_1"}
telefono = {"locator_type": "name",
                       "locator": "telephone"}
ciudad = {"locator_type": "name",
                       "locator": "city"}
codigo_postal = {"locator_type": "name",
                       "locator": "postcode"}
pais = {"locator_type": "id",
                       "locator": "input-payment-country"}
pais_seleccionado = {"locator_type": "xpath",
                         "locator": "/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[6]/select/option[contains(.,'opcion')]"}

region = {"locator_type": "name",
                       "locator": "zone_id"}
region_seleccionada = {"locator_type": "xpath",
                       "locator": "/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[7]/select/option[contains(.,'opcion1')]"}

confirmar_password = {"locator_type": "name",
                       "locator": "confirm"}

check_terminos = {"locator_type": "name",
                       "locator": "agree"}

boton_registro = {"locator_type": "id",
                       "locator": "button-register"}

confirmar_envio = {"locator_type": "id",
                       "locator": "button-shipping-address"}

descuento_aplicado = {"locator_type": "xpath",
                       "locator": "//label[contains(.,'Flat Shipping Rate - $5.00')]"}

confirmar_descuento = {"locator_type": "id",
                       "locator": "button-shipping-method"}

confirmar_pago = {"locator_type": "id",
                       "locator": "button-payment-method"}

monto_total = {"locator_type": "xpath",
                       "locator": "//td[contains(.,'$205.00')]"}

confirmar_compra = {"locator_type": "id",
                       "locator": "button-confirm"}
                       
mi_cuenta = {"locator_type": "xpath",
                       "locator": "/html/body/nav/div/div[2]/ul/li[2]/a/span[1]"}
                                              
campo_email_login = {"locator_type": "id",
                       "locator": "input-email"}

campo_password_login = {"locator_type": "id",
                       "locator": "input-password"}

historial_cuenta = {"locator_type": "xpath",
                       "locator": "/html/body/div[2]/div/div/p[2]/a[2]"}

verificar_compra_pendiente =  {"locator_type": "xpath",
                       "locator": "//td[contains(.,'Pending')]"}

detalle_compra =  {"locator_type": "xpath",
                       "locator": "/html/body/div[2]/div/div/div[1]/table/tbody/tr/td[7]/a"}
