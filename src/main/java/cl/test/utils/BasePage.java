package cl.test.utils;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: Base principal para POM y PageFactory
 *
 * */

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected Logger log = LogManager.getLogger(this.getClass());
    protected WebDriver driver;
	private WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected void waitForElementToAppear(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement locator) {
        this.wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForTextToDisappear(WebElement locator, String text) {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }

    protected boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException var4) {
            return false;
        } catch (Exception var5) {
            this.log.error(var5);
            return false;
        }
    }

    protected boolean isInvisible(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException var3) {
            return true;
        }
    }

    protected void validateElement (WebElement element) {
        try {
            if (element.isEnabled()) {
                element.isDisplayed();
                element.clear();
                this.log.error("El elemento existe y es visible.");
            } else {
                this.log.error("El elemento no existe y no es visible.");
            }
        } catch (NoSuchElementException e) {
            this.log.error("El elemento no está visible y requiere su revisión " +e);
        }
        return;
    }

    protected void waitFor(int segundos) {
        try {
            this.log.debug("Esperando por " + segundos + " segundos");
            this.log.warn("Usar con precaución!!");
            Thread.sleep((long)(segundos * 1000));
        } catch (InterruptedException var3) {
            this.log.error(var3);
        }

    }

    public void scrollEndPage() {
        try {
            this.log.debug("Realizando un scroll hasta el final de la pagina");
            this.log.warn("Usar con precaución!!");
            JavascriptExecutor js = (JavascriptExecutor)this.driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception var2) {
            this.log.error(var2);
        }

    }

    public byte[] takeScreenshot() {
        return (byte[])((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
    }
    
    public void getUrl(String urlPage) {
    	if (this.driver != null) {
			this.driver.get(urlPage);
		}
		return;
	}

}