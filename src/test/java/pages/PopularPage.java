package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(className = "home-movie-play-button")
    WebElement playBtnEl;

    @FindBy(className = "website-logo")
    WebElement appLogoEL;

    @FindBy(className = "avatar-img")
    WebElement accountEl;


    @FindBy (className="contact-us-paragraph")
    WebElement contactUsEl;

    @FindAll({
            @FindBy(className="movie-icon-item"),})
    public List<WebElement> popularListEl;

    @FindAll({
            @FindBy(className="nav-link"),})
    public List<WebElement> listHeadingTopEl;


    @FindAll({
            @FindBy(className="slick-slide"),})
    public List<WebElement> moviesListOnTrendEl;

    @FindAll({
            @FindBy(className="icon-element"),})
    public List<WebElement> iconListEl;



    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);

    }

    public WebElement playBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        return playBtnEl;
    }
    public WebElement movieLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        return appLogoEL;
    }







    public List<WebElement> popularMoviesList(){
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("movie-icon-item")));

        js.executeScript("window.scrollTo(0, 500)");

        return popularListEl;
    }

    public List<WebElement> moviesTopTextList(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("nav-link")));

        return listHeadingTopEl;
    }

    public List<WebElement> moviesListTrend() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("slick-slide")));
        return moviesListOnTrendEl;
    }
    public WebElement iconListButtom(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("icon-element")));

        return iconListEl.get(index);
    }
}
