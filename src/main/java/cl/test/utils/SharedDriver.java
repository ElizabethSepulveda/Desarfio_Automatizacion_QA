package cl.test.utils;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: cierre de webdriver
 *
 * */

import static cl.test.utils.BrowserFactory.getBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedDriver extends EventFiringWebDriver {
	
    public static final WebDriver REAL_DRIVER;
    public static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
        try {
            REAL_DRIVER = getBrowser();
        } catch (Throwable throwable) {
            throw new Error(throwable);
        }
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
    
}