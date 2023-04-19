package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //locating and entering username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //locating and entering password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //login button
        driver.findElement(By.id("login-button")).click();

        //verify 'products' text is displayed
        String expectedMessage = "Products";
        WebElement actualTextMessage = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //locating and entering username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //locating and entering password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //locating and clicking on login button
        driver.findElement(By.id("login-button")).click();
        //verifying 6 products are displayed
        int expectedNumber = 6;
        List<WebElement> actualNumberElement = driver.findElements(By.className("inventory_item"));
        int actualNumber = actualNumberElement.size();
        Assert.assertEquals(expectedNumber, actualNumber);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}