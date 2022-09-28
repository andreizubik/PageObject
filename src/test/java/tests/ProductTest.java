package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

    @Test(description = "Check if the price of the product in the Cart is correct")
    public void cartProductPriceShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickCart();
        assertEquals(cartPage.getProductPrices("Sauce Labs Backpack"), "$29.99",
                "Product price is not correct");
    }
}