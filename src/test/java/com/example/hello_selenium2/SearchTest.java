package com.example.hello_selenium2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SearchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(System.getProperty("browser","firefox"));
        driver = new RemoteWebDriver(new URL("http://10.250.12.1:4444"), capabilities);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Search_Google_Test() {
        driver.get("https://www.google.es/");
        driver.manage().window().setSize(new Dimension(1183, 807));
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#introAgreeButton")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("devops");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
}


