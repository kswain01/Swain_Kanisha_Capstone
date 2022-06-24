package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    By searchField = By.id("ispbxii_0");
    By searchButton = By.cssSelector("#shopify-section-header > section > header > div.header-main-content > div.header-content-right > form > input.header-search-button");
    By accountButton = By.id("customer_login_link");
    By registerButton = By.xpath("//*[@id='keyboard-nav-3']/div[2]/div[3]/a");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void findProduct(String productName){

        driver.findElement(searchField).sendKeys(productName);
    }
    public void clickSearchButton(){

        driver.findElement(searchButton).click();
    }
    public void clickAccountButton(){
        driver.findElement(accountButton).click();
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

}
