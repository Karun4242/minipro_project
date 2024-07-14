package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy (className = "login-website-logo")
    WebElement appLogoImageEl;


    @FindBy(className = "sign-in-heading")
    WebElement loginTextEl;

    @FindBy(xpath = "//label[text()='USERNAME']")
    WebElement usernameLabelEl;

    @FindBy(xpath = "//label[text()='PASSWORD']")
    WebElement passwordLabelEl;

    @FindBy (id="usernameInput")
    WebElement userINputFiledEl;

    @FindBy (id="passwordInput")
    WebElement passwordInputFieldEl;

    @FindBy (className="login-button")
    WebElement loginBtnEl;

    @FindBy (className = "error-message")
    WebElement errorMsgEl;



    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    public WebElement appLogoImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-website-logo")));
        return appLogoImageEl;
    }

    public void enterPasswordInput(String pass){

        passwordInputFieldEl.sendKeys(pass);
    }
    public void enterUserNameInput(String pass){

        userINputFiledEl.sendKeys(pass);
    }

    public void clickOnLoginBtn(){

        loginBtnEl.click();
    }

    public String getLoginTextMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sign-in-heading")));
        return loginTextEl.getText();
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsgEl.getText();
    }

    public String getUserText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='USERNAME']")));
        return usernameLabelEl.getText();
    }

    public String getpasswordText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='PASSWORD']")));
        return passwordLabelEl.getText();
    }
    public WebElement loginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
        return loginBtnEl;
    }
    public void enterValidUserPassToNavHomePage(String user,String pass){
        enterUserNameInput(user);
        enterPasswordInput(pass);
        clickOnLoginBtn();
    }
}
