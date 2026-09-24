package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "title")
    private WebElement productsTitle;
    @FindBy(css = "h3[data-test='error']")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginAs(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public boolean isProductsPageDisplayed() {
        return productsTitle.isDisplayed();
    }
        public boolean isLoginErrorDisplayed () {
            return loginError.isDisplayed();
        }
    }
