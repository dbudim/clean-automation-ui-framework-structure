package com.dbudim.some_examples.atomic;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListNotContains;

public class Smell extends FixtureAdminView {

    private Book book;

    @BeforeMethod
    public void prepareBook() {
        book = bookStack.books.createBook(randomAlphabetic(10));
    }

    @Test
    public void renameAndDeleteBook() {
        pages.booksPage.open()
                .openBook(book.name);

        String newName = randomAlphabetic(5);
        pages.manageBookPage.rename(newName);

        Book renamed = execute(client.booksService.getBook(book.id)).body();
        assertEquals(renamed.name, newName, "books wasn't renamed");

        pages.manageBookPage.delete();
        List<Book> books = execute(client.booksService.getBooks()).body().data;
        assertListNotContains(books, b -> b.name.equals(newName), "book wasn't removed");
    }
}
