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
                .loginValidDate("test2@gmail.com", "test.test123")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

//    @Test
//    public void logInWithInvalidDataTest() {
//        WebElement error = new HomePage(driver)
//                .openMyAccountPage()
//                .loginInvalidDate("test2testx@test.pl", "test.tes123t123")
//                .getError();
//
//        Assert.assertTrue(error.getText().contains("Incorrect username or password."));
//    }
}
