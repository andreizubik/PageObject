package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

     public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Login page")
    public void open() {
        driver.get(BASE_URL);
    }
    @Step("Login by {username} using password '{password}'")

    public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();


    }
    @Step("Getting error message")

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();

    }
}
