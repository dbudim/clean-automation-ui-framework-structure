package com.dbudim.some_examples.var;

import com.dbudim.fixtures.FixtureAdminView;
import com.codeborne.selenide.SelenideElement;
import com.dbudim.client.models.Book;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class VarUsageExample extends FixtureAdminView {

    @Test
    public void smell() throws IOException {
        var bookOnUi = pages.booksPage.getBook("my book");
        var bookOnApi = client.booksService.getBook("my book").execute().body();
        assertEquals(bookOnUi.getText(), bookOnApi.name, "book name on UI and API doesn't match");

    }


    @Test
    public void well() throws IOException {
        SelenideElement bookOnUi = pages.booksPage.getBook("my book");
        Book bookOnApi = client.booksService.getBook("my book").execute().body();
        assertEquals(bookOnUi.getText(), bookOnApi.name, "book name on UI and API doesn't match");
    }
}
