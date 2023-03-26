package pl.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.tester.models.Customer;
import pl.tester.pages.HomePage;
import pl.tester.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {


    @Test
    public void checkoutTest() {
        Customer customer = new Customer();
        customer.setEmail("specyficzny@gmail.com");

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAdressDetails(customer, "some random comment");
        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
