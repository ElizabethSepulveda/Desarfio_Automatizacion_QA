package cl.test.utils;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: objeto para carga de datos
 *
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataReadProvider {

    private String ENVIRONMENT = "src/test/java/cl/test/dataResource/data/environment.properties";
    private String USER_LOGIN = "src/test/java/cl/test/dataResource/data/login.properties";
    private String REGISTER_USER = "src/test/java/cl/test/dataResource/data/registerUser.properties";
    private String DATA_BUY = "src/test/java/cl/test/dataResource/data/dataBuy.properties";

    public Properties loadEnvironment() {
        Properties props = new Properties();
        String filePath = new File(ENVIRONMENT).getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    public Properties loadUserLogin() {
        Properties props = new Properties();
        String filePath = new File(USER_LOGIN).getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    public Properties loadRegisterUser() {
        Properties props = new Properties();
        String filePath = new File(REGISTER_USER).getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    public Properties loadDataBuy () {
        Properties props = new Properties();
        String filePath = new File(DATA_BUY).getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }


}
