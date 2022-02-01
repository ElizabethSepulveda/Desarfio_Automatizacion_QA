package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderHistoryPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Account')]")
    private WebElement tituloOrderHistory;

    @FindBy(xpath = "//tbody/..//tr[1]/td[contains(text(),'Pending')]")
    private WebElement statusPending;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]")
    private WebElement botonViewResumen;

    @FindBy(xpath = "//td[contains(text(),'Order Details')]")
    private WebElement tituloOrderDetails;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleTituloOrderHistory() {
        isVisible(tituloOrderHistory);
        return tituloOrderHistory.isEnabled();
    }

    public boolean isVisibleStatusPending(){
        isVisible(statusPending);
        return statusPending.isEnabled();
    }

    public void clickBotonViewResumen() {
        isVisible(botonViewResumen);
        botonViewResumen.click();
    }

    public boolean isVisibleTituloOrderDetails(){
        isVisible(tituloOrderDetails);
        return tituloOrderDetails.isEnabled();
    }
}
