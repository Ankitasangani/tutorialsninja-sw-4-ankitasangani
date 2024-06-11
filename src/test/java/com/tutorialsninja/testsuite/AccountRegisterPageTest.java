package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * <p>
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 * <p>
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * <p>
 * 3.1 Clickr on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * <p>
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 */


public class AccountRegisterPageTest extends TestBase {

    MyAccountPage myAccountPage = new MyAccountPage();
    AccountRegisterPage accountRegisterPage = new AccountRegisterPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");

        // Verify the text “Register Account”
        String expectedResult = "Register Account";
        String actualResult = myAccountPage.verifyTextRegisterAccount();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        accountRegisterPage.registrationDetails();
        accountRegisterPage.selectSubscribeButton();
        accountRegisterPage.clickOnPrivacyPolicy();
        accountRegisterPage.clickOnContinueButton();

        //Verify the message “Your Account Has Been Created!”
        String expectedResult = "Your Account Has Been Created!";
        String actualResult = accountRegisterPage.verifyAccountMessage();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

        accountRegisterPage.clickOnNextContinueButton();
        accountRegisterPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = accountRegisterPage.verifyAccountLogout();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        accountRegisterPage.clickOnNextContinueButton();
    }

}
