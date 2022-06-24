package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;
    By continueShopping = By.id("continue_button");
    By continuePayment = By.xpath("//*[@id=\"continue_button\"]");
    By payNow = By.name("button");
    By email = By.xpath("//*[@id=\"checkout_email\"]");
    By fName = By.id("checkout_shipping_address_first_name");
    By lName = By.id("checkout_shipping_address_last_name");
    By address =By.id("checkout_shipping_address_address1");
    By city = By.id("checkout_shipping_address_city");
    By zipCode = By.id("checkout_shipping_address_zip");



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickContinueShopping(){
        driver.findElement(continueShopping).click();
    }
    public void clickContinuePayment(){
        driver.findElement(continuePayment).click();
    }
    public void enterEmail(){
        driver.findElement(email).sendKeys("test1111@yahoo.com");
    }
    public void enterFName(){
        driver.findElement(fName).sendKeys("John");
    }
    public void enterLName(){
        driver.findElement(lName).sendKeys("Fink");
    }
    public void enterAddress(){
        driver.findElement(address).sendKeys("7400 south gartrell road");
    }
    public void enterCity(){
        driver.findElement(city).sendKeys("Aurora");
    }
    public void enterZip(){
        driver.findElement(zipCode).sendKeys("80016");
    }
}
