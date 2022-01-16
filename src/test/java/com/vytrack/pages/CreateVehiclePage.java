package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CreateVehiclePage {
    public CreateVehiclePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = " (//div/input[@type='text'])[1]")
    public WebElement licencePlate;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "(//div/input[@type='text'])[2]")
    public WebElement driver;

    @FindBy(xpath = "(//div/input[@type='text'])[3]")
    public WebElement location;

    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement chassisNumber;

    @FindBy(xpath = "(//input[@type='number'])[2]")
    public WebElement lastOdometer;

    @FindBy(xpath = "(//div/input[@type='text'])[4]")
    public WebElement modelYear;

    @FindBy(xpath = "(//div/input[@type='text'])[5]")
    public WebElement immatriculationDate;

    @FindBy(xpath = "(//div/input[@type='text'])[6]")
    public WebElement firstContractDate;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement catalogValue;

    @FindBy(xpath = "(//input[@type='number'])[3]")
    public WebElement seatsNumber;

    @FindBy(xpath = "(//input[@type='number'])[4]")
    public WebElement doorsNumber;


    @FindBy(xpath = "(//a/span[text()='Choose a value...'])[1]")
    public WebElement transmissionDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionMaual;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionAutomatic;

    @FindBy(xpath = "//div[@class='pull-right pinned-dropdown']")
    public WebElement saveAndClose;

    @FindBy(className = "message")
    public WebElement successMessage;

    public void fillForm() {
        Faker faker = new Faker();
        licencePlate.sendKeys(faker.numerify("#-###-###"));
        allCheckBoxes.get(1).click();
        driver.sendKeys(faker.name().fullName());
        location.sendKeys(faker.country().capital());
        chassisNumber.sendKeys(faker.numerify("###,###"));
        modelYear.sendKeys(String.valueOf(BrowserUtil.randomNumber(2000, 2021)));
        lastOdometer.sendKeys(String.valueOf(faker.number().numberBetween(1, 50000)));
        immatriculationDate.sendKeys("Apr 12, 2021" + Keys.ENTER);
        firstContractDate.sendKeys("Apr 12, 2019"+Keys.TAB);
        transmissionDropDown.click();
        transmissionOptionMaual.click();
        System.out.println("Form is filled");
    }
}
