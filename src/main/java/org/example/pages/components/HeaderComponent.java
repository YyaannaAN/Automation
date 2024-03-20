package org.example.pages.components;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//div[@id='header']//img")
    private WebElement image;

    public  WebElement getImage()
    {
        return this.image;
    }


}
