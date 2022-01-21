package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.CreateOdometerPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleOdometerPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_08 extends TestBase {

    @Test
    public void AC_01(){
        new LoginPage().login("driver");


        new CommonAreaPage().navigateToModule("Fleet","Vehicle Odometer");

        BrowserUtil.waitFor(4);
        new VehicleOdometerPage().createVehicleOdometer.click();

        CreateOdometerPage createOdometerPage = new CreateOdometerPage();
        createOdometerPage.fillForm();

        BrowserUtil.scrollToElement(createOdometerPage.saveAndClose);
        createOdometerPage.saveAndClose.click();

        String actualText = createOdometerPage.successMessage.getText();
        Assertions.assertEquals("Entity saved",actualText);
    }
}
