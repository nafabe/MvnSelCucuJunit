package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver () {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/afa/Downloads/chromedriver-mac-x64/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setBinary("/Users/afa/Downloads/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
            driver = new ChromeDriver(options);

        }

        return driver;
    }

    public static void closeDriver () {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}