package pl.tester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AdressDetailsPage openAddressDetails(){
        proceedToCheckoutButton.click();
        return new AdressDetailsPage(driver);

    }
}
