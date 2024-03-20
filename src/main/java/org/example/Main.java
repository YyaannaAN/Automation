package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            WebDriver webDriver = new ChromeDriver();

            webDriver.get("https://maven.apache.org/");

            WebElement image = webDriver.findElement(By.xpath("//img[@alt='Apache Maven Site']"));

            Assert.assertFalse(image.isDisplayed(), "Maven page is not opened successfully");
        }
    }
