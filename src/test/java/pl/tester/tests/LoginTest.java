package pl.tester.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.tester.pages.HomePage;


public class LoginTest extends BaseTest {


    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .loginValidDate("test1@test.pl", "test1@test12")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidDate("test1@test.pl", "test.tes123t123")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."));
    }
}
