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
import pages.AccountPage;


import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;
    HomePage homepage;
    AccountPage accountpage;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        homepage= new HomePage(driver);
        accountpage= new AccountPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("I am on the Account page")
    public void iaminHomePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        login.enterValidUserPassToNavHomePage("rahul","rahul@2021");
    }

    @After
    public void browserclose(){
        driver.quit();
    }

    @When("I click on Account element")
    public void clickOnAccount(){
        homepage.getAccountPic().click();
    }
    @Then("I checked all Account movies displayed or not")
    public void iChekedAllInAccount(){
        for(int i=0;i<accountpage.AccountAllList().size();i++){
            Assert.assertTrue(accountpage.AccountPageAllEl.get(i).isDisplayed());
        }
    }
    @Then("I click on Logout Element")
    public void i_click_on_logout_element() {
        // Write code here that turns the phrase above into concrete actions
        accountpage.logoutBtn();
    }




}
