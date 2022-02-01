package cl.test.utils;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: controlador central de webdriver chrome driver, manejador automatico
 *
 * */

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends ChromeDriver {
	
	protected static WebDriver driver;
	protected static Logger logger = Logger.getLogger(ChromeBrowser.class);

    public static WebDriver buildChromeBrowser() throws Throwable {
        logger.info("inicializando webdriver automaticamente");

    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();

        /* //Usar en caso de ser necesario
    	ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--window-size=1440,808");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-gpu");
        options.addArguments("headless");
        */

        return driver;
    }

    private ChromeBrowser(){
        super();
    }
}