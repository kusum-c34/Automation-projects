package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageDisplayed() {
        return productsTitle.isDisplayed();
    }

    public String getProductsTitle() {
        return productsTitle.getText();
    }

    public void addBackpackToCart() {
        addBackpackButton.click();
    }

    public String getCartItemCount() {
        return cartBadge.getText();
    }
}
