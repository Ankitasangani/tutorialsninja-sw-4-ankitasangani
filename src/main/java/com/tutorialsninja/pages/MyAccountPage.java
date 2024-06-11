package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {

    By linkMyAccount = By.xpath("//span[normalize-space()='My Account']"); //Click on My Account Link
    By verify = By.xpath("//h1[normalize-space()='Register Account']"); // Verify the text “Register Account”
    By verifyText = By.xpath("//h2[normalize-space()='Returning Customer']"); // Verify the text “Returning Customer”.


    // create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    // This method should click on the options whatever name is passed as parameter.
    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    public void clickOnMyAccountLink() {
        clickOnElement(linkMyAccount);
    }

    public String verifyTextRegisterAccount() {
        return getTextFromElement(verify);
    }


    public String verifyTextReturningCustomer() {
        return getTextFromElement(verifyText);
    }


}
