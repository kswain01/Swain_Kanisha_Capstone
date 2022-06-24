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
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/LoginReport.html");
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
    public void wrong_email_test() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail2();
        loginPage.enterPassword();
        loginPage.loginBtn();
        Thread.sleep(20000);

        String expected = "Sorry! Please try that again.";
        Assert.assertEquals(expected, loginPage.getErrorMessage());

       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Wrong_email.png"));
    }
    @Test(priority = 2)
    public void login_test() throws IOException, InterruptedException {
        driver.get("https://www.alexandnova.com/account/login");
        loginPage = new LoginPage(driver);
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.loginBtn();
        Thread.sleep(20000);
       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Welcome_page.png"));
    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
