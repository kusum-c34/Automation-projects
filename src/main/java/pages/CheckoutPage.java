package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class CheckoutPage {

        private WebDriver driver;

        @FindBy(id = "first-name")
        private WebElement firstName;

        @FindBy(id = "last-name")
        private WebElement lastName;

        @FindBy(id = "postal-code")
        private WebElement postalCode;

        @FindBy(id = "continue")
        private WebElement continueButton;

        @FindBy(className = "title")
        private WebElement checkoutTitle;

        public CheckoutPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public boolean isCheckoutPageDisplayed() {
            return checkoutTitle.isDisplayed();
        }

        public void enterFirstName(String firstNameValue) {
            firstName.sendKeys(firstNameValue);
        }

        public void enterLastName(String lastNameValue) {
            lastName.sendKeys(lastNameValue);
        }

        public void enterPostalCode(String postalCodeValue) {
            postalCode.sendKeys(postalCodeValue);
        }

        public void clickContinue() {
            continueButton.click();
        }

        public void enterCustomerDetails(
                String firstNameValue,
                String lastNameValue,
                String postalCodeValue) {

            enterFirstName(firstNameValue);
            enterLastName(lastNameValue);
            enterPostalCode(postalCodeValue);
        }
    }

