package com.dbudim.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement emailInput = $("#email");
    private SelenideElement passInput = $("#password");
    private SelenideElement loginBtn = $(".text-right button");
    private SelenideElement userAvatar = $(".user-name .avatar");

    private static final String PATH = "/login";

    public LoginPage open() {
        Selenide.open(PATH);
        emailInput.shouldBe(visible);
        return this;
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        loginBtn.click();
        userAvatar.shouldBe(visible);
    }
}
