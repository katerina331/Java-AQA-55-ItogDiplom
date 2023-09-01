package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private static Properties properties = new Properties();
    private static int i = 0;

    private TestProperties() {
    }

    public static String getProperties(String key) {
        if (i == 0) {
            try {
                properties.load(new FileInputStream(new File("application.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        return properties.getProperty(key);
    }
}