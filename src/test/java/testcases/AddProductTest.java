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
import pages.MainPage;
import pages.ProductPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddProductTest {

    WebDriver driver;
    MainPage mainPage;
    ProductPage productPage;
    CartPage cartPage;
    static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AddProductReport.html");
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
    public void product_price_test() throws InterruptedException, IOException {
        test =extent.createTest("product_price_test", "Test Passed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        productPage = new ProductPage(driver);
        productPage.clickOnProduct();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Product_Price.png"));
    }
    @Test(priority = 2)
    public void add_to_cart_test() throws InterruptedException, IOException {
        test =extent.createTest("add_to_cart_test", "Test Passed");
        productPage = new ProductPage(driver);
        productPage.clickOnColor();
        productPage.clickOnSize();
        productPage.clickOnQuantity();
        productPage.clickOnAddToCart();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Cart.png"));
    }
    @Test(priority = 3)
    public void refresh_page_test() throws InterruptedException, IOException {
        test =extent.createTest("refresh_page_test", "Test Passed");
        productPage = new ProductPage(driver);
        driver.navigate().refresh();
        productPage.clickCart();
        Thread.sleep(5000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/Refresh_cart.png"));
    }
    @Test(priority = 4)
    public void increase_quantity_test() throws InterruptedException, IOException {
        test =extent.createTest("increase_quan_test", "Test Passed");
        cartPage = new CartPage(driver);
        cartPage.quantityIncrease();
        cartPage.clickUpdateCart();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Quantity_increase.png"));
    }
    @Test(priority = 5)
    public void remove_quantity_test() throws InterruptedException, IOException {
        test =extent.createTest("remove_quan_test", "Test Passed");
        cartPage = new CartPage(driver);
        cartPage.quantityRemove();
        cartPage.clickUpdateCart();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Remove_items.png"));
    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
