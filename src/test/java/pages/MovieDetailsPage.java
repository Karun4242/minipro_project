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

public class MovieDetailsPage {
    public WebDriver driver;
    public WebDriverWait wait;





    @FindAll({
            @FindBy(xpath="//div[@id='root']/descendant::img"),})
    public List<WebElement> finalMoviePageEl;



    public MovieDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }





    public List<WebElement> totalMoviesList(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='root']/descendant::img")));
        return finalMoviePageEl;
    }

}
