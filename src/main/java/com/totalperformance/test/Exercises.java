package com.totalperformance.test;

import com.google.common.base.StandardSystemProperty;
import com.totalperformance.test.beans.CustomElement;
import com.totalperformance.test.helpers.Constants;
import com.totalperformance.test.helpers.FileParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises {

    private Map fileContent = new HashMap();
    private WebDriver driver;

    public Exercises (){
        //gets all files content into one dictionary of dictionaries, placed in constructor
        FileParser.getElementsDictionary(fileContent, Constants.FILE_1);
    }

    public WebElement find_element(String name) {
        List<WebElement> foundElements;
        if ((String)fileContent.get(name) != null) {
            foundElements = driver.findElements(By.cssSelector((String)fileContent.get(name)));
        } else {
            foundElements = driver.findElements(By.name(name));
        }
        // Returns null if none or 2 or more elements are found.
        if (foundElements.size() != 1) return null; else return foundElements.get(0);
    }

    public CustomElement find_element_near_to (CustomElement originElement) {

        return findElementCloseToElement(originElement);
    }

    private CustomElement findElementCloseToElement(CustomElement originElement) {

        return null;
    }

}
