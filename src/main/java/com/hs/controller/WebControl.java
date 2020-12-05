package com.hs.controller;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>WebControl</h1>
 * Contains WebElement wrapper functions
 * Provides ability to get the WebElement based on the name
 */
@Log4j2
public class WebControl {

    private WebDriver driver;
    protected WebElement element;
    protected List<WebElement> elements;

    private static final long WEBDRIVER_WAIT = 10L;
    private static final long WEBDRIVER_WAIT_DUMMY = 1L;
    private static final long WEBDRIVER_WAIT_FOR_ALERT = 25L;
    private static final long FLUENT_WAIT = 60;
    private static final long POLLING_INTERVAL = 500;

//    private static final Logger LOGGER = Logger.getLogger(WebControl.class);

    public WebControl(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
        new WebDriverWait(driver, WEBDRIVER_WAIT);
    }

    public WebControl(WebElement element, By by) {
        element.findElement(by);
    }

    public WebControl(WebDriver driver, WebElement element, By by) {
        this.driver = driver;
        this.element = element.findElement(by);
        new WebDriverWait(driver, WEBDRIVER_WAIT);
    }

    public WebControl(WebDriver driver, By by1, By by2) {
        this.driver = driver;
        element = driver.findElement(By.xpath("/html/body"));
        this.element = element.findElement(by1).findElement(by2);
        new WebDriverWait(driver, WEBDRIVER_WAIT);
    }

    public WebControl(WebDriver driver, By locator) {
        this.driver = driver;
        this.element = driver.findElement(locator);
        new WebDriverWait(driver, WEBDRIVER_WAIT);
    }

    public WebControl(WebDriver driver, WebElement element, By by1, By by2) {
        this.driver = driver;
        this.element = element.findElement(by1).findElement(by2);
        new WebDriverWait(driver, WEBDRIVER_WAIT);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by1, By by2) {
        return driver.findElement(by1).findElements(by2);
    }

    public List<WebElement> findElements(WebElement element1, By by2) {
        return element1.findElements(by2);
    }

    public List<WebElement> findElements(WebElement element1, By by1, By by2) {
        return element1.findElement(by1).findElements(by2);
    }

    public List<WebElement> findElements(By by1, By by2, By by3) {
        return element.findElement(by1).findElement(by2).findElements(by3);
    }

    public WebControl(WebDriver driver) {
        this.driver = driver; // HS: ADDED TO PASS DRIVER INSTANCE
    }


