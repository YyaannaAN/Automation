import io.qameta.allure.*;
import org.example.pages.DragAndDropPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests extends BaseTest {

    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void BeforeMethod()
    {
       dragAndDropPage = new DragAndDropPage(webDriver);
    }

   @Test
    public void dragAndDrop()
    {
        webDriver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        takeScreenshot(webDriver);
        dragAndDropPage
               .moveOsloToItaly()
               .moveStockholmToNorway();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("1. Go to site 2.Take screenshot 3. move Oslo to Italy")
    @Owner("Andrii")
    @Link ()
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void dragAndDrop2()
    {
        webDriver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        takeScreenshot(webDriver);
        dragAndDropPage.moveOsloToItalyWithPause();
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void scrollDown()
    {
        webDriver.get("https://www.selenium.dev/documentation/webdriver/elements/information/");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);");
    }
}
