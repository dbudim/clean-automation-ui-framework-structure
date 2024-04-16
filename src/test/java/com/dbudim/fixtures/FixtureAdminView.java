package com.dbudim.fixtures;

import com.dbudim.client.BookStack;
import com.dbudim.pages.Pages;
import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.utils.ExecutionUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class FixtureAdminView {

    protected Book book;
    protected static final String EMAIL = "admin@admin.com";
    protected static final String PASS = "password";

    protected BookStackRestClient client = new BookStackRestClient();
    protected BookStack bookStack = new BookStack(client);
    protected Pages pages = new Pages();
    protected List<Book> generatedData = new ArrayList<>();

    @BeforeClass
    public void loginByAdmin() {
        //smell - can't break other tests
        bookStack.books.removeAllBooks();

        pages.loginPage.open()
                .login(EMAIL, PASS);
    }

    @AfterClass
    public void clearGeneratedData() {
        for (Book book : generatedData) {
            ExecutionUtils.execute(client.booksService.deleteBook(book.id));
        }
    }

    //smell
    public void createBookSmell(String name) {
        book = bookStack.books.createBook(name);
    }

    //well
    public Book createBook(String name) {
        return bookStack.books.createBook(name);
    }
}
