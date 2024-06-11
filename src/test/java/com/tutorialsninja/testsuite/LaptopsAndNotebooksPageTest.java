package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * <p>
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * <p>
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */

public class LaptopsAndNotebooksPageTest extends TestBase {

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        laptopsAndNotebooksPage.mouseHoverAndClickOnLaptopsNotebooks();
        laptopsAndNotebooksPage.selectMenu("Show AllLaptops & Notebooks");

        // Verify the text "Laptops & Notebooks"
        String expectedResult = "Laptops & Notebooks";
        String actualResult = laptopsAndNotebooksPage.verifyTextLaptopsNotebooks();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        laptopsAndNotebooksPage.mouseHoverAndClickOnLaptopsNotebooks();
        laptopsAndNotebooksPage.selectMenu("Show AllLaptops & Notebooks");
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();

        List<Double> actualText = laptopsAndNotebooksPage.beforeFilterProductPrice();
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
        Thread.sleep(2000);
        List<Double> expectedText = laptopsAndNotebooksPage.afterFilterProductPrice();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        shoppingCartPage.mouseHoverOnCurrencyDropdownAndClick();
        shoppingCartPage.mouseHoverOnPoundSterlingAndClick();
        laptopsAndNotebooksPage.mouseHoverAndClickOnLaptopsNotebooks();
        laptopsAndNotebooksPage.selectMenu("Show AllLaptops & Notebooks");
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
        laptopsAndNotebooksPage.selectProductSonyVAIO();

        //Verify the text “Sony VAIO”
        String expectedResult = "Sony VAIO";
        String actualResult = laptopsAndNotebooksPage.verifyTextSonyVAIO();
        Assert.assertEquals(actualResult, expectedResult, "Text didn't match!");

        shoppingCartPage.clickOnAddToCartButton();
        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        String expectedMessage = "Success: You have added Sony VAIO to your shopping cart!";
        String actualMessage = laptopsAndNotebooksPage.verifyTextMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Text didn't match!");

        shoppingCartPage.clickOnLinkShoppingCart();
        // Verify the text "Shopping Cart"
        String expectedText = "Shopping Cart";
        String actualText = shoppingCartPage.verifyTheTextShoppingCart();
        Assert.assertEquals(actualText, expectedText, "Text didn't match!");

        // Verify the Product name "Sony VAIO"
        String expectedProduct = "Sony VAIO";
        String actualProduct = laptopsAndNotebooksPage.verifyTheProductSonyVAIO();
        Assert.assertEquals(actualProduct, expectedProduct, "Text didn't match!");

        laptopsAndNotebooksPage.changeQty();
        laptopsAndNotebooksPage.clickOnUpdateTab();

        // Verify the message “Success: You have modified your shopping cart!”
        String expectedUpdate = "Success: You have modified your shopping cart!";
        String actualUpdate = laptopsAndNotebooksPage.modifiedMessage();
        Assert.assertEquals(actualUpdate, expectedUpdate, "Text didn't match!");

        // Verify the Total "£1,472.45"
        String expectedTotal = "£1,472.45";
        String actualTotal = laptopsAndNotebooksPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Text didn't match!");
        laptopsAndNotebooksPage.clickOnCheckOutButton();

        // Verify the text “Checkout”
        String expected = "Checkout";
        String actual = laptopsAndNotebooksPage.verifyTheTextCheckout();
        Assert.assertEquals(actual, expected, "Text didn't match!");

        // Verify the text “New Customer”
        String expectedNew = "New Customer";
        String actualNew = laptopsAndNotebooksPage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualNew, expectedNew, "Text didn't match!");

        laptopsAndNotebooksPage.clickOnGuestCheckout();
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.guestCheckoutFields();
        laptopsAndNotebooksPage.clickOnContinueButtonGuest();
        laptopsAndNotebooksPage.addCommentsAboutOrder();
        laptopsAndNotebooksPage.continueButton();
        Thread.sleep(2000);
        laptopsAndNotebooksPage.termsAndConditionCheckBox();
        laptopsAndNotebooksPage.nextContinueButton();
        laptopsAndNotebooksPage.confirmOrderButton();
    }
}

















