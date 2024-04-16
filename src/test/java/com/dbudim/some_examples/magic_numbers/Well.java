package com.dbudim.some_examples.magic_numbers;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class Well extends FixtureAdminView {

    private static final int TOTAL_BOOKS_COUNT = 10;

    @BeforeMethod
    public void setUp() throws IOException {
        createRandomBooks(TOTAL_BOOKS_COUNT);
        pages.booksPage.open();
    }


    @Test
    public void someTest() {
        //.....
    }


    //even better

    private List<Book> createRandomBooks(int count) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Book book = execute(client.booksService.createBook(new Book(randomAlphabetic(10), randomAlphabetic(10)))).body();
            books.add(book);
        }
        return books;
    }
}
