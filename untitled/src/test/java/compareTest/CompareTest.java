package compareTest;

import baseTest.BaseTest;
import expectedResult.ExpectedResult;
import org.junit.Test;
import testData.TestData;

public class CompareTest extends BaseTest {

    @Test
    public void firstTest(){
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().enterPartNumberInToInputSearch(TestData.PART_NUMBER);

        pageProvider.searchPage().selectSearchBy("rawSize");
        pageProvider.searchPage().enterRawSizeInToInputSearch(TestData.RAW_SIZE);
        pageProvider.searchPage().clickOnButtonSearch();

        pageProvider.resultPage().setAddToCompareCheckboxes();
        pageProvider.resultPage().clickOnButtonCompare();
        pageProvider.comparePage().checkBrandsInComparePage(ExpectedResult.BRAND__IN_IMAGE3, ExpectedResult.BRAND_IN_IMAGE2, ExpectedResult.BRAND_IN_IMAGE1);
        pageProvider.comparePage().checkModelsInComparePage(ExpectedResult.MODEL_NAME3, ExpectedResult.MODEL_NAME2, ExpectedResult.MODEL_NAME1);
        pageProvider.comparePage().checkWarrantyInComparePage(ExpectedResult.WARRANTY1, ExpectedResult.WARRANTY0, ExpectedResult.WARRANTY0);
        pageProvider.comparePage().checkPartNumbersInComparePage(ExpectedResult.PART_NUMBER3, ExpectedResult.PART_NUMBER2, ExpectedResult.PART_NUMBER1);

        //і так всі елементи сторінки



}}
