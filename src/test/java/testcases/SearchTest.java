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
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchTest {

    WebDriver driver;
    MainPage mainPage;
    SearchResultPage searchResultPage;
    static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/SearchReport.html");
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

    @Test(priority = 2)
    public void search_product_test() throws InterruptedException, IOException {
        test =extent.createTest("search_product_test", "Test Passed");
        mainPage = new MainPage(driver);
        mainPage.findProduct("baby shoes");
        mainPage.clickSearchButton();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Search.png"));
    }
    @Test(priority = 1)
    public void click_on_search_test() throws InterruptedException, IOException {
        test =extent.createTest("click_on_search_test", "Test Passed");
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        mainPage.findProduct(" ");
        mainPage.clickSearchButton();
        Thread.sleep(5000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/No_Results.png"));

       // String expected = "No results found. Showing top popular products you might want to consider...";
       // String actual = searchResultPage.getErrorMessage();
       // Assert.assertEquals(actual ,expected);

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
