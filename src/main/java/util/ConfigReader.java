package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis =
                     new FileInputStream("src/main/resources/playwright_config.properties")) {

            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getConfig(String key) {
        return properties.getProperty(key);
    }

    public static Integer getIntegerConfig(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static Double getDoubleConfig(String key) {
        return Double.parseDouble(properties.getProperty(key));
    }

    public static Boolean getBooleanConfig(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}