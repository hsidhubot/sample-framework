package com.hs.shared;

import com.google.common.base.CharMatcher;
import com.hs.config.runTimeConfig;
import com.hs.controller.ConfigRunSetup;
import com.hs.controller.Controller;
import com.hs.driver.BaseWebDriver;
import com.hs.pageobjects.NewHomes.NewHomePage;
import io.cucumber.java.Scenario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.util.Locale.ENGLISH;
import static org.assertj.core.api.Assertions.assertThat;

@Data
@EqualsAndHashCode(callSuper = false)
@Log4j2
public class GenericMethods extends Controller {
    private By breadCrumb = By.className("breadcrumbs_crumb");
    private final WebDriver driver = BaseWebDriver.getWebdriver();
    public ThreadLocal<String> searchLocationName = new ThreadLocal<>();
    public ThreadLocal<String> developmentName = new ThreadLocal<>();
    public ThreadLocal<String> developmentStateLabel = new ThreadLocal<>();
    public ThreadLocal<String> proposedDevelopmentName = new ThreadLocal<>();
    public ThreadLocal<String> registerInterestForm = new ThreadLocal<>();
    public ThreadLocal<String> plotName = new ThreadLocal<>();
    public ThreadLocal<String> apartmentName = new ThreadLocal<>();
    public ThreadLocal<String> formName = new ThreadLocal<>();

    public ThreadLocal<String> contactUsNumber = new ThreadLocal<>();
    public ThreadLocal<String> contactUsOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> contactUsClosedText = new ThreadLocal<>();
    public ThreadLocal<String> mondayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> tuesdayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> wednesdayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> thursdayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> fridayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> saturdayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> sundayOpeningTimeText = new ThreadLocal<>();
    public ThreadLocal<String> contactUsAddress = new ThreadLocal<>();

    private final By activeImageLocator = By.xpath("//*[contains(@class, 'slick-active')]");
    private final By imageGalleryLocator = By.xpath("//*[@class='slick-slide']");
    private final By tagNameImage = By.tagName("img");
    private final By tagNameA = By.tagName("a");
    private final By tagNameButton = By.tagName("button");
    private final By tagNameSpan = By.tagName("span");
    private final By tagNameSVG = By.tagName("svg");
    private final By tagNameUse = By.tagName("use");

    private final By mainHeaderOptions = By.className("masthead-meta-links-list");
    private final By headerOptionFromHomePageLocator = By.className("masthead-meta-links-list__item");

    private final By mainSubHeaderOptions = By.id("primary_nav");
    private final By mainSubHeaderOptionsPageLocator = By.className("masthead-primary-links-list__item");

    private final By mainClassLocator = By.className("masthead-secondary-links-list");
    private final By mainClassItemsOptionsLocator = By.className("masthead-secondary-links-list__item");

    private static volatile GenericMethods instance = null;

    private GenericMethods() {
    }

    public static GenericMethods getInstance() {
        if (instance == null) {
            synchronized (NewHomePage.class) {
                if (instance == null) {
                    instance = new GenericMethods();
                }
            }
        }
        return instance;
    }

