package com.totalperformance.testng;

import com.totalperformance.test.Exercises;
import com.totalperformance.test.helpers.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

class Exercise1 {

    private WebDriver driver;

    @BeforeSuite
    public void initDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.navigate().to(Constants.PATH_FOR_BROWSER);
    }

    @Test
    public void nameHasLocator() {
        Exercises test = new Exercises();
        Assert.assertNotNull("Element not found", test.find_element(driver, "Element1"));
    }

    @Test
    public void nameExistsInFiles() {
        Exercises test = new Exercises();
        Assert.assertNotNull("Element not found", test.find_element(driver,"paragraph"));
    }

    @Test
    public void nameDoesntExist() {
        Exercises test = new Exercises();
        Assert.assertNull("Element found", test.find_element(driver, "fruit"));
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}