package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By click = By.xpath("//a[normalize-space()='Laptops & Notebooks']"); // Mouse hover on “Laptops & Notebooks” Tab and click
    By laptopsNotebooks = By.xpath("//h2[normalize-space()='Laptops & Notebooks']"); // Verify the text "Laptops & Notebooks"
    By price = By.id("input-sort"); // //Select Sort By position "Price high to low"
    By priceValue = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']"); // before Filter price value
    By afterFilter = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']"); // After filter price
    By product = By.linkText("Sony VAIO"); // //Select Product “Sony VAIO”
    By verifySonyVAIO = By.xpath("//h1[contains(text(),'Sony VAIO')]"); // Verify the text “Sony VAIO”
    By message = By.xpath("//div[contains(text(),'Success')]"); // Verify the message “Success: You have added Sony VAIO to your shopping cart!”
    By productSony = By.linkText("Sony VAIO");  // Verify the Product name "Sony VAIO"
    By quantity = By.xpath("//input[@class='form-control']"); // change quantity "2"
    By update = By.xpath("//button[@type='submit']"); // Click on “Update” Tab
    By updateMessage = By.xpath("//div[contains(text(),'Success')]"); //Verify the message “Success: You have modified your shopping cart!”
    By totalAmount = By.xpath("//tbody//tr//td[6]"); // Verify the Total £1,472.45
    By checkout = By.xpath("//a[@class='btn btn-primary']"); //Click on “Checkout” button
    By textCheckout = By.xpath("//h1[normalize-space()='Checkout']"); // Verify the text “Checkout”
    By newCustomer = By.xpath("//h2[contains(text(),'New Customer')]");  // Verify the Text “New Customer”
    By radioBtn = By.xpath("//input[@value='guest']"); //Click on “Guest Checkout” radio button
    By tabContinue = By.id("button-account"); // //Click on “Continue” tab
    By firstName = By.id("input-payment-firstname");
    By lastname = By.id("input-payment-lastname");
    By eMail = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postcode = By.id("input-payment-postcode");
    By payment = By.id("input-payment-zone");
    By guest = By.id("button-guest"); // //Click on “Continue” Button
    By comments = By.xpath("//textarea[@name='comment']"); // Add Comments About your order into text area
    By shipping = By.id("button-shipping-method"); // //Click on “Continue” button
    By checkBox = By.xpath("//input[@name='agree']"); // // Check the Terms & Conditions check box
    By pay = By.id("button-payment-method"); // click on payment button
    By confirm = By.id("button-confirm"); // confirm Order button


    // create method with name "selectMenu" it has one parameter name "menu" of type string
    // This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        List<WebElement> elements = getMultipleElements(By.xpath("//a[@class='see-all']"));
        for (WebElement e : elements) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }


    public void mouseHoverAndClickOnLaptopsNotebooks() {
        mouseHoverToElementAndClick(click);
    }

    public String verifyTextLaptopsNotebooks() {
        return getTextFromElement(laptopsNotebooks);
    }

    public void selectSortByPriceHighToLow() {
        selectByValueFromDropDown(price, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
    }

    public List<Double> beforeFilterProductPrice() throws InterruptedException {
        List<WebElement> beforeFilterProductPrice = getMultipleElements(priceValue);
        //Create arraylist
        List<Double> beforeFilterProductPriceList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : beforeFilterProductPrice) {
            String beforeFilterPrice = p.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double priceValueBeforeFilter = Double.parseDouble(beforeFilterPrice);
            beforeFilterProductPriceList.add(priceValueBeforeFilter);
        }
        //Sort arraylist to ascending order
        Collections.sort(beforeFilterProductPriceList);
        //Reverse the list
        Collections.reverse(beforeFilterProductPriceList);
        return beforeFilterProductPriceList;
    }


    public List<Double> afterFilterProductPrice() {
        //Store elements after filtering
        List<WebElement> afterFilterProductPrice = getMultipleElements(afterFilter);
        //Create another list to store text of elements after clicking on filter Price high to low
        List<Double> afterFilterProductPriceList = new ArrayList<>();
        for (WebElement s : afterFilterProductPrice) {
            String afterFilterPrice = s.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double afterFilterPriceValue = Double.parseDouble(afterFilterPrice);
            afterFilterProductPriceList.add(afterFilterPriceValue);
        }
        return afterFilterProductPriceList;
    }


    public void selectProductSonyVAIO() {
        clickOnElement(product);
    }

    public String verifyTextSonyVAIO() {
        return getTextFromElement(verifySonyVAIO);
    }

    public String verifyTextMessage() {
        return getTextFromElement(message).substring(0, 56);
    }

    public String verifyTheProductSonyVAIO() {
        return getTextFromElement(productSony);
    }

    public void changeQty() {
        driver.findElement(quantity).clear();
        sendTextToElement(quantity, "2");
    }

    public void clickOnUpdateTab() {
        clickOnElement(update);
    }

    public String modifiedMessage() {
        return getTextFromElement(updateMessage).substring(0, 46);
    }

    public String verifyTotal() {
        return getTextFromElement(totalAmount);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkout);
    }

    public String verifyTheTextCheckout() {
        return getTextFromElement(textCheckout);
    }

    public String verifyTheTextNewCustomer() {
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckout() {
        clickOnElement(radioBtn);
    }

    public void clickOnContinueTab() {
        clickOnElement(tabContinue);
    }

    public void guestCheckoutFields() {
        sendTextToElement(firstName, "Ankita");
        sendTextToElement(lastname, "Sangi");
        sendTextToElement(eMail, "ankita456@gmail.com");
        sendTextToElement(telephone, "07724567892");
        sendTextToElement(address, "25 Harbor Street");
        sendTextToElement(city, "birmingham");
        sendTextToElement(postcode, "B202DW");
        selectByValueFromDropDown(payment, "3569");
    }

    public void clickOnContinueButtonGuest() {
        clickOnElement(guest);
    }

    public void addCommentsAboutOrder() {
        sendTextToElement(comments, "macbook is out of stock");
    }

    public void continueButton() {
        clickOnElement(shipping);

    }

    public void termsAndConditionCheckBox() {
        clickOnElement(checkBox);
    }

    public void nextContinueButton() {
        clickOnElement(pay);
    }

    public void confirmOrderButton() {
        clickOnElement(confirm);
    }
}













































