package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsCheckBoxPage extends BaseTest {

    WebElement singleCheckboxLocator;

    public ElementsCheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSingleCheckboxLocator() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
    }

    public void checkSingleCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


}
