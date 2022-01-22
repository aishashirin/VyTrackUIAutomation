package com.vytrack.pages;

import com.vytrack.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleModelPage {
    public VehicleModelPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".grid-row.row-click-action")
    public List<WebElement> allVehicles;
}
