
package com.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties was not found on the classpath"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load config.properties", e
            );
        }
    }

    /**
     * Reads a configuration value, allowing command-line overrides.
     *
     * @param key configuration property name
     * @return configured value
     */
    public static String getProperty(String key) {

        // System properties take precedence over the properties file.
        String value = System.getProperty(key);

        if (value == null || value.isBlank()) {
            value = properties.getProperty(key);
        }

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing configuration property: " + key
            );
        }

        return value.trim();
    }



}
