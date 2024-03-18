package ua.automation.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1Test extends BaseTest {

    public String getValue(String xpath) {
        WebElement firstElementPrice = webDriver.findElement(By.xpath(xpath));
        return firstElementPrice.getText().trim();
    }

    public String getActualResult(String xpath) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(xpath))).getText().trim();
    }

    public void goToItemDetails() {
        String firstElementTitleLinkXpath = "//div[@class='search-result-card']//a[@class='item-title__title']";
        WebElement firstElementTitleLink = webDriver.findElement(By.xpath(firstElementTitleLinkXpath));
        firstElementTitleLink.click();
    }

    @Test
    public void testDescription() {
        String firstElementDescriptionXpath = "//li[1]//div[contains(concat(' ', normalize-space(@class), ' '), ' search-result-card__description ')]";
        String valueInList = getValue(firstElementDescriptionXpath).split("•")[0].trim();
        String firstElementDetailDescriptionXpath = "//div[@class='row']/table[contains(concat(' ', normalize-space(@class), ' '), 'tender--customer')]//tr[1]/td[2]";
        goToItemDetails();

        String valueInDetails = getActualResult(firstElementDetailDescriptionXpath);

        Assert.assertEquals(valueInList, valueInDetails, "Description is not correct");
    }

    @Test
    public void testStatus() {
        String firstElementStatusXpath = "//li[1]//p[contains(concat(' ', normalize-space(@class), ' '), ' search-result-card__label ')]//span[1]";
        String valueInList = getValue(firstElementStatusXpath);
        String firstElementDetailStatusXpath = "//div[@class='tender--head--inf margin-bottom']//span";
        goToItemDetails();

        String valueInDetails = getActualResult(firstElementDetailStatusXpath);

        Assert.assertEquals(valueInList, valueInDetails, "Status is not correct");
    }

    @Test
    public void testPrice() {
        String firstElementPriceXpath = "//li[1]//p[contains(concat(' ', normalize-space(@class), ' '), ' app-price__amount ')]";
        String firstElementDetailsPriceXpath = "//div[contains(concat(' ', normalize-space(@class), ' '), ' tender--description--cost--number ')]//strong";

        String valueInList = getValue(firstElementPriceXpath).replaceAll("[A-Z]*", "").trim();
        goToItemDetails();
        String valueInDetails = getActualResult(firstElementDetailsPriceXpath).replaceAll("[A-Z]*", "").trim();

        Assert.assertEquals(valueInList, valueInDetails, "Price is not correct");
    }

    @Test
    public void testTitle() {
        String firstElementTitleXpath = "//li[1]//a[contains(concat(' ', normalize-space(@class), ' '), ' item-title__title ')]";
        String firstElementDetailTitleXpath = "//div[contains(concat(' ', normalize-space(@class), ' '), ' tender--head--title ')]";

        String valueInList = getValue(firstElementTitleXpath);
        goToItemDetails();
        String valueInDetails = getActualResult(firstElementDetailTitleXpath);

        Assert.assertEquals(valueInList, valueInDetails, "Title is not correct");
    }
}
