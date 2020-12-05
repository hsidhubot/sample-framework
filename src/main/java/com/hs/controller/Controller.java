package com.hs.controller;

import com.hs.driver.BaseWebDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class Controller {

    public WebControl getWebControl(By by) {
        return new WebControl(BaseWebDriver.getWebdriver(), by);
    }

    public WebControl getWebControl(WebElement element) {
        return new WebControl(BaseWebDriver.getWebdriver(), element);
    }

    //    control to find multiple elements using ONE WEBELEMENT
    public List<WebElement> getWebControl(By webElement, boolean multipleElementsTrue) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElements(webElement);
    }

    public WebElement getWebElementControl(By by) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElement(by);
    }


    public WebElement getWebElementControl(By by1, By by2) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElement(by1).findElement(by2);
    }

    public WebElement getWebElementControl(WebElement elem, By by1) {
        return new WebControl(BaseWebDriver.getWebdriver(),elem).findElement(by1);
    }

    //    control to find multiple elements using WEBELEMENT & second locator
    public List<WebElement> getWebControl(WebElement webElement1, By webElement2by, boolean multipleElementsTrue) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElements(webElement1, webElement2by);
    }

    //    control to find multiple elements using 2 WEBELEMENTS
    public List<WebElement> getWebControl(By webElement1, By webElement2by, boolean multipleElementsTrue) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElements(webElement1, webElement2by);
    }

    //    control to find SINGLE element using WEBELEMENT and BY
    public WebControl getWebControl(WebElement webElement1, By by) {
        return new WebControl(BaseWebDriver.getWebdriver(), webElement1, by);
    }

    //    control to find SINGLE element using  2 BY
    public WebControl getWebControl(By by1, By by2) {
        return new WebControl(BaseWebDriver.getWebdriver(), by1, by2);
    }


    //    control to find SINGLE element using  2 BY
    public WebControl getWebControl(WebElement element, By by1, By by2) {
        return new WebControl(BaseWebDriver.getWebdriver(), element, by1, by2);
    }

    //    control to find MULTIPLE ELEMENTS LOCATOR element using  2 BY
    public List<WebElement> getWebControl(WebElement element, By webElement1, By webElement2by, boolean multipleElementsTrue) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElements(element, webElement1, webElement2by);
    }

    //    control to find MULTIPLE ELEMENTS LOCATOR element using  3 BY
    public List<WebElement> getWebControl(By by1, By by2, By by3, boolean multipleElementsTrue) {
        return new WebControl(BaseWebDriver.getWebdriver()).findElements(by1, by2, by3);
    }

    public WebControl getWebControl() {
        return new WebControl(BaseWebDriver.getWebdriver());
    }
}
