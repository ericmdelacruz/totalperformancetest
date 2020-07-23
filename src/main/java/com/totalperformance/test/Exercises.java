package com.totalperformance.test;

import com.totalperformance.test.helpers.Constants;
import com.totalperformance.test.helpers.FileParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Exercises {

    private Map fileContent = new HashMap();

    public Exercises (){
        //gets all files content into one dictionary of dictionaries, placed in constructor
        FileParser.getElementsDictionary(fileContent, Constants.FILE_1);
    }

    public WebElement find_element(WebDriver driver, String name) {
        List<WebElement> foundElements = new ArrayList<>();
        if (fileContent.get(name) == null) return null;
        try {
            if (((String)fileContent.get(name)).isEmpty()) foundElements = driver.findElements(By.name(name));
        } catch (Exception e) {
            foundElements = driver.findElements(By.cssSelector(((String)((Map)fileContent.get(name)).get("locator"))));
        } finally {
            // Returns null if none or 2 or more elements are found.
            if (foundElements.size() != 1) return null; else return foundElements.get(0);
        }
    }

    public String find_element_near_to (WebDriver driver, String originElement) {
        int referenceposition = getIntPosition(driver, originElement);
        AtomicInteger closerElement = new AtomicInteger(Integer.MAX_VALUE);
        AtomicReference<String> closerElementName = new AtomicReference<>("");
        //Element not found = -1
        if (referenceposition == -1) return null;
        fileContent.forEach((k, v) -> {
            int newElementPosition = getIntPosition(driver, k);
            if (newElementPosition > -1 && newElementPosition < closerElement.get()) {
                closerElement.set(newElementPosition);
                closerElementName.set((String) k);
            }
        });
        return closerElementName.get();
    }

    private int getIntPosition(WebDriver driver, Object originElement) {
        WebElement referenceElement = find_element(driver, (String)originElement);
        if (referenceElement == null) return -1;
        Point referenceElementPoint = referenceElement.getLocation();
        return referenceElementPoint.x + referenceElementPoint.y;
    }
}
