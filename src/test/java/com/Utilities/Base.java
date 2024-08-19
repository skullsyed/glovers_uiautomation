package com.Utilities;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {



    public static WebDriver driver;
 public static JavascriptExecutor js;
    public static void driverLaunch(String browerType) {

        switch (browerType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                break;
        }
    }

    public void get(String value) {
        driver.get(value);

    }
    public void getUrlNavigation(String Url) {
        driver.navigate().to(Url);

    }
    public void getUrlNavigateClass(String url) throws MalformedURLException {
        URL u = new URL(url);
        driver.navigate().to(u);

    }
    public void forward() {
        driver.navigate().forward();
    }
    public void back() {
        driver.navigate().back();
    }
    public void refresh() {
        driver.navigate().refresh();
    }
    public void maximize() {
        driver.manage().window().maximize();
    }
    public void implicitwait(int arg) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(arg));
    }
    public WebElement locateElementById(String attribute) {
        WebElement element = driver.findElement(By.id(attribute));
        return element;
    }
    public WebElement locateElementByClass(String attribute) {
        WebElement element = driver.findElement(By.className(attribute));
        return element;
    }
    public WebElement locateElementByName(String attribute) {
        WebElement element = driver.findElement(By.name(attribute));
        return element;
    }
    public WebElement locateElementByXpath(String attribute) {
        WebElement element = driver.findElement(By.xpath(attribute));
        return element;
    }
    public void click(WebElement element) {
        element.click();
    }
    public String getText(WebElement element) {
        String text = element.getText();
        return text;

    }
    public String getAttribute(WebElement element) {
        String attribute = element.getAttribute("Value");
        return attribute;
    }
    public String getAttribute(WebElement element, String value) {
        String attribute = element.getAttribute(value);
        return attribute;
    }
    public static void type(WebElement element, String key) {
        element.sendKeys(key);
    }

    public static void explicitWaitUntil(WebElement element,int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Method to click an element using JavaScript
    public void clickElementByJS(WebElement element) {
         js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    }

