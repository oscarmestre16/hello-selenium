package com.example.hello_selenium2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;;

public class SearchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void googlesearch() {
        // Test name: google search
        // Step # | name | target | value | comment
        // 1 | open | https://www.google.com/ |  |
        driver.get("https://www.google.com/");
        // 2 | selectFrame | index=0 |  |
        driver.switchTo().frame(0);
        // 3 | click | css=#introAgreeButton .RveJvd |  |
        driver.findElement(By.cssSelector("#introAgreeButton .RveJvd")).click();
        // 4 | selectFrame | relative=parent |  |
        driver.switchTo().defaultContent();
        // 5 | type | name=q | devops |
        driver.findElement(By.name("q")).sendKeys("devops");
        // 6 | sendKeys | name=q | ${KEY_ENTER} |
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // 7 | runScript | window.scrollTo(0,114) |  |
        js.executeScript("window.scrollTo(0,114)");
        // 8 | click | css=.g:nth-child(8) .LC20lb > span |  |
        driver.findElement(By.cssSelector(".g:nth-child(8) .LC20lb > span")).click();
    }
}

