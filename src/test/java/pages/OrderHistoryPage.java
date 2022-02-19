package pages;

public class OrderHistoryPage extends BasePage {

    private String myAccountButton = "//span[contains(text(),'My Account')]";
    private String OrderHistoryOption = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]";
    private String viewOrderHistorybuttton = "//tbody/tr[1]/td[7]/a[1]/i[1]";
    private String logoutButton = "//*[@id='column-right']/div/a[13]";
    private String continueLogoutButton = "//*[@id='content']/div/div/a";

    public OrderHistoryPage() {
        super(driver);

    }

    public void viewOrderHistory() {

        clickElement(myAccountButton);
        clickElement(OrderHistoryOption);
        clickElement(viewOrderHistorybuttton);
        

    }

    public void closeOrderHistory(){
        clickElement(logoutButton);
        clickElement(continueLogoutButton);
    }

}
