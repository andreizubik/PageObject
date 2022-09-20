package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By PAGE_TITLE = By.cssSelector(".title");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();

    }
    @Step("Adding to cart")
    public void addToCart(String product) {
        String locator = String.format("//*[text()='%s']//ancestor::div[@class='inventory_item']//button",
                product);
        driver.findElement(By.xpath(locator)).click();

    }
}

