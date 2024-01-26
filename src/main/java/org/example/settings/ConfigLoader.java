package org.example.settings;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Logger logger= LogManager.getLogger(ConfigLoader.class);
    private static final String FILE_CONFIG = "app.properties";

    private static final Properties CONFIG_PROPERTIES = new Properties();

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_CONFIG)) {
            CONFIG_PROPERTIES.load(input);
        } catch (IOException ex) {
            logger.error("Error with reading property {}", ex.toString());

        }
    }

    public static int getIntegerProperty(final String key) {
        return Integer.parseInt(CONFIG_PROPERTIES.getProperty(key));
    }

    public static String getStringProperty(final String key) {
        return CONFIG_PROPERTIES.getProperty(key);
    }

}


