package com.vytrack.pages;

import com.vytrack.utility.ConfigReader;
import com.vytrack.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement loginButton;

    public void login(String userType) {
        username.sendKeys(ConfigReader.read(userType + "_username"));
        password.sendKeys(ConfigReader.read(userType + "_password"));
        loginButton.click();
    }
}
