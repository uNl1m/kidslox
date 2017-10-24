package com.kidslox.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kidslox.helpers.TempMailApi;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private static SelenideElement
            emailField = $$(byName("email")).last(),
            passwordField = $$(byName("password")).last(),
            goToLoginForm = $(".login-button"),
            loginBtn = $("button.login-button"),
            forgotPassLink = $(byLinkText("Forgotten Password"))
    ;

    public static void login(){
        goToLoginForm.click();
        emailField.setValue(TempMailApi.getUserEmail());
        passwordField.setValue("123456");
        loginBtn.click();

    }
    public static void goToForgetPassForm(){
        goToLoginForm.click();
        forgotPassLink.shouldBe(Condition.visible).click();
    }
}
