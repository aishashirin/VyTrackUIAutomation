package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.CreateVehicleContractPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleContractsPage;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be create Vehicle Contract.
 */
public class UserStory_09 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();

    /**
     * AC #1: managers are able to Create Vehicle Contract.
     */
    @Test
    public void AC_01() {
        loginPage.login("salesmanager");

        commonAreaPage.navigateToModule("Fleet", "Vehicle Contracts");
        commonAreaPage.waitUntilLoaderScreenDisappear();

        new VehicleContractsPage().createVehicleContract.click();

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        createVehicleContractPage.fillForm();
        createVehicleContractPage.saveAndClose.click();

        String actualText = createVehicleContractPage.successMessage.getText();
        Assertions.assertEquals("Entity saved", actualText);
    }

    /**AC #2: driver should not to create Vehicle Contract. */
    @Test
    public void AC_02(){
        loginPage.login("driver");

        commonAreaPage.navigateToModule("Fleet","Vehicle Contracts");
        String actualText = commonAreaPage.permissionAlert.getText();
        Assertions.assertEquals("Ypu do not have permission to perform this action",actualText);

    }

}
