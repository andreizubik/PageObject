package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By CART_ITEM = By.cssSelector(".inventory_item_name");
    private final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    private String numberOfItems;

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
    @Step("Removing product from the Cart")
    public void removeFromCart (String productName) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//button[@id='remove-sauce-labs-bike-light']",
                productName);
        driver.findElement(By.xpath(locator)).click();

    }
    public String getNumberOfItemsInCart() {
        int arraySize = driver.findElements(CART_ITEM).size();
        return numberOfItems = Integer.toString(arraySize);
    }

}
