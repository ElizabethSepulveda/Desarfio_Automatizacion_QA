# file: Core/Selenium.py
# ----------------------------------------------------------------------------
# CLASE BASE: Contiene todas las interacciones básicas con selenium-webDriver
# ----------------------------------------------------------------------------

import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager


# ----- Información Relevante -----
# -Esta clase sólo contiene las funciones más relevantes de Selenium, si se desea usar una logica más compleja
#  deberá implementarse Selenium puro o una combinación de etos métodos.
# -Todos los métodos con parámetro "timer" buscan un elemento por el tiempo definido en el timer, si el elemento
#  se encuentra, deja de buscar, sino, busca hasta que el timer se acabe. Por defecto es de 10s si no se quiere
#  enviar el argumento en el llamado al método.
# -Todos los métodos con parámetro "wait" esperan el tiempo definido en el wait para ejecutar sus lineas de código.
#  Por defecto es 0.25s si no se quiere enviar el argumento en el llamado al método.
# -Todos los métodos con parámetro "printer" imprimen sus errores para que el log de errores lo capture sólo si
#  el printer es True. Por defecto es True si no se quiere enviar el argumento en el llamado al método.


class Selenium(object):

    def __init__(self):
        self.driver = None

    # convierte las entradas de configuracion (C-U por ejemplo) en valores válidos para el programa
    @staticmethod
    def browserConfiguration(txt):
        # lista de retorno
        ret = []
        # array para el split
        conf = []

        if txt is not None:
            conf = txt.split('-')
            if len(conf) != 2:
                raise Exception('La estructura del modo de ejecución de pruebas no es la correcta: \n' +
                                '   ' + str(txt) + '.\n' +
                                'Ejemplos del modo de ejecución: \n' +
                                '   --define conf=C-U [en Chrome, con UI]\n' +
                                '   --define conf=F-H [en Firefox, Headless (sin IU)]')
        else:
            txt = 'C-U'
            conf = txt.split('-')

        # navegador
        if conf[0] == 'C':
            ret.append('chrome')
        elif conf[0] == 'F':
            ret.append('firefox')
        else:
            raise Exception('La configuración para el navegador debe ser C(chrome) o F(firefox).\n' +
                            'La ingresada es: ' + conf[0] + '.')

        # boolean para headless
        if conf[1] == 'U':
            ret.append(False)
        elif conf[1] == 'H':
            ret.append(True)
        else:
            raise Exception('La configuración para Headless debe ser U(con UI) o H(headless).\n' +
                            'La ingresada es: ' + conf[1] + '.')
        return ret

    # obtiene el tipo de búsqueda de un elemento (por name, por ID, etc.)
    @staticmethod
    def getBytype(locator_type, printer=True):
        if locator_type == 'id':
            return By.ID
        if locator_type == 'name':
            return By.NAME
        if locator_type == 'class':
            return By.CLASS_NAME
        if locator_type == 'link-text':
            return By.LINK_TEXT
        if locator_type == 'xpath':
            return By.XPATH
        if locator_type == 'css':
            return By.CSS_SELECTOR
        if locator_type == 'tag':
            return By.TAG_NAME
        error = 'No existe el tipo de locator', locator_type + '.'
        if printer is True: print(error)
        raise Exception(error)

    # lanza el navegador en base a la configuración establecida
    def launchBrowser(self, browser_type, headless):
        if browser_type == 'firefox':
            options = webdriver.FirefoxOptions()
            options.add_argument('--disable-gpu')
            options.add_argument('--disable-extensions')
            options.add_argument('--ignore-certificate-errors')
            options.add_argument("--log-level=3")

            # si headless es True se va a ejecutar sin UI
            if headless is True:
                options.add_argument('--headless')
                options.add_argument('--no-sandbox')
                options.add_argument('--window-size=1920,1080')
            else:
                options.add_argument('start-maximized')
            self.driver = webdriver.Firefox(executable_path=GeckoDriverManager().install(), firefox_options=options)

        if browser_type == 'chrome':
            options = webdriver.ChromeOptions()
            options.add_argument('--disable-gpu')
            options.add_argument('--disable-extensions')
            options.add_argument('--ignore-certificate-errors')
            options.add_argument("--log-level=3")

            # si headless es True se va a ejecutar sin UI
            if headless is True:
                options.add_argument('--headless')
                options.add_argument('--no-sandbox')
                options.add_argument('--window-size=1920,1080')
            else:
                options.add_argument('start-maximized')
            self.driver = webdriver.Chrome(executable_path=ChromeDriverManager().install(), chrome_options=options)

    # cierra el navegador
    def closeBrowser(self, printer=True):
        try:
            self.driver.close()
            return True
        except Exception as e:
            if printer is True: print('No se pudo cerrar el navegador.', e)
            return False

    # va a la url definida
    def goToURL(self, url, wait=0.25, printer=True):
        time.sleep(wait)
        try:
            self.driver.get(url)
            return True
        except Exception as e:
            if printer is True: print('No se pudo ir a la URL:', url + '.', e)
            return False

    # espera por un tiempo definido a que el titulo de la pestaña sea el esperado
    def waitForTabTittle(self, tittle, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        wait_time = WebDriverWait(self.driver, timer)
        try:
            wait_time.until(EC.title_is(tittle))
            return True
        except Exception as e:
            if printer is True: print('No se pudo obtener el título de pestaña:', tittle + '.', e)
            return False

    # da zoom a la página en el procentaje recibido
    def zoom(self, percent, wait=0.25, printer=True):
        time.sleep(wait)
        try:
            self.driver.execute_script("document.body.style.zoom = '" + str(percent) + "%'")
            return True
        except Exception as e:
            if printer is True: print('No se pudo hacer zoom de:', percent + '%.', e)
        return False

    # da scroll a la pagina en base al x & y recibido,
    # si X es -1, se irá al extremo derecho de la pagina
    # si Y es -1, se irá al extremo derecho de la pagina
    def scroll(self, x=0, y=0, wait=0.25, printer=True):
        time.sleep(wait)
        if y == -1:
            y = 'document.body.scrollHeight'
        else:
            y = str(y)
        if x == -1:
            x = 'document.body.scrollHeight'
        else:
            x = str(x)
        cmd = "window.scroll(" + x + ", " + y + ");"
        try: 
            self.driver.execute_script(cmd)
            return True
        except Exception as e:
            if printer is True: print('No se pudo hacer scroll a', x + ',' + y + '.', e)
        return False

    # se va al top de la página y al lado más izquierdo
    def goToTop(self, wait=0.25, printer=True):
        time.sleep(wait)
        cmd = "window.scrollTo(0, 0);"
        try:
            self.driver.execute_script(cmd)
            return True
        except Exception as e:
            if printer is True: print('No se pudo hacer scroll a 0,0.', e)
        return False

    # busca el elemento del locator por un tiempo timer definido y lo retorna
    # el parametro driver es para buscar dentro de un elemento definido
    def getElement(self, locator, driver=None, timer=10, wait=0.25, printer=True, expected_condition='presence_of_element_located'):
        time.sleep(wait)

        if driver is None:
            driver = self.driver

        locator_type = self.getBytype(locator['locator_type'])
        wait = WebDriverWait(driver, timer)
        ec = self.getExpectedCondition(expected_condition, printer=printer)
        try:
            element_check = wait.until(ec((locator_type, locator['locator'])))
            if element_check is not None:
                return element_check
            else:
                if printer is True: print("El elemento:", locator['locator'], "buscado por:", locator['locator_type'], "no está presente.")
                return None
        except Exception as e:
            if printer is True: print("No se pudo encontrar el elemento:", locator['locator'], "buscado por:", locator['locator_type'] + '.', e)
        return None

    # busca los elementos del locator por un tiempo timer definido y lo retorna
    # el parametro driver es para buscar dentro de un elemento definido
    def getElements(self, locator, driver=None, timer=10, wait=0.25, printer=True, expected_condition='presence_of_all_elements_located'):
        time.sleep(wait)

        if driver is None:
            driver = self.driver

        locator_type = self.getBytype(locator['locator_type'])
        wait = WebDriverWait(driver, timer)
        ec = self.getExpectedCondition(expected_condition, printer=printer)

        try:
            elements_check = wait.until(ec((locator_type, locator['locator'])))
            if elements_check is not None:
                return elements_check
            else:
                if printer is True: print("Los elementos:", locator['locator'], "buscados por:", locator['locator_type'], "no están presentes.")
                return None
        except Exception as e:
            if printer is True: print("No se pudo encontrar los elementos:", locator['locator'], "buscados por:", locator['locator_type'] + '.', e)
        return None

    # obtiene el texto de un elemento (usa la función getElement para obtener el elemento)
    def getTextOfElement(self, locator, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        ele = self.getElement(locator, timer=timer, wait=0, printer=printer)
        try:
            return ele.text
        except Exception as e:
            if printer is True: print('No se pudo obtener el texto del elemento:', locator['locator'] + '.', e)
            return None

    # obtiene un atruibuto de un elemento (usa la función getElement para obtener el elemento)
    def getAttributetOfElement(self, locator, att='value', timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        ele = self.getElement(locator, timer=timer, wait=0, printer=printer)
        try:
            return ele.get_attribute(att)
        except Exception as e:
            if printer is True: print('No se pudo obtener el atributo', att, ' del elemento:',
                                      locator['locator'] + '.', e)
            return None

    # setea el atributo dado de un elemento web
    def setAttributetOfElement(self, locator, att='value', value='0', timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        ele = self.getElement(locator, timer=timer, wait=0, printer=printer)
        try:
            self.driver.execute_script("arguments[0].setAttribute('" + att + "',arguments[1])", ele, value)
            return True
        except Exception as e:
            if printer is True: print('No se pudo cambiar el valor del atributo', att, 'del elemento:',
                                      locator['locator'] + '.', e)
            return False
        


    # hace scroll y lo coloca encime de un elemento (usa la función getElement para obtener el elemento)
    def scrollToElement(self, locator, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        element = self.getElement(locator, timer=timer, wait=wait, printer=printer)
        if element is None:
            return False
        x, y = element.location['x'], element.location['y']
        try:
            cmd = "window.scrollTo(" + str(x) + ", " + str(y) + ");"
            self.driver.execute_script(cmd)
            return True
        except Exception as e:
            if printer is True: print('No se pudo mover el mouse hacia el elemento:', locator['locator'] +
                                      '(posición: ' + str(x) + ',' + str(y) + ').')
            return False

    # da click a un un elemento  (usa la función getElement para obtener el elemento)
    def clickToElement(self, locator, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        button = self.getElement(locator, timer=timer, wait=0, printer=printer, expected_condition='element_to_be_clickable')
        if button is None:
            return False
        try:
            button.click()
            return True
        except Exception as e:
            if printer is True: print('No se pudo dar click al elemento:', locator['locator'] + '.', e)
        return False

    # da click derecho un elemento  (usa la función getElement para obtener el elemento)
    def contextClickToElement(self, locator, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        element = self.getElement(locator, timer=timer, wait=0, printer=printer, expected_condition='element_to_be_clickable')
        if element is None:
            return False
        try:
            webdriver.ActionChains(self.driver).context_click(element).perform()
            return True
        except Exception as e:
            if printer is True: print('No se pudo dar click derecho al elemento:', locator['locator'] + '.', e)
            return False

    # da doble click a un elemento (usa la función getElement para obtener el elemento)
    def doubleClickToElement(self, locator, timer=10, wait=0.25, printer=True):
        time.sleep(wait)
        element = self.getElement(locator, timer=timer, wait=0, printer=printer, expected_condition='element_to_be_clickable')
        if element is None:
            return False
        try:
            webdriver.ActionChains(self.driver).double_click(element).perform()
            return True
        except Exception as e:
            if printer is True: print('No se pudo dar doble click al elemento:', locator['locator'] + '.', e)
            return False

    # inserta el texto al campo de texto (usa la función getElement para obtener el elemento)
    def setInputToElement(self, locator, txt, timer=10, wait=0.25, printer=True):
        if txt == 'nan':
            return True
        time.sleep(wait)
        input_element = self.getElement(locator, timer=timer, wait=0, printer=printer)
        if input_element is not None:
            try:
                input_element.clear()
                input_element.send_keys(txt)
                return True
            except Exception as e:
                if printer is True: print('No se pudo ingresar:', txt, 'al elemento:', locator['locator'] + '.', e)
        return False

    # inserta el texto al campo de texto letra letra (usa la función getElement para obtener el elemento)
    def typeInputToElement(self, locator, txt, timer=10, wait=0.25, wait_between_letters=0.1, printer=True):
        if txt == 'nan':
            return True
        time.sleep(wait)
        input_element = self.getElement(locator, timer=timer, wait=wait, printer=printer)
        if input_element is not None:
            try:
                input_element.clear()
                # perform the operation
                for letter in txt:
                    input_element.send_keys(letter)
                    time.sleep(wait_between_letters)
                return True
            except Exception as e:
                if printer is True: print('No se pudo ingresar:', txt, 'al elemento:', locator['locator'] + '.', e)
        return False

    # devuelve el keys para evitar dobles imports
    @staticmethod
    def getKeys():
        return Keys

    # devuelve el keys para evitar dobles imports
    def getActions(self, driver=None):
        if driver is None:
            return webdriver.ActionChains(self.driver)
        else:
            return webdriver.ActionChains(driver)

    @staticmethod
    def getExpectedCondition(expected_cond, printer=True):
        if expected_cond is None:
            return EC
        elif expected_cond == 'element_to_be_clickable':
            return EC.element_to_be_clickable
        elif expected_cond == 'element_to_be_selected':
            return EC.element_to_be_selected
        elif expected_cond == 'presence_of_all_elements_located':
            return EC.presence_of_all_elements_located
        elif expected_cond == 'presence_of_element_located':
            return EC.presence_of_element_located
        elif expected_cond == 'text_to_be_present_in_element':
            return EC.text_to_be_present_in_element
        elif expected_cond == 'visibility_of_element_located':
            return EC.visibility_of_element_located
        elif expected_cond == 'visibility_of_all_elements_located':
            return EC.visibility_of_all_elements_located
        error = 'No existe el expected condition', expected_cond + '.'
        if printer is True: print(error)
        raise Exception(error)

    @staticmethod
    def wait(wait_time=0.25):
        time.sleep(wait_time)
