package com.hs.shared;


import com.github.javafaker.Faker;
import com.hs.config.runTimeConfig;
import com.hs.controller.ConfigRunSetup;
import com.hs.driver.BaseWebDriver;
import com.hs.pageobjects.ValidateUrlsPageSource;
import lombok.extern.log4j.Log4j2;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SharedMethods {

    private static By personalIdentificationBarLocator = By.className("key-details-bar");
    private static By logOutLink = By.tagName("a");
    WebDriver driver = BaseWebDriver.getWebdriver();


    public static class generateDummyTestData {

        private Faker faker = new Faker(new Locale("en_GB"));
        private String name = faker.name().fullName();
        private String firstName = faker.name().firstName();
        private String lastName = faker.name().lastName();
        private String email = firstName + "." + lastName + "@valtech.com";
        private String streetAddress = faker.address().streetAddress();
        private String phoneNumber = faker.phoneNumber().phoneNumber();
        private String randomText = faker.superhero().name() + faker.beer().name() + faker.chuckNorris().fact();
        private long ni = faker.number().randomNumber(2, true);

        public String getName() {
            return name;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public Long getNINumber() {
            return ni;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getSomeText() {
            return randomText + randomText;
        }

    }

    public static List<WebElement> readTable(By tableLocator, WebDriver driver) {
        driver.findElement(tableLocator);
        WebElement userTable = driver.findElement(tableLocator);
        WebElement baseTable = userTable.findElement(By.tagName("tbody"));
        return baseTable.findElements(By.tagName("tr"));
    }

    public static List<WebElement> readTable(WebDriver driver) {
        WebElement baseTable = driver.findElement(By.tagName("tbody"));
        return baseTable.findElements(By.tagName("tr"));
    }

    public static List<WebElement> readTableHeaders(By tableLocator, WebDriver driver) {
        driver.findElement(tableLocator);
        WebElement userTable = driver.findElement(tableLocator);
        WebElement baseTable = userTable.findElement(By.tagName("thead"));
        return baseTable.findElements(By.tagName("th"));
    }


    public void generateMavenReport() {
        File reportOutputDirectory = new File("target/cucumber-reporting");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report/cucumber.json");

        String buildNumber = "1.0";
        String projectName = "Taylor Wimpey Automation Report";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Browser", getBrowserName());
        configuration.addClassifications("Branch", "release Date: " + getTodayDate());
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        configuration.setQualifier("sample", "Some Qualifier");
        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    public String getBrowserName() {
        String browserName;
        boolean isBrowserHeadless = Boolean.parseBoolean(new runTimeConfig().getheadlessRunTimeConfiguration());
        if (isBrowserHeadless) browserName = "Headless";
        else browserName = new runTimeConfig().getBrowserRunTimeConfiguration();
        return browserName.toUpperCase();
    }

    public String getTodayDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "yyyy-MM-dd-HHmmss");
        Date now = new Date();
        return sdfDate.format(now);
    }

    public void redirectValidation(String cvsFileName, int redirectStatusCode) throws FileNotFoundException {
        String baseURL = new ConfigRunSetup().getBaseUrl();
        List<String> allCSVData = ValidateUrlsPageSource.getInstance().readCSV("csvFiles/qa/" + cvsFileName + ".csv");
        for (String cvsData : allCSVData) {
            String url = baseURL + cvsData;
            if (url.isEmpty()) {
                log.info("URL not configured / EMPTY for : = " + url);
                continue;
            }
            try {
                URL obj = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
                conn.setReadTimeout(5000);
                conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                conn.addRequestProperty("User-Agent", "Mozilla");
                conn.addRequestProperty("Referer", "google.com");
                conn.setInstanceFollowRedirects(false);
                log.info("Requested URL to validate ... " + url);

                /* Redirect is FALSE */
                int redirectStatus = conn.getResponseCode();
                assertThat(redirectStatus)
                        .withFailMessage("")
                        .isEqualTo(redirectStatusCode);

                log.info("Redirect Response Code for above URL is --  " + redirectStatus);

                /* Redirect is TRUE */
                HttpURLConnection conn2 = (HttpURLConnection) obj.openConnection();
                conn2.setReadTimeout(5000);
                conn2.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                conn2.addRequestProperty("User-Agent", "Mozilla");
                conn2.addRequestProperty("Referer", "google.com");
                conn2.setInstanceFollowRedirects(true);

                int finalStatus = conn2.getResponseCode();
                assertThat(finalStatus)
                        .withFailMessage("")
                        .isEqualTo(200);

                log.info("FINAL Response Code for above URL is --  " + finalStatus);

            } catch (Exception e) {
                e.printStackTrace();
                assertThat("expected result")
                        .withFailMessage("")
                        .isEqualTo(false);
            }

        }


    }
}


//    public void redirectValidation(String url) {
//        try {
//            URL obj = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//            conn.setReadTimeout(5000);
//            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//            conn.addRequestProperty("User-Agent", "Mozilla");
//            conn.addRequestProperty("Referer", "google.com");
//            conn.addRequestProperty("Redirect", "false");
//            conn.setInstanceFollowRedirects(false);
//
//            System.out.println("Request URL ... " + url);
//
//            boolean redirect = false;
//
//            // normally, 3xx is redirect
//            int status = conn.getResponseCode();
//            if (status != HttpURLConnection.HTTP_OK) {
//                if (status == HttpURLConnection.HTTP_MOVED_TEMP
//                        || status == HttpURLConnection.HTTP_MOVED_PERM
//                        || status == HttpURLConnection.HTTP_SEE_OTHER)
//                    redirect = true;
//            }
//
//            System.out.println("Response Code ... " + status);
//
//            if (redirect) {
//
//                // get redirect url from "location" header field
//                String newUrl = conn.getHeaderField("Location");
//
//                // get the cookie if need, for login
//                String cookies = conn.getHeaderField("Set-Cookie");
//
//                // open the new connnection again
//                conn = (HttpURLConnection) new URL(newUrl).openConnection();
//                conn.setRequestProperty("Cookie", cookies);
//                conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//                conn.addRequestProperty("User-Agent", "Mozilla");
//                conn.addRequestProperty("Referer", "google.com");
//
//                System.out.println("Redirect to URL : " + newUrl);
//
//            }
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuffer html = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                html.append(inputLine);
//            }
//            in.close();
//
//           System.out.println("URL Content... \n" + html.toString());
//            System.out.println("Done");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
