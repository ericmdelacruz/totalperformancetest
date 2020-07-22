package com.totalperformance.test;

import com.totalperformance.test.beans.CustomElement;
import com.totalperformance.test.helpers.Constants;

import java.util.Dictionary;
import java.util.Enumeration;

import org.json.*;

public class Exercises {

    private Dictionary elementDictionaty = new Dictionary() {
        @Override
        public int size( ) {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration keys() {
            return null;
        }

        @Override
        public Enumeration elements() {
            return null;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(Object key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }
    };

    public static CustomElement find_element (String name) {
        Dictionary fileContent = loadFile(Constants.FILE_1);
        return findElementInDictionary (name);
    }

    private static CustomElement findElementInDictionary(String name) {

        return null;
    }

    private static Dictionary loadFile(String file1) {

        return null;
    }

    public static CustomElement find_element_near_to (CustomElement originElement) {

        return findElementCloseToElement(originElement);
    }

    private static CustomElement findElementCloseToElement(CustomElement originElement) {

        return null;
    }

}
