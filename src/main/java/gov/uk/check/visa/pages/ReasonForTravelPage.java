package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReasonForTravelPage extends Utility {
   @CacheLookup
   @FindBy (xpath = "//div[@class='gem-c-radio govuk-radios__item']//label")
   List<WebElement> reasonForVisitList;


    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;


    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectReasonForVisit(String reason){

               for(WebElement reason1 : reasonForVisitList){
            if(reason1.getText().equalsIgnoreCase(reason)){
               reason1.click();
                break;
            }
        }


        }


            public void clickNextButton(){

            pmClickOnElement(nextStepButton);
        }
}
