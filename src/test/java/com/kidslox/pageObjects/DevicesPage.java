package com.kidslox.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.kidslox.helpers.TempMailApi;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DevicesPage {
    private static SelenideElement
            thankYou = $(".thank-you-section"),
            accountBtn = $(".account")
    ;
    private static ElementsCollection
            descriptionsField = $$(".description");

    public static void checkSuccessMessage(){
        thankYou.shouldBe(Condition.visible);
    }
    public static void checkUserEmailAddress(){
        accountBtn.click();
        descriptionsField.get(2).shouldHave(Condition.text(TempMailApi.getUserEmail()));
    }

}
