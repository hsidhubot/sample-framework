package com.hs.driver;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    WebDriver createInstance(String browser, String target);
}
