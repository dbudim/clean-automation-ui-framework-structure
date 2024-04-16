package com.dbudim.core.configurations;

import com.dbudim.configuration.Configuration;

import static com.dbudim.core.configurations.UiParameters.BROWSER;
import static com.dbudim.configuration.Parameters.PROJECT_URL;


/**
 * Created by dbudim on 17.12.2023
 */

public class UiConfigurations extends Configuration {

    public static String getProjectUrl() {
        return getParameter(PROJECT_URL);
    }

    public static String getBrowser() {
        return getParameter(BROWSER);
    }

}
