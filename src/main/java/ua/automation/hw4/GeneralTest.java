package ua.automation.hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GeneralTest extends BaseTest {
    private String baseUrl = "https://prozorro.gov.ua/en";

    @DataProvider(name="dataTestNegative")
    public Object [][] dataNegative(){
        return new Object [][] {
                {"as;jdfkasdf;asdfj;"}
        };
    }

    @DataProvider(name="dataTest")
    public Object [][] data(){
        return new Object [][] {
                {"тумба"},
                {"комод"}
        };
    }

    public WebElement getClickableElement(String xpath) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(
                (By.xpath(xpath)))
            );
    }

    public boolean isElementPresent(String locatorKey) {
        try {
            webDriver.findElement(By.xpath(locatorKey));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public List<WebElement> getSearchResultList (String text) {
        webDriver.get(baseUrl);
        WebElement input = webDriver
                .findElement(By.xpath("//input[@class='search-text__input']"));
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='search-result__list']/li"));
        return list;
    }

    @Test(groups = {"positive"}, dataProvider="dataTest")
    public void search(String text) {
        List<WebElement> list = getSearchResultList(text);
        Assert.assertTrue(list.size() > 0, "Search result list must have at least one item.");
    }


    @Test(groups = {"negative"}, dataProvider="dataTestNegative")
    public void noSearchResult(String text) {
        List<WebElement> list = getSearchResultList(text);
        Assert.assertTrue(list.size() <= 0, "Search result list must empty.");
    };

    @Test(groups = {"positive"})
    public void searchInProductsTab() {
        String searchWord = "скальпель";
        webDriver.get(baseUrl);

        WebElement productTabLink = getClickableElement("//ul[@class='search-mode url-tabs']/li/a[@href='/en/search/products']");
        productTabLink.click();

        WebElement input = getClickableElement("//input[@class='search-text__input']");
        input.clear();
        input.sendKeys(searchWord);
        webDriver.findElement(By.xpath("//button[@class='btn search-text__btn']")).click();

        List<WebElement> list = webDriver.findElements(By.xpath("//ul[@class='search-result__list']/li"));

        Assert.assertTrue(list.size() > 0, "Search result list must have at least one item.");
    }

    @Test(groups = {"positive"})
    public void clearButtonVisible() {
        webDriver.get(baseUrl);
        WebElement input = getClickableElement("//input[@class='search-text__input']");
        input.clear();
        input.sendKeys("test");
        Assert.assertTrue(isElementPresent("//button[@class='btn search-text__close']"));
    };

    @Test(groups = {"negative"})
    public void clearButtonInvisible() {
        webDriver.get(baseUrl);
        WebElement input = getClickableElement("//input[@class='search-text__input']");
        input.clear();
        Assert.assertFalse(isElementPresent("//button[@class='btn search-text__close']"));
    };
}
