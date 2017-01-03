package org.wso2.automation.ui.utils.browser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by asankav on 7/21/16.
 */
public class UIElementMapper {

    public static final Properties uiProperties = new Properties();
    private static UIElementMapper instance;

    static {
        try {
            setStream();
            instance = new UIElementMapper();
        } catch (IOException ioe){
            throw new ExceptionInInitializerError("mapper stream not set. Failed to read file");
        }
    }

    private UIElementMapper() {
    }

    public static UIElementMapper getInstance() {
        return instance;
    }

    private static Properties setStream() throws IOException {
        InputStream inputStream = UIElementMapper.class.getResourceAsStream("/locator.properties");
        if (inputStream.available() > 0) {
            uiProperties.load(inputStream);
            inputStream.close();
            return uiProperties;
        }
        return null;
    }

    public String getElement(String key) {
        return uiProperties.getProperty(key);
    }
}
