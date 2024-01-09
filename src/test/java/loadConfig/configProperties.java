package loadConfig;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class configProperties {
    public static Properties property;
    private static String configpath = "src\\main\\resources\\config.properties";
    public static void initializePropertyFile() throws IOException {
    	property = new Properties();
    		InputStream input = new FileInputStream(configpath);
    		property.load(input);
  
    }
}