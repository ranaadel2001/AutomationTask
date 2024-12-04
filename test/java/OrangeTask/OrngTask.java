package OrangeTask;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class OrngTask {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData; // to use test data bn3mel intialize

    @Test
    public void start() throws InterruptedException{

     new P01_LoginPage(driver).loginSteps(testData.getTestData("userName"), testData.getTestData("password")).clickAdminTab().getOriginalRecords().clickAddButton().fillForm(testData.getTestData("newUsername"),testData.getTestData("newPassword")).formSubmittedSuccessfully().getNumberafterAddingNewUserRecords().numberOfRecordsIncBy1();//3rfna el hagat f page tanya w nadena 3aleha

     new P03_AdminPage(driver).getNumberOfRecords();
     Thread.sleep(5000);

    }
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver before each test
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        testData = new SHAFT.TestData.JSON("OrangeTest.json");//3shan n3araf el test data
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver after each test
        driver.quit();
    }
}
