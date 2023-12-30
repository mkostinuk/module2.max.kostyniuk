package org.example.settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final String FILE_CONFIG = "app.properties";

    private static final Properties CONFIG_PROPERTIES = new Properties();

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_CONFIG)) {
            CONFIG_PROPERTIES.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int getIntegerProperty(final String key) {
        return Integer.parseInt(CONFIG_PROPERTIES.getProperty(key));
    }
    public static String getStringProperty(final String key){
        return CONFIG_PROPERTIES.getProperty(key);
    }

}