    //   1-  MAIN HEADER SELECTION
    public void clickSelectedElementINMainHeader_Step1(String elementToClick) {
        boolean clickSuccessful = false;
        List<WebElement> elements;
        getWebControl().waitForElementToBeVisibleBy(mainHeaderOptions);
        getWebControl().waitForElementToBeVisibleBy(headerOptionFromHomePageLocator);
        elements = getWebControl(mainHeaderOptions, headerOptionFromHomePageLocator, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                getWebControl(elem, tagNameA).waitForElementAndClick();
                clickSuccessful = true;
//                getWebControl().waitForElementAndClickIgnoreStaleError(elem, tagNameA);
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }

    //    2 - SUB - MAIN HEADER SELECTION
    public void clickSelectedElementUnderMainHeader_Step2(String elementToClick) {
        boolean clickSuccessful = false;
        List<WebElement> elements;
        getWebControl().waitForElementToBeVisibleBy(mainSubHeaderOptions);
        getWebControl().waitForElementToBeVisibleBy(mainSubHeaderOptionsPageLocator);
        elements = getWebControl(mainSubHeaderOptions, mainSubHeaderOptionsPageLocator, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                getWebControl(elem, tagNameA).waitForElementAndClick();
                clickSuccessful = true;
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }


    //  3- SUB - SUB - HEADER SELECTION
    public void clickSecondaryOptions_Step3(String elementToClick) {
        boolean clickSuccessful = false;
        List<WebElement> elements;
        getWebControl().waitForElementToBeVisibleBy(mainClassLocator);
        getWebControl().waitForElementToBeVisibleBy(mainClassItemsOptionsLocator);
        elements = getWebControl(mainClassLocator, mainClassItemsOptionsLocator, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                getWebControl(elem, tagNameA).waitForElementAndClick();
                clickSuccessful = true;
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }

    //    ** To SELECT LINKS FROM WITHIN THE PAGE ***
    public void selectOptionsFromThePage(String optionToClick) {
        boolean clickSuccessful = false;
        By spotLightContent = By.className("spotlight-content");
        List<WebElement> allOptions = getWebControl(spotLightContent, tagNameA, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(allOptions);
        for (WebElement option : allOptions) {
            if (option.getText().contains(optionToClick)) {
                getWebControl().performClickAction(option);
                clickSuccessful = true;
                break;
            }
        }
        isClickSuccess(clickSuccessful, optionToClick);
    }

    public void clickSelectedElement_FromLegacy(String elementToClick, By by1, By by2) {
        boolean clickSuccessful = false;
        getWebControl().waitForAllElementsToBeVisibleBy(by1);
        List<WebElement> elements = getWebControl(by1, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                List<WebElement> elems = getWebControl(elem, by2, true);
                getWebControl().waitForALLWebElementToBeVisibleBy(elems);
                for (WebElement element : elems) {
                    if (element.getText().contains(elementToClick)) {
                        getWebControl().waitForElementAndClick(element);
                        clickSuccessful = true;
                        break;
                    }
                }
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }


    public void clickSelectedElementInMastheadSecondary(String elementToClick, By by1, By by2) {
        boolean clickSuccessful = false;
        getWebControl().waitForAllElementsToBeVisibleBy(by1);
        List<WebElement> elements = getWebControl(by1, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                List<WebElement> elems = getWebControl(elem, by2, true);
                getWebControl().waitForALLWebElementToBeVisibleBy(elems);
                for (WebElement element : elems) {
                    if (element.getText().contains(elementToClick)) {
                        getWebControl().waitForElementAndClick(element);
                        clickSuccessful = true;
                        break;
                    }
                }
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }


    public void clickSelectedElementFromHomePage(String elementToClick, By by1) {
        boolean clickSuccessful = false;
        List<WebElement> elements = getWebControl(by1, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                getWebControl(elem, tagNameA).waitForElementAndClick();
                clickSuccessful = true;
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }

    public void clickSelectedElementFromHomePageTRY(String elementToClick, By by1) {
        boolean clickSuccessful = false;
        List<WebElement> elements = getWebControl(by1, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);

//        elements
//                .stream()
//                .filter()
        for (WebElement elem : elements) {
            if (elem.getText().contains(elementToClick)) {
                getWebControl(elem, tagNameA).waitForElementAndClick();
                clickSuccessful = true;
                break;
            }
        }
        isClickSuccess(clickSuccessful, elementToClick);
    }


    public void isClickSuccess(boolean value, String elementToClick) {
        assertThat(value)
                .withFailMessage("Element did not get click - Option To Click : " + elementToClick)
                .isTrue();
    }


    public void clickSelectedElementInMastheadSecondary(String elementToClick, By by1) {
        boolean clickSuccessful = false;
        List<WebElement> elements = getWebControl(by1, true);
        getWebControl().waitForALLWebElementToBeVisibleBy(elements);
        for (WebElement element : elements) {
            if (element.getText().contains(elementToClick)) {
                getWebControl().waitForElementAndClick(element);
                clickSuccessful = true;
                break;
            }
        }

        isClickSuccess(clickSuccessful, elementToClick);
    }

    public void checkScenarioRunStatus(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseWebDriver.getWebdriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg", scenario.getName());
            log.error("Failure for this scenario -- " + scenario.getName());

//            scenario.embed(takeScreenShotAsByte(), "image/jpeg", scenario.getName());
//            Reporter.log("target/reports/screenshots/embedded1.jpg");
        }
    }


    private static byte[] takeScreenShotAsByte() throws IOException {
        return takeFullPageScreenShotAsByte(BaseWebDriver.getWebdriver());
    }

    private static byte[] takeFullPageScreenShotAsByte(WebDriver driver) throws IOException {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        BufferedImage originalImage = fpScreenshot.getImage();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(originalImage, "jpeg", baos);
            baos.flush();
            return baos.toByteArray();
        }
    }

    public void validateBreadCrumb(String pageName) {
        int numberOfBreadCrumb = getWebControl(breadCrumb, true).size();
        switch (pageName) {
            case "homepage":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(1);
                checkBreadCrumbTextHome();
                break;
            case "findahome":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(2);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                break;
            case "town": // search result page
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(3);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                break;
            case "development":
            case "proposed-developments":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - " + "Development or Proposed Development Breadcrumb" + "--" + pageName)
                        .isEqualTo(4);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                break;
            case "plot":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                checkBreadCrumbTextPlotName();
                break;
            case "apartment":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                checkBreadCrumbTextApartmentName();
                break;
            case "register-interest":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                checkBreadCrumbTextRegisterInterest();
                break;
            case "form": //TBC
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                break;
            case "download-brochure":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                checkBreadCrumbDownloadBrochurePage();
                break;
            case "request-callback":
                assertThat(numberOfBreadCrumb)
                        .withFailMessage("Assertion Error - --Actual--" + numberOfBreadCrumb)
                        .isEqualTo(5);
                checkBreadCrumbTextHome();
                checkBreadCrumbTextNewHome();
                checkBreadCrumbTextTown();
                checkBreadCrumbTextDevelopmentName();
                checkRequestCallbackPage();
                break;
            default:
                throw new IllegalStateException("Unexpected value of : " + pageName);
        }
    }

    private void checkBreadCrumbTextHome() {
        assertThat(getWebControl(breadCrumb, true).get(0).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextTown "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(0).getText()
                        + "\n --Expected --" + "Homes")
                .matches("Home");
    }

    private void checkBreadCrumbTextNewHome() {
        assertThat(getWebControl(breadCrumb, true).get(1).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextTown "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(1).getText()
                        + "\n --Expected --" + "New Homes")
                .matches("New Homes");
    }

    private void checkBreadCrumbTextTown() {
        String searchLocationName = GenericMethods.getInstance().searchLocationName.get();

        String updatedSearchLocationName = searchLocationName.substring(0, 1).toUpperCase() + searchLocationName.substring(1).toLowerCase(); // make first letter Capital

        assertThat(getWebControl(breadCrumb, true).get(2).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextTown "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(2).getText()
                        + "\n --Expected --" + updatedSearchLocationName)
                .matches(updatedSearchLocationName);
    }

    private void checkBreadCrumbTextDevelopmentName() {
        String developmentName = GenericMethods.getInstance().developmentName.get();
        assertThat(getWebControl(breadCrumb, true).get(3).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextDevelopmentName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(3).getText()
                        + "\n --Expected --" + developmentName)
                .matches(developmentName);
    }

    private void checkBreadCrumbTextPlotName() {
        String plotName = GenericMethods.getInstance().plotName.get();
        assertThat(getWebControl(breadCrumb, true).get(4).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextPlotName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(4).getText()
                        + "\n --Expected --" + plotName)
                .matches(plotName);
    }

    private void checkBreadCrumbTextApartmentName() {
        String apartmentName = GenericMethods.getInstance().apartmentName.get();
        assertThat(getWebControl(breadCrumb, true).get(4).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextApartmentName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(4).getText()
                        + "\n --Expected --" + apartmentName)
                .matches(apartmentName);
    }

    private void checkBreadCrumbTextRegisterInterest() {
        assertThat(getWebControl(breadCrumb, true).get(4).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextApartmentName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(4).getText()
                        + "\n --Expected --" + "Register Interest")
                .matches("Register Interest");
    }

    private void checkBreadCrumbDownloadBrochurePage() {
        assertThat(getWebControl(breadCrumb, true).get(4).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextApartmentName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(4).getText()
                        + "\n --Expected --" + "Register Interest")
                .matches("Download Brochure");
    }

    private void checkRequestCallbackPage() {
        assertThat(getWebControl(breadCrumb, true).get(4).getText())
                .withFailMessage("Assertion Error on - checkBreadCrumbTextApartmentName "
                        + "--Actual--" + getWebControl(breadCrumb, true).get(4).getText()
                        + "\n --Expected --" + "Register Interest")
                .matches("Request Callback");
    }

    public GenericMethods validateURLAndOpenPage(String url) {
        try {
            BaseWebDriver.getWebdriver().get(url);
        } catch (Exception InvalidArgumentException) {
            assert false;
            log.error("URL is NULL for running  in - " + new runTimeConfig().getEnvironment());
            log.error("Check relevant ENVIRONMENT-PROPERTIES files to ensure that URL is available in listed environment");
        }
        return this;
    }

    public GenericMethods deleteCookies() {
        BaseWebDriver.getWebdriver().manage().deleteAllCookies();
        return this;
    }

    public void validateImageGallery(String pageName, int numberOfImages) {
        getWebControl().waitForElementToBeVisibleBy(activeImageLocator);
        int imageNumber = 1;
        List<WebElement> activeImage = getWebControl(activeImageLocator, true);

        if (activeImage.size() > 1)
            assertThat(activeImage.size() - 1)
                    .withFailMessage("Number of Images Mismatch on - " + pageName + " - Page" + "--Actual Number Of Images = " + (activeImage.size() - 1))
                    .isEqualTo(1);
        else
            assertThat(activeImage.size())
                    .withFailMessage("Number of Images Mismatch on - " + pageName + " - Page" + "--Actual Number Of Images = " + activeImage.size())
                    .isEqualTo(1);

        String activePixelWidth = getWebControl().getElementByAttribute(activeImage.get(0), tagNameImage, "width");
        String activePixelHeight = getWebControl().getElementByAttribute(activeImage.get(0), tagNameImage, "height");
        validatePixelAssertion(imageNumber, pageName, activeImage.get(0), activePixelWidth, activePixelHeight);
        imageNumber = imageNumber + 1;

        List<WebElement> allImages = getWebControl(imageGalleryLocator, true);
        assertThat(allImages.size())
                .withFailMessage("Number of Images Mismatch on - " + pageName + " - Page" + "--Actual Number Of Images = " + allImages.size())
                .isEqualTo(numberOfImages - 1);

        for (WebElement image : allImages) {
            String pixelWidth = getWebControl().getElementByAttribute(image, tagNameImage, "width");
            String pixelHeight = getWebControl().getElementByAttribute(image, tagNameImage, "height");
            validatePixelAssertion(imageNumber, pageName, image, pixelWidth, pixelHeight);
        }
    }

    private void validatePixelAssertion(int imageNumber, String pageName, WebElement element, String actualPixelWidth, String actualPixelHeight) {
        String requiredPixelWidth;
        String requiredPixelHeight;

        String targetMachine = new runTimeConfig().getTargetConfiguration();

        if (targetMachine.contains("docker")) {
            requiredPixelWidth = "545";
            requiredPixelHeight = "363";
        } else {
            requiredPixelWidth = "960";
            requiredPixelHeight = "640";
        }

        assertThat(actualPixelWidth)
                .withFailMessage(pageName + "- actualPixelWidth- Assertion Error on the Image Gallery Number - " + imageNumber + "--Actual Pixel Width = " + actualPixelWidth)
                .matches(requiredPixelWidth);

        assertThat(actualPixelHeight)
                .withFailMessage(pageName + "- actualPixelWidth- Assertion Error on the Image Gallery Number - " + imageNumber + "--Actual Pixel Width = " + actualPixelHeight)
                .matches(requiredPixelHeight);
    }

    public void readALLCSSELEMENTS(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) BaseWebDriver.getWebdriver();
        String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" +
                "return s;";
        System.out.println(executor.executeScript(script, getWebControl(by, true).get(0)));
    }

    public void scrollUntilElementIsAvailable(By by) {
        getWebControl().scrollToThePageByPixel(0, 800);
        int yPixel = 300;
        boolean actionBarAvailability = false;
        while (!actionBarAvailability) {
            try {
                getWebControl().waitForElementToBeVisibleBy(by);
                actionBarAvailability = true;
            } catch (Exception TimeoutException) {
                getWebControl().scrollToThePageByPixel(0, yPixel);
                yPixel = yPixel + 400;
            }
        }
    }

    public void validateRedirect(String csvFileName) {
        try {
            validateLinks(csvFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateLinks(String csvFileName) throws IOException {
//        200 – Valid Link
//        400 – Bad request
//        401 – Unauthorized
//        403 - Forbidden
//        404 – Not found
//        408 - Request Timeout
//        500 – Internal Error
        String baseURL = new ConfigRunSetup().getBaseUrl();
        List<List<String>> allCSVData = readCSV("csvFiles/qa/" + csvFileName + ".csv");
        for (List<String> cvsData : allCSVData) {
            String url = baseURL + cvsData.get(0);
            if (url.isEmpty()) {
                log.info("URL not configured / EMPTY for : = " + url);
                continue;
            }

            try {
                if (!url.startsWith("xyz") && ignoreURLList(url)) {
                    HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    int respCode = huc.getResponseCode();
                    if (respCode >= 400) {
                        log.fatal("ERROR with REDIRECT URL : = " + url);
                        log.info("RESPONSE CODE : = " + respCode);
                    }
                    log.info("Redirect URL is working fine. URL : = " + url + " \n -- Response Code is : = " + respCode);
                }
            } catch (Exception ValidatorException) {
                log.error("sun.security.validator.ValidatorException with the URL : - " + url);

            }
        }
    }

    private boolean ignoreURLList(String url) {
        boolean result = true;
        String url1 = "https://www./";
        String url2 = "https://www.snapsurveys.com/wh/s.asp?";
        String url3 = "http://www.";
        String url4 = "http://www./";
        String url5 = "https://www.nationalarchives.gov.uk/";
        String url6 = "#content";
        String url7 = "#reset-password-label";

        List<String> ls = new ArrayList<>();
        ls.add(url1);
        ls.add(url2);
        ls.add(url3);
        ls.add(url4);
        ls.add(url5);
        ls.add(url6);
        ls.add(url7);

        Iterator<String> iterator = ls.iterator();
        while (iterator.hasNext()) {
            if (url.contains(iterator.next())) {
                result = false;
                break;
            }
        }
        return result;
    }

    @SneakyThrows
    public List<List<String>> readFloorPlanData(String csvFileName) {
        return readCSVAndRemoveSpecialCharacters("csvFiles/qa/" + csvFileName + ".csv");
    }

    private List<List<String>> readCSV(String csvFile) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private List<List<String>> readCSVAndRemoveSpecialCharacters(String csvFile) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine().replace("\uFEFF", "")));
            }
        }
        return records;
    }

    public List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
//
//    public Map<String, String> getMapFromCSV(final String filePath) throws IOException {
//        Stream<String> lines = Files.lines(Paths.get(filePath));
//        Map<String, String> resultMap =
//                lines.map(line -> line.split("="))
//                        .collect(Collectors.toMap(line -> line[0], line -> line[1]));
//
//        lines.close();
//        return resultMap;
//    }


    public String getLocalDate(String value, String dateValue) {
        String format;
        LocalDate localDate;
        if (value.equals("weekday")) {
            format = "EEEE d";
        } else {
            format = "MMMM";
        }

        if (dateValue.equals("today"))
            localDate = LocalDate.now();//Today's date
        else {
            LocalDate date = LocalDate.now(); // Tomorrow's date
            localDate = date.plusDays(1);
        }

        int month = localDate.getDayOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern(month, format));
        return localDate.format(formatter);
    }

    private String getPattern(int month, String format) {
//        String first = "MMMM d";
//        String first = "EEEE d";
//        String first = format;
//        String last = ", yyyy";

        String pos;
        if (format.contains("EEEE")) {
            pos = (month == 1 || month == 21 || month == 31) ? "'st'" : (month == 2 || month == 22) ? "'nd'" : (month == 3 || month == 23) ? "'rd'" : "'th'";
        } else {
            pos = "";
        }

        return format + pos;
    }

    public void setupContactUsDataFor(String developmentName) {
        String todayDay = String.valueOf(LocalDate.now().getDayOfWeek());
        switch (developmentName.toLowerCase()) {
            case "brislington":
                contactUsNumber.set(TestData.brislingtonSICPhoneNumber);
                contactUsOpeningTimeText.set(todayDay.toLowerCase().contains("wednesday") || todayDay.toLowerCase().contains("monday") ? "Closed Today" : "Open Today 09:00 to 19:00");
                mondayOpeningTimeText.set("Closed");
                tuesdayOpeningTimeText.set("09:00 to 19:00");
                wednesdayOpeningTimeText.set("Closed");
                thursdayOpeningTimeText.set("09:00 to 19:00");
                fridayOpeningTimeText.set("09:00 to 19:00");
                saturdayOpeningTimeText.set("09:00 to 19:00");
                sundayOpeningTimeText.set("09:00 to 19:00");
                contactUsAddress.set(TestData.brislingtonSICAddress);
                break;
            case "northwich":
                contactUsNumber.set(TestData.cheshireSICPhoneNumber);
                contactUsOpeningTimeText.set(todayDay.toLowerCase().contains("monday") || todayDay.toLowerCase().contains("sunday") ? "Closed Today" : "Open Today 09:00 to 19:00");
                mondayOpeningTimeText.set("Closed");
                tuesdayOpeningTimeText.set("09:00 to 19:00");
                wednesdayOpeningTimeText.set("09:00 to 19:00");
                thursdayOpeningTimeText.set("09:00 to 19:00");
                fridayOpeningTimeText.set("09:00 to 19:00");
                saturdayOpeningTimeText.set("09:00 to 19:00");
                sundayOpeningTimeText.set("Closed");
                contactUsAddress.set(TestData.cheshireSICAddress);
                break;
            default:
                throw new IllegalStateException("Unexpected value In the Development Name : -  " + developmentName);
        }
    }


    public void validateDynamicURLNotFound(int serverErrorResponseCodeToValidate, String cvsFileName) {
        try {
            validateDynamicURL(serverErrorResponseCodeToValidate, cvsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateDynamicURL(int serverErrorResponseCodeToValidate, String cvsFileName) throws IOException {
//        200 – Valid Link
//        400 – Bad request
//        401 – Unauthorized
//        403 - Forbidden
//        404 – Not found
//        408 - Request Timeout
//        500 – Internal Error
        String baseURL = new ConfigRunSetup().getBaseUrl();
        List<List<String>> allCSVData = readCSV("csvFiles/qa/" + cvsFileName + ".csv");
        for (List<String> cvsData : allCSVData) {
            String url = baseURL + cvsData.get(0);
            if (url.isEmpty()) {
                log.info("URL not configured / EMPTY for : = " + url);
                continue;
            }

            try {
                if (!url.startsWith("xyz") && ignoreURLList(url)) {
                    HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    int respCode = huc.getResponseCode();
                    if (respCode == serverErrorResponseCodeToValidate) {
                        log.info("URL is returning " + serverErrorResponseCodeToValidate + ". URL : = " + url + " \n -- Response Code is : = " + respCode);
                    } else {
                        log.fatal("ERROR with returning " + serverErrorResponseCodeToValidate + " URL : = " + url);
                        log.error("ACTUAL RESPONSE CODE : = " + respCode);
                        assertThat(respCode)
                                .withFailMessage("URL is returning "
                                        + serverErrorResponseCodeToValidate
                                        + "\n URL : = " + url
                                        + "\n -- Required Response Code is : = " + serverErrorResponseCodeToValidate
                                        + "\n -- Actual Response Code is : = " + respCode)
                                .isEqualTo(serverErrorResponseCodeToValidate);
                    }
                }
            } catch (Exception ValidatorException) {
                log.error("sun.security.validator.ValidatorException with the URL : - " + url);
            }
        }
    }

    public void caveatDisclaimerTextValidation() {
        By aSACaveatPlacemenTextLocator = By.className("asa-disclaimer__text");
        getWebControl().waitForElementToBeVisibleBy(aSACaveatPlacemenTextLocator);
        assertThat(getWebControl(aSACaveatPlacemenTextLocator).getElementText())
                .withFailMessage("Action bar not displayed on the PLOT page. Please check")
                .matches(TestData.CaveatPlacementText);
//        .matches(new runTimeConfig().getEnvironment().equals("qa") ? QATestData.CaveatPlacementText : LIVETestData.CaveatPlacementText);
    }

    public void offerHeaderTitleValidation() {
        By offerTitleLocator = By.className("offers__title");
        getWebControl().waitForElementToBeVisibleBy(offerTitleLocator);
        assertThat(getWebControl(offerTitleLocator).getElementText())
                .withFailMessage("Offer Title is not Expected - Actual - " + getWebControl(offerTitleLocator).getElementText())
                .matches("Helping you move");
    }

    public int offerValidation(String offerHeading, String text, int counter) {
        if (offerHeading.contains("Example Scotland Home")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Example Scotland Home Fund Local Offer");
            counter = counter + 1;
        } else if (offerHeading.contains("Example National Stamp")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Example National Stamp Duty Paid");
            counter = counter + 1;
        } else if (offerHeading.contains("Example Local Offer No Text")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Example Local Offer No Text Expansion");
            counter = counter + 1;
        } else if (offerHeading.contains("Example Local Offer With Text")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Example Local Offer With Text Expansion");
            counter = counter + 1;

        } else if (offerHeading.contains("Central London Local")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Central London Local Offer");
            counter = counter + 1;
        } else if (offerHeading.contains("Equity Loan")) {
            assertThat(text)
                    .withFailMessage(" Required Offer Card text does not match - Actual " + text)
                    .contains("Help to Buy: Equity Loan");
            counter = counter + 1;
        }
        return counter;
    }

    public void validateCounterValues(int counter, int expectedValue, String plotOrDevelopment) {
        assertThat(counter)
                .withFailMessage("Number of offer cards for - " + plotOrDevelopment + " - not as expected - Actual =" + counter)
                .isEqualTo(expectedValue);
    }

    public void validateLondonThemeForOffers() {
        By offerTitle = By.className("offers__title");
        By brushstroke = By.className("brushstroke--regular");
        By findOutMoreLocator = By.className("reveal-detail-summary__title");

        getWebControl().waitForElementToBeVisibleBy(offerTitle);
        /*Offer Title - Dark Grey Color*/
        List<WebElement> allBrushstrokeColor = getWebControl(offerTitle, brushstroke, true);
        assertThat(allBrushstrokeColor.get(0).getCssValue("color"))
                .withFailMessage("London Theme for the Offers - Find out more - is incorrect !!")
                .isEqualTo(TestData.darkGrey);

        /*Offer Title - Brush Stoke under*/
        String brushStokeActualColor = driver.findElement(offerTitle).findElements(By.tagName("span")).get(1).findElements(By.tagName("svg")).get(1).findElement(By.tagName("use")).getCssValue("fill");
        assertThat(brushStokeActualColor)
                .withFailMessage("London Theme - brush stroke Gold Svg - is incorrect !! - Actual")
                .isEqualTo(TestData.goldB);

        //  ******* OFFER CARDS **********
        List<WebElement> allFindOutMore = getWebControl(findOutMoreLocator, true);
        for (WebElement all : allFindOutMore) {
            /*Offer FIND OUT MORE - Dark Grey Color*/
            assertThat(all.getCssValue("color"))
                    .withFailMessage("London Theme for the Offers - Find out more - is incorrect !!")
                    .isEqualTo(TestData.darkGrey);

            /*Dropdown - Find out more */
            WebElement elem = all.findElement(tagNameSpan);
            String findOutMoreDropDownColor = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before')." +
                    "getPropertyValue('background-color');", elem).toString();
            assertThat(findOutMoreDropDownColor)
                    .withFailMessage("London Theme - Selling Drop Down Arrow stroke Gold Svg - is incorrect !! - Actual")
                    .isEqualTo(TestData.goldB);
        }
    }

    public int getTotalCountOfHomesUnderADevelopment(String viewAllHomesText) {
        return Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(viewAllHomesText));
    }

    public String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1).toLowerCase(); // Will Capitalise first letter and all others to lower case
    }

