package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By updateCart = By.name("update");
    By checkOut = By.name("checkout");
    By quantity = By.name("updates[]");
    By quantity2 = By.xpath("//*[@id=\"updates_32260486463541\"]");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpdateCart(){
        driver.findElement(updateCart).click();
    }
    public void clickCheckout(){
        driver.findElement(checkOut).click();
    }
    public void quantityRemove(){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("0");
    }
    public void quantityIncrease(){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("6");
    }
}
