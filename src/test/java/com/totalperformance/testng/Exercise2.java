package com.totalperformance.testng;

import com.totalperformance.test.Exercises;
import com.totalperformance.test.helpers.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

class Exercise2 {

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
        String referenceElement = "Element1";
        String closeElement = "";
        closeElement = test.find_element_near_to(driver, referenceElement);
        Assert.assertNotNull("Element not found", test.find_element(driver, closeElement));
        System.out.println("Element closer to " + referenceElement + " is " + closeElement);
    }

    @Test
    public void nameExistsInFiles() {
        Exercises test = new Exercises();
        String referenceElement = "paragraph";
        String closeElement = "";
        closeElement = test.find_element_near_to(driver, referenceElement);
        Assert.assertNotNull("Element not found", test.find_element(driver, closeElement));
        System.out.println("Element closer to " + referenceElement + " is " + closeElement);
    }

    @Test
    public void nameDoesntExist() {
        Exercises test = new Exercises();
        String referenceElement = "fruit";
        String closeElement = "";
        closeElement = test.find_element_near_to(driver, referenceElement);
        Assert.assertNull("Element found", test.find_element(driver, closeElement));
        System.out.println("Element " + referenceElement + " was not found");
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}