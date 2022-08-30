package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    WebDriver driver;
    public static final String BASE_URL = "https://www.saucedemo.com/";
    private final By CART = By.id("shopping_cart_container");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCart() {
        driver.findElement(CART).click();
}

    public void clickOnFinishButton() {
    }
}

