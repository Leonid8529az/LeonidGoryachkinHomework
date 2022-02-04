package homework6;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestOnHomework extends UsableAPI {
    @Test
    public void clickOnRadio() {
        click("//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input");
        WebElement radio = createWebElement("//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input");
        Assert.assertTrue(radio.isSelected());
        System.out.println("Radio 1 is selected");
        waitSeconds(2);
        click("//*[@id=\"radio-btn-example\"]/fieldset/label[2]/input");
        radio = createWebElement("//*[@id=\"radio-btn-example\"]/fieldset/label[2]/input");
        Assert.assertTrue(radio.isSelected());
        System.out.println("Radio 2 is selected");
        waitSeconds(2);
        click("//*[@id=\"radio-btn-example\"]/fieldset/label[3]/input");
        radio = createWebElement("//*[@id=\"radio-btn-example\"]/fieldset/label[3]/input");
        Assert.assertTrue(radio.isSelected());
        System.out.println("Radio 3 is selected");
        waitSeconds(2);
    }
    @Test
    public void selectCountries() {
        enterTextByID("autocomplete","can");
        waitSeconds(1);
        List<WebElement> dropdown = getOptionsFromDropDownMenuByID("ui-id-1");
        waitSeconds(1);
        for (WebElement element : dropdown) {
            if (element.getText().equalsIgnoreCase("Central African Republic")) {
                element.click();
            }
        }
        String actualText = getTextByID("autocomplete");
        Assert.assertEquals(actualText,"Central African Republic");
    }
    @Test
    public void dropDownMenu() {
        selectDropDownOptionByID("dropdown-class-example","Option1");
        String actual = getText("//*[@id=\"dropdown-class-example\"]/option[2]");
        Assert.assertEquals(actual,"Option1");
        System.out.println("Option 1 is selected");
        waitSeconds(1);
        selectDropDownOptionByID("dropdown-class-example","Option2");
        actual = getText("//*[@id=\"dropdown-class-example\"]/option[3]");
        Assert.assertEquals(actual,"Option2");
        System.out.println("Option 2 is selected");
        waitSeconds(1);
        selectDropDownOptionByID("dropdown-class-example","Option3");
        actual = getText("//*[@id=\"dropdown-class-example\"]/option[4]");
        Assert.assertEquals(actual,"Option3");
        System.out.println("Option 3 is selected");
        waitSeconds(1);
    }
    @Test
    public void checkBox() {
        clickByID("checkBoxOption1");
        WebElement element1 = createWebElementByID("checkBoxOption1");
        clickByID("checkBoxOption2");
        WebElement element2 = createWebElementByID("checkBoxOption2");
        clickByID("checkBoxOption3");
        WebElement element3 = createWebElementByID("checkBoxOption3");
        Assert.assertTrue(element1.isSelected());
        Assert.assertTrue(element2.isSelected());
        Assert.assertTrue(element3.isSelected());
        waitSeconds(2);
        if (element2.isSelected()) {
            clickByID("checkBoxOption2");
        }
        waitSeconds(2);
        Assert.assertFalse(element2.isSelected());
        System.out.println("Option 2 is not selected");
    }
    @Test
    public void openWindow() {
        clickByID("openwindow");
        switchToNewWindow();
        click("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[8]/a");
        WebElement element = createWebElement("/html/body/app-root/div/header/div[1]/div/div/div[1]/ul/li");
        Assert.assertEquals(element.getText(),"contact@rahulshettyacademy.com");
        System.out.println("New window is opened and contact is clicked");
    }
    @Test
    public void openNewTab() {
        clickByID("opentab");
        switchToNewTab();
        click("/html/body/app-root/div/header/div[2]/div/div/div[2]/nav/div[2]/ul/li[7]");
        WebElement element = createWebElement("//*[@id=\"form-container\"]/div/div[2]/h2");
        Assert.assertEquals(element.getText(),"Join now to Practice");
        System.out.println("Changed the tab and clicked on practice successfully");
    }
    @Test
    public void alertClicking() {
        String myName = "Leonid";
        clickByID("alertbtn");
        alertClick(true);
        enterTextByID("name",myName);
        clickByID("confirmbtn");
        String actualText = alertTextDetector();
        Assert.assertEquals(actualText,"Hello " + myName + ", Are you sure you want to confirm?");
        alertClick(false);
        System.out.println("Alerts are working perfectly");
    }
    @Test
    public void webTableExample() {
        String firstOne = "Rahul Shetty";
        String secondOne = "Learn JMETER from Scratch - (Performance + Load) Testing Tool";
        String thirdOne = "0";
        String actualFirstOne = getText("//*[@id=\"product\"]/tbody/tr[2]/td[1]");
        String actualSecondOne = getText("//*[@id=\"product\"]/tbody/tr[6]/td[2]");
        String actualThirdOne = getText("//*[@id=\"product\"]/tbody/tr[11]/td[3]");
        Assert.assertEquals(firstOne,actualFirstOne);
        Assert.assertEquals(secondOne,actualSecondOne);
        Assert.assertEquals(thirdOne,actualThirdOne);
        System.out.println("All the data is collected from databased and equals to expected");
    }
    @Test
    public void elementDisplayed() {
        WebElement element = createWebElementByID("displayed-text");
        Assert.assertTrue(element.isDisplayed());
        System.out.println("This element is displayed");
        clickByID("hide-textbox");
        Assert.assertFalse(element.isDisplayed());
        System.out.println("This element is hidden");
        clickByID("show-textbox");
        Assert.assertTrue(element.isDisplayed());
        System.out.println("This element is displayed again");
    }
    /*@Test
    public void webTableFixedHeader() {
        scroller("600");
        WebElement element = createWebElement("//*[@id=\"product\"]/tbody");
        String[] myElements = getValuesFromRow(element,9);
        for (int i = 0; i < myElements.length; i++) {
            System.out.println(myElements[i]);
        }*/

    @Test
    public void hoverOverTheButton() {
        scroller("1000");
        hoverOver("//*[@id=\"mousehover\"]");
        click("/html/body/div[4]/div/fieldset/div/div/a[1]");
        scroller("1000");
        hoverOver("//*[@id=\"mousehover\"]");
        click("/html/body/div[4]/div/fieldset/div/div/a[2]");
        scroller("1000");
        System.out.println("Page successfully reloaded");
    }
    @Test
    public void iframeTest() {
        scroller("1000");
        switchToIFrame(0);
        click("/html/body/app-root/div/header/div[1]/div/div/div[2]/ul/li[1]/a/span");
        System.out.println("It pressed, but the youtube do not load");
    }

}
