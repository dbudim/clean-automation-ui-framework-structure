package com.dbudim.some_examples.string_constants;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class Smell extends FixtureAdminView {

    @BeforeClass
    public void setUp() throws IOException {
        client.booksService.createBook(new Book("YOUR-BOOK", randomAlphabetic(10))).execute().body();
    }

    @BeforeMethod
    public void openBooksPage() {
        pages.booksPage.open();
    }

    @Test
    public void testWithBook1() {
        pages.booksPage.openBook("YOUR-BOOK");
    }

    @Test
    public void testWithBook2() {
        pages.booksPage.openBook("YOUR-BOOK");
    }

    @Test
    public void testWithBook3() {
        pages.booksPage.openBook("MY-BOOK");
    }

    @Test
    public void testWithBook4() {
        pages.booksPage.openBook("MY-BOOK");
    }

    @Test
    public void testWithBook5() {
        pages.booksPage.openBook("YOUR-BOOK");
    }


}
