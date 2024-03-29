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
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(dropDown));
            select.selectByValue(value);
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
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
            String textFromElement = element.getText();
            Assert.assertEquals("Text in element not matched", expectedText, textFromElement);
            logger.info("Text matched: " + expectedText + " = " + textFromElement);
        } catch (Exception e) {
            logger.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
    }

    protected void checkTextInAltAtribute(WebElement element, String expectedText) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
            String textFromElement = element.getAttribute("alt");
            Assert.assertEquals("Text in element not matched", expectedText, textFromElement);
            logger.info("Text matched");
        } catch (Exception e) {
            logger.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            logger.info("Element is displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is displayed -> false");
            return false;
        }
    }

    protected void checkIsElementNotVisible(WebElement webElement) {
        Assert.assertTrue("Element is visible", !isElementDisplayed(webElement));
    }

    protected void checkIsElementVisible(WebElement webElement) {
        Assert.assertTrue("Element is not visible", isElementDisplayed(webElement));
    }


    protected void checkToCheckbox(WebElement checkbox) {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(checkbox));
        try {
            if (!checkbox.isSelected()) {
                checkbox.click();
                logger.info("Checkbox was checked");
            } else {
                logger.info("Checkbox is already selected");
            }
        } catch (Exception e) {
            logger.error("Can not work with checkbox");
            Assert.fail("Can not work with checkbox");
        }
    }

    protected void  enterTextInToInputSymbolically( WebElement input, String text){

        try {
            for (int i = 0; i < text.length(); i++) {
                char symbol = text.charAt(i);
                input.sendKeys(String.valueOf(symbol));
                Thread.sleep(500);
            }
            logger.info(text + " was inputed in to input " + getElementName(input));
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    protected void sleep(int time) {
        //зробив окремий метод тут, так як утіловський метод sleep в безкінечно виконує тест, якщо його використовувати на пейджі, наприклад тут ResultPage.checkNumberOfTiresFound
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
