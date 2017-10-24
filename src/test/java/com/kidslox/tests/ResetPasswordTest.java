package com.kidslox.tests;

import com.kidslox.drivers.SelenoidWebDriverProvider;
import com.kidslox.helpers.TempMailApi;
import com.kidslox.pageObjects.ForgotPassPage;
import com.kidslox.pageObjects.LoginPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ResetPasswordTest extends SelenoidWebDriverProvider{

    @Test
    public void resetPassword(){
        open("");
        LoginPage.goToForgetPassForm();
        ForgotPassPage.resetPassword();
        ForgotPassPage.checkSuccessMsg();
        open(TempMailApi.getResetUrl());
        ForgotPassPage.fillResetPasswordForm();
    }

}
