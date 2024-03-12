package ua.automation.hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.automation.hw4.value.CommonValue;
import ua.automation.hw4.value.DescriptionValue;
import ua.automation.hw4.value.PriceValue;

import java.time.Duration;

public class SearchDetailsTest extends BaseTest {

    @DataProvider(name="searchWords", parallel = false)
    public Object [][] searchData(){
        return new Object [][] {{
            "тумба"
        },{
            "комод"
        },{
            "стіл"
        },{
            "вікно"
        },{
            "вішак"
        }};
    }

    public void searchText(String text) {
        webDriver.get("https://prozorro.gov.ua/en");
        WebElement input = webDriver
                .findElement(By.xpath("//input[@class='search-text__input']"));
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
    }

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

    private CommonValue getTitle() {
        return new CommonValue(
            "//li[1]//a[contains(concat(' ', normalize-space(@class), ' '), ' item-title__title ')]",
            "//div[contains(concat(' ', normalize-space(@class), ' '), ' tender--head--title ')]",
            "Title is not correct"
        );
    }

    private CommonValue getStatus() {
        return new CommonValue(
            "//li[1]//p[contains(concat(' ', normalize-space(@class), ' '), ' search-result-card__label ')]//span[1]",
            "//div[@class='tender--head--inf margin-bottom']//span",
            "Status is not correct"
        );
    }

    private DescriptionValue getDescription() {
        return new DescriptionValue(
            "//li[1]//div[contains(concat(' ', normalize-space(@class), ' '), ' search-result-card__description ')]",
            "//div[@class='row']/table[contains(concat(' ', normalize-space(@class), ' '), 'tender--customer')]//tr[1]/td[2]",
            "Description is not correct"
        );
    }

    private PriceValue getPrice() {
        return new PriceValue(
            "//li[1]//p[contains(concat(' ', normalize-space(@class), ' '), ' app-price__amount ')]",
            "//div[contains(concat(' ', normalize-space(@class), ' '), ' tender--description--cost--number ')]//strong",
            "Price is not correct"
        );
    }

    @Test(groups = {"positive"}, dataProvider = "searchWords")
    public void matchListItemToDetail(String textToFind) {

        CommonValue title = getTitle();
        CommonValue status = getStatus();
        DescriptionValue description = getDescription();
        PriceValue price = getPrice();

        // searching specified text
        searchText(textToFind);

        // collect data from first item of search result
        title.setListValue(getValue(title.getListXpath()));
        status.setListValue(getValue(status.getListXpath()));
        description.setListValue(getValue(description.getListXpath()));
        price.setListValue(getValue(price.getListXpath()));

        // go to first item details
        goToItemDetails();

        // collect data from first item details
        title.setDetailsValue(getActualResult(title.getDetailsXpath()));
        status.setDetailsValue(getActualResult(status.getDetailsXpath()));
        description.setDetailsValue(getActualResult(description.getDetailsXpath()));
        price.setDetailsValue(getActualResult(price.getDetailsXpath()));

        // perform tests
        Assert.assertEquals(title.getDetailsValue(), title.getListValue(), title.getMessage());
        Assert.assertEquals(status.getDetailsValue(), status.getListValue(), status.getMessage());
        Assert.assertEquals(description.getDetailsValue(), description.getListValue(), description.getMessage());
        Assert.assertEquals(price.getDetailsValue(), price.getListValue(), price.getMessage());
    }
}
