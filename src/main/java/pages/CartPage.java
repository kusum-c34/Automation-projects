package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "title")
    private WebElement cartTitle;
    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickCart() {
        cartIcon.click();
    }

    public boolean isCartPageDisplayed() {
        return cartTitle.isDisplayed();
    }

    public void clickCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));

        checkoutButton.click();

        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
}