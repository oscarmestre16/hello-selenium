package com.example.hello_selenium2;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import java.net.URL;

public class RottenTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
         /*driver = new FirefoxDriver();
        options.setHeadless(true);*/
        Configuration.startMaximized = true;
        open("about:blank");
        driver = getWebDriver();

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

        driver.findElement(By.id("suggestion-search")).click();
        driver.findElement(By.id("suggestion-search")).sendKeys("Wandavision");
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        WebElement wandaresult = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\'WandaVision\')]")));
        driver.findElement(By.xpath("//a[contains(text(),\'WandaVision\')]")).click();
        js.executeScript("window.scrollTo(0,741)");
        WebElement we = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("TRIVIA")));
        we.click();
    }
}

