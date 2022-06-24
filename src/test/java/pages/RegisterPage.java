package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    By firstName = By.xpath("//*[@id=\"ispbxii_1\"]");
    By lastName = By.xpath("//*[@id=\"ispbxii_2\"]");
    By email = By.xpath("//*[@id=\"ispbxii_3\"]");
    By password = By.xpath("//*[@id=\"create_customer\"]/div[4]/input");
    By registerBtn = By.xpath("//*[@id=\"create_customer\"]/div[5]/input");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(){
        driver.findElement(firstName).sendKeys("john");
    }
    public void inputLastName(){
        driver.findElement(lastName).sendKeys("fink");
    }
    public void inputEmail(){
        driver.findElement(email).sendKeys("test311@gmail.com");
    }
    public void inputPassword(){
        driver.findElement(password).sendKeys("P@ssword");
    }
    public void clickRegisterBtn(){
        driver.findElement(registerBtn).click();
    }
    public void inputEmail1(){
        driver.findElement(email).sendKeys("testAtgmail.com");
    }
    public void inputEmail2() {
        driver.findElement(email).sendKeys("testcom");
    }
    public void inputEmail3() {
        driver.findElement(email).sendKeys("test31Atgmail.com");
    }
    public void inputEmail4() {
        driver.findElement(email).sendKeys("test31gmailcom");
    }
    public void password2(){
        driver.findElement(password).sendKeys("passw");
    }

}
