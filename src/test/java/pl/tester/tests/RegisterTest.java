package pl.tester.tests;

import org.testng.annotations.Test;
import pl.tester.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest(){
        new HomePage(driver).openMyAccountPage()
                .registerUser("testowekonto1234@test.com", "testowekonto1234password");
    }
}
