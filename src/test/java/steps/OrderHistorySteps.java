package steps;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import io.cucumber.java.en.And;

public class OrderHistorySteps extends BaseSteps{
    
    @And("^Valido que el estado de la orden sea (.+)$")
    public void validateOrderInOrderHistory(String status) throws FileNotFoundException {
        checkout.goToOrderHistory();
        assertTrue("El estado de la orden es diferente a Pendiente", orderHistory.getStatusOrder().equals(status));
    }
}
