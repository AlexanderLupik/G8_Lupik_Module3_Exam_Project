package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

//Parent class for all tests
public class BaseTest {
    WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected PageProvider pageProvider;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //download and setup driver
        webDriver = new ChromeDriver(); //create driver
        webDriver.manage().window().maximize(); //maximize window
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait 5 seconds
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
    }

    @After

    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");

    }


}
