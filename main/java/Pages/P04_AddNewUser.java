package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AddNewUser {
    SHAFT.GUI.WebDriver driver;
    //lazm constructor
    public P04_AddNewUser(SHAFT.GUI.WebDriver driver){ this.driver=driver;}
    By userRoleDropDown = By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By selectUserRole = By.xpath("//div[@class=\"oxd-select-option\"] [contains(.,'Admin')]");
    By employeeNameInput = By.xpath("//label[contains(.,'Employee Name')]//following::input[1]");
    By employeeNameEle = By.xpath("//span[@class=\"oxd-userdropdown-tab\"]//p");
    By selectEmployee = By.xpath("(//div[@role='option'])[1]");
    By StatusDropDown = By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By selectStatus = By.xpath ("//div[@class=\"oxd-select-option\"] [contains(.,'Enabled')]");
    By userNameInput = By.xpath("//label[contains(.,'Username')]//following::input[1]");
    By PasswordInput = By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By ConfirmPasswordInput = By.xpath("//label[contains(.,'Confirm Password')]//following::input[1]");
    By saveButton = By.xpath ("//button[@type=\"submit\"]");


    public P03_AdminPage fillForm(String newUsername , String newPassword) throws InterruptedException {
        driver.element().click(userRoleDropDown).and().click(selectUserRole).and().type(employeeNameInput,getEmployeeName());
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until( d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmployee));
            driver.element().click(selectEmployee).and().click(StatusDropDown).click(selectStatus).type(userNameInput,newUsername).type(PasswordInput, newPassword).type(ConfirmPasswordInput, newPassword).and().click(saveButton);
            return new P03_AdminPage(driver);



    }
    public String getEmployeeName(){
        return driver.element().getText(employeeNameEle);

    }

}
