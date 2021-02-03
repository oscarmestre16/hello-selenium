package com.example.hello_selenium2;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
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
import java.util.concurrent.TimeUnit;

public class PruebaRobo {
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
    public void pruebarobobar() {
      /*
        //WebElement we = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\'submit\']")])));
        //we.click();*/

       /* try {
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){

        }*/
        driver.get("http://localhost:3000/#!/");
        driver.findElement(By.xpath("//button[contains(.,\'+\')]")).click();
        vars.put("p1", driver.findElement(By.xpath("//button[contains(.,\'+\')]")).getText());
        driver.findElement(By.xpath("//button[contains(.,\'+\')]")).click();
        vars.put("p2", driver.findElement(By.xpath("//button[contains(.,\'+\')]")).getText());
        driver.findElement(By.xpath("//tr[2]/td[3]/div/div/div[2]/button")).click();
        vars.put("p3", driver.findElement(By.xpath("//button[contains(.,\'+\')]")).getText());
        driver.findElement(By.xpath("//tr[3]/td[3]/div/div/div[2]/button")).click();
        vars.put("total", driver.findElement(By.xpath("//button[contains(.,\'+\')]")).getText());

        //driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        WebElement result = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\'submit\']")));
        result.click();


        System.out.println("Cola=vars.get('p1').toString()");
        System.out.println("Beer=vars.get('p2').toString()");
        System.out.println("Wine=vars.get('p3').toString()");
        System.out.println("Total=vars.get('total').toString()");
        assertEquals(vars.get("total").toString(),"€6.25");
        /*

        driver.findElement(By.xpath("//input[@id=\'ageInput\']")).click();
        driver.findElement(By.xpath("//input[@id=\'ageInput\']")).sendKeys("24");
        vars.put("edad", driver.findElement(By.xpath("//input[@id=\'ageInput\']")).getText());
        System.out.println("Edad= vars.get('edad').toString()");
        driver.findElement(By.xpath("//button[contains(.,\'Order\')]")).click();

        */

    }
}