    public String capitalizeFirstLetter(String name) {
        return WordUtils.capitalizeFully(name);
    }

    public String developmentNameInTheUrl(String name) {
        return WordUtils.capitalizeFully(name).replace(" ", "-");
    }

    public void hardWaitForPageToRefresh() {
        By dummy = By.id("dummyvalue");
        try {
            getWebControl().waitForDUMMYElementToBeVisibleBy(dummy);
        } catch (NoSuchElementException | ElementNotVisibleException | TimeoutException ignored) {
        }
    }


}


//
//    By by = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/div[2]/details/summary/div/span");
//    JavascriptExecutor executor = (JavascriptExecutor) BaseWebDriver.getWebdriver();
//    String script1 = "var s = '';" +
//            "var o = getComputedStyle(arguments[0],':before');" +
//            "for(var i = 0; i < o.length; i++){" +
//            "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" +
//            "return s;";
//
//    private void validateLondonThemeForOfferCardDetailTitle(By titleName) {
//        assertThat(getWebControl(titleName).getRequiredCSSAttribute("color"))
//                .withFailMessage("London Theme for the Offers - Find out more - is incorrect !!")
//                .isEqualTo(TestData.colorB);
//    }
//
//    public void validateOfferCardDetailFindOutMoreDropDownIconColor() {
//        /*Dropdown - Find out more */
//        By xx = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/div[2]/details/summary/div/span");
//        WebElement el = driver.findElement(xx);
//        String actualColor = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before')." +
//                "getPropertyValue('background-color');", el).toString();
//
//        assertThat(actualColor)
//                .withFailMessage("London Theme - Selling Drop Down Arrow stroke Gold Svg - is incorrect !! - Actual")
//                .isEqualTo(TestData.colorC1);
//    }
///*Offer Title - Dark Grey Color*/
//private void validateLondonThemeTitleForDarkGreyColor(List<WebElement> allFindOutMore) {
//    assertThat(allFindOutMore.get(0).getCssValue("color"))
//            .withFailMessage("London Theme for the Offers - Find out more - is incorrect !!")
//            .isEqualTo(TestData.colorB);
//}
//
//    /*Offer Title - Brush Stoke under*/
//    public void validateBrushStokeColorForOfferTitle() {
//        By offerTitle = By.className("offers__title");
//        getWebControl().waitForElementToBeVisibleBy(offerTitle);
//        String actualColor = driver.findElement(offerTitle).findElements(By.tagName("span")).get(1).findElements(By.tagName("svg")).get(1).findElement(By.tagName("use")).getCssValue("fill");
//        assertThat(actualColor)
//                .withFailMessage("London Theme - brush stroke Gold Svg - is incorrect !! - Actual")
//                .isEqualTo(TestData.colorC1);
//    }
