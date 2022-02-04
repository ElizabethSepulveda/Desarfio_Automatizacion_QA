package BaseAutomatizacion;

import org.openqa.selenium.WebDriver;


public class CreateDriver {

    private static CreateDriver instancia = null;

    private CreateDriver() {
        CreateDriver.iniciarDriver();
    }

    public static CreateDriver getInstancia() {
        if (instancia == null) {
            instancia = new CreateDriver();
        }
        return instancia;
    }

    public static WebDriver iniciarDriver(){
        WebDriver driver;
        driver = WebDriverFactory.createNewWebDriver();
        return driver;
    }
}
