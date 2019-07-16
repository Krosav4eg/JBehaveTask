package serhii_potapov.test_automation.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Serhii_Potapov
 */

public class DriverFactory {

    public static final String FIREFOX = "Firefox";
    public static final String CHROME = "Chrome";
    public static final String OPERA = "Opera";
    private static final String DRIVER_NAME_OPERA = "webdriver.opera.driver";
    private static final String PATH_TO_DRIVER_OPERA = "driver\\operadriver.exe";
    private static final String DRIVER_NAME = "webdriver.chrome.driver";
    private static final String PATH_TO_DRIVER = "driver\\chromedriver.exe";

    static {
        System.setProperty(DRIVER_NAME, PATH_TO_DRIVER);
    }

    private static Map<String, WebDriver> drivers = new HashMap<>();

    public static WebDriver getDriver(String driverName) {
        WebDriver driver = drivers.get(driverName);
        if (driver == null) {
            switch (driverName) {
                case FIREFOX: {
                    driver = new FirefoxDriver();
                    drivers.put(FIREFOX, driver);
                    break;
                }
                case OPERA: {
                    DesiredCapabilities operaCapabilities = DesiredCapabilities.opera();
                    driver = new OperaDriver(operaCapabilities);
                    drivers.put(OPERA, driver);
                    break;
                }
                case CHROME: {
                    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                    driver = new ChromeDriver(chromeCapabilities);
                    drivers.put(CHROME, driver);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        assert driver != null;

        return driver;
    }
}