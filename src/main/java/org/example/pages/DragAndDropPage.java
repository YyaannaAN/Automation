package org.example.pages;

import org.example.pages.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage  {
    public HeaderComponent headerComponent;

    @FindBy(id ="box1")
    private WebElement oslo;
    @FindBy(id ="box106")
    private WebElement italy;

    @FindBy(id ="box2")
    private WebElement stockholm;
    @FindBy(id ="box101")
    private WebElement norway;

    public DragAndDropPage moveOsloToItaly()
    {
        new Actions(webDriver).dragAndDrop(oslo,italy).build().perform();
        return this;
    }
    public  DragAndDropPage moveStockholmToNorway()
    {
        new Actions(webDriver).dragAndDrop(stockholm,norway).build().perform();
        return this;
    }

    public DragAndDropPage moveOsloToItalyWithPause()
    {
        new Actions(webDriver).clickAndHold(oslo)
                .pause(2000)
                .moveToElement(italy)
                .release()
                .build()
                .perform();
        return this;
    }

  public DragAndDropPage (WebDriver webDriver)
  {
      super(webDriver);
      headerComponent = new HeaderComponent(webDriver);
  }
}
