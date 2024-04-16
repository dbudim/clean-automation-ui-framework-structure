package com.dbudim.some_examples.magic_numbers;

import com.dbudim.fixtures.FixtureAdminView;
import com.dbudim.client.models.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class Smell extends FixtureAdminView {

    @BeforeMethod
    public void setUp() throws IOException {
        for (int i = 0; i < 10; i++) {
            client.booksService.createBook(new Book(randomAlphabetic(10), randomAlphabetic(10))).execute();
        }
        pages.booksPage.open();
    }


    @Test
    public void someTest() {
        //.....
    }
}
