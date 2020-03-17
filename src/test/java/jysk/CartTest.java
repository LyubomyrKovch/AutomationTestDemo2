package jysk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void cartTest(){
        //Close cookie popup window
        WebElement cookieButtonOK = driver.findElement(By.xpath("//*[@id='cookieOk']"));
        cookieButtonOK.click();
        //Close advertising popup window
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='sc-modal']/div[@class='close-x']")));
        closeButton.click();
        //In search field write name of furniture
        WebElement searchField = driver.findElement(By.xpath("//*[@id='edit-query']"));
        searchField.sendKeys("Шафа MANDERUP");
        //Click search button
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='edit-submit--2']"));
        searchButton.click();
        //Click on furniture from the result list
        WebElement furniture = driver.findElement(
                By.xpath("//div[@class='product item node node-product node-teaser product-teaser clearfix']" +
                        "[@id ='node-304659']/div[@class='product-content']//span[contains(text(),'Шафа MANDERUP ')]"));
        furniture.click();
        //Click on buy button
        WebElement buyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@class='btn primary addToBasket wss-payment-add-to-basket']")));
        buyButton.click();
        //Find element in cart page and verify that furniture is added to the cart
        WebElement amountGoods = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='notification-item-quantity']")));
        Assert.assertTrue(amountGoods.getText().equals("1"));
    }
}
