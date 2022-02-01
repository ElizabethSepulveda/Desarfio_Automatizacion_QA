# file: features/steps/st_flujo01.py
# ----------------------------------------------------------------------------
# STEPS:
# ----------------------------------------------------------------------------
from ssl import ALERT_DESCRIPTION_CERTIFICATE_UNOBTAINABLE
from behave import step
from Core.Excel import getDataframe

import string, random
import Locators.localizadores as LC
import TestData.datos_prueba as TD

@step('Estoy en la pagina principal')
def step_impl(context):
    assert context.browser.goToURL(TD.URL) is True

@step('Busco el articulo "{articulo}"')
def step_impl(context, articulo):
    assert context.browser.setInputToElement(LC.input_busqueda, articulo + context.browser.getKeys().ENTER, timer=10, wait=0.25, printer=True) is True

@step('Agrego el articulo al carrito')
def step_impl(context):
    assert context.browser.scrollToElement(LC.carrito, timer=10, wait=0.25, printer=True) is True
    assert context.browser.clickToElement(LC.carrito, timer=10, wait=0, printer=True) is True

@step('Aparece el mensaje de confirmación')
def step_impl(context):
    assert context.browser.getElement(LC.mensaje_exito, timer=10, wait=0.25, printer=True) is not None
    context.flagEvidencia=True

@step('Ingreso al carrito de compras')
def step_impl(context):
    assert context.browser.clickToElement(LC.cart_total, timer=10, wait=0.50, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Verifico que el articulo se agrego al carrito "{articulo}"')
def step_impl(context, articulo):
    LC.elemento_en_el_carrito["locator"] = str(LC.elemento_en_el_carrito["locator"]).replace("producto", articulo)
    assert context.browser.getElement(LC.elemento_en_el_carrito, timer=10, wait=0.25, printer=True) is not None
    #reemplazo el valor de la variable producto
    LC.elemento_en_el_carrito["locator"] = str(LC.elemento_en_el_carrito["locator"]).replace (articulo, "producto")

@step('Compro los articulos')
def step_impl(context):
    assert context.browser.clickToElement(LC.checkout, timer=10, wait=0.50, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Continuo para registrar cuenta')
def step_impl(context):
    assert context.browser.clickToElement(LC.registrar_cuenta, timer=10, wait=0.25, printer=True) is True
    assert context.browser.clickToElement(LC.continuar_registrar_cuenta, timer=10, wait=1, printer=True) is True

@step('Registro los datos "{Nombre}, {Apellido}, {Direccion}, {Correo}, {Telefono}, {Ciudad}, {Codigo_Postal}, {Clave}"')
def step_impl(context, Nombre, Apellido, Direccion, Correo, Telefono, Ciudad, Codigo_Postal, Clave):
    if Correo == 'randon':
        length_of_string = 8
        Correo=(''.join(random.choice(string.ascii_letters + string.digits) for _ in range(length_of_string))) + '@mail.com'

    assert context.browser.setInputToElement(LC.nombre, Nombre, timer=10, wait=1, printer=True) is True
    assert context.browser.setInputToElement(LC.apellido, Apellido, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.direccion, Direccion, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.input_username, Correo, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.telefono, Telefono, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.ciudad, Ciudad, timer=10, wait=0.25, printer=True) is True    
    assert context.browser.setInputToElement(LC.codigo_postal, Codigo_Postal, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.input_password, Clave, timer=10, wait=0.25, printer=True) is True
    assert context.browser.setInputToElement(LC.confirmar_password, Clave, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Ingreso el pais "{Pais}"')
def step_impl(context, Pais):
    LC.pais_seleccionado["locator"] = str(LC.pais_seleccionado["locator"]).replace("opcion", Pais)
    assert context.browser.clickToElement(LC.pais, timer=10, wait=0.25, printer=True) is True
    assert context.browser.clickToElement(LC.pais_seleccionado, timer=10, wait=0.25, printer=True) is not None

@step('Ingreso la region "{Region}"')
def step_impl(context, Region):
    LC.region_seleccionada["locator"] = str(LC.region_seleccionada["locator"]).replace("opcion1", Region)
    assert context.browser.clickToElement(LC.region, timer=10, wait=1.50, printer=True) is True
    assert context.browser.clickToElement(LC.region_seleccionada, timer=10, wait=0.25, printer=True) is not None

@step('Ingreso el email "{Correo}"')
def step_impl(context, Correo):
    assert context.browser.setInputToElement(LC.input_username, Correo, timer=10, wait=2, printer=True) is True


@step('Ingreso la clave "{Clave}"')
def step_impl(context, Clave):
    assert context.browser.setInputToElement(LC.input_password, Clave, timer=10, wait=0.25, printer=True) is True
    context.flagEvidencia=True

@step('Acepto los termino y condiciones')
def step_impl(context):
    assert context.browser.scrollToElement(LC.check_terminos, timer=10, wait=0.25, printer=True) is True
    assert context.browser.clickToElement(LC.check_terminos, timer=10, wait=2, printer=True) is True
    context.flagEvidencia=True

@step('Finalizo el registro')
def step_impl(context):
    assert context.browser.clickToElement(LC.boton_registro, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(3)
    context.flagEvidencia=True


@step('Doy click al botón de Login')
def step_impl(context):
    assert context.browser.clickToElement(LC.boton_login, timer=10, wait=0.25, printer=True) is True

@step('Confirmo la direccion de envio')
def step_impl(context):
    assert context.browser.clickToElement(LC.confirmar_envio, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Verifico el descuento de envío')
def step_impl(context):
    assert context.browser.getElement(LC.descuento_aplicado, timer=10, wait=0.25, printer=True) is not None
    context.browser.wait(1)

@step('Confirmo descuento de envío')
def step_impl(context):
    assert context.browser.clickToElement(LC.confirmar_descuento, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Confirmar el pago')
def step_impl(context):
    assert context.browser.clickToElement(LC.confirmar_pago, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Confirmar monto total de la orden')
def step_impl(context):
    assert context.browser.getElement(LC.monto_total, timer=10, wait=0.25, printer=True) is not None
    context.browser.wait(2)
    context.flagEvidencia=True

@step('Confirmar la compra')
def step_impl(context):
    assert context.browser.clickToElement(LC.confirmar_compra, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(1)
    context.flagEvidencia=True

@step('Ingresar al Historial de la Compra')
def step_impl(context):
    assert context.browser.clickToElement(LC.historial_cuenta, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(2)
    context.flagEvidencia=True


@step('Verificar compra pendiente')
def step_impl(context):
    assert context.browser.getElement(LC.monto_total, timer=10, wait=0.25, printer=True) is not None
    context.browser.wait(2)
    context.flagEvidencia=True

@step('Visualizar detalle de la compra')
def step_impl(context):
    assert context.browser.clickToElement(LC.detalle_compra, timer=10, wait=0.25, printer=True) is True
    context.browser.wait(20)
    context.flagEvidencia=True

