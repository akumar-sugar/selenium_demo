package test.java;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestExampleChromeDriver {

    WebDriver driver;

    @Test
    public void testTitle(){
        /*
        In order to use chrome driver
        Go to: http://chromedriver.storage.googleapis.com/index.html?path=2.9/
        * Download (I'm using mac, hence) chromedriver_mac32.zip
        * Extract to <Project DIR>/libs folder
        * System.setproperty(key,value);
            Key = "webdriver.chrome.driver"
            Value = "chromedriver.{extension}", Absolute path of chromedriver
        */
        System.setProperty("webdriver.chrome.driver","./libs/chromedriver");
        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        assertEquals("Expecting Cheese! ", "Cheese", driver.getTitle());

        //Close the browser
        // driver.quit(); // when a test fails, the browser does not close; so moving to tearDown with @After
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

