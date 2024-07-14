package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {

    public WebDriver driver;
    public WebDriverWait wait;


    @FindBy (className ="search-button")
    WebElement searchFinalEl;

    @FindAll({
            @FindBy(className="//div[@class='account-information-container']/descendant::p"),})
    public List<WebElement> AccountPageAllEl;

    @FindBy (className ="logout-button")
    WebElement LogOutBtnEl;

    public AccountPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    public void clickOnsearchBtn(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-button")));
        searchFinalEl.click();
    }

    public List<WebElement> AccountAllList(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='account-information-container']/descendant::p")));
        return AccountPageAllEl;
    }
    public void logoutBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        LogOutBtnEl.click();
    }
}
