package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsTextBoxPage extends BaseTest {

    WebElement fullName,email,currentAddress,permanentAddress,submitButton;

    public ElementsTextBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddress() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }
    //----------------------------

    public void inputFullName(String fullName){
        getFullName().clear();
        getFullName().sendKeys(fullName);
    }
    public void inputEmail(String email){
        getEmail().clear();
        getEmail().sendKeys(email);
    }
    public void inputCurrentAddress(String currentAddress){
        getCurrentAddress().clear();
        getCurrentAddress().sendKeys(currentAddress);
    }
    public  void inputPermanentAddress(String permanentAddress){
        getPermanentAddress().clear();
        getPermanentAddress().sendKeys(permanentAddress);
    }
    public void clickOnSubmit(){
        getSubmitButton().click();
    }

}
