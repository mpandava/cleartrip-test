package com.ctrip.common.pages;

import com.ctrip.common.CommonEnums;
import com.ctrip.common.Utils.BrowserUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
@Slf4j
public class Home extends BrowserUtils{

    private static String leftMenuItemXpath = "//*[@id='Home']//a[@href='/%s']";

    @FindBy(how = How.CSS, using = "span[title='Cleartrip ']")
    WebElement homeBtn;

    public Home(WebDriver newDriver) {
        super(newDriver);
    }

    public void gotoLeftMenuItem(CommonEnums.LeftMenu menuItem){
        By locator = By.xpath(String.format(leftMenuItemXpath, menuItem.value()));
        WebElement element = driver.findElement(locator);
        element.click();
        waitForPageLoad();
    }

    public void gotoHomePage(){
        homeBtn.click();
        waitForPageLoad();
    }

}
