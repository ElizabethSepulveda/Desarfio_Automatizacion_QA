package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadExternalData {

    private static Properties data = null;

    public static Properties readData() throws FileNotFoundException {

        try {
            data = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/DATA/config.properties");
            data.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
