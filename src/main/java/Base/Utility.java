package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
    protected WebDriver driver;

    public void wait(WebElement element) throws Exception{
        for(int second = 0; second<60;second++){
            Thread.sleep(1000);
            if(element.isDisplayed()){
                break;
            }
        }
    }
}
