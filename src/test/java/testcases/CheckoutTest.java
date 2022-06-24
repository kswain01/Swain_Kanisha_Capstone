package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PaymentPage;
import pages.ProductPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutTest {

    WebDriver driver;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ProductPage productPage;
    PaymentPage paymentPage;
    static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/CheckoutReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "kanisha.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Kanisha Swain");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Capstone report");
        htmlReporter.config().setReportName("Capstone Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }
    @Test(priority = 1)
    public void gift_card_test() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        test =extent.createTest("gift_card_test", "Test Passed");
        productPage = new ProductPage(driver);
        productPage.clickOnProduct();
        productPage.clickOnColor();
        productPage.clickOnSize();
        productPage.clickOnQuantity();
        productPage.clickOnAddToCart();
        productPage.clickBuyNow();
        Thread.sleep(5000);

       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Discount_code.png"));
    }
    @Test(priority = 3)
    public void field_blank_test() throws InterruptedException, IOException {
        test =extent.createTest("field_blank_test", "Test Passed");
        paymentPage = new PaymentPage(driver);
        paymentPage.clickPayNow();

        Thread.sleep(5000);
       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Payment_blank.png"));
    }
    @Test(priority = 2)
    public void payment_mode_test() throws InterruptedException, IOException {
        test =extent.createTest("payment_mode_test", "Test Passed");
        checkoutPage = new CheckoutPage(driver);
        Thread.sleep(300);
        checkoutPage.enterEmail();
        checkoutPage.enterFName();
        checkoutPage.enterLName();
        checkoutPage.enterAddress();
        checkoutPage.enterCity();
        checkoutPage.enterZip();
        checkoutPage.clickContinueShopping();
        Thread.sleep(5000);
        checkoutPage.clickContinuePayment();

       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Payment_mode.png"));
    }
    @Test(priority = 4)
    public void add_payment_test() throws InterruptedException, IOException {
        test =extent.createTest("add_payment_test", "Test Passed");
        paymentPage = new PaymentPage(driver);
        paymentPage.enterCardNumber();
        driver.switchTo().parentFrame();

        paymentPage.enterNameOnCard();
        driver.switchTo().parentFrame();

        paymentPage.enterExpoDate();
        driver.switchTo().parentFrame();

        paymentPage.enterSecCode();
        driver.switchTo().parentFrame();

        Thread.sleep(5000);
       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Checkout.png"));

        paymentPage.clickPayNow();
    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}

