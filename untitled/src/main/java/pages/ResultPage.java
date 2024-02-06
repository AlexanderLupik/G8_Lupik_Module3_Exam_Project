package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Util;

import static testData.TestData.PART_NUMBER;

public class ResultPage extends ParentPage{

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
    String urlpn1 = "#!results?part_numbers%5B0%5D";
    String urlpn2="=%s&order_by=best_match&display=full&location_id=14716&search_by=partNumber&page=1";
      return urlpn1 + String.format(urlpn2, PART_NUMBER); //- цей код видає java.util.UnknownFormatConversionException: Conversion = 'D' але,я не розумію чому...
        //  chatGPT переконує, що тут не повинно бути помилки))) тому я захардкодив це значення
      //  return "#!results?part_numbers%5B0%5D=91064&order_by=best_match&display=full&location_id=14716&search_by=partNumber&page=1";
    }


    @FindBy(xpath = ".//button[@class='tcwlw_brand_btn_light tcwlw_btn_small tcwlw_back_btn ']")
    private WebElement buttonBack;

    @FindBy(xpath = ".//h3[@class='tcwlw_results_query_param']")
    private WebElement textPartNumberInResult;

    @FindBy(xpath = ".//strong[@class='tcwlw_font_color']")
    private WebElement numberOfTiresFound;

    @FindBy(xpath =".//ul[@class='tcwlw_tabs_list']//li[1]")                                  //".//a[@class='tcwlw_font_color tcwlw_tResTabSpecs']")
    private WebElement linkSpecs;

    @FindBy(xpath = "//li[contains(@class, 'tcwlw_tResSpecPart') and not(.//span[@class='tcwlw_text_name tcwlw_text_name_underscored'])]")
    private WebElement PartNumberInSpecs;

    @FindBy(xpath = ".//span[@class='tcwlw_result_title_model']")
    private WebElement modelName;

    @FindBy(xpath = ".//img[@class='tcwlw_result_brand_logo']")
    private WebElement brandName;

    @FindBy(xpath = ".//button[@class='tcwlw_brand_btn tcwlw_select_btn']")
    private WebElement buttonSelectTire;

    @FindBy(xpath = ".//UL//li[1]//span[@class='tcwlw_result_compare']//input[@type='checkbox']")
    private WebElement checkboxCompare1;

    @FindBy(xpath = ".//UL//li[2]//span[@class='tcwlw_result_compare']//input[@type='checkbox']")
    private WebElement checkboxCompare2;

    @FindBy(xpath = ".//UL//li[3]//span[@class='tcwlw_result_compare']//input[@type='checkbox']")
    private WebElement checkboxCompare3;

    @FindBy(xpath = ".//button[@class='tcwlw_brand_btn tcwlw_btn_small tcwlw_compare_btn']")
    private WebElement buttonCompare;

    @FindBy(xpath = ".//div[@class='tcwlw_dropdown tcwlw_filter_dropdown tcwlw_tFilterBrand']")
    private WebElement brandFilter;

    @FindBy(xpath = ".//div[@class='tcwlw_filters_list']//ul//li//input[@value='Westlake']")
    private WebElement westlakeFilterCheckbox;

    @FindBy(xpath = ".//div[@class='tcwlw_selected_filters']//span[contains(text(), 'Westlake')]")
    private WebElement brandFilterInAppliedFilter;


    public void checkIsRedirectToResultPage() {

        webDriverWait10.until(ExpectedConditions.urlToBe(BASEURL + getRelativeUrl()));
        checkUrl();
    }

    public void checkPartNumberInResult() {
        checkTextInElement(textPartNumberInResult, PART_NUMBER);
        logger.info("Part number is correct");
    }

    public void checkNumberOfTiresFound(String number) {
        sleep(800);
        checkTextInElement(numberOfTiresFound, number);
        logger.info("Number of tires found is correct" );
    }

    public void checkPartNumberInSpecs(String partNumber) {
       webDriverWait10.until(ExpectedConditions.
               visibilityOf(linkSpecs));
        clickOnElement(linkSpecs);
        checkTextInElement(PartNumberInSpecs,"Part #: " + partNumber);
        logger.info("Part number in specs is correct");


    }

    public void checkModelName(String modelName) {
        checkTextInElement(this.modelName, modelName);
        logger.info("Model name is correct");
    }

    public void checkBrandName(String brandName1) {

        checkTextInAltAtribute(brandName, brandName1);
    }

    public void clickOnButtonSelectTire() {
        clickOnElement(buttonSelectTire);
    }

    public void setAddToCompareCheckboxes() {

        checkToCheckbox(checkboxCompare1);
        checkToCheckbox(checkboxCompare2);
        checkToCheckbox(checkboxCompare3);
    }

    public void clickOnButtonCompare() {
        clickOnElement(buttonCompare);
    }

    public void selectBrandFilter() {
        clickOnElement(brandFilter);
        checkToCheckbox(westlakeFilterCheckbox);
    }

    public void checkBrandInAppliedFilter(String brandName) {
        checkTextInElement(brandFilterInAppliedFilter, brandName);
    }
}
