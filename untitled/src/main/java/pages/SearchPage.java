package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SearchPage extends ParentPage {


   @FindBy(xpath = ".//input[@id='tcwlw_part_number']")
    private WebElement inputPartNumber;

   @FindBy(xpath = ".//select[@id='tcwlw_search_by_select']")
    private WebElement dropDownSearchBy;



    @FindBy(xpath = ".//button[@class='tcwlw_btn tcwlw_brand_btn tcwlw_submit']")
   private WebElement buttonSearch;

    @FindBy(xpath = ".//input[@id='tcwlw_raw_size']")
    private WebElement inputRawSize;

    // --------------------------Tire Size Selectors  --------------------------

    @FindBy(xpath =".//div[@class='tcwlw_field' and label[@for='tcwlw_width']]//div[@class='tcwlw_select_field tcwlw_custom_select']")                    //".//select[@name='width']")
    private WebElement dropDownWidth;

   final String  widthValue = ".//ul[@style='max-height: 19em;']/li[@data-tcwlw-value='%s']";

    @FindBy(xpath = widthValue)
    private WebElement widthValueInDropDown;

    @FindBy(xpath = ".//div[@class='tcwlw_field' and label[@for='tcwlw_rim']]//div[@class='tcwlw_select_field tcwlw_custom_select']")
    private WebElement dropDownProfile;
    
    final String profileValue = ".//ul[@style='max-height: 19em;']/li[@data-tcwlw-value='%s']";
    
    @FindBy(xpath = profileValue)
    private WebElement profileValueInDropDown;

    @FindBy(xpath = ".//div[@class='tcwlw_field' and label[@for='tcwlw_rim']]//div[@class='tcwlw_select_field tcwlw_custom_select']")
    private WebElement dropDownRim;

    final String rimValue = ".//ul[@style='max-height: 19em;']/li[@data-tcwlw-value='%s']";

    @FindBy(xpath = rimValue)
    private WebElement rimValueInDropDown;

    @FindBy(xpath = ".//div[@class='tcwlw_field' and label[@for='tcwlw_seasonId']]//div[@class='tcwlw_select_field tcwlw_custom_select']")
    private WebElement dropDownSeason;

    final String seasonValue = ".//ul[@style='max-height: 19em;']/li[@data-tcwlw-value='%s']";

    @FindBy(xpath = seasonValue)
    private WebElement seasonValueInDropDown;


    public  SearchPage(WebDriver webDriver){
        super(webDriver);

    }

    @Override
    protected String getRelativeUrl() {
        return "#!search?location_id=14716&search_by=partNumber";
    }
    public void openWidget() {
        webDriver.get("https://devapp.tireconnect.ca/web/5aa5fb55c50266079fe79d72a9319321");
    }



    public void enterPartNumberInToInputSearch(String partNumber) {
//        enterTextInToInput(inputPartNumber, partNumber);
//       //це костильний метод, але інакше при вводі першої цифри загружається спіннер і вводиться тільки остання цифра 2055516 ->6
//        clickOnElement(inputPartNumber);
//        enterTextInToInput(inputPartNumber, partNumber);
//        clickOnElement(inputPartNumber);
//        clearInput(inputPartNumber);
//        enterTextInToInput(inputPartNumber, partNumber);
        enterTextInToInputSymbolically(inputPartNumber, partNumber);


    }

    public void enterRawSizeInToInputSearch(String rawSize) {
        enterTextInToInputSymbolically(inputRawSize, rawSize);

    }

    private void clearInput(WebElement inputRawSize) {

        inputRawSize.clear();

    }


    public void clickOnButtonSearch() {
          clickOnElement(buttonSearch);
   }

   public void checkIsRedirectToSearchPage() {
        webDriverWait10.until(ExpectedConditions.urlToBe(BASEURL + getRelativeUrl()));
        checkUrl();
    }

    public void selectSearchBy(String searchBy) {
        clickOnElement(dropDownSearchBy);
        selectValueInDropDown(dropDownSearchBy, searchBy);
    }

    public void selectWith(String width) {
        clickOnElement(dropDownWidth);
     WebElement widthValueInDropDown = webDriver.findElement(By.xpath(String.format(widthValue, width)));
        clickOnElement(widthValueInDropDown);
    }

    public void selectProfile(String profile) {
      //  clickOnElement(dropDownProfile);
        logger.info("Profile is selected");
        WebElement profileValueInDropDown = webDriver.findElement(By.xpath(String.format(profileValue, profile)));
        clickOnElement(profileValueInDropDown);

    }

    public void selectWheelSize(String Rim) {
       // clickOnElement(dropDownRim);
        WebElement rimValueInDropDown = webDriver.findElement(By.xpath(String.format(rimValue, Rim)));
        clickOnElement(rimValueInDropDown);
    }

    public void selectSeason(String season) {

        WebElement seasonValueInDropDown = webDriver.findElement(By.xpath(String.format(seasonValue, season)));
        clickOnElement(seasonValueInDropDown);
    }
}
