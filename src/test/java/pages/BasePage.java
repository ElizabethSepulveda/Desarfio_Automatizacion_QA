package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    /**
     * Configuraciones base para el ChromeDriver.
     * 
     */
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setCapability("chrome.switches", Arrays.asList("--disable-web-security"));
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Método constructor de la clase, se inicializa el driver
     * 
     * @param driver
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    /**
     * Método para cerrar la instancia del navegador.
     */
    public static void closeBrowser() {
        driver.quit();
    }

    /**
     * Método para navegar a una URL.
     * 
     * @param url dirección absoluta de URL.
     */
    public static void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Método para encontrar un WebElement identificandolo por XPATH.
     * Tiene una espera explicita de 10 segundos, pero se hace implicita para todo
     * el Framework.
     * Nos ahorramos hacer los ImplicitlyWait en cada elemento.
     * 
     * @param locator xpath del WebElement.
     * @return el WebElement que fue buscado.
     */
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Método que sirve para hacer click en un WebElement.
     * 
     * @param locator xpath del WebElement.
     */
    public void clickElement(String locator) {
        find(locator).click();
    }

    /**
     * Método para escribir un texto en un campo input.
     * 
     * @param locator     xpath del WebElement.
     * @param textToWrite texto que se escribe en el campo input.
     */
    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    /**
     * Método para seleccionar un elemento desde un Dropdown, pasando el value.
     * 
     * @param locator       xpath del WebElement.
     * @param valueToSelect value del elemento que queremos seleccionar.
     */
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    /**
     * Método para seleccionar un elemento desde un Dropdown, pasando el index.
     * 
     * @param locator       xpath del WebElement.
     * @param valueToSelect index del elemento que queremos seleccionar.
     */
    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    /**
     * Método para seleccionar un elemento desde un Dropdown, pasando el texto.
     * 
     * @param locator       xpath del WebElement.
     * @param valueToSelect texto del elemento que queremos seleccionar.
     */
    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    /**
     * Método para pasar el puntero por sobre un elemento.
     * 
     * @param locator xpath del WebElement.
     */
    public void hoverOverElement(String locator) {
        action.moveToElement(find(locator));
    }

    /**
     * Método para realizar un doble click sobre un elemento.
     * 
     * @param locator xpath del WebElement.
     */
    public void doubleClick(String locator) {
        action.doubleClick(find(locator));
    }

    /**
     * Método para hacer click derecho sobre un elemento.
     * 
     * @param locator xpath del WebElement.
     */
    public void rightClick(String locator) {
        action.contextClick(find(locator));
    }

    /**
     * Método para cambiar a un Iframe.
     * 
     * @param iFrameIndex index del Iframe al que queremos cambiar.
     */
    public void switchToIframe(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    /**
     * Método para volver al Iframe padre.
     */
    public void switchToParentIframe() {
        driver.switchTo().parentFrame();
    }

    /**
     * Método para cerrar un popup.
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Método que retorna el texto que contiene un elemento.
     * 
     * @param locator xpath del WebElement.
     * @return texto que contiene el elemento.
     */
    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    /**
     * Método retorna True si el elemento esta disponible, o False si no esta
     * disponible.
     * 
     * @param locator xpath del WebElement.
     * @return True si el elemento esta disponible, o False si no esta disponible.
     */
    public boolean elementEnabled(String locator) {
        return find(locator).isEnabled();
    }

    /**
     * Método retorna True si el elemento se esta mostrando, o False si no se esta
     * mosrtano.
     * 
     * @param locator xpath del WebElement.
     * @return True si el elemento se esta mostrando, o False si no se esta
     *         mosrtano.
     */
    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    /**
     * Método retorna True si el elemento esta seleccionado, o False si no esta
     * seleccionado.
     * 
     * @param locator xpath del WebElement.
     * @return True si el elemento esta seleccionado, o False si no esta
     *         seleccionado.
     */
    public boolean elementIsSelected(String locator) {
        return find(locator).isSelected();
    }

    /**
     * Método retorna un listado de WebElements.
     * 
     * @param locator xpath del WebElement.
     * @return listado de WebElements.
     */
    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * Método para obtener el texto de una celda especifica de una tabla
     * 
     * @param locator xpath del WebElement de la tabla.
     * @param row     número de fila.
     * @param column  número de columna.
     * @return el texto que contiene la celda.
     */
    public String getValueFromTable(String locator, Integer row, Integer column) {
        String cellINeed = locator + "tr[" + row + "]/td[" + column + "]";
        return find(cellINeed).getText();
    }
}
