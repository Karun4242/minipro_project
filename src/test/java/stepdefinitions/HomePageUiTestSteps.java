package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;

import java.time.Duration;
import java.util.ArrayList;

public class HomePageUiTestSteps {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;
    HomePage homepage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        homepage= new HomePage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("I am on the Home page")
    public void iaminHomePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        login.enterValidUserPassToNavHomePage("rahul","rahul@2021");
    }

    @When("I checked trend text")
    public void textCheckTrend(){
        Assert.assertEquals(homepage.moviesTextList().get(0).getText(),"Trending Now", "trend name mismatch");
        Assert.assertEquals(homepage.moviesTextList().get(1).getText(),"Originals", "original name mismatch");

    }
    @When("i checked contact Icon")
    public void iCheckedContactIcon(){
        for(int i=0; i<homepage.iconListEl.size();i++){
            Assert.assertTrue(homepage.iconListButtom(i).isDisplayed());
        }

    }
    @Then("I checked contact Us text")
    public void IcheckedcontactUstext(){
        Assert.assertEquals(homepage.getcontactUsText(),"Contact Us","contactText error");



    }
    @Then("I Test whether the play button is displayed or not")
    public void playBtnChecked(){
        Assert.assertTrue(homepage.playBtn().isDisplayed());

    }

    @And("I checked trends movies displayed or not")
    public void ICheckedTrendsMoviesDisplayed(){


        for(int i=0; i<homepage.trendNowMoviesTextList().size();i++){

            Assert.assertTrue(homepage.trendNowMoviesTextList().get(i).isDisplayed());

        }



    }


    @And("I checked TopMenu text")
    public void IcheckedTopMenutext(){
        Assert.assertEquals(homepage.moviesTopTextList().get(0).getText(),"Home");
        Assert.assertEquals(homepage.moviesTopTextList().get(1).getText(),"Popular");
    }
    @When("I checked app logo")
    public void iCheckedAppLogo(){
        Assert.assertTrue(homepage.movieLogo().isDisplayed(),"logo mismatch");
    }
    @When("I click on home")
    public void iClickOnAccount(){
        homepage.moviesTopTextList().get(0).click();
    }
    @Then("I checked nav bar to accounts page")
    public void iCheckedNavBarToAcountPage(){
        String accUrl="https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(accUrl));
        Assert.assertEquals(driver.getCurrentUrl(),accUrl,"url misMatch");
    }

    @Then("I checked nav bar elements")
    public void iCheckedNavBarElements(){
        String home="https://qamoviesapp.ccbp.tech/";
        String popular="https://qamoviesapp.ccbp.tech/popular";
        homepage.moviesTopTextList().get(1).click();
        wait.until(ExpectedConditions.urlToBe(popular));
        Assert.assertEquals(driver.getCurrentUrl(),popular,"popular mismatch");
        homepage.moviesTopTextList().get(0).click();
        wait.until(ExpectedConditions.urlToBe(home));
        Assert.assertEquals(driver.getCurrentUrl(),home,"homepage mismatch");
    }


    @After
    public void browserclose(){
        driver.quit();
    }

}
