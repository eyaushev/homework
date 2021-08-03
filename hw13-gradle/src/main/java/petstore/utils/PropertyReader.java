package petstore.utils;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyReader {
    private final Properties properties;

    public PropertyReader(){
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "IOException Occured while loading properties file::::" +e.getMessage());
        }
    }

    public String getValue(String keyName) {
        Logger.getLogger(getClass().getName()).log(Level.INFO, "Reading Property " + keyName);
        return properties.getProperty(keyName, "There is no key in the properties file");
    }
}