    public void waitForTitleToExist(String title) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.titleIs(title));
    }

    public void waitForTitleToExistContains(String title) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.titleContains(title));
    }

    public void waitForElementToBeVisibleBy(By by) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForDUMMYElementToBeVisibleBy(By by) {
        new WebDriverWait(driver, WEBDRIVER_WAIT_DUMMY).until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void waitForAllElementsToBeVisibleBy(By by) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElementToBeVisibleBy(WebElement parentElement, By by) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, by));
    }

    public void waitForElementsToBeVisibleBy(WebElement parentElement, By by) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parentElement, by));
    }

    public void waitForAWebElementToBeVisibleBy(WebElement element) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForALLWebElementToBeVisibleBy(List<WebElement> elements) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForTextToBePresentInElementValue(By By, String value) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.textToBePresentInElementValue(By, value));
    }

    public void waitForTextToBePresentInElementValue(WebElement webElement, String value) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.textToBePresentInElementValue(webElement, value));
    }


    public void waitForAttributeToContain(By locator, String attribute, String value) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public void waitForAttributeToContain(WebElement element, String attribute, String value) {
        new WebDriverWait(driver, WEBDRIVER_WAIT).until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void waitForAlertToBePresent() {
        new WebDriverWait(driver, WEBDRIVER_WAIT_FOR_ALERT).until(ExpectedConditions.alertIsPresent());
    }


    /* Internally uses ExpectedConditions class
     * Waits for the java script to load
     * Scrolls to the element
     * Waits for the element to be visible
     * Waits for the element to be clickable
     */
    public void waitForElementAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        this.scrollElementIntoMiddleView(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForElementAndClickIgnoreStaleError(By by) {
        Boolean wait = new WebDriverWait(driver, WEBDRIVER_WAIT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(by).click();
                    return true;
                });
    }

    public void waitForElementAndClickIgnoreStaleError(WebElement elem, By by2) {
        new WebDriverWait(driver, WEBDRIVER_WAIT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    elem.findElement(by2).click();
                    return true;
                });
    }

    public void waitForElementAndClick(WebElement element) {
        this.scrollElementIntoMiddleView(element);
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public void waitForElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        moveToElement(by);
        this.element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        this.scrollElementIntoMiddleView(element);
        element.click();
    }

    public void waitForElementAndClick(By by1, By by2) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by1)));
        moveToElement(by1);
        this.element = driver.findElement(by1).findElement(by2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        this.scrollElementIntoMiddleView(element);
        element.click();
    }

    public void waitForElementAndClick(WebElement elem, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        this.element = elem.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        this.scrollElementIntoMiddleView(element);
        element.click();
    }

    public void waitForElementAttributeBeforeNextStep(WebElement element, String attributeName, String value) {
        this.scrollElementIntoMiddleView(element);
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.attributeContains(element, attributeName, value));

    }

    public void waitElementAndSendData(String text) {
        this.scrollElementIntoMiddleView(element);
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }


    public void waitElementAndSendData(By by, String text) {
        this.element = driver.findElement(by);
        moveToTheElement(element);
        this.scrollElementIntoMiddleView(element);
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }


    public void scrollToThePageByPixel(int xPixel, int yPixel) {
        this.driver = driver;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xPixel + "," + yPixel + ")");
    }


    /*
     * Method to scroll up to the element
     * Uses java script executor
     *
     * @param webElement WebElement to scroll upto
     */
    private void scrollElementIntoMiddleView(WebElement webElement) {
        String scrollElementIntoMiddleJS = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);" +
                "var elementTop = " + "arguments[0].getBoundingClientRect().top;window.scrollBy(0, elementTop-(viewPortHeight/2));";
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript(scrollElementIntoMiddleJS, webElement);
    }


    /*
     * Method to decide if the element is displayed on web page
     * User WebDriverWait
     * Waits for 10s to for the web element to be visible
     *
     * @return true if the web element is displayed, false otherwise
     */
    public boolean isDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException | TimeoutException var3) {
//            LOGGER.error(var3);
            return false;
        }
        return true;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException | TimeoutException var3) {
//            LOGGER.error(var3);
            return false;
        }
        return true;
    }


    /*
     * Method to set the text in text box
     * First waits for 10s for the element to be visible
     * Clears the previous text if exists in the text box
     * uses sendKeys function to set the text
     *
     * @param text text that needs to be set
     */
    public void sendText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void sendTextAndSubmit(String text) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        element.submit();
    }

    /*
     * Method to the text from Web Element
     *
     * @param element WebElement whose text needs to be extracted
     * @return String Returns the text of the Web Element
     */
    public String getText() {
        String text;
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getAttribute("value");
        return text;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getRequiredAttribute(String attributeName) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attributeName);
    }

    public String getRequiredCSSAttribute(String cssAttributeName) {
        WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getCssValue(cssAttributeName);
    }


    /*
     * Method to wait until the dropdown is loaded
     * Wait until the first element in the dropdown is loaded
     */
    private void waitDropdown() {
        final Select dropList = new Select(element);
        ExpectedCondition<Boolean> dropdownLoad = (WebDriver webDriver) -> dropList.getOptions().size() > 1;
        (new FluentWait(driver)).withTimeout(Duration.ofSeconds(FLUENT_WAIT)).pollingEvery(Duration.ofMillis(POLLING_INTERVAL))
                .until(dropdownLoad);
    }

    /*
     * Method to select from dropdown
     * Calls waitDropdown method to wait for the dropdown to load
     * @param visibleText Text which needs to be selected from dropdown
     */
    public void selectFromDropdown(String visibleText) {
        waitDropdown();
        (new Select(element)).selectByVisibleText(visibleText);
    }

    public void selectFromDropdown(WebElement element, String visibleText) {
        waitDropdown();
        (new Select(element)).selectByVisibleText(visibleText);
    }

    public void selectFromDropdown(WebElement element, int indexNumber) {
        waitDropdown();
        (new Select(element)).selectByIndex(indexNumber);
    }

    public void selectFromDropdown(By by, String text) {
        Select fruits = new Select(driver.findElement(by));
        fruits.selectByVisibleText(text);
    }

    public void selectFromDropdown(By by, int indexNumber) {
        Select fruits = new Select(driver.findElement(by));
        fruits.selectByIndex(indexNumber);
    }

    /*
     * Method to get the selected option in the dropdown

     * @return text of the selected item in the dropdown
     */
    public String getSelectedItemText() {
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }

    /*
     * Method to check the checkbox or a radio button
     * Check if the element is not selected, otherwise selects it
     */
    public boolean checkIfElementIsSelected(By by) {
        boolean elementSelected = true;
        this.element = driver.findElement(by);
        if (!element.isSelected()) {
            elementSelected = false;
        }
        return elementSelected;
    }


    public void deselectElementIfSelected() {
        if (element.isSelected()) {
            waitForElementAndClick();
        }
    }

    public void selectElementIfNotSelected(WebElement elem) {
        this.element = elem;
        if (!element.isSelected()) {
            waitForElementAndClick();
        }
    }


    public void deSelectElementIfSelected(WebElement elem) {
        this.element = elem;
        if (element.isSelected()) {
            waitForElementAndClick();
        }
    }

    /*
     * Method to get the selected option in the dropdown

     * @return true if the element is selected, otherwise false
     */
    public boolean isSelected() {
        return element.isSelected();
    }


    /*
     * <h1>parseByPattern method</h1>
     * method used to get a value from string based on regex pattern
     * @param body actual string to parse the value from
     * @param patten actual regex
     * @param group
     * @return value parsed from the string by regex
     */
    public static String parseByPattern(String body, String pattern, int group) {
        String result = "";
        final Pattern pat = Pattern.compile(pattern);
        final Matcher matcher = pat.matcher(body);
        int i = 0;
        while (matcher.find()) {
            if (i == group) {
                result = matcher.group(i);
                break;
            } else {
                i++;
            }

        }
        return result;
    }

    /*
     * <h1>getRegexFromTimeStamp method</h1>
     * @param timestamp - actual timestamp to be converted
     * @return regex
     */
    public static String getRegexFromTimeStamp(String timestamp) {
        StringBuilder result = new StringBuilder();
        final char[] chars = timestamp.toCharArray();
        final String PART = "[0-9]";
        int i = 0;
        for (char ch : chars) {
            if (Character.isAlphabetic(ch)) {
                i++;
            } else {
                result.append(PART + "{" + i + "}" + ch);
                i = 0;
            }
        }
        result.append(PART + "{" + i + "}");
        return result.toString();
    }

    /*
     * <h1>replaceValues method </h1>
     * a method to replace one by one all occurences of a charsequence in a string with members of string array
     * @param string - a string to be modified
     * @param find - char sequence to be replaced
     * @param replace - string array of replacements
     * @return resulting modified string
     */
    public static String replaceValues(String string, String find, String[] replace) {

        List<String> temp = new ArrayList<>();
        Arrays.asList(string.split(find)).forEach(temp::add);
        if (string.endsWith(find.replace("\\", ""))) {
            temp.add("");
        }
        String[] parts = temp.toArray(new String[temp.size()]);
        StringBuilder result = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            result.append(replace[i - 1]);
            result.append(parts[i]);
        }
        return result.toString();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void tearDownDriver() {
        driver.quit();
    }

    public void navigateBackToLastPage() {
        driver.navigate().back();
    }

    public void deleteCookies(String myCookie) {
        try {
            driver.manage().deleteCookieNamed(myCookie);
        } catch (NotFoundException e) {
            log.warn("Cookie = " + myCookie + " NOT Found");
        }
    }

    public void navigateToRootElement() {
        element = driver.findElement(By.xpath("/html/body"));
    }

    public void navigateToParentElement() {
        element = element.findElement(By.xpath("./.."));
    }

    public WebElement navigateToElement(By by) {
        element = driver.findElement(By.xpath("/html/body"));
        element = element.findElement(by);
        return element;
    }

    public WebElement getElementBy(By by) {
        element = driver.findElement(By.xpath("/html/body"));
        element = element.findElement(by);
        return element;
    }

    public void navigateToElementBy(By by1, By by2) {
        element = element.findElement(by1).findElement(by2);
    }

    public void navigateToElementBy(By by) {
        element = driver.findElement(By.xpath("/html/body"));
        element = element.findElement(by);
    }

    public void isElementDisplayed(By by1, By by2) {
        element = element.findElement(by1).findElement(by2);
        element.isDisplayed();
    }

    public List<WebElement> navigateToElementsBy(By by) {
        element = driver.findElement(By.xpath("/html/body"));
        return element.findElements(by);
    }

    public List<WebElement> navigateToElementsBy(By by1, By by2) {
        element = driver.findElement(By.xpath("/html/body"));
        return element.findElement(by1).findElements(by2);
    }

    public WebElement navigateToElementBy(WebElement elem, By by1) {
        return elem.findElement(by1);
    }

    public List<WebElement> navigateToElementsBy(WebElement elem, By by1, By by2) {
        return elem.findElement(by1).findElements(by2);
    }

    public List<WebElement> navigateToElementsBy(WebElement elem, By by) {
        return elem.findElements(by);
    }

    public List<WebElement> navigateToElementsBy(int selectElement, By by1, By by2) {
        element = driver.findElement(By.xpath("/html/body"));
        return element.findElements(by1).get(selectElement).findElements(by2);
    }

    public List<WebElement> navigateToElementsBy(int selectElement, By by1, By by2, By by3) {
        element = driver.findElement(By.xpath("/html/body"));
        return element.findElements(by1).get(selectElement).findElement(by2).findElements(by3);
    }

    public String getElementTexts(By by1, By by2) {
        element = driver.findElement(By.xpath("/html/body"));
        return element.findElement(by1).findElement(by2).getText();
    }

    public String getElementText(WebElement elem, By by1, By by2) {
        return elem.findElement(by1).findElement(by2).getText();
    }

    public String getElementText(WebElement elem, By by1) {
        return elem.findElement(by1).getText();
    }

    public void clickOnSelectedLink(WebElement elem, By by1, By by2) {
        elem.findElement(by1).findElement(by2).click();
    }

    public void clickOnSelectedLink(WebElement elem, By by1, By by2, int selectElement) {
        elem.findElement(by1).findElements(by2).get(selectElement).findElement(By.tagName("a")).click();
    }

    public void click() {
        element.click();
    }

    public void performClickAction(WebElement elem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().perform();
    }

    public void performClickAction(By by) {
        this.element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void moveToTheElement(WebElement elem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).perform();
    }


    public void editValueInDropDownField(String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public void type(String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clearTextBox() {
        element.clear();
    }

    public boolean getPresenceOfElement(By by) {
        navigateToRootElement();
        boolean present = false;
        if (element.findElements(by).size() != 0) {
            present = true;
        }
        return present;
    }


    public String getElementText() {
        return element.getText();
    }

    public String getElementByAttribute(By by, String attributeName) {
        navigateToRootElement();
        navigateToElementBy(by);
        return element.getAttribute(attributeName);
    }

    public String getElementByAttribute(WebElement element, By by, String attributeName) {
        return element.findElement(by).getAttribute(attributeName);
    }

    public String getHeading(By by) {
        navigateToRootElement();
        navigateToElementBy(by);
        return getElementText();
    }

    public String getStartPageHeading(By by) {
        navigateToRootElement();
        navigateToElementBy(by);
        return getElementText();
    }


    public String getDate(By monthLocator, By yearLocator) {
        navigateToRootElement();
        navigateToElementBy(monthLocator);
        String month = getElementText();
        navigateToRootElement();
        navigateToElementBy(yearLocator);
        String year = getElementText();
        return month + " " + year;
    }

    public String getDate(By dayLocator, By monthLocator, By yearLocator) {
        navigateToRootElement();
        navigateToElementBy(dayLocator);
        String day = getElementText();
        navigateToRootElement();
        navigateToElementBy(monthLocator);
        String month = getElementText();
        navigateToRootElement();
        navigateToElementBy(yearLocator);
        String year = getElementText();
        return day + " " + month + " " + year;
    }

    public boolean isElementSelected(By by) {
        navigateToElementBy(by);
        return element.isSelected();
    }

    public boolean isButtonEnabled() {
        return element.isEnabled();
    }

    public void moveToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void moveToElement(WebElement elem) {
        this.element = elem;
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void clearValueInTextBox() {
        int counter = 0;
        int actualLength = getLengthOfText();
        while (counter <= actualLength) {
            element.sendKeys(Keys.chord(Keys.BACK_SPACE));
            counter++;
        }
    }

    private int getLengthOfText() {
        return element.getAttribute("value").length();
    }
}


