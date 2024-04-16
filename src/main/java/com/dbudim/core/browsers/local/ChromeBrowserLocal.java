package com.dbudim.core.browsers.local;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;

import javax.annotation.Nonnull;
import java.util.List;

public class ChromeBrowserLocal extends ChromeDriverFactory {

    @Nonnull
    @Override
    protected List<String> createChromeArguments(Config config, Browser browser) {
        var chromeArguments = super.createChromeArguments(config, browser);
        chromeArguments.add("--disable-notifications");
        chromeArguments.add("--no-sandbox");
        chromeArguments.add("--disable-gpu");
        chromeArguments.add("--disable-webgl");
        chromeArguments.add("--disable-extensions");
        chromeArguments.add("--disable-features=IsolateOrigins,site-per-process");
        chromeArguments.remove("--disable-dev-shm-usage");
        return chromeArguments;
    }

}
