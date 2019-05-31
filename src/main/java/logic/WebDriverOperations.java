package logic;

import org.openqa.selenium.WebDriver;

public interface WebDriverOperations {
    void stop();
    void goTo(String url);
    WebDriver getDriver();
}
