package com.totalperformance.test.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileParser {

    public static void getElementsDictionary (Map map, Object fileName) {
        JSONParser parser = new JSONParser();
        Map tempMap;
        try
        {
            FileReader reader = new FileReader(Constants.PATH + (String) fileName);
            //Define and instance containerFactory
            ContainerFactory containerFactory = new ContainerFactory() {
                @Override
                public Map createObjectContainer() {
                    return new LinkedHashMap<>();
                }
                @Override
                public List creatArrayContainer() {
                    return new LinkedList<>();
                }
            };
            //Reads JSON file and put it in a JSON array
            tempMap = (Map)parser.parse(reader, containerFactory);

            // flagImport is to know if it's a file of locators or finders
            tempMap.forEach((k,v)-> {
                // in case it finds import, it adds a single definition dictionary - key: element name,
                // value = dictionary with key: locator, value: CSS locator
                // in case it finds __FINDERS__, every name will be saved as key with empty value.
                // if already exists saves locator in case it's empty, if not it ignores the new value.
                switch ((String)k) {
                    case "import": ((List)v).forEach(e -> getElementsDictionary (map, e)); break;
                    case "__FINDERS__": ((List)v).forEach(e -> map.put(((Map)e).get("locator"),null)); break;
                    default: map.put(k,v);
                }
            });
        } catch (FileNotFoundException e) {
            //catches error if file is not found, in case it's not found ignores it
            // (returns empty map) recursively keeps previous data
            e.printStackTrace();
        } catch (IOException e) {
            //File is there but can't be read, same result as FileNotFoundException
            e.printStackTrace();
        } catch (ParseException e) {
            //Json is not a valid one, same result as FileNotFoundException
            e.printStackTrace();
        }
    }
}
