package com.vytrack.tests;

import com.vytrack.pages.*;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Story: As a user, I should be create vehicle costs.
 */
public class UserStory_07 extends TestBase {
    /**
     * AC #1: users are able to create vehicle costs.
     */
    @Test
    public void AC_01() {
        CommonAreaPage commonAreaPage = new CommonAreaPage();

        new LoginPage().login("storemanager");

        commonAreaPage.navigateToModule("Fleet", "Vehicle Costs");
        commonAreaPage.waitUntilLoaderScreenDisappear();

        new VehicleCostsPage().createVehicleCosts.click();

        CreateVehicleCosts createVehicleCosts = new CreateVehicleCosts();
        createVehicleCosts.fillForm();
        createVehicleCosts.saveAndClose.click();

        String actualText = createVehicleCosts.successMessage.getText();

        Assertions.assertEquals("Entity saved", actualText);
    }

}
