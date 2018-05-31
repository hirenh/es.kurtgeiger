package pageobject;

import driver_helpers.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.List;

public class PdpPage extends DriverHelpers {
    Utils utils = new Utils();

    public void colours(String colourname) {
        utils.hoverAndClickMultipleElements(colourname, By.cssSelector(".filter-colour_group>li>span"));
    }

    public void size(String size) {
        utils.hoverAndClickMultipleElements(size, By.cssSelector(".filter-size>li>span"));
    }

    public boolean iAmOnPDPpage() {
        String expected = driver.getTitle();
        System.out.println(expected);
        return driver.getCurrentUrl().contains("shoes");
    }

    public void addProduct() {
        driver.findElement(By.cssSelector("a[title=\"Bazza\"]")).click();
        utils.hoverAndClickMultipleElements("40", By.cssSelector(".eu_region.sizes-btn>span"));
        driver.findElement(By.id("add-to-cart-ss17")).click();
    }

    public void goToBag() throws InterruptedException {
        Thread.sleep(3000);
        //driver.findElement(By.id("go-to-cart-ss17")).click();
        driver.findElement(By.cssSelector(".btn.btn--rounded.btn--primary.kgtrack.active>span>span")).click();
    }

    public String totalItemsInBag() {
        String numberOfItems = driver.findElement(By.cssSelector(".page-title>h1")).getText();
        System.out.println(numberOfItems);
        return numberOfItems;
    }

    public void clickToProceedToCheckOut() {
        driver.findElement(By.cssSelector(".field.rate.metapack_INTERNATIONAL>label")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-proceed-checkout")));
        driver.findElement(By.id("btn-proceed-checkout")).click();
    }

    public String confirmedCheckOutPage() {

        String Actual = driver.findElement(By.cssSelector(".page-title>h2")).getText();
        System.out.println(Actual);
        return Actual;
    }
}
