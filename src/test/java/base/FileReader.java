package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader extends BaseApiTest{
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    public static String getProperty(String file, String key) {
        try {
            fileInputStream = new FileInputStream(file);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return PROPERTIES.getProperty(key);
    }
}