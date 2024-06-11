package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends Utility {

    By currencyDropdown = By.xpath("//span[normalize-space()='Currency']"); // Mouse hover on Currency Dropdown and click
    By poundSterling = By.xpath("//button[normalize-space()='£Pound Sterling']"); // Mouse hover on £Pound Sterling and click
    By sortBy = By.id("input-sort"); // Select Sort By position "Name: A to Z"
    By productHP = By.xpath("//a[normalize-space()='HP LP3065']"); // Select product “HP LP3065”
    By verifyTextHP = By.xpath("//h1[normalize-space()='HP LP3065']"); // Verify the Text "HP LP3065"
    By openCalender = By.xpath("//div[@class='input-group date']//button[@type='button']"); // Open the calendar
    By monthYear = By.xpath("//div[@class='datepicker-days']//thead//tr[1]"); // get Text month and year
    By nextMonth = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"); // click on '>' for next Month
    By dateAndDay = By.xpath("//td[contains(@class,'day')]"); // select the date
    By addToCart = By.xpath("//button[@id='button-cart']"); // Click on “Add to Cart” button
    By message = By.xpath("//div[contains(text(),'Success')]"); // Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    By link = By.xpath("//a[normalize-space()='shopping cart']"); // Click on link “shopping cart” display into success message
    By shoppingCart = By.xpath("//h1[contains(text(),'Shopping Cart')]"); // Verify the text "Shopping Cart"
    By productName = By.linkText("HP LP3065"); // Verify the Product name "HP LP3065"
    By verifyDate = By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"); // Verify the Delivery Date "2023-11-27"
    By verifyModel = By.xpath("//td[normalize-space()='Product 21']"); // Verify the Model "Product21"
    By total = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"); // Verify the Total "£74.73"


    public void mouseHoverOnCurrencyDropdownAndClick() {
        mouseHoverToElementAndClick(currencyDropdown);
    }

    public void mouseHoverOnPoundSterlingAndClick() {
        mouseHoverToElementAndClick(poundSterling);
    }

    public void SortByPositionAToZ() {
        selectByValueFromDropDown(sortBy, "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
    }

    public void selectProductHP() {
        clickOnElement(productHP);
    }

    public String verifyTextHPLP3065() {
        return getTextFromElement(verifyTextHP);
    }

    public void selectDeliveryDate() {
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(openCalender);

        while (true) {
            String monthAndYear = getTextFromElement(monthYear);
            String[] a = monthAndYear.split(" ");
            String mon = a[1];
            String yer = a[2];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(nextMonth);
            }
        }
        // Select the Date
        List<WebElement> allDates = getMultipleElements(dateAndDay);
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String verifyTheMessage() {
        return getTextFromElement(message).substring(0, 56);
    }

    public void clickOnLinkShoppingCart() {
        clickOnElement(link);
    }

    public String verifyTheTextShoppingCart() {
        return getTextFromElement(shoppingCart).substring(0, 13);
    }

    public String verifyTheProductNameHPLP3065() {
        return getTextFromElement(productName);
    }

    public String verifyTheDeliveryDate() {
        return getTextFromElement(verifyDate).substring(14, 24);
    }

    public String verifyTheModelProduct21() {
        return getTextFromElement(verifyModel);
    }

    public String verifyTheTotal() {
        return getTextFromElement(total);
    }
}
