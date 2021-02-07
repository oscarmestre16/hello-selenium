package com.example.hello_selenium2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SearchIMDB {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws MalformedURLException{
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
    public void wanda()  {

        driver.get("https://www.imdb.com/");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("wandavision");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated((By.linkText("WandaVision")))).click();

        js.executeScript("window.scrollTo(0,285)");
        driver.findElement(By.linkText("TRIVIA")).click();
    }
}

