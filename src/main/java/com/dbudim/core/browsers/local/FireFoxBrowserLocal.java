package com.dbudim.core.browsers.local;

import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxBrowserLocal extends FirefoxDriverFactory {
    @Override
    protected void setupPreferences(FirefoxOptions firefoxOptions) {
        super.setupPreferences(firefoxOptions);
        firefoxOptions.addPreference("general.useragent.override", "awesome agent");
    }
}
