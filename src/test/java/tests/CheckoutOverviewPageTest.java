package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test
    public void SuccessfulPurchaseShouldBeConfirmed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillCheckout("Ivan", "Ivanov", "24680");
        checkoutPage.clickOnFinishButton();
        assertTrue(driver.findElement(By.id("checkout_complete_container")).isDisplayed());
    }

    @Test
    public void TotalPriceShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillCheckout("Ivan", "Ivanov", "24680");
        assertEquals(checkoutOverviewPage.getItemTotal(), "Item total: $29.99");
        assertEquals(checkoutOverviewPage.getTax(), "Tax: $2.40");
        assertEquals(checkoutOverviewPage.getTotalCost(), "Total: $32.39");

    }
}

