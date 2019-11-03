package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.*;

public class HomePage extends LoginPage{

    @FindBy(xpath ="//*[@id='bAdd']")
    private WebElement createButton;

    @FindBy(xpath ="//*[@id='bEdit']")
    private WebElement editButton;

    @FindBy(xpath ="//*[@id='bDelete']")
    private WebElement deleteButton;

    @FindBy(xpath ="//*[@class='formFooter']/p")
    private WebElement delete;

    @FindBy(xpath="//form[@name='employeeForm']/fieldset/label[1]/input")
    private WebElement firstNameIn;

    @FindBy(xpath="//form[@name='employeeForm']/fieldset/label[2]/input")
    private WebElement lastNameIn;

    @FindBy(xpath="//form[@name='employeeForm']/fieldset/label[3]/input")
    private WebElement startDate;

    @FindBy(xpath="//form[@name='employeeForm']/fieldset/label[4]/input")
    private WebElement emailIn;

    @FindBy(xpath="//*[@class='formFooter']/button[1]")
    WebElement updateButton;

    @FindBy(name="employeeForm")
    WebElement UserForm;

    @FindBy(xpath="//*[@class='formFooter']/button[2]")
    WebElement SubmitButton;

    @FindBy(id="employee-list")
    WebElement employeeList;

    @FindBy(xpath="//*[@id='employee-list']/li")
    List<WebElement> employeeNames;

    public static WebDriver driver;
    Utility util = new Utility();
    public static JavascriptExecutor jscript;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateButton() throws Exception {
        util.wait(createButton);
        createButton.click();
    }

    public void enterUserDetails(String firstName, String lastName, String date, String email) throws Exception {
        util.wait(UserForm);
        firstNameIn.clear();
        firstNameIn.sendKeys(firstName);
        lastNameIn.clear();
        lastNameIn.sendKeys(lastName);
        startDate.clear();
        startDate.sendKeys(date);
        emailIn.clear();
        emailIn.sendKeys(email);
    }

    public void submitForm(){
        SubmitButton.click();
    }

    public void nameDetails(String name1, String name2) throws Exception {
        util.wait(employeeList);
        Actions action = new Actions(driver);
        for (WebElement empName: employeeNames){
            String fullName = empName.getText();
            if(fullName.equals(name1+" "+name2)){
                action.doubleClick(empName).perform();
                Thread.sleep(1000);
                break;
            }
        }
    }

    public void userDetails() throws Exception {
        util.wait(employeeList);
        employeeList.isDisplayed();
        employeeList.click();
    }

    public void correctDetailsDoubleCLick(String firstName, String lastName, String date, String email){
        jscript = (JavascriptExecutor) driver;
        String Name1 = jscript.executeScript("return document.getElementsByTagName('input')[0].value").toString();
        assertEquals(firstName, Name1);
        String Name2 = jscript.executeScript("return document.getElementsByTagName('input')[1].value").toString();
        assertEquals(lastName, Name2);
        String Date = jscript.executeScript("return document.getElementsByTagName('input')[2].value").toString();
        assertEquals(date, Date);
        String Email = jscript.executeScript("return document.getElementsByTagName('input')[3].value").toString();
        assertEquals(email, Email);
    }

    public void editForm() throws Exception {
        util.wait(editButton);
        editButton.isEnabled();
        editButton.click();
    }

   public void updateForm(){
        updateButton.click();
   }

    public void deleteForm() throws Exception {
        util.wait(delete);
        delete.isEnabled();
        delete.click();
    }

    public void acceptAlert(){
        ExpectedConditions.alertIsPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void userNotinList(String name1, String name2) throws Exception {
        util.wait(employeeList);
        for (WebElement empName: employeeNames){
            String fullName = empName.getText();
            assertNotSame(fullName, (name1 + " " + name2));
        }

    }
}
