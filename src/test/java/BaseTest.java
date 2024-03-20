import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver webDriver;

    @BeforeClass
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    }

    @BeforeMethod
    public void initDriver()
    {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1280,720");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");

        webDriver = new ChromeDriver(options);
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

    }

    @Attachment(type = "image/png")
    public byte[] takeScreenshot (WebDriver driver)
    {
        byte[] result = null;
        if(driver!=null)
        {
            result =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
        return result;
    }

    @AfterMethod
    public void destroy()
    {
        webDriver.quit();
    }
}
