package cl.test.stepdef;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: controlador central de webdriver chrome driver
 *
 * */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cl.test.utils.SharedDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {

    private WebDriver driver;

    public Hooks(SharedDriver driver){
        this.driver= driver.getWrappedDriver();
    }

    @Before
    public void beforeHooks(){
        if(driver != null){
            driver.manage().deleteAllCookies();
        }
    }

    @After
    /**
     *
     * Inserta una captura de pantalla en el informe de prueba si la prueba es fallida
     *
     */
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            try {
                scenario.embed(takeScreenshot(), "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) throws InterruptedException {
        Thread.sleep(2000);
        scenario.write(driver.getCurrentUrl());
        scenario.embed(takeScreenshot(), "image/png");
    }

    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
