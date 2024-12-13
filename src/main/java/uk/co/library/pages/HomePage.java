package uk.co.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import uk.co.library.utilities.Utility;

//moreSearchOptionsLink, salaryMin, salaryMax, salaryTypeDropDown, jobTypeDropDown, findJobsBtn
//  Methods - enterJobTitle(String jobTitle), enterLocation(String location), selectDistance(String distance), clickOnMoreSearchOptionLink(),
//  enterMinSalary(String minSalary),  enterMaxSalary(String maxSalary), selectSalaryType(String sType), selectJobType(String jobType),
//  clickOnFindJobsButton().

public class HomePage extends Utility {



    @CacheLookup
    @FindBy(id = "cf_consent-buttons__accept-all")
    WebElement acceptAllConsentButton;

    // Option 1: Using ID (if the button has an id attribute)
//        try {
//        WebElement acceptButton = driver.findElement(By.id("accept-all"));
//        // Example id
//        acceptButton.click();
//        System.out.println("Clicked the Accept button.");
//    } catch (Exception e) {
//        System.out.println("Could not find button with ID.");
//    }

    //  jobTitle
    @CacheLookup
    @FindBy(xpath = " //input[@id='keywords']")
    WebElement jobTitleTextArea;

    // location
    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationTextArea;

    //distanceDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;

    //moreSearchOptionsLink
    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;

    //salaryMin
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    //salaryMax
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;


    //salaryTypeDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;


    //jobTypeDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;


    //findJobsBtn
    @CacheLookup
    @FindBy(id = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;


    //  Methods - enterJobTitle(String jobTitle), enterLocation(String location), selectDistance(String distance), clickOnMoreSearchOptionLink(),
//  enterMinSalary(String minSalary),  enterMaxSalary(String maxSalary), selectSalaryType(String sType), selectJobType(String jobType),
//  clickOnFindJobsButton()

    public void handleConsentForm() {

        WebElement acceptAllButton = waitForElementWithFluentWait(By.id("#cf_consent-buttons__accept-all"), 30, 5);
        acceptAllConsentButton.click();


        try {

            WebElement shadowHost = waitForElementWithFluentWait(By.cssSelector("div.cf_modal_container"), 15, 500);
            // WebElement shadowHost = driver.findElement(By.cssSelector("div.cf_modal_container"));
            WebElement rejectButton = getShadowElement(shadowHost, "button#cf_consent-buttons__reject-all");
            rejectButton.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterJobTitle(String jobTitle) {
        jobTitleTextArea.sendKeys(jobTitle);
    }

    public void enterLocation(String location) {
        locationTextArea.sendKeys(location);
    }


    //selectDistance(String distance) Method
    public void selectDistance(String distance) {
        distanceDropDown.sendKeys(distance);
    }


    //clickOnMoreSearchOptionLink() Method
    public void clickOnMoreSearchOptionLink() {
        moreSearchOptionsLink.click();
    }

    //enterMinSalary(String minSalary) Method
    public void enterMinSalary(String minSalary) {
        salaryMin.sendKeys(minSalary);
    }

    //enterMaxSalary(String maxSalary) Method
    public void enterMaxSalary(String maxSalary) {
        salaryMax.sendKeys(maxSalary);
    }

    //selectSalaryType(String sType) Method
    public void selectSalaryType(String sType) {
        salaryTypeDropDown.click();
    }

   // selectJobType(String jobType)
    public void selectJobType(String jobType){
        jobTypeDropDown.click();
    }

    // clickOnFindJobsButton()
    public void  clickOnFindJobsButton(){
        findJobsBtn.click();
    }


}

