package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * <p>
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * <p>
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * <p>
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * <p>
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */
public class DesktopsPageTest extends TestBase {

    DesktopPage desktopPage = new DesktopPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        desktopPage.mouseHoverAndClickOnDesktops();
        desktopPage.selectMenu("Show AllDesktops");

        // Verify the text ‘Desktops’
        String expectedResult = "Desktops";
        String actualResult = desktopPage.verifyTextDesktops();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        desktopPage.mouseHoverAndClickOnDesktops();
        desktopPage.clickOnShowAllDesktops();

        List<String> actualText = desktopPage.verifyDescendingOrder();
        desktopPage.SortByPositionZtoA();
        Thread.sleep(2000);
        List<String> expectedText = desktopPage.getProductsNameAfterFilterZToA();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        shoppingCartPage.mouseHoverOnCurrencyDropdownAndClick();
        shoppingCartPage.mouseHoverOnPoundSterlingAndClick();
        desktopPage.mouseHoverAndClickOnDesktops();
        desktopPage.clickOnShowAllDesktops();
        shoppingCartPage.SortByPositionAToZ();
        shoppingCartPage.selectProductHP();

        // Verify the text "HP LP3065"
        String expectedResult = "HP LP3065";
        String actualResult = shoppingCartPage.verifyTextHPLP3065();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

        shoppingCartPage.selectDeliveryDate();
        shoppingCartPage.clickOnAddToCartButton();

        // Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!";
        String actualMessage = shoppingCartPage.verifyTheMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Text didn't match!");

        shoppingCartPage.clickOnLinkShoppingCart();

        // Verify the text "Shopping Cart"
        String expectedText = "Shopping Cart";
        String actualText = shoppingCartPage.verifyTheTextShoppingCart();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        // Verify the Product name "HP LP3065"
        String expectedName = "HP LP3065";
        String actualName = shoppingCartPage.verifyTheProductNameHPLP3065();
        Assert.assertEquals(actualName, expectedName, "Text didn't match!");

        // Verify the Delivery Date "2023-11-27"
        String expectedDate = "2023-11-27";
        String actualDate = shoppingCartPage.verifyTheDeliveryDate();
        Assert.assertEquals(actualDate, expectedDate, "Text didn't match!");

        // Verify the Model "Product21"
        String expectedModel = "Product 21";
        String actualModel = shoppingCartPage.verifyTheModelProduct21();
        Assert.assertEquals(actualModel, expectedModel, "Text didn't match!");

        // Verify the Total "£74.73"
        String expectedTotal = "£74.73";
        String actualTotal = shoppingCartPage.verifyTheTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Text didn't match!");

    }
}
