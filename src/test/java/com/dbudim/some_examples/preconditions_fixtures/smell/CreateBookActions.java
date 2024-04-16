package com.dbudim.some_examples.preconditions_fixtures.smell;

import com.dbudim.pages.Pages;
import com.dbudim.client.BookStack;
import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.exceptions.BookNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dbudim.utils.ExecutionUtils.execute;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class CreateBookActions {

    private static final String EMAIL = "admin@admin.com";
    private static final String PASS = "password";
    private static final String BOOK_NAME = randomAlphabetic(10);

    private Book book;
    private BookStackRestClient client = new BookStackRestClient();
    private BookStack bookStack = new BookStack(client);
    private Pages pages = new Pages();

    @BeforeClass
    public void loginByAdmin() {
        pages.loginPage.open()
                .login(EMAIL, PASS);
    }

    @BeforeMethod
    public void openBooks() {
        pages.booksPage.open();
    }

    @Test
    public void createBookTest() {
        pages.booksPage.createBook(BOOK_NAME);
        execute(client.booksService.getBooks()).body().data
                .stream()
                .filter(b -> b.name.equals(BOOK_NAME))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(BOOK_NAME));
    }

}
