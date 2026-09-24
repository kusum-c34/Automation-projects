package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutOverviewPage {

    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement overviewTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement orderCompleteMessage;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOverviewPageDisplayed() {
        return overviewTitle.isDisplayed();
    }

    public void clickFinish() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement finish = wait.until(
                ExpectedConditions.elementToBeClickable(finishButton)
        );

        finish.click();
    }

    public boolean isOrderCompleteDisplayed() {
        return orderCompleteMessage.isDisplayed();
    }

}