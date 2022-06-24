package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    WebDriver driver;

    By cardNumber = By.xpath("//iframe[contains(@id,'card-fields-number-')]");
    By nameOnCard = By.xpath("//iframe[contains(@id,'card-fields-name-')]");

    By expoDate = By.xpath("//iframe[contains(@id,'card-fields-expiry-')]");

    By secCode = By.xpath("//iframe[contains(@id,'card-fields-verification_value-')]");

    By payNow = By.name("button");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPayNow(){
        driver.findElement(payNow).click();
    }
    public void enterCardNumber(){
        driver.findElement(cardNumber).sendKeys("3698");
        driver.findElement(cardNumber).sendKeys( "5214");
        driver.findElement(cardNumber).sendKeys("7698");
        driver.findElement(cardNumber).sendKeys("74");
    }
    public void enterNameOnCard(){
        driver.findElement(nameOnCard).sendKeys("john fink");
    }
    public void enterExpoDate(){
        driver.findElement(expoDate).sendKeys("06/5");
    }
    public void enterSecCode(){
        driver.findElement(secCode).sendKeys("222");
    }
}
/**
 * By iFrameCard = By.xpath("//iframe[contains(@id,'card-fields-number-')]");
 *     By iFrameName = By.xpath("//iframe[contains(@id,'card-fields-name-')]");
 *     By iFrameDate = By.xpath("//iframe[contains(@id,'card-fields-expiry-')]");
 *     By iFrameCode = By.xpath("//iframe[contains(@id,'card-fields-verification_value-')]");
 * driver.switchTo().parentFrame();
 */