package com.kidslox.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class PinCodePage {

    private static ElementsCollection
            pinBtns = $$(".pin-button");

    public static void fillPinCode(int a, int b, int c, int d){
        pinBtns.get(0).shouldBe(Condition.visible);
        pinBtns.get(a-1).click();
        pinBtns.get(b-1).click();
        pinBtns.get(c-1).click();
        pinBtns.get(d-1).click();
        sleep(1000);
    }
}
