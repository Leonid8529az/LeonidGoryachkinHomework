package homework6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsableAPI {
    public WebDriver driver;

    @BeforeMethod
    public void startingPoint() {
        System.out.println("---------------------------------------------------");
        String prop = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",prop + "\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @AfterMethod
    public void endPoint() {
        driver.quit();
    }
    public void click(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            driver.findElement(By.cssSelector(locator)).click();
        }
    }
    public void enterText(String locator, String whichTextYouWantToEnter) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(whichTextYouWantToEnter, Keys.ENTER);
        } catch (Exception e) {
            driver.findElement(By.cssSelector(locator)).sendKeys(whichTextYouWantToEnter,Keys.ENTER);
        }
    }
    public void clickByID(String locator) {
        driver.findElement(By.id(locator)).click();
    }
    public void enterTextByID(String locator, String yourTextHere) {
        driver.findElement(By.id(locator)).sendKeys(yourTextHere,Keys.ENTER);
    }
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement createWebElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }
    public WebElement createWebElementByID(String locator) {
        WebElement element = driver.findElement(By.id(locator));
        return element;
    }
    public List<WebElement> getOptionsFromDropDownMenu(String dropdownLocator) {
        List<WebElement> list = driver.findElements(By.xpath(dropdownLocator));
        return list;
    }
    public List<WebElement> getOptionsFromDropDownMenuByID(String dropdownLocator) {
        List<WebElement> list = driver.findElements(By.id(dropdownLocator));
        return list;
    }
    public String getTextByID(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }
    public String getText(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }
    public void selectDropDownOption(String locator, String option) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Select select = new Select(element);
            try {
                select.selectByVisibleText(option);
            } catch (Exception e) {
                select.selectByValue(option);
            }
        } catch (Exception e) {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Select select = new Select(element);
            try {
                select.selectByVisibleText(option);
            } catch (Exception e1) {
                select.selectByValue(option);
            }
        }
    }
    public void selectDropDownOptionByID(String locator, String option) {
            WebElement element = driver.findElement(By.id(locator));
            Select select = new Select(element);
            try {
                select.selectByVisibleText(option);
            } catch (Exception e) {
                select.selectByValue(option);
            }

    }
    public void switchToNewWindow() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    public void switchToNewTab() {
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
    }
    public void alertClick(boolean trueOrFalse) {
        if (trueOrFalse == true) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }
    public String alertTextDetector() {
        return driver.switchTo().alert().getText();
    }
    public void scroller(String howManyPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + howManyPixels + ")");

    }
    //public void scrollerForInnerTables(WebElement el) {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();",el);

    //}
    public List<WebElement> getListOfElements(String locator) {
        List<WebElement> listOfElements = driver.findElements(By.xpath(locator));
        return listOfElements;
    }
    public String[] getValuesFromRow(WebElement el, int whichRow) {
        String[] text;
        WebElement ar = el;
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        List<WebElement> column = rows.get(whichRow).findElements(By.tagName("td"));
        text = new String[column.size()];
        for (int i = 0; i < column.size(); i++) {
            text[i] = column.get(i).getText();
        }
        return text;
    }
    public WebElement createWebElementFromClassName(String locator) {
        return driver.findElement(By.className(locator));
    }
    public void hoverOver(String locator) {
        Actions action = new Actions(driver);
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            action.moveToElement(element).build().perform();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.cssSelector(locator));
            action.moveToElement(element).build().perform();
        }
    }
    public void switchToIFrame(int index) {
        driver.switchTo().frame(index);
    }
    public void howManyIframesWeHave() {
        int size = driver.findElements(By.tagName("iframe")).size();
        for (int i = 0; i<size;i++) {
            driver.switchTo().frame(i);
            System.out.println(i + " " + driver.getTitle());
        }
    }

}
