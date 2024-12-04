package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {
    SHAFT.GUI.WebDriver driver;

    //constructor
    public P01_LoginPage(SHAFT.GUI.WebDriver driver){ this.driver=driver;}
    //Locators
    By userNameInput = By.xpath("//input[@name=\"username\"]");
    By passwordInput = By.xpath("//input[@type=\"password\"]");
    By loginBtn = By.xpath ("//button[@type=\"submit\"]");

    //Methods
    public P02_HomePage loginSteps(String username , String password){
        driver.element().type(userNameInput,username).and().type(passwordInput,password).and().click(loginBtn);
        return new P02_HomePage(driver);

    }
}
