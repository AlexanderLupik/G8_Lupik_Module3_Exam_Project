package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveQuotePage extends ParentPage {

    public SaveQuotePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "#!save_quote";
    }

    @FindBy(xpath = "//button[contains(@class, 'tcwlw_brand_btn') and contains(text(), 'Email Quote')]")
    private WebElement buttonEmailQuote;

    @FindBy(xpath = "//input[@label='First name']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@label='Last name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@label='Email Address']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@label='Phone Number']")
    private WebElement inputPhone;

    @FindBy(xpath = "//textarea[@label='Notes']")
    private WebElement inputNotes;

    @FindBy(xpath = "//button[@class='tcwlw_brand_btn tcwlw_submit']")
    private WebElement buttonSendEmail;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkboxFollowUp;

    public SaveQuotePage checkIsRedirectToSaveQuotePage() {
        checkUrl();
        return this;
    }


    public void clickOnButtonEmailQuote() {
        clickOnElement(buttonEmailQuote);
    }

    public void enterFirstName(String firstName) {
        enterTextInToInput(inputFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        enterTextInToInput(inputLastName, lastName);
    }

    public void enterEmail(String email) {
        enterTextInToInput(inputEmail, email);
    }

    public void enterPhone(String phone) {
        enterTextInToInput(inputPhone, phone);
    }

    public void enterNotes(String notes) {
        enterTextInToInput(inputNotes, notes);
    }

    public void clickOnButtonSendEmail() {
        clickOnElement(buttonSendEmail);
    }

    public void setFollowUpCheckBoxSelected() {
        checkToCheckbox(checkboxFollowUp);
    }
}
