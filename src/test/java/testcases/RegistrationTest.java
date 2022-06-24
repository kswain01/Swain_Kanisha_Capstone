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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RegistrationTest {

    WebDriver driver;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/RegistrationReport.html");
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
    public void new_user_page_test() throws InterruptedException, IOException {
        test =extent.createTest("new_user_page_test", "Test Passed");
        mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        mainPage.clickRegisterButton();
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/New_user_page.png"));
        Thread.sleep(20000);
    }

    @Test(priority = 5)
    public void register_new_user_test() throws InterruptedException {
        test =extent.createTest("register_new_user_test", "Test Passed");
        driver.get("https://www.alexandnova.com/account/register");

        registerPage = new RegisterPage(driver);
        registerPage.inputFirstName();
        registerPage.inputLastName();
        registerPage.inputEmail();
        registerPage.inputPassword();
        registerPage.clickRegisterBtn();
        Thread.sleep(20000);
    }
   @Test(priority = 3)
    public void email_validation_test() throws InterruptedException, IOException {
       test =extent.createTest("email_validation_test", "Test Passed");
       driver.get("https://www.alexandnova.com/account/register");

        registerPage = new RegisterPage(driver);
        registerPage.inputFirstName();
        registerPage.inputLastName();
        registerPage.inputEmail1();
        registerPage.inputPassword();
        registerPage.clickRegisterBtn();
        Thread.sleep(20000);

        String expected = "Email invalid.";
        Assert.assertEquals(expected, loginPage.getErrorMessage());

       //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       //FileUtils.copyFile(file, new File("src/test/resources/screenshots/Email_val_page.png"));
    }
    @Test(priority = 2)
    public void mandatory_field_test() throws InterruptedException, IOException {
        test =extent.createTest("mandatory_field_test", "Test Passed");
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterBtn();
        Thread.sleep(20000);
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Mandatory_page.png"));
    }
    @Test(priority = 4)
    public void password_test() throws InterruptedException, IOException {
        test =extent.createTest("password_test", "Test Passed");
        driver.get("https://www.alexandnova.com/account/register");

        registerPage = new RegisterPage(driver);
        registerPage.inputFirstName();
        registerPage.inputLastName();
        registerPage.inputEmail();
        registerPage.password2();
        registerPage.clickRegisterBtn();
        Thread.sleep(20000);

        String expected = "passwd invalid.";
        Assert.assertEquals(expected, loginPage.getErrorMessage());

       // File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(file, new File("src/test/resources/screenshots/Password_page.png"));

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}

