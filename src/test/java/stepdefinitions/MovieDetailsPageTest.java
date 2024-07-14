package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;
import pages.MovieDetailsPage;

import java.time.Duration;

public class MovieDetailsPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;
    HomePage homepage;
    PopularPage popularpage;
    SearchPage searchpage;
    MovieDetailsPage movies;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        homepage= new HomePage(driver);
        popularpage=new PopularPage(driver);
        searchpage=new SearchPage(driver);
        movies=new MovieDetailsPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("I am on the movies page")
    public void iaminmoviePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        login.enterValidUserPassToNavHomePage("rahul","rahul@2021");
    }
    @Given("I click on popular nav and clicked any one movie")
    public void iclickOnpopularMovie(){
        homepage.moviesTopTextList().get(1).click();

    }
    @Then("I checked all movies displayed or not")
    public void ichekedPopularmovies(){
        for(int i=0;i<popularpage.popularMoviesList().size();i++){
            popularpage.popularMoviesList().get(i).click();
            for(int j=0;j<movies.finalMoviePageEl.size();j++){
                Assert.assertTrue(movies.finalMoviePageEl.get(j).isDisplayed());

            }
            driver.navigate().back();
        }
    }
    @Given("I click on home element")
    public void iclickOnHomeMovie(){
        homepage.moviesTopTextList().get(0).click();

    }
    @Then("I checked all home movies displayed or not")
    public void ichekedHomemovies(){
        for(int i=0;i<homepage.HomemoviesList().size();i++){
            homepage.HomemoviesList().get(i).click();
            for(int j=0;j<movies.finalMoviePageEl.size();j++){
                Assert.assertTrue(movies.finalMoviePageEl.get(j).isDisplayed());
            }
        }
    }

    @After
    public void browserclose(){
        driver.quit();
    }

}
