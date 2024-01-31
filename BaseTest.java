package Base;

import Pages.Elements.ElementsCheckBoxPage;
import Pages.Elements.ElementsTextBoxPage;
import Pages.Elements.RadioButtonPage;
import Pages.Elements.WebTablesPage;
import Pages.Forms.PracticeForm;
import Pages.HomePage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public ElementsTextBoxPage elementsTextBoxPage;
    public PracticeForm practiceForm;
    public ElementsCheckBoxPage elementsCheckBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();

    }



    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
