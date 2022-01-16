package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be to select any vehicle/car from vehicle page
 */
public class UserStory_03 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();

    /**
     * AC #1: user can select all the cars by checking the first checkbox
     */
    @Test
    public void AC_01() {
        loginPage.login("salesmanager");
        commonAreaPage.navigateToModule("Fleet", "Vehicles");

        VehiclesPage vehiclesPage = new VehiclesPage();

        BrowserUtil.waitFor(4);

        vehiclesPage.selectAllCheckboxes.click();

        Assertions.assertTrue(BrowserUtil.getIsCheck(vehiclesPage.allCheckboxes, vehiclesPage.nextButton));
    }

    /**
     * AC #2: user can select any car
     * */

    @Test
    public void AC_02(){
        loginPage.login("salesmanager");
        commonAreaPage.navigateToModule("Fleet","Vehicles");

        VehiclesPage vehiclesPage = new VehiclesPage();

        BrowserUtil.waitFor(4);

        int i = BrowserUtil.randomNumber(0,10);

        vehiclesPage.allCheckboxes.get(i).click();

        Assertions.assertTrue(vehiclesPage.allCheckboxes.get(i).isSelected());
    }
}
