package pageobject;

import driver_helpers.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends DriverHelpers {
    public void loginAsAGuest() {
        driver.findElement(By.id("register-guest:email")).sendKeys("hirenh@mail.com");
        driver.findElement(By.cssSelector(".buttons-set.login>button>span>span")).click();
    }

    public void dropDownTitleByPassingValue() {

        driver.findElement(By.cssSelector(".input-box>input[id=\"shipping:firstname\"]")).sendKeys("john");
        driver.findElement(By.cssSelector(".input-box>input[id=\"shipping:lastname\"]")).sendKeys("smith");
        driver.findElement(By.cssSelector(".input-box>input[id=\"shipping:telephone\"]")).sendKeys("07852071592");
        new Select(driver.findElement(By.id("addressfinder:shippingcountry"))).selectByVisibleText("Spain");
        driver.findElement(By.cssSelector("input[ id=\"addressfinder:shipping\"]")).sendKeys("Calle Evangelios, 4");
        driver.findElement(By.cssSelector("input[id=\"shipping:street1\"]")).sendKeys("28026 Madrid");
        driver.findElement(By.cssSelector("input[id=\"shipping:city\"]")).sendKeys("spain");
        new Select(driver.findElement(By.name("shipping[region_id]"))).selectByVisibleText("Alava");

    }

    public void contiuneToPayment() {
        driver.findElement(By.cssSelector(".button[title=\"Continue to Payment\"]")).click();

    }

    public String paymentSummeryPage() {
        String actual = driver.findElement(By.cssSelector(".page-title>h2")).getText();
        System.out.println(actual);
        return actual;
    }

    public void selectPaymentMethod() {
        driver.findElement(By.cssSelector("#p_method_sagepayserver_label")).click();
    }

    public void enterCreditCardAndExpiryDetails(String creditCardNumber, String expiry) {
        driver.switchTo().frame("sagepaysuite-server-incheckout-iframe");
        WebElement card = driver.findElement(By.id("form-card_details.field-pan"));
        WebElement expirydate = driver.findElement(By.cssSelector(".form-group__controls>div>input"));
        card.sendKeys(creditCardNumber);
        expirydate.sendKeys(expiry);
    }

    public void cvcDetails(String cvcNumber) {

        WebElement searchBox1 = driver.findElement(By.cssSelector(".form-group__controls>input"));
        searchBox1.sendKeys(cvcNumber);
    }

    public void cardDetails() {
        WebElement confirmCardDetails = driver.findElement(By.cssSelector("button[value=\"proceed\"]"));
        confirmCardDetails.click();
    }

    public String cardValidityChecks() {
        String actual = driver.findElement(By.cssSelector(".form-group__error")).getText();
        System.out.println(actual);
        return actual;
    }
}
