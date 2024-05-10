package com.maximus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    Properties properties = new Properties();

    public void loadProps(String path) throws IOException {
        try (FileInputStream propStream = new FileInputStream(path)) {
            properties.load(propStream);
        }
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
}

