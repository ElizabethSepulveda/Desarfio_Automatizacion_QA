package pages;

public class OrderHistoryPage extends BasePage {

    private String btnOrderView = "//a[@class='btn btn-info']";
    private String tableOrderHistory = "//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody/";

    public OrderHistoryPage() {
        super(driver);
    }

    /**
     * Método que lleva a ver la información de la primera orden en el listado.
     */
    public void goToOrderView() {
        clickElement(btnOrderView);
    }

    /**
     * Método para devolver el valor del estado de la orden.
     * 
     * @return el estado de la orden.
     */
    public String getStatusOrder() {
        String status = "";
        status = getValueFromTable(tableOrderHistory, 1, 4);
        return status;
    }
}
