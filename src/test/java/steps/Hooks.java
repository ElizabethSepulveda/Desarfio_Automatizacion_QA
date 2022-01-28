package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    /**
     * Método para generár evidencia mediantes screenshots y agregarlas al reporte.
     * 
     * @param scenario Escenario al cual se le sacará evidencia.
     */
    @AfterStep
    public void takeEvidence(Scenario scenario) {
        final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", "Imagen de evidencia");
    }
}
