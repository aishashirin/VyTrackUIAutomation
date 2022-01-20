package com.vytrack.tests;

import com.vytrack.pages.AccountsPage;
import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.BrowserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be to select accounts from accounts page
 */
public class UserStory_05 {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();
    AccountsPage accountsPage = new AccountsPage();

    /**
     * AC #1: user can select all the accounts by checking the first checkbox
     */
    @Test
    public void AC_01() {
        loginPage.login("storemanager");
        commonAreaPage.navigateToModule("Customers", "Accounts");
        commonAreaPage.waitUntilLoaderScreenDisappear();
        accountsPage.selectAllCheckboxes.click();
        Assertions.assertTrue(BrowserUtil.getIsCheck(accountsPage.allCheckboxes, accountsPage.nextButton));
    }

    /**
     * AC #2: user can select any account
     */

    @Test
    public void AC_02(){
        loginPage.login("storemanager");
        commonAreaPage.navigateToModule("Customers","Accounts");
        commonAreaPage.waitUntilLoaderScreenDisappear();
        accountsPage.allCheckboxes.get(1).click();
        Assertions.assertTrue(accountsPage.allCheckboxes.get(1).isSelected());
    }
}
