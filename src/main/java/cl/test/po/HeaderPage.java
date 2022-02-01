package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage {

    @FindBy (xpath = "//a/span[contains(text(),'My Account')]")
    private WebElement botonMyAccount;

    @FindBy (xpath = "//header/..//input[@name='search']")
    private WebElement inputSearch;

    @FindBy (xpath = "//button[@type='button' and @class='btn btn-default btn-lg']/i")
    private WebElement botonLupaSearch;

    @FindBy (xpath = "//button/..//span[@id='cart-total']")
    private WebElement botonCarroTotal;

    @FindBy (xpath = "//strong[i[@class='fa fa-share']]")
    private WebElement botonCheckout;

    @FindBy (xpath = "//strong[i[@class='fa fa-shopping-cart']]")
    private WebElement botonViewCart;

    @FindBy (xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    private WebElement mgsLogout;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysInputSearch(String input) {
        isVisible(inputSearch);
        inputSearch.clear();
        inputSearch.sendKeys(input);
    }

    public void clickBotonLupaSearch() {
        isVisible(botonLupaSearch);
        botonLupaSearch.click();
    }

    public void clickBotonCarTotal() {
        isVisible(botonCarroTotal);
        botonCarroTotal.click();
    }

    public void clickBotonCheckOut() {
        isVisible(botonCheckout);
        botonCheckout.click();
    }

    public void clickBotonMyAccount(){
        isVisible(botonMyAccount);
        botonMyAccount.click();
    }

    public void sendKeysSelectNombreOpcion(String opcion){
        isVisible(botonMyAccount);
        List<WebElement> opcionList = botonMyAccount.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'"+opcion+"')]"));
        for(WebElement element : opcionList){
            if (element.getText().contains(opcion)){
                element.click();
            }
        }
    }

    public boolean isVisibleMensajeLogout() {
        isVisible(mgsLogout);
        return mgsLogout.isEnabled();
    }
}
