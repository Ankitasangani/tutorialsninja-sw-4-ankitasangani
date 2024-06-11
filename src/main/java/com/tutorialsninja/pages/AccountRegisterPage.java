package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class AccountRegisterPage extends Utility {

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subscribe = By.xpath("//label[normalize-space()='Yes']"); // Select Subscribe Yes radio button
    By checkBox = By.xpath("//input[@name='agree']"); // Click on Privacy Policy check box
    By button = By.xpath("//input[@value='Continue']"); //Click on Continue button
    By verify = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"); //Verify the message “Your Account Has Been Created!”
    By nextButton = By.xpath("//a[normalize-space()='Continue']"); //Click on Continue button
    By link = By.xpath("//span[normalize-space()='My Account']"); // Click on My Account Link
    By logout = By.xpath("//div[@id='content']//h1"); // Verify the text “Account Logout”


    public void registrationDetails() {
        sendTextToElement(firstName, "Ankita");
        sendTextToElement(lastName, "Sangi");
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);            //Create random username
        String emailID = "User" + userName + "@example.com";
        sendTextToElement(email, emailID);
        sendTextToElement(telephone, "07724567892");
        sendTextToElement(password, "abc123");
        sendTextToElement(confirmPassword, "abc123");
    }

    public void selectSubscribeButton() {
        clickOnElement(subscribe);
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(checkBox);
    }

    public void clickOnContinueButton() {
        clickOnElement(button);
    }

    public String verifyAccountMessage() {
        return getTextFromElement(verify);
    }

    public void clickOnNextContinueButton() {
        clickOnElement(nextButton);
    }

    public void clickOnMyAccountLink() {
        clickOnElement(link);
    }

    public String verifyAccountLogout() {
        return getTextFromElement(logout);
    }
}
