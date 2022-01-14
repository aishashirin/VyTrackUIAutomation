package com.vytrack.pages;

import com.vytrack.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {
    public AccountsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@data-toggle='dropdown']/input")
    public WebElement selectAllCheckboxes;

    @FindBy(xpath = "//input[@data-role='select-row-cell']")
    public List<WebElement> allCheckboxes;

    @FindBy(xpath = "//a[@data-grid-pagination-direction='next']")
    public WebElement nextButton;
}
