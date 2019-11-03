package StepDefinition;

import Base.HomePage;
import Base.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class UIStepdefs {
    public static WebDriver driver = null;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver","E:\\TestAutomate\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I load web page$")
    public void iLoadWebPage() {
        //System.out.println("Login page");
        loginPage .navigateTo();
    }

    @When("^I enter username and password$")
    public void iEnterUsernameAndPassword() throws Throwable{
        loginPage.login("Luke", "Skywalker");
    }

    @Then("^I verify loginname$")
    public void iVerifyLoginname() {
        loginPage.verifyLogin("Hello Luke");
    }

    @Then("^I logout of application$")
    public void iLogoutOfApplication() throws Throwable {
        loginPage.logout();
    }

    @And("^Login form displayed$")
    public void login_form_displayed() throws Throwable {
       //System.out.println("Load page");
        loginPage.loginFormDisplay();
    }

    @When("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String username, String password) throws Throwable {
        loginPage.loginUser(username,password);
      }

    @And("^user clicks the Login button$")
    public void userClicksTheLoginButton() throws Throwable{
        loginPage.clickLogin();
    }

    @Then("^user should see \"([^\"]*)\"$")
    public void userShouldSee(String error) throws Throwable {
        loginPage.checkErrorMsg(error);
    }

    @And("^I click on create button$")
    public void iClickOnCreateButton() throws Throwable{
        homePage.clickCreateButton();
    }

    @And("^I enters firstname \"([^\"]*)\" and lastname \"([^\"]*)\" and startDate \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void iEnterFirstnameAndLastnameAndStartDateAndEmail(String fname, String lname, String sdate, String email) throws Throwable {
        homePage.enterUserDetails(fname,lname,sdate,email);
    }

    @And("^I click on Submit form$")
    public void iClickOnSubmitForm() {
        homePage.submitForm();
    }

    @When("^I select name from the list\"([^\"]*)\", \"([^\"]*)\"$")
    public void iSelectNameFromTheList(String fname, String lname) throws Throwable {
        homePage.nameDetails(fname,lname);
    }

    @Then("^I verify correct user details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void iVerifyCorrectUserDetails(String fname, String lname, String sdate, String email) throws Throwable {
        homePage.correctDetailsDoubleCLick(fname,lname,sdate,email);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() throws Exception {
        homePage.editForm();
    }

    @And("^I update firstname \"([^\"]*)\" and lastname \"([^\"]*)\" and startDate \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void iUpdateFirstnameAndLastnameAndStartDateAndEmail(String newFname, String newLname, String newDate, String newEmail) throws Throwable {
        homePage.enterUserDetails(newFname,newLname,newDate,newEmail);
    }

    @And("^I click on Update button$")
    public void iClickOnUpdateButton() {
        homePage.updateForm();
    }

    @Then("^I select name from the list$")
    public void iSelectNameFromTheList() throws Exception {
        homePage.nameDetails("hkib3","urilw9");
    }

    @Then("^I verify existing user from the list$")
    public void iVerifyExistingUserFromTheList() throws Exception {
        homePage.clickCreateButton();
        homePage.enterUserDetails("sample1","Test1","2019-11-02","test@xyr.com");
        homePage.submitForm();
    }

    @Then("^I click on user list$")
    public void iClickOnUserList() throws Exception {
        homePage.userDetails();
    }

    @When("^I select updated details from the list\"([^\"]*)\", \"([^\"]*)\"$")
    public void iSelectUpdatedDetailsFromTheList(String name1, String name2) throws Throwable {
        homePage.nameDetails(name1,name2);
    }

    @Then("^I verify updated user details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void iVerifyUpdatedUserDetails(String fname, String lname, String date, String email) throws Throwable {
        homePage.correctDetailsDoubleCLick(fname,lname,date,email);
    }

    @And("^I click on delete button$")
    public void iClickOnDeleteButton() throws Exception {
        homePage.deleteForm();
    }

    @Then("^I should not see the details \"([^\"]*)\", \"([^\"]*)\" in the list$")
    public void iShouldNotSeeTheDetailsInTheList(String name1, String name2) throws Throwable {
        homePage.userNotinList(name1,name2);
    }

    @And("^I agree with the alert$")
    public void iAgreeWithTheAlert() {
        homePage.acceptAlert();
    }
}

