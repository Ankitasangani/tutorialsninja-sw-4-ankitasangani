package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComponentsPage extends Utility {

   By components =By.xpath("//a[normalize-space()='Components']"); //  Mouse hover on “Components” Tab and click
   By textComponents = By.xpath("//h2[normalize-space()='Components']"); // Verify the text "Components"

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


    public void mouseHoverAndClickOnComponents(){
        mouseHoverToElementAndClick(components);
    }

    public String verifyTextComponents(){
        return getTextFromElement(textComponents);
    }

}

