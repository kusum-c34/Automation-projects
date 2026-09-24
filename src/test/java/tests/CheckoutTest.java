 package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckout() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        // Add product
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();

        // Open cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();

        // Checkout
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed(),
                "Checkout page is not displayed"
        );

        checkoutPage.enterFirstName("Kusum");
        checkoutPage.enterLastName("Ahirwar");
        checkoutPage.enterPostalCode("201001");
        checkoutPage.clickContinue();

        // Checkout Overview
        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertTrue(
                overviewPage.isOverviewPageDisplayed(),
                "Checkout Overview page is not displayed"
        );

        // Finish order
        overviewPage.clickFinish();

        // Verify order completion+
        Assert.assertTrue(
                overviewPage.isOrderCompleteDisplayed(),
                "Order completion message is not displayed"
        );

        System.out.println("Checkout completed successfully!");
    }
}

