package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;
    By selectProduct = By.xpath("//*[@id=\"shopify-section-section-2\"]/section/div/article[6]/div/p/a");
    By color = By.xpath("//*[@id=\"bcpo-select-option-0\"]/div[4]/label");
    By age = By.xpath("//*[@id=\"bcpo-select-option-1\"]/div[1]/label");
    By quantity = By.name("quantity");
    By addToCart = By.xpath("//*[@id=\"product_form_4640419577909\"]/div[4]/input");
    By cartButton = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a");
    By buyNowBtn = By.xpath("//*[@id=\"alexnova-btn-cont-id\"]/div");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnProduct(){
        driver.findElement(selectProduct).click();
    }
    public void clickOnColor(){
        driver.findElement(color).click();
    }
    public void clickOnSize(){
        driver.findElement(age).click();
    }
    public void clickOnQuantity(){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("2");
    }
    public void clickOnAddToCart(){
        driver.findElement(addToCart).click();
    }
    public void removeQuantity(){
        driver.findElement(quantity).clear();
    }
    public void clickCart(){
        driver.findElement(cartButton).click();
    }
    public void clickBuyNow(){
        driver.findElement(buyNowBtn).click();
    }
}
