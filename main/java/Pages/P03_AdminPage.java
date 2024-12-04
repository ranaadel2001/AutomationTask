package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_AdminPage {

    SHAFT.GUI.WebDriver driver;
  static  int originalNumberOfRecords , cNumberOfRecordsAfter;

    //constructor
    public P03_AdminPage(SHAFT.GUI.WebDriver driver){ this.driver=driver;}
    //Locators
    By numberOfrecordsEle = By.xpath("//span[@class=\"oxd-text oxd-text--span\"][contains(.,\"Records\")]");
    By addBtn = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    By successMsg = By.xpath("//div[@class=\"oxd-toast-start\"]//p[contains(.,'Successfully Saved')]");

    //methods
    public int getNumberOfRecords (){
        int numberOfrecords = Integer.parseInt(driver.element().getText(numberOfrecordsEle).replaceAll("[^0-9]", ""));
        System.out.println("Number of records found:  "+ numberOfrecords);
        return numberOfrecords;

    }

    public P03_AdminPage getOriginalRecords(){
        originalNumberOfRecords = getNumberOfRecords();
        System.out.println("original number of records found : " + originalNumberOfRecords);
        return this;


    }

    public P03_AdminPage getNumberafterAddingNewUserRecords(){
        cNumberOfRecordsAfter = getNumberOfRecords();
        System.out.println("original number of records found : " + cNumberOfRecordsAfter);
        return this; //lw fe moshkla shele de


    }
    public P04_AddNewUser clickAddButton(){
        driver.element().click(addBtn);
        return new P04_AddNewUser(driver);
    }

    public P03_AdminPage formSubmittedSuccessfully(){
        driver.element().assertThat(successMsg).exists().perform(); // ay haga n3mlha assert lazm n2felha b perform
        return this;
    }

    public void numberOfRecordsIncBy1 (){
        SHAFT.Validations.verifyThat().object(cNumberOfRecordsAfter).isEqualTo(originalNumberOfRecords+1).perform();
    }
}
