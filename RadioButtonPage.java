package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RadioButtonPage extends BaseTest {

    List<WebElement> YesImpressiveNoButtons;
    WebElement notificationIfClickYesButton,notificationIfClickImpressiveButton, radioButtonNo;


    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getYesImpressiveNoButtons() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public WebElement getNotificationIfClickYesButton() {
        return driver.findElement(By.className("mt-3"));
    }

    public WebElement getNotificationIfClickImpressiveButton() {
        return driver.findElement(By.className("text-success"));
    }

    //Istrazivao sam za NO, probao sam i na ovaj nacn
    public boolean getRadioButtonNo() {
        return driver.findElement(By.cssSelector("input[id='noRadio']")).isDisplayed();

    }
    public void clickNoButton(){
        if (getRadioButtonNo() == true){
            radioButtonNo.click();
        }
    }
}
