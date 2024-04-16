package com.dbudim.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ManageBookPage {

    private SelenideElement mainContent = $("#main-content .content-wrap");
    private SelenideElement title = mainContent.$(".break-text");
    private SelenideElement editableTitle = $("#name");
    private SelenideElement editBtn = $("[data-shortcut='edit']");
    private SelenideElement deleteBtn = $("[data-shortcut='delete']");
    private SelenideElement saveBookBtn = $(".form-group [type='submit']");
    private SelenideElement confirmDeleteBtn = $("[method='POST'] [type='submit']");
    private SelenideElement bookContent = $(".book-content");
    private SelenideElement pageIcon = $("[data-icon='page']");
    private SelenideElement chapterIcon = $("[data-icon='chapter']");


    public ManageBookPage assertIsOpenedEditMode() {
        editableTitle.shouldBe(Condition.visible);
        return this;
    }

    public ManageBookPage assertIsOpened(String id) {
        Selenide.webdriver().shouldHave(urlContaining(id));
        title.shouldBe(Condition.visible);
        return this;
    }

    public ManageBookPage rename(String newName) {
        editBtn.click();
        typeName(newName);
        save();
        return this;
    }

    public void delete() {
        deleteBtn.click();
        confirmDeleteBtn.click();
        confirmDeleteBtn.shouldBe(Condition.visible);
    }

    public ManageBookPage typeName(String name) {
        editableTitle.clear();
        editableTitle.sendKeys(name);
        return this;
    }

    public ManageBookPage save() {
        saveBookBtn.click();
        saveBookBtn.shouldNotBe(Condition.visible);
        return this;
    }

    public void assertAllElementsPresent() {
        title.shouldBe(Condition.visible);
        bookContent.shouldBe(Condition.visible);
        chapterIcon.as("chapter icon").shouldBe(Condition.visible);
        pageIcon.as("page icon").shouldBe(Condition.visible);
    }

    public void assertAllElementsPresentSoft() {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(title.is(Condition.visible), "title");
        sa.assertTrue(bookContent.is(Condition.visible), "book content");
        sa.assertTrue(chapterIcon.is(Condition.visible), "chapter icon");
        sa.assertTrue(pageIcon.is(Condition.visible), "page icon");
        sa.assertAll("Check elements presence on page");
    }
}
