package com.dbudim.some_examples.string_constants;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class Well extends FixtureAdminView {

    private static final String BOOK_NAME = "TTTWE";

    @BeforeClass
    public void setUp() throws IOException {
        client.booksService.createBook(new Book(BOOK_NAME, randomAlphabetic(10))).execute().body();
    }

    @BeforeMethod
    public void openBooksPage() {
        pages.booksPage.open();
    }

    @Test
    public void testWithBook1() {
        pages.booksPage.openBook(BOOK_NAME);
    }

    @Test
    public void testWithBook2() {
        pages.booksPage.openBook(BOOK_NAME);
    }

    @Test
    public void testWithBook3() {
        pages.booksPage.openBook(BOOK_NAME);
    }

    @Test
    public void testWithBook4() {
        pages.booksPage.openBook(BOOK_NAME);
    }

    @Test
    public void testWithBook5() {
        pages.booksPage.openBook(BOOK_NAME);
    }


}
