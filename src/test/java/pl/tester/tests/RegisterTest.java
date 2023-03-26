package pl.tester.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.tester.pages.HomePage;


public class RegisterTest extends BaseTest {


    @Test
    public void registerUserTest() {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test" + random + "@gmail.com", "test.test123")
                .getDashboardLink();
        Assert.assertTrue(dashboardLink.isDisplayed());
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test@gmail.com", "test.test123")
                .getError();
        Assert.assertTrue(error.getText().contains("Error: An account is already registered with your email address. Please log in."));
    }
}
