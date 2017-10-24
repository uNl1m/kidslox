package com.kidslox.tests;

import com.kidslox.drivers.SelenoidWebDriverProvider;
import com.kidslox.pageObjects.DevicesPage;
import com.kidslox.pageObjects.LoginPage;
import com.kidslox.pageObjects.PinCodePage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends SelenoidWebDriverProvider {

    @Test
    public void login(){
        open("");
        LoginPage.login();
        PinCodePage.fillPinCode(1,2,3,4);
        DevicesPage.checkSuccessMessage();
        DevicesPage.checkUserEmailAddress();
    }
}
