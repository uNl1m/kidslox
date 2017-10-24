package com.kidslox.drivers;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidWebDriverProvider implements com.codeborne.selenide.WebDriverProvider {
    @Before
        public void setUp(){
        Configuration.baseUrl = "https://app.kidslox.com/#/site/signup";
        Configuration.browser = SelenoidWebDriverProvider.class.getName();
        Configuration.timeout = 6000;
    }
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("61.0");
        browser.setCapability("enableVNC", true);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:5000/wd/hub").toURL(),
                    browser
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }
}