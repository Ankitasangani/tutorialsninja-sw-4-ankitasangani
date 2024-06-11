package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends TestBase {

    ComponentsPage componentsPage = new ComponentsPage();


    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        componentsPage.mouseHoverAndClickOnComponents();
        componentsPage.selectMenu("Show AllComponents");

        // Verify the text "Components"
        String expectedResult = "Components";
        String actualResult = componentsPage.verifyTextComponents();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

    }
}
