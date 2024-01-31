package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WebTablesPage extends BaseTest {
    WebElement addToRegistrationForm,FirstName,LastName,Email,Age,Salary,Department,submitButton,deleteUser,editUser,AleksandarCvetanovic;
    List<WebElement> RegistrationForm;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToRegistrationForm() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getAge() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSalary() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getDepartment() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getDeleteUser() {
        return driver.findElement(By.id("delete-record-4"));
    }

    public WebElement getEditUser() {
        return driver.findElement(By.id("edit-record-4"));
    }

    public List<WebElement> getAleksandarCvetanovic() { // morao sam da stavim u listu
        return driver.findElements(By.className("rt-tr-group"));
    }

    public List<WebElement> getRegistrationForm() {
        return driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
    }
    //--------------------------
    public void clickAddRegistrationForm(){
        getAddToRegistrationForm().click();
    }
    public void inputFirstName(String firstName1){
        getFirstName().clear();
        getFirstName().sendKeys(firstName1);
    }
    public void inputLastName(String lastName1){
        getLastName().click();
        getLastName().sendKeys(lastName1);
    }
    public void inputEmail(String email1){
        getEmail().clear();
        getEmail().sendKeys(email1);
    }
    public void inputAge(String age1){
        getAge().clear();
        getAge().sendKeys(age1);
    }
    public void inputSalary(String salary1){
        getSalary().clear();
        getSalary().sendKeys(salary1);
    }
    public void inputDepartment(String department1){
        getDepartment().clear();
        getDepartment().sendKeys(department1);
    }
    public void clickSubmitButton(){
        getSubmitButton().click();
    }
}
