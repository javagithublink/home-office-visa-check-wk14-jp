package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy (xpath = "//div [@class='govuk-radios']//div//label")
    List<WebElement> selectJobTypeList;


    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectJobType(String job){
        for(WebElement jobType:selectJobTypeList){
            if(jobType.getText().equalsIgnoreCase(job)){
                pmClickOnElement(jobType);
                break;
            }
        }
    }

    public void clickNextStepButton(){
        pmClickOnElement(nextStepButton);
    }
}
