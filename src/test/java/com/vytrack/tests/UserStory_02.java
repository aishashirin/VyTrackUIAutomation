package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.CreateVehiclePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be create vehicles/cars.
 */
public class UserStory_02 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();

    /**
     * AC #1: only store/sales manager able to create car
     */
    @Test
    public void AC_01() {
        loginPage.login("salesmanager");
        commonAreaPage.navigateToModule("Fleet", "Vehicles");

        BrowserUtil.waitFor(4);

        new VehiclesPage().createCar.click();

        CreateVehiclePage createVehiclePage = new CreateVehiclePage();

        createVehiclePage.fillForm();
        createVehiclePage.saveAndClose.click();
        String actualText = createVehiclePage.successMessage.getText();

        String expectedText = "Entity saved";

        Assertions.assertEquals(expectedText, actualText);

    }

    /**
     * AC #2: drivers should not able to create a car
     */
    @Test
    public void AC_02() {
        loginPage.login("driver");

        commonAreaPage.navigateToModule("Fleet","Vehicles");

        boolean result = BrowserUtil.waitForElementIsNotLocated(new VehiclesPage().createCar);

        Assertions.assertFalse(result);

    }
}
