package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleContractsPage;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be create Vehicle Contract.
 */
public class UserStory_09 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();

    /**AC #1: managers are able to Create Vehicle Contract.
     */
    @Test
    public void AC_01(){
        loginPage.login("salesmanager");

        commonAreaPage.navigateToModule("Fleet","Vehicle Contracts");
        commonAreaPage.waitUntilLoaderScreenDisappear();

        new VehicleContractsPage().createVehicleContract.click();



    }

}
