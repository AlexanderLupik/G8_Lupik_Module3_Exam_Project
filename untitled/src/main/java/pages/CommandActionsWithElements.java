package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandActionsWithElements {

 protected  WebDriver webDriver;
 protected  Logger logger = Logger.getLogger(getClass());
 protected WebDriverWait webDriverWait10, webDriverWait15, webDriverWait45;




    public CommandActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //для ініціалізації елементів сторінки опираючись на анотації @FindBy
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait45 = new WebDriverWait(webDriver, Duration.ofSeconds(45));
    }






    protected void clickOnElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            String elementName = getElementName(element);
            element.click();

            logger.info("Element was clicked " + elementName);
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    protected String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    protected void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(value);
            logger.info(value + " was selected in DropDown" + getElementName(dropDown));

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    protected void enterTextInToInput(WebElement input, String text) {
        try {
            //input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + getElementName(input));
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }


    protected void checkTextInElement(WebElement element, String expectedText) {
        try {
            String textFromElement = element.getText();
            Assert.assertEquals("Text in element not matched", expectedText, textFromElement);
            logger.info("Text matched");
        } catch (Exception e) {
            logger.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
    }

    protected void checkTextInAltAtribute(WebElement element, String expectedText) {
        try {
            String textFromElement = element.getAttribute("alt");
            Assert.assertEquals("Text in element not matched", expectedText, textFromElement);
            logger.info("Text matched");
        } catch (Exception e) {
            logger.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
    }


}
