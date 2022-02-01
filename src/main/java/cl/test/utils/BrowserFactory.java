package cl.test.utils;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: habilitador de chrome browser
 *
 * */


import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName =  System.getProperty("browser", "chrome");
        WebDriver desiredBrowser = null;
        switch (desiredBrowserName){
            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser();
                break;
            default:
                // TODO: 20/01/2022
                break;
        }
        return desiredBrowser;
    }
}
