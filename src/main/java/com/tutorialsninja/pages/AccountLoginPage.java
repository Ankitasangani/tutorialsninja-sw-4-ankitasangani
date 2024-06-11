package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class AccountLoginPage extends Utility {

    By email = By.id("input-email"); // Enter Email address
    By password = By.id("input-password"); // Enter Password
    By loginButton = By.xpath("//input[@value='Login']");  // Click on Login button
    By account = By.xpath("//h2[contains(text(),'My Account')]"); // Verify text “My Account”
    By link = By.xpath("//span[normalize-space()='My Account']"); // Click on My Account Link


    public void enterEmailAddress(){
        sendTextToElement(email, "abc123465@gmail.com");
    }

    public void enterPassword(){
        sendTextToElement(password, "abc123");
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        return getTextFromElement(account);
    }

    public void clickOnMyAccountLink(){
        clickOnElement(link);
    }

}
