package com.dbudim.some_examples.get_0;

import com.dbudim.fixtures.FixtureAdminView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Condition.text;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class BooksPageTest extends FixtureAdminView {

    private static final String BOOK_NAME = "NBook For Search";

    @BeforeMethod
    public void setUp() {
        bookStack.books.createBook(BOOK_NAME);
        bookStack.books.createBook("E" + randomAlphabetic(10));
        pages.booksPage.open();
    }

    @Test
    public void addBookTestSmell() {
        pages.booksPage.books.first().shouldHave(text(BOOK_NAME));
    }

    @Test
    public void addBookTestWell() {
        pages.booksPage.books.shouldHave(anyMatch("Search book: " + BOOK_NAME, b -> b.getText().contains(BOOK_NAME)));
    }

}
