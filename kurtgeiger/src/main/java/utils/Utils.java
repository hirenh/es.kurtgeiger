package utils;

import driver_helpers.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Utils extends DriverHelpers {
    //For hovering on multiple elements
    public void hoverMultipleElements(String department, By by) {
        List<WebElement> megaNavLists = driver.findElements(by);
        for (WebElement element : megaNavLists) {
            if (element.getText().equalsIgnoreCase(department)) {
                new Actions(driver).moveToElement(element).perform();
                break;
            }
        }

    }

    //For hovering on multiple elements and clicking a element
    public void hoverAndClickMultipleElements(String category, By by) {
        List<WebElement> megaNavLists = driver.findElements(by);
        for (WebElement element : megaNavLists) {
            if (element.getText().equalsIgnoreCase(category)) {
                new Actions(driver).moveToElement(element).click().build().perform();
                break;
            }
        }
    }
}
