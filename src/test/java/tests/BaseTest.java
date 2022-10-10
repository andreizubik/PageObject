package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    CartPage cartPage;
    static WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)  // запускать всегда
    public void close() {
        if (driver != null) {
            driver.quit(); }
    }
}