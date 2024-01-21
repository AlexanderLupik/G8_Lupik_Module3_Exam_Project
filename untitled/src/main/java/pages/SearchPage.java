package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends ParentPage {

    @FindBy(xpath = ".//button[@class='tcwlw_btn tcwlw_brand_btn tcwlw_submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//li[@data-tcwlw-value='205']")
    private WebElement selectWidth;

    public  SearchPage(WebDriver webDriver){
        super(webDriver);

    }


    public void openWidget() {
        webDriver.get("https://devapp.tireconnect.ca/web/5aa5fb55c50266079fe79d72a9319321");
    }

    public boolean isButtonDisabled() {



        return isElementDisplayed(buttonSearch);
    }

    public void selectWidth(String width) {
       // clickOnElement(selectWidth);
        selectValueInDropDown(selectWidth, width);
    }
}
