package com.vytrack.tests;

import com.vytrack.pages.*;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/**
 * Story: As a user, I should be create contact information.
 */
public class UserStory_04 extends TestBase {

    /**AC #1: users are able to create contacts. */

    @Test
    public void AC_01(){
        LoginPage loginPage = new LoginPage();
        CommonAreaPage commonAreaPage = new CommonAreaPage();

        loginPage.login("salesmanager");

        commonAreaPage.navigateToModule("Customers","Contacts");

        BrowserUtil.waitFor(4);
        new ContactsPage().createContact.click();

        CreateContactPage createContactPage = new CreateContactPage();

        createContactPage.fillForm();

        BrowserUtil.scrollToElement(createContactPage.saveAndClose);

        createContactPage.saveAndClose.click();

        String text = BrowserUtil.waitForVisibility(By.cssSelector(".message"),10).getText();

        System.out.println(text);

        Assertions.assertEquals("Contact saved",text);
    }
}
