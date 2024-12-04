package OrangeTask;
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
public class Testing {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    //locators
    By adminClick = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    By clickOnAddUser = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    By clickOnstatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
    By statusValue = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");

    By employeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By typeUsername = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By typePassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");

    By confirmPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");

    By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    // Test method
    @Test
    public void start() {

        driver.element()
                .click(adminClick)
                .and()
                .click(clickOnAddUser)
                .and()
                .click(userRoleDropdown).and().click(clickOnstatus)
                .and().click(statusValue)
                .and().type(employeeName,"King Virat Kholi")
                .and().type(typeUsername,"ranaadel")
                .and().type(typePassword,"a12345678")
                .and().type(confirmPassword,"a12345678")
                .and().click(saveButton);

        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(clickOnstatus));

        Actions actions = new Actions(driver.getDriver());
        actions.sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        String recordCountText = new ElementActions((WebDriver) driver)
                .getText(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));

        String recordCountText2 = new ElementActions((WebDriver) driver)
                .getText(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));

        // Check if the record count has changed
        if (!recordCountText2.equals(recordCountText)) {
            System.out.println("Record's number changed");
        }
    }

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver before each test
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        testData = new SHAFT.TestData.JSON("OrangeTest.json");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver after each test
        driver.quit();
    }
}




