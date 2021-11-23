package com.csf.oop.domino.Helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonHelper {

    private ObjectMapper mapper;

    public JsonHelper() {
        this.mapper = new ObjectMapper();
    }

    public void writeToJSONFile(String filename, Object object)  {
        try {
            mapper.writeValue(new File(filename), object);
        } catch (IOException exception) {
            System.err.print(exception);
        }
    }

    public  void readJsonFile(String filename, Object object) {
        try {
            Object objectValue = mapper.readValue(Paths.get(filename).toFile(), object.getClass());
            System.out.println(objectValue);
        } catch (IOException exception) {
            System.err.print(exception);
        }
    }
}
