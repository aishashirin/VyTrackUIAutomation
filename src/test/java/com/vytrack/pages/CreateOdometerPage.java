package com.vytrack.pages;

import com.vytrack.utility.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOdometerPage {
    public CreateOdometerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[data-ftid='custom_entity_type_OdometerValue']")
    public WebElement odometerValue;

    @FindBy(className = "datepicker-input")
    public WebElement datePicker;

    @FindBy(xpath = "//button[normalize-space()='Save and Close']")
    public WebElement saveAndClose;

    @FindBy(className = "message")
    public WebElement successMessage;

    public void fillForm() {

        odometerValue.sendKeys("140000");
        datePicker.sendKeys("Oct 12, 2021"+ Keys.TAB);
    }
}
