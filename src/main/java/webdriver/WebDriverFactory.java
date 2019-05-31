package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyLoader;

public class WebDriverFactory {
    private static final String CHROME = "chrome";

    private static WebDriver webDriver = null;

    /**
     * Factory method to return a WebDriver instance given the browser to hit
     * @param browser : String representing the local browser to hit
     * @return WebDriver instance
     */
    public static WebDriver getInstance(String browser) {

        if (webDriver != null) {
            return webDriver;
        }

        String driverPath = PropertyLoader.loadProperty("webdriver.path");
        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            webDriver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.gecko.driver", driverPath);
            webDriver = new FirefoxDriver();
        }

        return webDriver;
    }

}
