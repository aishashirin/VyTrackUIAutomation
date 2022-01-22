package com.vytrack.pages;

import com.vytrack.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateVehicleContractPage {
    public CreateVehicleContractPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
    public WebElement typeDropdown;


    @FindBy(css = ".select2-result-label")
    public List<WebElement> typesOfContracts;

    @FindBy(xpath = "//button[normalize-space()='Save and Close']")
    public WebElement saveAndClose;

    @FindBy(className = "message")
    public WebElement successMessage;

    public void fillForm() {
        typeDropdown.click();
        typesOfContracts.get(2).click();



    }
}
