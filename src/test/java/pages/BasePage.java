package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;
    

    static {
        
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
        
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void navigateTo(String url){ 
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    public void write (String locator , String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
        
    }

    public void selectFromDropdownByText(String locator, String TextToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(TextToSelect);

        
    }


    public boolean elementIsDisplayed(String locator){
        return find(locator).isDisplayed();
    }



    
  


}
