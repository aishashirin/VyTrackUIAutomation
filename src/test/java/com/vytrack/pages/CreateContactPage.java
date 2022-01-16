package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateContactPage {
    public CreateContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "oro_contact_form[firstName]")
    public WebElement firstName;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
    public WebElement owner;


    @FindBy(xpath = "(//div[@class='select2-result-label'])[10]")
    public WebElement ownerSelect;


    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;


    @FindBy(xpath = "//select[@name='oro_contact_form[method]']")
    public WebElement contactMethodDropDown;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[4]")
    public WebElement countryDropdown;

    @FindBy(className = "select2-result-label")
    public List<WebElement> allCountries;

    @FindBy(xpath = "//button[normalize-space()='Save and Close']")
    public WebElement saveAndClose;

    @FindBy(css = ".message")
    public WebElement successMessage;


    public void fillForm(){
        Faker faker=new Faker();
        BrowserUtil.waitFor(3);
        owner.click();
        BrowserUtil.waitFor(3);
        ownerSelect.click();
        firstName.sendKeys(faker.name().firstName());
        email.sendKeys(faker.internet().emailAddress());
        BrowserUtil.selectByVisibleText(contactMethodDropDown,"Email");
        countryDropdown.click();
        allCountries.get(5).click();

        System.out.println("\"Form is filled\" = " + "Form is filled");


    }
}
