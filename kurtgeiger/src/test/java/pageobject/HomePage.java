package pageobject;

import driver_helpers.DriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.jboss.netty.util.internal.SystemPropertyUtil.contains;

public class HomePage extends DriverHelpers {
    public String actual;
    public WebElement element;
    Utils utils=new Utils();
    public void selectCategoryFromHeader(String categoery){
       utils.hoverAndClickMultipleElements(categoery,By.cssSelector(".main-nav--link>span") );
    }

    public  boolean isOnHomepage(){
        System.out.println("I am on HomePage");
        return driver.getCurrentUrl().contains("kurtgeiger.es");
    }

    public void hooverToHeaderElements(String headerName){

        List<WebElement>HeaderElements  = driver.findElements(By.cssSelector(".main-nav--link>span"));
        for (WebElement element:HeaderElements){
            if ( element.getText().equalsIgnoreCase(headerName)){
                new Actions(driver).moveToElement(element).clickAndHold().build().perform();
                break;
            }
        }
    }

    public void selectBrand(String brandName){
        List<WebElement> brandSelection= driver.findElements(By.xpath(".//*[@id='tab1']/div/ul/li/a"));
        for (WebElement element: brandSelection){
            if(element.getText().equalsIgnoreCase(brandName)){
                element.click();
                break;
            }
        }
    }

    public String titleOfPage(String titlePage){
        System.out.println(driver.getTitle());
        actual= driver.getTitle();
        return actual;
    }
    public void getBrand(String brandOnPage){
        List<WebElement>brandNames= driver.findElements(By.cssSelector(".product-brand>a"));
        for (WebElement element: brandNames){
            String productName=element.getText();
            System.out.println(productName);
            Assert.assertEquals("DOLCE & GABBANA", productName);
        }

    }
}
