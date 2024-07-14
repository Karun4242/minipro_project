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

public class HomePage {
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
            @FindBy(className="movies-list-heading"),})
    public List<WebElement> listHeadingEl;

    @FindAll({
            @FindBy(className="nav-link"),})
    public List<WebElement> listHeadingTopEl;
    @FindAll({
            @FindBy(xpath="//h1[text()='Trending Now']/following-sibling::div/descendant::div[contains(@class,'slick-slide')]/child::div/child::div/child::div"),})
    public List<WebElement> trendMoviesEL;

    @FindAll({
            @FindBy(xpath="//div[@class='slick-list']/descendant::a"),})
    public List<WebElement> listHomeMoviesEl;


    @FindAll({
            @FindBy(className="slick-slide"),})
    public List<WebElement> moviesListOnTrendEl;

    @FindAll({
            @FindBy(className="icon-element"),})
    public List<WebElement> iconListEl;
    @FindAll({
            @FindBy(className="slick-next"),})
    public List<WebElement> navEl;


    public HomePage(WebDriver driver){
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

    public WebElement getAccountPic(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        return accountEl;
    }



    public String getcontactUsText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact-us-paragraph")));

        return contactUsEl.getText();
    }

    public List<WebElement> moviesTextList(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("movies-list-heading")));

        return listHeadingEl;
    }
    public List<WebElement> navList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("slick-next")));

        return navEl;
    }
    public List<WebElement> trendNowMoviesTextList(){

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("link-item")));
        for(int i=0;i<5;i++) {
            navList().get(0).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("link-item")));

        }

        return trendMoviesEL;
    }
    public List<WebElement> HomemoviesList(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='slick-list']/descendant::a")));

        return listHomeMoviesEl;
    }

    public List<WebElement> moviesTopTextList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-link")));

        return listHeadingTopEl;
    }

    public List<WebElement> moviesListTrend() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slick-slide")));
        return moviesListOnTrendEl;
    }
    public WebElement iconListButtom(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-element")));

        return iconListEl.get(index);
    }



}
