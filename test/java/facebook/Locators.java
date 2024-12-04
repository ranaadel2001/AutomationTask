//package facebook;
//
//import com.shaft.driver.SHAFT;
//import org.openqa.selenium.By;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class Locators {
//    //locators
//  SHAFT.GUI.WebDriver driver;
//    By loginButton = By.id("u_0_5_do");
//    By emailInput = By.id("email");
//
//    By loginBtn2 = By.name("login");
//
//    By loginBtn3 = By.className("uiContextualLayerParent");
//
//    By passwordInput = By.id("passContainer");
//
//
//    // test methods
//
//    @Test
//    public void login(){
//
//        driver.browser().navigateToURL("https://www.facebook.com/");
//        driver.element().type(emailInput,"Test@gmail.com");
//        driver.element().type(passwordInput,"12345555556");
//        driver.element().click(loginButton);
//    }
//    //before methods
//
//    @BeforeClass
//    public void beforeClass() {
//        driver = new SHAFT.GUI.WebDriver();
////        testData = new SHAFT.TestData.JSON("simpleJSON.json");
//    }
//    //after methods
//    @AfterClass(alwaysRun = true)
//    public void afterClass(){
////        driver.quit();
//    }
//}
package facebook;


import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Locators {
    SHAFT.GUI.WebDriver driver;

    //Locators
    By emailInput = By.id("email");
    By passInput = By.id("pass");
    By loginBtn = By.xpath("//button[@name='login']");
    By errorMsg = By.xpath("//div[@class='_9ay7']");



    //Test Methods
    @Test
    public void login(){
        driver.browser().navigateToURL("https://www.facebook.com/");
        driver.element().type(emailInput,"Test@Gmail.com").
                and().type(passInput,"P@ssw0rd").
                and().click(loginBtn);
        driver.element().assertThat(errorMsg).exists().perform();
        driver.element().assertThat(errorMsg).text().contains("The password you’ve entered is incorrect.").perform();
//        driver.element().type(passInput,"P@ssw0rd");
    }


    //Before Method
    @BeforeClass
    public void setUp(){
        driver = new SHAFT.GUI.WebDriver();
    }

    //After Method
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
