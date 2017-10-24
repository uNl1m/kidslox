package com.kidslox.pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.kidslox.helpers.TempMailApi;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    private static SelenideElement
            fistNameField = $(byName("firstName")),
            lastNameField = $(byName("lastName")),
            emailField = $(byName("email")),
            passwordField = $(byName("newPassword")),
            confirmPasswordField = $(byName("newConfirm")),
            termsCheckbox = $(byName("terms")),
            signUpBtn = $("button.sign-up-button")
            ;

    public static void signUp(){
        fistNameField.setValue("Anton");
        lastNameField.setValue("Sylantiev");
        emailField.setValue(TempMailApi.getUserEmail());
        passwordField.setValue("123456");
        confirmPasswordField.setValue("123456");
        termsCheckbox.click();
        signUpBtn.click();
    }

}
