package ua.automation.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    private WebDriver webDriver;

    @BeforeMethod
    public void initDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void destroy() {
        webDriver.quit();
    }

    @Test
    public void task1() {
        webDriver.get("https://a-level.com.ua/");
        WebElement image = webDriver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/a/img[1]"));
        Assert.assertTrue(image.isDisplayed(), "Page is not opened successfully");
    }
}
