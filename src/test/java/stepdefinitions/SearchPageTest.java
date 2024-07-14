package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {

    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;
    HomePage homepage;
    PopularPage popularpage;
    SearchPage searchpage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        homepage= new HomePage(driver);
        popularpage=new PopularPage(driver);
        searchpage=new SearchPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("I am on the Search page")
    public void iaminHomePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        login.enterValidUserPassToNavHomePage("rahul","rahul@2021");
    }

    @When("I click search Element and enter name")
    public void iClickAndEnterName(){
        searchpage.searchBtnclick();
        searchpage.enternameInseasrchInput("titanic");
        searchpage.clickOnsearchBtn();
    }
    @Then("I checked count movies")
    public void ICheckedCountMovies(){
        System.out.println("count of Movies"+searchpage.CountMoviesList().size());
    }

    @When("I click search Element and OutOf name")
    public void iClickAndEnterNameUnkonw(){
        searchpage.searchBtnclick();
        searchpage.enternameInseasrchInput("passion");
        searchpage.clickOnsearchBtn();
    }

    @Then("I checked Error sms")
    public void iChekedErrorsms(){
        String error="Your search for passion did not find any matches.";

        Assert.assertEquals(searchpage.getErrorSmsText(),error,"error MisMatch");
    }
    @After
    public void browserclose(){
        driver.quit();
    }

}
