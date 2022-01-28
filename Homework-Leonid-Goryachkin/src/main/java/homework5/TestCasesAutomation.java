package homework5;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCasesAutomation {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
    String prop = System.getProperty("user.dir");
    System.setProperty("webdriver.chrome.driver",prop + "\\src\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.amazon.com/");
    String expectedTitle = "Amazon.com. Spend less. Smile more.";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void amazonLoginTest() {
        String userEmail = "socwaloze@gmail.com";
        String password = "1234abcd";
        String expected = "TestUser123";
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(userEmail);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[3]/a/div")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"home-profile-0\"]")).getText();
        Assert.assertEquals(expected,actual);
        System.out.println("Expected Username matches the actual");
    }
    @Test
    public void invalidEmailTest() {
        String userEmail = "testInvalidEmail@gmail.com";
        String expectedFirst = "There was a problem";
        String expectedSecond = "We cannot find an account with that email address";
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(userEmail);
        driver.findElement(By.id("continue")).click();
        String actualOne = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText();
        String actualTwo = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
        Assert.assertEquals(expectedFirst,actualOne);
        Assert.assertEquals(expectedSecond,actualTwo);
        System.out.println("User cannot log in with an invalid email");
    }
    @Test
    public void invalidPasswordTest() {
        String userEmail = "socwaloze@gmail.com";
        String invalidPassword = "12345678";
        String expectedFirst = "There was a problem";
        String expectedSecond = "Your password is incorrect";
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(userEmail);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(invalidPassword);
        driver.findElement(By.id("signInSubmit")).click();
        String actualFirst = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText();
        String actualSecond = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
        Assert.assertEquals(expectedFirst,actualFirst);
        Assert.assertEquals(expectedSecond,actualSecond);
        System.out.println("User cannot sign in with invalid password");
    }
    @Test
    public void searchBoxTest() {
        String search = "headphones";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String searchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        if (searchResult.contains("\"")) {
            searchResult = searchResult.replace('"',' ');
            searchResult = searchResult.trim();
        }
        Assert.assertEquals(search,searchResult);
        String resultProductDescription = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).getText().toLowerCase();
        Assert.assertTrue(resultProductDescription.contains(search));
        System.out.println("The search box is working and gives correct result");
    }
    @Test
    public void invalidSearchData() {
        String oneInvalidSearch = "tesla car buy";
        String twoInvalidSearch = "eaghjevtfw";
        String threeInvalidSearch = "27467802";
        int count = 0;
        String fourInvalidSearch = "[===]{:::::::::::::::>";
        String bestSeller = "Best Seller";
        char [] checker = threeInvalidSearch.toCharArray();
        boolean veryGood = false, veryGoodForNumbers = false;
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(oneInvalidSearch);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String carActualSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[1]/h2/a/span")).getText().toLowerCase();
        driver.findElement(By.id("nav-logo-sprites")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(twoInvalidSearch);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String lettersActualSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[1]/h2/a/span")).getText().toLowerCase();
        for(int i = threeInvalidSearch.length()-1; i>=1; i--) {
            String check = "";
            for(int j = 0; j<i; j++) {
                check+=checker[j];
            }
            if(lettersActualSearch.contains(check)) {
                veryGood = true;
            }
        }
        driver.findElement(By.id("nav-logo-sprites")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(threeInvalidSearch);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String numbersActualSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/div[1]/h2/a/span")).getText().toLowerCase();
        checker = numbersActualSearch.toCharArray();
        for(int i = 1; i<checker.length; i++) {
            if(Character.isDigit(checker[i-1]) && Character.isDigit(checker[i])) {
                count++;
            }
        }
        if (count>=2) {
            veryGoodForNumbers = true;
        }
        driver.findElement(By.id("nav-logo-sprites")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(fourInvalidSearch);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String symbolsActualSearch = driver.findElement(By.xpath("//*[@id=\"B09KZ6TBNY-best-seller-label\"]/span/span")).getText().toLowerCase();
        Assert.assertTrue(carActualSearch.contains("tesla"));
        Assert.assertTrue(veryGood);
        Assert.assertTrue(veryGoodForNumbers);
        Assert.assertEquals(symbolsActualSearch,bestSeller);
    }

    @Test
    public void departmentDropDown() {
        String search = "headphones";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("searchDropdownBox")).click();
        driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[18]")).click();
        String suggestionForPhoneOne = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[4]/div/div/span")).getText().toLowerCase();
        String suggestionForPhoneTwo = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[8]/div/div/span")).getText().toLowerCase();
        suggestionForPhoneOne = suggestionForPhoneOne.trim();
        driver.findElement(By.id("searchDropdownBox")).click();
        driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[45]")).click();
        String suggestionForMusicOne = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[4]/div/div/span")).getText().toLowerCase();
        String suggestionForMusicTwo = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[6]/div/div/span")).getText().toLowerCase();
        driver.findElement(By.id("searchDropdownBox")).click();
        driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[58]")).click();
        String suggestionForGamesOne = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[4]/div/div/span")).getText().toLowerCase();
        String suggestionForGamesTwo = driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[6]/div[5]/div/div/span")).getText().toLowerCase();

        Assert.assertTrue(suggestionForPhoneOne.contains("wireless"));
        Assert.assertTrue(suggestionForPhoneTwo.contains("iphone"));
        Assert.assertTrue(suggestionForMusicOne.contains("music"));
        Assert.assertTrue(suggestionForMusicTwo.contains("singing"));
        Assert.assertTrue(suggestionForGamesOne.contains("xbox"));
        Assert.assertTrue(suggestionForGamesTwo.contains("ps4"));
    }

    @Test
    public void addItemToCard() {
        String search = "headphones jbl tune 510bt";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span")).click();
        driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
        driver.findElement(By.id("nav-logo-sprites")).click();
        String itemCount = driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).getText();
        Assert.assertEquals(itemCount,"1");
        System.out.println("User can add items to cart");
    }
    @Test
    public void canDeleteFromCart() {
        String search = "headphones jbl tune 510bt";
        String empty = "Your Amazon Cart is empty";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span")).click();
        driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[3]/div/div[2]/div[4]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
        driver.findElement(By.id("nav-cart")).click();
        String actualEmpty = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div[2]/div[1]/h2")).getText();
        Assert.assertEquals(empty,actualEmpty);
    }
    @Test
    public void browseHistory() {
        String userEmail = "socwaloze@gmail.com";
        String password = "1234abcd";
        String search = "headphones jbl tune 510bt";
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(userEmail);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-recently-viewed\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"asin_list\"]/div[1]/div[2]/a/img")).click();
        String historyItem = driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText().toLowerCase();
        String[] searchCheck = search.split(" ");
        Assert.assertTrue(historyItem.contains(searchCheck[0]) || historyItem.contains(searchCheck[1])
        || historyItem.contains(searchCheck[2]) || historyItem.contains(searchCheck[3]));

    }
    @Test
    public void yourOrders() {
        String userEmail = "socwaloze@gmail.com";
        String password = "1234abcd";
        String order = "your orders";
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(userEmail);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a/div")).click();
        String actualOrders = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[2]/div[1]/h1")).getText().toLowerCase();
        Assert.assertEquals(order,actualOrders);

    }


    @AfterMethod
    public void close(){
        driver.quit();
    }

}
