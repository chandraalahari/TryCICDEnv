package com.qa.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleTest {
    WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void setup() throws IOException {
        String env = System.getProperty("env", "dev"); // default to dev

        // Load URLs from properties
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/config.propertiess");
        props.load(fis);

        baseUrl = props.getProperty(env + ".url");
        System.out.println("Running tests on environment: " + env + " with URL: " + baseUrl);

        driver = new ChromeDriver();
    }

    @Test
    public void testHomePage() {
        driver.get(baseUrl);
        System.out.println("Page title: " + driver.getTitle());
        // Add your assertions here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
