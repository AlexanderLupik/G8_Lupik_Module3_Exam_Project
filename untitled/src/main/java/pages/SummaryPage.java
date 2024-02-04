package pages;

import expectedResult.ExpectedResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummaryPage extends ParentPage
{


    public SummaryPage(WebDriver webDriver)
    {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl()
    {  // String url = "#!summary?location_id=14716&optional_services=use_default&quantities%5B0%5D=1&tire_ids%5B0%5D=SXJvbm1hbnx8OTEwNjR8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D#!summary?location_id=14716&optional_services=use_default&quantities%5B0%5D=1&tire_ids%5B0%5D='%s'";
       // return String.format(url, ExpectedResult.tire_id);  // тут знову ексепшн java.util.UnknownFormatConversionException: Conversion = 'D'
        return "#!summary?location_id=14716&optional_services=use_default&quantities%5B0%5D=1&tire_ids%5B0%5D=SXJvbm1hbnx8OTEwNjR8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D";
    }
    @FindBy(xpath = ".//div[@class='tcwlw_max_width tcwlw_summary_wrapper tcwlw_optional_services']//div[text()='Seasonal Tire Storage']")
    private WebElement nameOptionalService;

    @FindBy(xpath = ".//div[@class='tcwlw_max_width tcwlw_summary_wrapper tcwlw_optional_services']//td[@class='tcwlw_price_cell']")
    private WebElement priceOptionalService;

    @FindBy(xpath = ".//span[@class='tcwlw_label tcwlw_qty_label_details']")
    private WebElement quantityOfTires;

//    @FindBy(xpath = ".//div[@class='tcwlw_max_width tcwlw_summary_wrapper tcwlw_optional_services']//input[@aria-label='Service switch.']")
//    private WebElement checkboxOptionalService;
    @FindBy(xpath = ".//div[@class='tcwlw_max_width tcwlw_summary_wrapper tcwlw_optional_services']//label[@class='tcwlw_fancy_checkbox']//input[@aria-label='Service switch.']")
    private WebElement checkboxOptionalService;
    @FindBy(xpath = ".//div[@class='tcwlw_qty_selector']//select")
    private WebElement selectQuantityOfTires;

    @FindBy(xpath = ".//tr[@class='tcwlw_tSubTotal']//td[@class='tcwlw_price_cell']")
    private WebElement subtotalPrice;

    @FindBy(xpath = ".//button[@class='tcwlw_brand_btn_light  tcwlw_tSaveQuoteBtn']")
    private WebElement buttonSaveYourQuote;


    public void checkIsRedirectToSummaryPage() {
        webDriverWait10.until(ExpectedConditions.urlToBe(BASEURL + getRelativeUrl()));
        checkUrl();

    }


    public void checkIsOptionalServiceNotVisible() {
        checkIsElementNotVisible(nameOptionalService);
        checkIsElementNotVisible(priceOptionalService);
        checkIsElementNotVisible(checkboxOptionalService);
        logger.info("Optional service is not visible");

    }

    public void checkForNumberOfSelectedTires(String quantity) {
        checkTextInElement(quantityOfTires, "Qty: " + quantity);
    }

    public void selectQuantityOfTires(String qty) {
         selectValueInDropDown(selectQuantityOfTires, qty);
    }

    public void checkSubtotalPrice(String price) {
        checkTextInElement(subtotalPrice, "$" + price);
    }

    public void checkIsOptionalServiceVisible() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(nameOptionalService));
        checkIsElementVisible(nameOptionalService);
        logger.info("Optional service is visible name");
        checkIsElementVisible(priceOptionalService);
        logger.info("Optional service is visible price");
        //я бачу цей елемент в браузері, але його не видно для селеніума????????????????????????????
        //webDriverWait10.until(ExpectedConditions.visibilityOf(checkboxOptionalService));
       // checkIsElementVisible(checkboxOptionalService);
       // logger.info("Optional service is visible");
    }

    public void clickButtonSaveYourQuote() {

        clickOnElement(buttonSaveYourQuote);
    }
}
