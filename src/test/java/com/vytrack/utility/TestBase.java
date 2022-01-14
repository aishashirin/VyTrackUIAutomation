package com.vytrack.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class is meant to be super class
 * to provide driver set up and closing browser
 * for it's subclasses
 * */
public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfigReader.read("url"));
    }

    @AfterEach
    public void closeBrowser(){
        Driver.closeBrowser();
    }
}
