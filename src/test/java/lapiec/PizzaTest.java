package lapiec;

import lapiec.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PizzaTest extends BaseTest {

    @Test
    public void CartTest(){
        //Click on pizza Quattro Formaggi
        driver.findElement(By.xpath("//*[@class=\"productHover mobilePreload preview preloaded\"][contains(@data-mobile-preview, \"kvatro\")]")).click();
        //Add pizza to the cart
        driver.findElement(By.xpath("//*[@class='button addToCart update-cart-product-single']")).click();
        //Open cart
        driver.findElement(By.xpath("//*//*[@class=\"basket\"]")).click();
        //Find element in cart page and verify that cart isn't empty
        WebElement pizza = driver.findElement(By.xpath("//*[@class=\"product-qty\"]"));
        Assert.assertTrue(pizza.getAttribute("value").equals("1"));

    }
    @Test
    public void localizationTest(){
        //Click on language dropdown button
        driver.findElement(By.xpath("//div[@class='headerSection hidden-xs hidden-sm']")).click();
        //Choose the English language
        driver.findElement(By.cssSelector("div.headerSection.hidden-xs.hidden-sm > div > ul > li.lang-en > a")).click();
        //Find element after changing language and verify that page is translated
        WebElement element = driver.findElement(By.xpath("//div[@class=\"tel open-popup hidden-xs hidden-sm\"]/p"));
        Assert.assertTrue(element.getText().equals("We’ll call you back"));
    }

}