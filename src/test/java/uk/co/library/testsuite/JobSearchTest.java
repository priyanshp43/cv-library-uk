package uk.co.library.testsuite;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.co.library.pages.HomePage;
import uk.co.library.testbase.BaseTest;

public class JobSearchTest extends BaseTest {


    HomePage homePage;

    @BeforeMethod

    public void inIt() {

        homePage = new HomePage();
    }

    @Test
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) {
        homePage.handleConsentForm();
        homePage.enterJobTitle("HR");
        homePage.enterLocation("London");
        homePage.selectDistance("10 miles");
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary("30,000");
        homePage.enterMaxSalary("60,000");
        homePage.selectSalaryType("Per month");
        homePage.selectJobType("Permanent");
        homePage.clickOnFindJobsButton();

    }

    @DataProvider(name = "jobSearchData")
    public Object[][] getJobSearchData() {
        return new Object[][]{
                {"Tester", "Harrow", "up to 5 miles", "30000", "500000", "Per annum", "Permanent", "Permanent Tester jobs in Harrow on the Hill"},
                {"Developer", "London", "up to 10 miles", "40000", "60000", "Per annum", "Permanent", "Permanent Developer jobs in London"},
                {"Manager", "Manchester", "up to 20 miles", "50000", "70000", "Per annum", "Permanent", "Permanent Manager jobs in Manchester"},
                {"Engineer", "Birmingham", "up to 5 miles", "35000", "55000", "Per annum", "Contract", "Contract Engineer jobs in Birmingham"},
                {"Analyst", "Edinburgh", "up to 15 miles", "30000", "45000", "Per annum", "Permanent", "Permanent Analyst jobs in Edinburgh"},
                {"Support", "Bristol", "up to 10 miles", "25000", "40000", "Per annum", "Permanent", "Permanent Support jobs in Bristol"}
        };
    }


}



