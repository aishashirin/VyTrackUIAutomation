package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be view 3 options under my account name.
 */
public class UserStory_06 extends TestBase {
    /**
     * AC #1: users have 3 options under their usernames.
     */
    @Test
    public void AC_01() {
        CommonAreaPage commonAreaPage = new CommonAreaPage();

        new LoginPage().login("storemanager");

        commonAreaPage.waitUntilLoaderScreenDisappear();
        commonAreaPage.userName.click();

        Assertions.assertEquals("My Configuration", commonAreaPage.myConf.getText());
        Assertions.assertEquals("My Calendar", commonAreaPage.myConf.getText());
    }
}
