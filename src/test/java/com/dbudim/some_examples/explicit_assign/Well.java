package com.dbudim.some_examples.explicit_assign;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.Test;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListNotContains;

public class Well extends FixtureAdminView {

    @Test
    public void renameBookTest() {
        book = createBook(randomAlphabetic(19));
        pages.booksPage.open().openBook(book.name);
        String newName = randomAlphabetic(5);
        pages.manageBookPage.rename(newName);

        Book renamed = execute(client.booksService.getBook(book.id)).body();
        assertEquals(renamed.name, newName, "books wasn't renamed");
    }

    @Test
    public void deleteBookTest() {
        book = createBook(randomAlphabetic(19));
        pages.booksPage.open().openBook(book.name);
        pages.manageBookPage.delete();
        List<Book> books = execute(client.booksService.getBooks()).body().data;
        assertListNotContains(books, b -> b.name.equals(book.name), "book wasn't removed");
    }

}
