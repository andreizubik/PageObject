package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


public class CheckoutPage extends BasePage {

    private By FIRSTNAME_FIELD = By.id("first-name");
    private By LASTNAME_FIELD = By.id("last-name");
    private By POSTALCODE_FIELD = By.id("postal-code");
    private By CONTINUE_BUTTON = By.id("continue");
    private By CANCEL_BUTTON = By.id("cancel");
    private By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillCheckout(String firstName, String lastName, String postalcode) {
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstName);
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
