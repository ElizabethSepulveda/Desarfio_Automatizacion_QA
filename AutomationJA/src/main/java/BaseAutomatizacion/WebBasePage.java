package BaseAutomatizacion;
import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebBasePage {

    public static WebDriver driver;
    public WebBasePage(){this.driver = Hooks.driver;}

    public WebElement iniciarElemento(By locator) throws InterruptedException {
        WebElement we;
        if(esVisibleElemento(locator)){
            we = driver.findElement(locator);
        }else{
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            we= driver.findElement(locator);
        }
        return we;
    }

    public WebElement iniciarElementoSimple(By locator){
            return driver.findElement(locator);
    }

    public WebElement iniciarElementoConEsperaEspecifica(By locator,int segundos) throws InterruptedException {
        WebElement we;
        if(esVisibleElemento(locator)){
            we = driver.findElement(locator);
        }else{
            WebDriverWait wait = new WebDriverWait(driver, segundos);
            we= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        return we;
    }

    public void ingresarTexto(By locator,String texto) throws InterruptedException {
        WebElement we = iniciarElemento(locator);
        we.clear();
        we.sendKeys(texto);
        esperarSegundos(2);
    }

    public String obtenerTexto (WebElement we){return we.getText();}

    public boolean validarTextoElemento(WebElement we,String textoAValidar){
        boolean validacion = false;
        String textoWebElement = obtenerTexto(we);
        if(textoWebElement.contains(textoAValidar)){validacion =true;}
        return validacion;
    }

    public void arrastrarElemento(By locatorInicio,By locatorFin) throws InterruptedException {
        Actions act=new Actions(driver);
        WebElement weArrastrar =iniciarElemento(locatorInicio);
        WebElement weSoltar= iniciarElemento(locatorFin);
        act.dragAndDrop(weArrastrar,weSoltar).build().perform();
    }

    public void esperarSegundos(int segundos) throws InterruptedException {
        Thread.sleep(segundos);
    }

    public boolean esVisibleElemento(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public WebElement busquedaDeElementoConEspera(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return we;
    };

    public void scrollVerticalBajo(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
    }




}
