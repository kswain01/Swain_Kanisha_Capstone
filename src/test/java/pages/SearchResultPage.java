package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    WebDriver driver;
    //page factory
    //@FindBy(xpath = )
    //List<WebElement> checkButtonLists;
    By searchMessage = By.className("isp_no_results_title");
    //*[@id="isp_search_results_container"]/li[1]
    //*[@id="isp_results_did_you_mean"]
//*[@id="isp_search_results_container"]/li[1]



    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getErrorMessage(){
        return driver.findElement(searchMessage).getText();
    }


}
