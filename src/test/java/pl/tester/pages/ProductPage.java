package pl.tester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.tester.utils.SeleniumHelper;

public class ProductPage {

    @FindBy(name="add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCart(){
        SeleniumHelper.waitforClickable(addToCartButton, driver);
        addToCartButton.click();
        return this;
    }

    public CartPage viewCart(){
        viewCartButton.click();
        return new CartPage(driver);
    }
}
