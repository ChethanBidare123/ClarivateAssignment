package dataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is a class to read any Property file
 *
 * @author Amritansh Diwakar
 */
public class PropertyFileReader {
    private final Properties properties = new Properties();

    /**
     * This method is the constructor
     *
     * @param propertyFilePath This is the path of the physical property file
     */
    public PropertyFileReader(String propertyFilePath) {
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to fetch the Properties
     *
     * @return This returns a Properties object
     */
    public Properties getProperties() {
        return properties;
    }
}