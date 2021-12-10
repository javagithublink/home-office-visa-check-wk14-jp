package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy (xpath = "//label[normalize-space()='Yes']")
    WebElement yes;

    @CacheLookup
    @FindBy (xpath = "//label[normalize-space()='No']")
    WebElement no;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver,this);
    }

    public void selectImmigrationStatus(String status){

        switch(status.trim()){

            case "Yes":
                pmClickOnElement(yes);
                break;

            case "No":
                pmClickOnElement(no);
                break;

        }


    }

    public void clickNextStepButton(){
        pmClickOnElement(nextStepButton);
    }

}
