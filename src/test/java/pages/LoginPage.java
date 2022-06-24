package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By enterEmail = By.id("ispbxii_1");
    By enterPassword = By.name("customer[password]");
    By loginBtn = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");
    By errorMessage = By.xpath("//*[@id=\"customer_login\"]/p");
    //*[@id="customer_login"]/p

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(){
        driver.findElement(enterEmail).sendKeys("test311@gmail.com");
    }
    public void enterEmail2(){
        driver.findElement(enterEmail).sendKeys("testAtgmail.com");
    }
    public void enterPassword(){
        driver.findElement(enterPassword).sendKeys("P@ssword");
    }
    public void loginBtn(){
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

}
