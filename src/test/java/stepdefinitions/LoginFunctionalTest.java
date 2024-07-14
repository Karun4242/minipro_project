package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.LoginPage;

import java.time.Duration;

public class LoginFunctionalTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage login;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleti\\OneDrive\\Desktop\\karun Od\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        login= new LoginPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Given("I am on the login page")
    public void isdisplayedLogo(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }



    @When("I checked login logo is displayed")
    public void ichekedLoginLogo(){
        Assert.assertTrue(login.appLogoImage().isDisplayed());
    }


    @When("^I enter valid (.*) and (.*)$")
    public void i_enter_valid_username_and_password(String user, String pass){
        login.enterUserNameInput(user);
        login.enterPasswordInput(pass);

    }
    @Then("I checked username and Password label")
    public void ICheckedUsernameAndPasswordLabel(){

        Assert.assertEquals(login.getUserText(),"USERNAME","usernmae mismatch");
        Assert.assertEquals(login.getpasswordText(),"PASSWORD","password Mismatch");
        Assert.assertEquals(login.getLoginTextMsg(),"Login","login mismatch");
    }
    @And("click login page")
    public void clickBtn(){
        Assert.assertTrue(login.loginBtn().isDisplayed());
        login.clickOnLoginBtn();
    }
    @Then("I should be get to the home page")
    public void getredirectedpage(){
        String exptUrl="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(exptUrl));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/","url mismatch");


    }
    @When("I click on the login button")
    public void clickOnLiginBtn(){
        login.clickOnLoginBtn();
    }

    @When("I enter password")
    public void ienterpassword(){
        login.enterPasswordInput("rahul@2021");
    }

    @Then("an error message for empty input should be visible")
    public void getErrorSmsEmptyInputs(){
        Assert.assertEquals(login.getErrorMsg(),"*Username or password is invalid","Error sms wrong");
    }

    @When("I enter username")
    public void enterValidUserName(){
        login.enterUserNameInput("rahul");
    }


    @And("I enter an invalid pass")
    public void ienterAnInvalidPass(){
        login.enterPasswordInput("rahul2021");
    }


    @Then("an error message 'invalid user ID' should be visible")
    public void validateErrorSms(){
        Assert.assertEquals(login.getErrorMsg(),"*username and password didn't match","Error sms wrong");
    }




    @After
    public void browserclose(){
        driver.quit();
    }

}
