package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutOverviewPage;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        // Products page
        ProductsPage productsPage = new ProductsPage(driver);

        // Add Backpack to cart
        productsPage.addBackpackToCart();

        // Verify cart badge
        Assert.assertEquals(
                productsPage.getCartItemCount(),
                "1",
                "Cart item count is not 1"
        );

        // Open Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();

        // Verify Cart page
        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page is not displayed"
        );

        // Go to Checkout
        cartPage.clickCheckout();

        // Checkout page
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Verify Checkout page
        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed(),
                "Checkout page is not displayed"
        );

        // Enter customer details
        checkoutPage.enterCustomerDetails(
                "Kusum",
                "Test",
                "110001"Z
        );

        // Continue to Checkout Overview
        checkoutPage.clickContinue();
        // Checkout Overview
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);

        Assert.assertTrue(
                overviewPage.isOverviewPageDisplayed(),
                "Checkout Overview page is not displayed"
        );

// Finish order
        overviewPage.clickFinish();

// Verify order completion
        Assert.assertTrue(overviewPage.isOrderCompleteDisplayed(), "Order completion message is not displayed");

        System.out.println("Order placed successfully!");

        System.out.println("Product added, Cart verified and Checkout details entered successfully!");
    }
}