package com.ctrip.flights.pages;

import com.ctrip.common.Enums;
import com.ctrip.common.browser.BrowserFactory;
import com.ctrip.common.pages.Home;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        log.info("test");

        WebDriver driver = BrowserFactory.launchApplication("firefox", "https://www.cleartrip.com/");
        Home home = PageFactory.initElements(driver, Home.class);
        home.gotoLeftMenuItem(Enums.LeftMenu.FLIGHTS);
    }
}
