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

public class SearchPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(className="search-empty-button")
    WebElement searchBntEl;

    @FindBy (id = "search")
    WebElement searchBoxEl;

    @FindBy (className ="search-button")
    WebElement searchFinalEl;

    @FindAll({
            @FindBy(className="movie-icon-item"),})
    public List<WebElement> listsearchMoviesEl;

    @FindBy (className ="not-found-search-paragraph")
    WebElement errorSmsEL;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    public void searchBtnclick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
         searchBntEl.click();
    }

    public void enternameInseasrchInput(String name){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        searchBoxEl.sendKeys(name);
    }
    public void clickOnsearchBtn(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-button")));
        searchFinalEl.click();
    }

    public List<WebElement> CountMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-button")));
        return listsearchMoviesEl;
    }
    public String getErrorSmsText() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("not-found-search-paragraph")));
        return errorSmsEL.getText();
    }


}
