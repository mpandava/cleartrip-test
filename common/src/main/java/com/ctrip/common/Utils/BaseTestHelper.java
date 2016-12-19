package com.ctrip.common.Utils;

import com.ctrip.common.browser.BrowserFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
@Slf4j
public class BaseTestHelper {
    public WebDriver driver;

    @BeforeTest
    public void initTest(){

    }

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initTest(String browser, String url) {
        log.info("Init DRIVER Browser : {}  ,  URL : {};", browser, url);
        driver = BrowserFactory.launchApplication(browser, url);
    }
}
