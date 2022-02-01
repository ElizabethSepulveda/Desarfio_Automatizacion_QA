package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy (xpath = "//h1[contains(text(),'Search')]")
    private WebElement tituloSearch;

    @FindBy (xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addProductCarro;

    @FindBy (xpath = "//h4/a")
    private WebElement tituloProducto;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickAgregarProducto(){
        isVisible(addProductCarro);
        addProductCarro.click();
    }

    public boolean isVisibleProducto(String texto) {
        By element = By.xpath(String.format("//h4/a[contains(text(),'%s')]", texto));
        return isVisible((WebElement) element);
    }

    public String getTituloProducto() {
        isVisible(tituloProducto);
        return tituloProducto.getText();
    }

}
