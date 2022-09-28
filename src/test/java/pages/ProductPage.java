package pages;

import io.qameta.allure.Step;
import org.apache.commons.exec.TimeoutObserver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Time;

public class ProductPage extends BasePage {

    private final By PAGE_TITLE = By.cssSelector(".title");
    private final By SORT_BUTTON = By.cssSelector(".product_sort_container");
    private final By MENU_BUTTON = By.id("react-burger-menu-btn");
    WebElement element;
    Select select;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();

    }
    @Step("Adding product to cart")
    public void addToCart(String product) {
        String locator = String.format("//*[text()='%s']//ancestor::div[@class='inventory_item']//button",
                product);
        driver.findElement(By.xpath(locator)).click();

    }
    public void visibleText(String optionName) {
        select.selectByVisibleText(optionName);
    }

    public boolean isSelected() {
        return select.getFirstSelectedOption().isSelected();
    }

    public boolean menuIsOpened() {
        return driver.findElement(MENU_BUTTON).isDisplayed();
    }


}

