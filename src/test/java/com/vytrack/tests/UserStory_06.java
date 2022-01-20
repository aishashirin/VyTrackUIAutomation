package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_06 {

    @Test
    public void AC_01(){
        CommonAreaPage commonAreaPage = new CommonAreaPage();

        new LoginPage().login("storemanager");

        commonAreaPage.waitUntilLoaderScreenDisappear();
        commonAreaPage.userName.click();

        Assertions.assertEquals("My Configuration",commonAreaPage.myConf.getText());
        Assertions.assertEquals("My Calendar",commonAreaPage.myConf.getText());
    }
}
