package BaseAutomatizacion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverFactory {

    private static WebDriverFactory instancia = null;
    public static String dirBrowser = "./src/main/resources/drivers/chromedriver.exe";

    private WebDriverFactory() {
    }

    public static WebDriverFactory getInstancia() {
        if (instancia == null) {
            instancia = new WebDriverFactory();
        }
        return instancia;
    }

    public static WebDriver createNewWebDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver",dirBrowser);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
