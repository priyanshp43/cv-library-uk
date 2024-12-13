package uk.co.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.utilities.Utility;

public class ResultPage extends Utility {

    //  resultText Locator
    @CacheLookup
    @FindBy(xpath = " //label[@for='per-page']")
    WebElement resultTextLocator;


    // Method
    public void verifyTheResults(String expected) {
        String result = driver.findElement((By) resultTextLocator).getText();
        assert result.contains(expected) : "Result does not match. Expected: " + expected + ", Found: " + result;
    }
}

