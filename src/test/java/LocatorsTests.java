import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsTests extends BaseTest {

    @Test
    public void FindByIdTest()
    {
        webDriver.get("https://www.ukr.net/");
        WebElement consentButton = webDriver.findElement(By.xpath("//button[@aria-label='Consent']"));
        consentButton.click();

        WebElement input =  webDriver.findElement(By.id("search-input"));
        WebElement findButton = webDriver.findElement(By.xpath("//input[@value='Пошук']"));

        input.clear();
        input.sendKeys("hello");
        findButton.click();
    }

    @Test
    public void findByClass()
    {
        webDriver.get("https://prozorro.gov.ua/en");
        List<WebElement> menuCategories = webDriver.findElements(By.className("url-tabs__item"));
        System.out.println(menuCategories.size());
    }

    @Test
    public void findByName()
    {
        webDriver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
        WebElement emailInput = webDriver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("test@test.com");
    }

    @Test
    public void findByPartialLinkText()
    {
        webDriver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
        WebElement link = webDriver.findElement(By.partialLinkText("Best Buy API Playgroun"));
        link.click();
    }

    @Test
    public void findByLinkText()
    {
        webDriver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
        WebElement link = webDriver.findElement(By.linkText("Best Buy API Playground"));
        link.click();
    }

    @Test
    public void findByCssSelector() {
        webDriver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");

        WebElement emailInput = webDriver.findElement(By.cssSelector("#subscribe-blog > #subscribe-email > input"));
        emailInput.clear();
        emailInput.sendKeys("test@test.com");

        WebElement emailTwoInput = webDriver.findElement(By.cssSelector("#subscribe-blog  input[style]"));

        emailTwoInput.clear();
        emailTwoInput.sendKeys("test2@test.com");
    }

    @Test
    public void findByXpath()
    {
        webDriver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");

        WebElement emailInput = webDriver.findElement(By.xpath("//input[@id='subscribe-field']//ancestor::div[1]//input[contains(@placeholder,'mail') and @name='email']"));
        emailInput.clear();
        emailInput.sendKeys("test@test.com");
    }
}
