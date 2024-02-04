package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage  extends ParentPage{
public ComparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
    //з юрлками тут треба гратися, бо вони змінюються від багатьох факторів. Це тільки приклад, такий собі хардкод
        return "#!comparing_tires?tire_ids%5B0%5D%5B0%5D=SXJvbm1hbnx8OTEwNjR8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D&tire_ids%5B1%5D%5B0%5D=SXJvbm1hbnx8NzIwMTd8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D&tire_ids%5B2%5D%5B0%5D=V2VzdGxha2V8fDM4MDc2fHx0ZXN0ZmVlZHx8MTQ3MTZ8fEI%3D&location_id=14716&quantity%5B0%5D=1&raw_size=2055516";
    }

    @FindBy(xpath = ".//tr[@class='tcwlw_no_line']//td[1]/img")
    private WebElement tireName1;

    @FindBy(xpath = ".//tr[@class='tcwlw_no_line']//td[2]/img")
    private WebElement tireName2;

    @FindBy(xpath = ".//tr[@class='tcwlw_no_line']//td[3]/img")
    private WebElement tireName3;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_model_tire tcwlw_no_line']//td[1]//h3//span")
    private WebElement modelName1;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_model_tire tcwlw_no_line']//td[2]//h3//span")
    private WebElement modelName2;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_model_tire tcwlw_no_line']//td[3]//h3//span")
    private WebElement modelName3;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_warranty_tire tcwlw_no_line']//td[1]//h3")
    private WebElement warranty1;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_warranty_tire tcwlw_no_line']//td[2]//h3")
    private WebElement warranty2;

    @FindBy(xpath = ".//tr[@class='tcwlw_row_warranty_tire tcwlw_no_line']//td[3]//h3")
    private WebElement warranty3;

    @FindBy(xpath = ".//tr[@class='tcwlw_tComparisonPartNumberRow']//td[1]//div[@class='tcwlw_compare_tire_indent']")
    private WebElement partNumber1;

    @FindBy(xpath = ".//tr[@class='tcwlw_tComparisonPartNumberRow']//td[2]//div[@class='tcwlw_compare_tire_indent']")
    private WebElement partNumber2;

    @FindBy(xpath = ".//tr[@class='tcwlw_tComparisonPartNumberRow']//td[3]//div[@class='tcwlw_compare_tire_indent']")
    private WebElement partNumber3;


    public void checkBrandsInComparePage(String brand1, String brand2, String brand3) {
        checkTextInAltAtribute(tireName1,brand1);
        checkTextInAltAtribute(tireName2,brand2);
        checkTextInAltAtribute(tireName3,brand3);
        logger.info("Brands are correct");
    }

    public void checkModelsInComparePage(String modelName, String modelName1, String modelName2) {
      checkTextInElement(this.modelName1, modelName);
        checkTextInElement(this.modelName2, modelName1);
        checkTextInElement(this.modelName3, modelName2);
        logger.info("Models are correct");
    }

    public void checkWarrantyInComparePage(String warranty1, String warranty0, String warranty01) {
        checkTextInElement(this.warranty1, warranty1);
        checkTextInElement(this.warranty2, warranty0);
        checkTextInElement(this.warranty3, warranty01);
        logger.info("Warranty are correct");
    }

    public void checkPartNumbersInComparePage(String partNumber3, String partNumber2, String partNumber1) {

        checkTextInElement(this.partNumber1, partNumber3);
        checkTextInElement(this.partNumber2, partNumber2);
        checkTextInElement(this.partNumber3, partNumber1);
        logger.info("Part numbers are correct");
    }
}
