package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(productsPage.isProductsPageDisplayed());
        Assert.assertEquals(productsPage.getProductsTitle(), "Products");

        System.out.println("Login successful and Products page verified!");
    }

    @Test
    public void testInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.isLoginErrorDisplayed());

        System.out.println("Invalid login handled successfully!");
    }
    @Test
    public void testAddProductToCart() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(productsPage.isProductsPageDisplayed());

        productsPage.addBackpackToCart();

        Assert.assertEquals(productsPage.getCartItemCount(), "1");

        System.out.println("Product added to cart successfully!");
    }
}