package com.example.hello_selenium2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RottenTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void wanda() {

        driver.get("https://www.imdb.com/");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("wandavision");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated((By.linkText("WandaVision")))).click();
        js.executeScript("window.scrollTo(0,285)");
        driver.findElement(By.linkText("TRIVIA")).click();
    }
}

