package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    By desktops = By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"); // // Mouse hover on “Desktops” Tab and click
    By textDesktops = By.xpath("//h2[normalize-space()='Desktops']"); // Verify the text ‘Desktops’
    By click = By.xpath("//a[normalize-space()='Show AllDesktops']"); // click on “Show All Desktops”
    By sort = By.id("input-sort"); // Select Sort By position "Name: Z to A"
    By descend = By.xpath("//div[@class='caption']//h4//a"); // Verify the Product will arrange in Descending order
    By element = By.xpath("//div[@class='caption']//h4"); // Store elements after filtering

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

    public void mouseHoverAndClickOnDesktops() {
        mouseHoverToElementAndClick(desktops);
    }

    public String verifyTextDesktops() {
        return getTextFromElement(textDesktops);
    }

    public void clickOnShowAllDesktops() {
        mouseHoverToElementAndClick(click);
    }

    public void SortByPositionZtoA() {
        selectByVisibleTextFromDropDown(sort, "Name (Z - A)");
    }

    public List<String> verifyDescendingOrder() {
        List<WebElement> elements = getMultipleElements(descend);
        //Create arraylist
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : elements) {
            beforeFilterProductNamesList.add(p.getText().toUpperCase());
        }
        // Sort arraylist to ascending order
        Collections.sort(beforeFilterProductNamesList);
        // //Reverse the list
        Collections.reverse(beforeFilterProductNamesList);
        return beforeFilterProductNamesList;
    }

    public List<String> getProductsNameAfterFilterZToA() {
        //Store elements after filtering
        List<WebElement> afterFilterProductNames = getMultipleElements(element);
        //Create another list to store text of elements after clicking on filter Z to A
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText().toUpperCase());
        }
        return afterFilterProductNamesList;
    }


}





















