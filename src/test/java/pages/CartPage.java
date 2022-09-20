package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrices(String product) {
        String locator = String.format("//div[text()='%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']",
                product);
        return driver.findElement(By.xpath(locator)).getText();

    }
    @Step("Clicking on Checkout Button")
    public void clickOnCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

}
