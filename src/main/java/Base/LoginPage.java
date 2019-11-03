package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class LoginPage extends Utility {
    String url = "http://cafetownsend-angular-rails.herokuapp.com/";

    @FindBy(xpath ="//*[@id='login-form']/fieldset/label[1]/input")
    private WebElement usernameInputElement;
    @FindBy(xpath ="//*[@id='login-form']/fieldset/label[2]/input")
    private WebElement passwordElement;
    @FindBy(xpath = "//*[@id='login-form']/fieldset/button")
    private WebElement login;
    @FindBy(xpath ="//*[@id='greetings']")
    private WebElement loginNameLabel;
    @FindBy(xpath ="/html/body/div/header/div/p[1]")
    private WebElement logout;
    @FindBy(xpath ="//*[@id='bAdd']")
    private WebElement create;
    @FindBy(xpath ="//*[@id=\"bEdit\"]")
    private WebElement edit;
    @FindBy(xpath ="//*[@id=\"bDelete\"]")
    private WebElement delete;
    @FindBy(id="login-form")
    private WebElement loginForm;
    @FindBy(className="error-message")
    private WebElement errorMessage;

    public LoginPage(){
            }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(url);
        assertEquals("CafeTownsend-AngularJS-Rails", driver.getTitle());
        driver.manage().window().maximize();
    }

    public void login(String username, String password) {
        usernameInputElement.clear();
        usernameInputElement.sendKeys(username);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        login.click();
    }

    public void loginUser(String username, String password) {
        usernameInputElement.clear();
        usernameInputElement.sendKeys(username);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        login.click();
    }

    public void verifyLogin(String name) {
        ExpectedConditions.textToBePresentInElement(loginNameLabel,name);
    }

    public void loginFormDisplay(){
        loginForm.isDisplayed();
    }

    public void checkErrorMsg(String expectMsg) throws Exception{
        Utility bs = new Utility();
        bs.wait(errorMessage);
        String errorMsg = errorMessage.getText();
        assertEquals(expectMsg, errorMsg);
    }

    public void logout() throws Exception {
        Utility bs = new Utility();
        bs.wait(logout);
        logout.click();
    }

}


