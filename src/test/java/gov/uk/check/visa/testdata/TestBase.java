package gov.uk.check.visa.testdata;

import gov.uk.check.visa.propertyreader.PropertyReader;
import gov.uk.check.visa.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

   /* @Test
    public void testMethod(){
        System.out.println("Hello World");
    }*/

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }

}
