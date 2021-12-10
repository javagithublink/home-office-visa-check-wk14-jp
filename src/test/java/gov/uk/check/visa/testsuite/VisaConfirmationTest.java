package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testdata.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {


    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ResultPage resultPage;
    ReasonForTravelPage reasonForTravelPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;

    @BeforeMethod
    public void init(){
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        resultPage = new ResultPage();
        reasonForTravelPage = new ReasonForTravelPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();

    }

    @Test (groups = {"smoke","sanity","regression"})
    public void anAustralianComingToUKForTourism(){

        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Tourism");
        reasonForTravelPage.clickNextButton();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK".trim());

    }

    @Test (groups = "regression")
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){

        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickNextButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickNextStepButton();
        resultPage.confirmResultMessage("You need a visa to work in health and care".trim());

    }

    @Test (groups = {"sanity","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){

        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        reasonForTravelPage.clickNextButton();
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        familyImmigrationStatusPage.clickNextStepButton();
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK".trim());


    }


}
