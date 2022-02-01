package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Your Store')]")
    private WebElement tituloHome;

    @FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
    private WebElement mensajeExito;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleMensajeExito() {
        isVisible(mensajeExito);
        return mensajeExito.isEnabled();
    }

    public boolean isVisibleTituloHome() {
        isVisible(tituloHome);
        return tituloHome.isEnabled();
    }
}
