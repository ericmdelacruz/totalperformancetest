package com.totalperformance.test.beans;

import org.openqa.selenium.WebElement;

public class CustomElement {

    private static WebElement webElement = null;
    private static int x = -1;
    private static int y = -1;
    private static int width = -1;
    private static int height = -1;

    public CustomElement (WebElement webElement, int x, int y, int width, int height) {
        setWebElement(webElement);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        CustomElement.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        CustomElement.y = y;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        CustomElement.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        CustomElement.height = height;
    }

    public static WebElement getWebElement() {
        return webElement;
    }

    public static void setWebElement(WebElement webElement) {
        CustomElement.webElement = webElement;
    }
}
