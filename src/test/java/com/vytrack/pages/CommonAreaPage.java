package com.vytrack.pages;

import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonAreaPage {
    public CommonAreaPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[ @class='title title-level-1']")
    public List<WebElement> allModules;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    @FindBy(linkText = "My Configuration")
    public WebElement myConf;

    @FindBy(linkText = "My Calendar")
    public WebElement myCalendar;

    @FindBy(css = "[title='Get help']")
    public WebElement getHelp;


    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement permissionAlert;

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigateToModule(String tab, String module) {

        BrowserUtil.waitFor(2);//span[normalize-space()='Fleet'] [@class='title title-level-1']
        String tabLocator = "//span[normalize-space()='"+tab+"'] [@class='title title-level-1']";
        String moduleLocator = "//span[normalize-space()='"+module+"'] [@class='title title-level-2']";

        WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
        new Actions(Driver.getDriver()).moveToElement(tabElement).pause(200).doubleClick(tabElement).perform();

        BrowserUtil.waitForVisibility(By.xpath(moduleLocator), 10).click();

    }
}
