package org.wso2.automation.ui.utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BrowserManager {
    private static WebDriver driver;


    public static WebDriver getWebDriver(String driverSelection)  {

        if (driverSelection.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/gecko/geckodriver");
            driver=new FirefoxDriver();

        } else if (driverSelection.equalsIgnoreCase("firefox<v48")) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", false);
            driver = new FirefoxDriver(capabilities);

        } else if (driverSelection.equalsIgnoreCase("Windowsfirefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\gecko\\geckodriver.exe");
            driver=new FirefoxDriver();

        } else if (driverSelection.equalsIgnoreCase("Macfirefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/gecko/geckodriver");
            driver=new FirefoxDriver();

        } else if (driverSelection.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new ChromeDriver(capability);

        } else if (driverSelection.equalsIgnoreCase("Windowschrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver.exe");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new ChromeDriver(capability);

        } else if (driverSelection.equalsIgnoreCase("MacChrome")) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/mac/chromedriver");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new ChromeDriver(capability);

    }
        else if (driverSelection.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\ie\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else if (driverSelection.equalsIgnoreCase("remotefirefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/gecko/geckodriver");
            DesiredCapabilities capabilities=DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);

//            FirefoxProfile profile = new FirefoxProfile();
//            profile.setAcceptUntrustedCertificates(true);
//            DesiredCapabilities caps = DesiredCapabilities.firefox();
//            caps.setCapability(FirefoxDriver.PROFILE, profile);

             driver = new RemoteWebDriver(capabilities);


        } else if (driverSelection.equalsIgnoreCase("remotechrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver");
            DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();


        } else if (driverSelection.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();

        }
        return driver;
    }


}
