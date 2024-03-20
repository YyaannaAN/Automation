import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

   private WebDriver webDriver;

    @BeforeMethod
    public void initDriver()
    {
        webDriver = new ChromeDriver();
    }

    @AfterMethod()
    public void destroy()
    {
        webDriver.quit();
    }

    @Test
    public void firstTest()
    {
        webDriver.get("https://maven.apache.org/");
        WebElement image = webDriver.findElement(By.xpath("//img[@alt='Apache Maven Siteee']"));
        Assert.assertTrue(image.isDisplayed(), "Maven page is not opened successfully");
    }
}
