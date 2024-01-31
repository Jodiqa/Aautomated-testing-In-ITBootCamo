package Tests;

import Base.BaseTest;
import Pages.Elements.ElementsCheckBoxPage;
import Pages.Elements.ElementsTextBoxPage;
import Pages.Elements.RadioButtonPage;
import Pages.Elements.WebTablesPage;
import Pages.HomePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestsElements extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        elementsTextBoxPage = new ElementsTextBoxPage(driver);
        elementsCheckBoxPage = new ElementsCheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        webTablesPage = new WebTablesPage(driver);

    }

    @Test(priority = 10)
    public void userCanFillTextBoxWithCorrectAllFields() {
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Text Box");
        elementsTextBoxPage.inputFullName("Aleksandar Cvetanovic");
        elementsTextBoxPage.inputEmail("betmen007@gmail.com");
        elementsTextBoxPage.inputCurrentAddress("Vojvode putnika 4");
        elementsTextBoxPage.inputPermanentAddress("Zdravke Vuckovic 74");
        elementsTextBoxPage.clickOnSubmit();
        Assert.assertTrue(driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12")).isDisplayed());

    }

    @Test(priority = 20)
    public void isertInvalidEmail() {
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Text Box");
        elementsTextBoxPage.inputFullName("Aleksandar Cvetanovic");
        elementsTextBoxPage.inputEmail("aaa");
        elementsTextBoxPage.inputCurrentAddress("Vojvode putnika 4");
        elementsTextBoxPage.inputPermanentAddress("Zdravke Vuckovic 74");
        elementsTextBoxPage.clickOnSubmit();
        Assert.assertTrue(driver.findElement(By.cssSelector(".mr-sm-2.field-error.form-control")).isDisplayed());

    }
    @Test(priority = 30)
    public void insertNameAndEmailWithOutAddresses() {
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Text Box");
        elementsTextBoxPage.inputFullName("Aleksandar Cvetanovic");
        elementsTextBoxPage.inputEmail("betmen007@gmail.com");
        elementsTextBoxPage.clickOnSubmit();
        Assert.assertTrue(driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12")).isDisplayed());

    }
    @Test(priority = 40)
    public void insertEmailAndTwoAddressWithOutFullName() {
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Text Box");
        elementsTextBoxPage.inputFullName("");
        elementsTextBoxPage.inputEmail("betmen007@gmail.com");
        elementsTextBoxPage.inputCurrentAddress("Vojvode putnika 4");
        elementsTextBoxPage.inputPermanentAddress("Zdravke Vuckovic 74");
        elementsTextBoxPage.clickOnSubmit();
        Assert.assertTrue(driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12")).isDisplayed());

    }
    @Test(priority = 50)
    public void clickOnYesInRadioButtons(){
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Radio Button");
        radioButtonPage.getYesImpressiveNoButtons().get(0).click();

        Assert.assertTrue(driver.findElement(By.className("mt-3")).isDisplayed());
    }

    @Test(priority = 60)
    public void clickOnImpressiveInRadioButtons(){
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Radio Button");
        radioButtonPage.getYesImpressiveNoButtons().get(1).click();

        Assert.assertTrue(driver.findElement(By.className("mt-3")).isDisplayed());
    }
    @Test(priority = 70)
    public void clickOnNoInRadioButtons(){
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Radio Button");
        radioButtonPage.clickNoButton();
        //Aertaciju ne znam, test prolazi i bez konacnog klika na NO
    }
    //Web Tables testovi
    @Test(priority = 80)
    public void inputDataRegistrationForm(){
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Web Tables");
        webTablesPage.clickAddRegistrationForm();
        webTablesPage.inputFirstName("Aleksandar");
        webTablesPage.inputLastName("Cvetanovic");
        webTablesPage.inputEmail("betmen007@gmail.com");
        webTablesPage.inputAge("35");
        webTablesPage.inputSalary("500");
        webTablesPage.inputDepartment("Analytical");
        webTablesPage.clickSubmitButton();

        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-tr.-even")).isDisplayed());
    }

    @Test(priority = 90)
    public void editLastNameUser(){
        inputDataRegistrationForm();
        webTablesPage.getEditUser().click();
        webTablesPage.getRegistrationForm().get(1).clear(); // Registration Form index 1 za prezime
        webTablesPage.getRegistrationForm().get(1).sendKeys("Djuric");
        webTablesPage.getSubmitButton().click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-tr.-even")).isDisplayed());
    }
    @Test(priority = 100)
    public void deleteUserAleksandarCvetanovic(){
        inputDataRegistrationForm();
        Assert.assertTrue(webTablesPage.getAleksandarCvetanovic().get(3).isDisplayed()); // index za mene je 3
        webTablesPage.getDeleteUser().click();
        Assert.assertTrue(webTablesPage.getAleksandarCvetanovic().get(3).getText().isBlank()); // isBlank sam izguglao

    }



    @Test
    public void testCheckbox() {
        homePage.clickOnElements();
        sidebarPage.clickOnSidebarButton("Check Box");
        elementsCheckBoxPage.checkSingleCheckbox();

        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        /*
        String currentText = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
        WebElement actualText = driver.findElement(By.id("result"));
        Assert.assertEquals(currentText,actualText);*/

    }
}
