package com.Utilities;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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

    public void moveToElement(WebElement target) {
        Actions action = new Actions(driver);
        action.moveToElement(target);
    }
    //21
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target);
    }
    //22
    public void rightClick() {
        Actions action = new Actions(driver);
        action.contextClick();
    }
    //23
    public void doubleClick() {
        Actions action = new Actions(driver);
        action.doubleClick();
    }
    //24
    public void tab() throws AWTException {
        Robot robert = new Robot();
        robert.keyRelease(KeyEvent.VK_TAB);
    }
    //25
    public void enter() throws AWTException {
        Robot robert = new Robot();
        robert.keyPress(KeyEvent.VK_ENTER);
        robert.keyRelease(KeyEvent.VK_ENTER);
    }
    //26
    public void shift() throws AWTException {
        Robot robert = new Robot();
        robert.keyPress(KeyEvent.VK_SHIFT);
        robert.keyRelease(KeyEvent.VK_SHIFT);
    }
    //27
    public void up() throws AWTException {
        Robot robert = new Robot();
        robert.keyPress(KeyEvent.VK_UP);
        robert.keyRelease(KeyEvent.VK_UP);
    }
    //28
    public void down() throws AWTException {
        Robot robert = new Robot();
        robert.keyPress(KeyEvent.VK_DOWN);
        robert.keyRelease(KeyEvent.VK_DOWN);
    }
    //29
    public void acceptAlert() {
        Alert al = driver.switchTo().alert();
        al.accept();
    }
    //30
    public void dismissAlert() {
        Alert al = driver.switchTo().alert();
        al.dismiss();;
    }
    //31
    public void promptAlert(String key) {
        Alert al = driver.switchTo().alert();
        al.sendKeys(key);
        al.accept();
    }

    public void setAttribueJs(String text, WebElement args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')", args);
    }
    //33
    public String getAttribueJs(WebElement args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object es = js.executeScript("returnarguments[0].getAttribute('value')", args);
        String s = (String) es;
        return s;
    }
    //34
    public void clickJs(WebElement args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", args);
    }
    //35
    public void downJs(WebElement args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", args);
    }
    //36
    public void upJs(WebElement args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", args);
    }

    public void fullScreenShot(String target) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File des = new File(target);
        FileUtils.copyFile(source, des);
    }
    //38
    public void elementScreenShot(WebElement element, String target) throws IOException {
        File source = element.getScreenshotAs(OutputType.FILE);
        File des = new File(target);
        FileUtils.copyFile(source, des);
    }

    //41
    public void selectByIndexDD(WebElement element, int num) {
        Select s = new Select(element);
        s.selectByIndex(num);
    }
    //42
    public void selectByValueDD(WebElement element, String value) {
        Select s = new Select(element);
        s.selectByValue(value);
    }
    //43
    public static void selectByVisibleTextDD(WebElement element, String value) {
        Select s = new Select(element);
        s.selectByVisibleText(value);
    }
    //44
    public List<WebElement> getOptionDD(WebElement element) {
        Select s = new Select(element);
        List<WebElement> list = s.getOptions();
        return list;
    }

    //45
    public int size(List<WebElement> list) {
        int size = list.size();
        return size;
    }
    //46
    public List<WebElement> getAllSelectOption(WebElement element) {
        Select s = new Select(element);
        List<WebElement> list = s.getAllSelectedOptions();
        return list;
    }
    //47
    public WebElement getFirstSelectedOption(WebElement element) {
        Select s = new Select(element);
        WebElement listElement = s.getFirstSelectedOption();
        return listElement;
    }
    //48
    public boolean isMultiple(WebElement element) {
        Select s = new Select(element);
        boolean multiple = s.isMultiple();
        return multiple;
    }
    //49
    public void deSelectByIndexDD(WebElement element, int num) {
        Select s = new Select(element);
        s.deselectByIndex(num);
    }
    //50
    public void deSelectByValueDD(WebElement element, String value) {
        Select s = new Select(element);
        s.deselectByValue(value);
    }
    //51
    public void deSelectByVisibleTextDD(WebElement element, String value) {
        Select s = new Select(element);
        s.deselectByVisibleText(value);
    }
    //52
    public void deSelectAllDD(WebElement element) {
        Select s = new Select(element);
        s.deselectAll();
    }
    //53
    public static void quit() {
        driver.quit();
    }
    //54
    public void close() {
        driver.close();
    }
    //55
    public void selectFrameById(int num) {
        driver.switchTo().frame(num);
    }
    //56
    public void selectFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }
    //57
    public void selectFrameByIndex(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }
    //58
    public List<WebElement> locateByTagName(String tagName) {
        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        return elements;
    }
    //59
    public void exitFrame() {
        driver.switchTo().defaultContent();
    }
    //60
    public void windowHandlingByURL(String name) {
        driver.switchTo().window(name);
    }
    //61
    public String getParentURLId() {
        String handle = driver.getWindowHandle();
        return handle;
    }
    //62
    public Set<String> getAllURLIds() {
        Set<String> handles = driver.getWindowHandles();
        return handles;
    }
    //63
    public void gotoParentWindow(String handle) {
        driver.switchTo().window(handle);
    }
    //64
    public List<WebElement> findElementsById(String attribute) {
        List<WebElement> elements = driver.findElements(By.id(attribute));
        return elements;
    }
    //65
    public List<WebElement> findElementsByName(String attribute) {
        List<WebElement> elements = driver.findElements(By.name(attribute));
        return elements;
    }
    //66
    public List<WebElement> findElementsByClassName(String attribute) {
        List<WebElement> elements = driver.findElements(By.className(attribute));
        return elements;
    }
    //67
    public List<WebElement> findElementsByxpath(String attribute) {
        List<WebElement> elements = driver.findElements(By.xpath(attribute));
        return elements;
    }
    //68
    public void clear(WebElement element) {
        element.clear();
    }
    }

