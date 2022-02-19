package steps;

import java.io.IOException;

import cucumber.api.java.en.And;
import pages.OrderHistoryPage;

public class OrderHistorySteps {

    

    OrderHistoryPage order = new OrderHistoryPage();

    @And("^reviso el historial de ordenes$")
    public void viewOrderDetails() throws IOException {
        order.viewOrderHistory();
        String dir = System.getProperty ("user.dir");
        order.takeScreenshot((dir +"\\test-output\\Screenshots_test\\Evidence_Order_History.png"));
        order.closeOrderHistory();

    
    }

}
