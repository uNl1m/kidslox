package com.kidslox.tests;

import com.kidslox.drivers.SelenoidWebDriverProvider;
import com.kidslox.helpers.TempMailApi;
import com.kidslox.pageObjects.DevicesPage;
import com.kidslox.pageObjects.PinCodePage;
import com.kidslox.pageObjects.SignUpPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class SignUpTest extends SelenoidWebDriverProvider{

    @Before
    public void generateNewEmail(){
        TempMailApi.generateAndSaveUserEmail();
    }
    @Test
    public void signUp(){
        open("");
        SignUpPage.signUp();
        PinCodePage.fillPinCode(1,2,3,4);
        PinCodePage.fillPinCode(1,2,3,4);
        DevicesPage.checkSuccessMessage();
        DevicesPage.checkUserEmailAddress();
    }
}
