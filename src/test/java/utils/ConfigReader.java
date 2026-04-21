package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();
    // Static block runs Once when the class is first used

    static {
        try {
            FileInputStream file = new FileInputStream("config/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Could not read config file: " + e.getMessage());
        }
    }
    // Simple method hand me a key , I ll give you the value

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
