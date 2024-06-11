package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * <p>
 * 2.1 Click on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 * <p>
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * <p>
 * 4.1 Click on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Click on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
public class AccountLoginPageTest extends TestBase {

    MyAccountPage myAccountPage = new MyAccountPage();
    AccountLoginPage accountLoginPage = new AccountLoginPage();
    AccountRegisterPage accountRegisterPage = new AccountRegisterPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");

        // Verify the text “Returning Customer”
        String expectedResult = "Returning Customer";
        String actualResult = myAccountPage.verifyTextReturningCustomer();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress();
        accountLoginPage.enterPassword();
        accountLoginPage.clickOnLoginButton();

        // Verify text “My Account”
        String expectedResult = "My Account";
        String actualResult = accountLoginPage.verifyTextMyAccount();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
        accountLoginPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = accountRegisterPage.verifyAccountLogout();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        accountRegisterPage.clickOnNextContinueButton();

    }
}
























