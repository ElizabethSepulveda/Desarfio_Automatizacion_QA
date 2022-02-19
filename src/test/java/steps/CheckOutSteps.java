package steps;

import java.io.IOException;

import cucumber.api.java.en.And;
import pages.CheckOutPage;

public class CheckOutSteps {

    CheckOutPage checkout = new CheckOutPage();

    @And("^realizo creacion de cuenta y envio de compra$")

    public void createAccountOpencart() throws IOException {

        checkout.clickRegisterAccount();
        checkout.registerAccount();

    }

}
