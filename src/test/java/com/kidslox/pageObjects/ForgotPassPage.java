package com.kidslox.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kidslox.helpers.TempMailApi;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPassPage {
    private static SelenideElement
        forgotField = $(byName("email")),
        submitBtn = $(".btn-kidslox"),
        newPassField = $("#kidslox_core_account_reset_plainPassword_password"),
        confirmNewPassField = $("#kidslox_core_account_reset_plainPassword_confirm"),
        resetPassBtn = $("#kidslox_core_account_reset_submit"),
        forgotPassSuccessMsg = $(".successMessage"),
        resetPassSuccesMsg = $("h3")
    ;

    public static void resetPassword(){
        forgotField.setValue(TempMailApi.getUserEmail());
        submitBtn.click();
    }
    public static void checkSuccessMsg(){
        forgotPassSuccessMsg.shouldBe(Condition.visible);
    }
    public static void fillResetPasswordForm(){
        newPassField.setValue("123456");
        confirmNewPassField.setValue("123456");
        resetPassBtn.click();
        resetPassSuccesMsg.shouldBe(Condition.visible);
    }
}
