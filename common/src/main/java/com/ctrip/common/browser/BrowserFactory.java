package com.ctrip.common.browser;

import com.ctrip.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class BrowserFactory {

    public static WebDriver launchApplication(String browserName, String url) {
        WebDriver driver = null;

        log.info("Initialising {} browser.", browserName);
        try {
            if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "PATH/chromedriver");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS);
            driver.get(url);
        } catch (Exception e) {
            log.error("Exception while Initialising browser : {}", e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }
}
