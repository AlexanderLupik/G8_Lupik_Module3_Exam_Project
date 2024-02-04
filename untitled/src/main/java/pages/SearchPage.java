package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SearchPage extends ParentPage {


   @FindBy(xpath = ".//input[@id='tcwlw_part_number']")
    private WebElement inputPartNumber;



    @FindBy(xpath = ".//button[@class='tcwlw_btn tcwlw_brand_btn tcwlw_submit']")
   private WebElement buttonSearch;




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
        enterTextInToInput(inputPartNumber, partNumber);
       //це костильний метод, але інакше при вводі першої цифри загружається спіннер і вводиться тільки остання цифра 2055516 ->6
        clickOnElement(inputPartNumber);
        enterTextInToInput(inputPartNumber, partNumber);
        clickOnElement(inputPartNumber);
        clearInput(inputPartNumber);
        enterTextInToInput(inputPartNumber, partNumber);


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
}
