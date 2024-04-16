package com.dbudim.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {

    private static final String PATH = "/books";

    private SelenideElement mainContent = $("#content");
    private SelenideElement createBookBtn = $("[data-shortcut='new']");
    public ElementsCollection books = $$(".grid [data-entity-type='book']");

    public BooksPage open() {
        Selenide.open(PATH);
        mainContent.shouldBe(visible);
        return this;
    }

    public ManageBookPage openBook(String name) {
        books.filter(innerText(name))
                .first()
                .click();
        return new ManageBookPage().assertIsOpened(name.toLowerCase());
    }

    public void assertBookIsPresent(String name) {
        books.shouldHave(CollectionCondition.itemWithText(name));
    }

    public ManageBookPage createBook(String name) {
        createBookBtn.click();
        ManageBookPage manageBookPage = new ManageBookPage();
        manageBookPage.assertIsOpenedEditMode();
        manageBookPage.typeName(name);
        manageBookPage.save();
        return manageBookPage;
    }

    public SelenideElement getBook(String name) {
        return books.filter(text(name)).first();
    }

    public ElementsCollection getBooks() {
        return books;
    }
}
