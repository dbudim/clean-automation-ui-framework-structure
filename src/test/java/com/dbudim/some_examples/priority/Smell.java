package com.dbudim.some_examples.priority;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import com.dbudim.exceptions.BookNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListNotContains;

public class Smell extends FixtureAdminView {

    private Book book;
    private static final String BOOK_NAME = randomAlphabetic(10);
    private static final String BOOK_NAME_NEW = randomAlphabetic(5);

    @BeforeClass
    public void prepareBook() {
        pages.booksPage.open();
    }

    @Test(priority = 1)
    public void createBookTest() {
        pages.booksPage.createBook(BOOK_NAME);
        book = execute(client.booksService.getBooks()).body().data
                .stream()
                .filter(b -> b.name.equals(BOOK_NAME))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(BOOK_NAME));
    }

    @Test(priority = 2)
    public void renameBookTest() {
        pages.manageBookPage.rename(BOOK_NAME_NEW);

        Book renamed = execute(client.booksService.getBook(book.id)).body();
        assertEquals(renamed.name, BOOK_NAME_NEW, "books wasn't renamed");
    }

    @Test(priority = 3)
    public void deleteBookTest() {
        pages.manageBookPage.delete();
        List<Book> books = execute(client.booksService.getBooks()).body().data;
        assertListNotContains(books, b -> b.name.equals(book.name), "book wasn't removed");
    }

}
