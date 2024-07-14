package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;
    HomePage homepage;
    PopularPage popularpage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        homepage= new HomePage(driver);
        popularpage=new PopularPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("I am on the popular page")
    public void iaminHomePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        login.enterValidUserPassToNavHomePage("rahul","rahul@2021");
    }

    @When("I click on popular element")
    public void iClickedOnPopularElemnt(){
        homepage.moviesTopTextList().get(1).click();
        String popularUrl="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(driver.getCurrentUrl(),popularUrl,"popular Url MisMatch");


    }
    @Then("I checked all popular movies displayed or not")
    public void toChekedaAllElementsOnPopular(){
        for(int i=0;i<popularpage.popularMoviesList().size();i++){
            Assert.assertTrue(popularpage.popularMoviesList().get(i).isDisplayed());
        }
    }



    @After
    public void browserclose(){
        driver.quit();
    }






}
