package pl.tester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.tester.models.Customer;

public class AdressDetailsPage {

    @FindBy(name = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(name = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;

    @FindBy(xpath = "//input[@name='billing_address_1']")
    private WebElement billingAddressInput;

    @FindBy(name = "billing_postcode")
    private WebElement billingPostcodeInput;

    @FindBy(name= "billing_city")
    WebElement billingCityInput;

    @FindBy(name = "billing_phone")
    private WebElement billingPhoneName;

    @FindBy(name = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;
    public AdressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAdressDetails(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostcodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneName.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        placeOrderButton.click();

        return new OrderDetailsPage(driver);

    }

    }

