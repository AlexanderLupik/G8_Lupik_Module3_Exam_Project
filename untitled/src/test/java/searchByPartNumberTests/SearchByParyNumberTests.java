package searchByPartNumberTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import testData.TestData;

public class SearchByParyNumberTests extends BaseTest {

    @Test

    //перевіряю, якщо зробити пошук по партномеру, то в результатах буде 1 шина з цим номером
    public void validPartNumber() {
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().checkIsRedirectToSearchPage();
        pageProvider.searchPage().enterPartNumberInToInputSearch(TestData.PART_NUMBER);
        pageProvider.searchPage().clickOnButtonSearch();

        pageProvider.resultPage().checkIsRedirectToResultPage();
        pageProvider.resultPage().checkNumberOfTiresFound("1");// перевіряю, чи тільки одна шина знайшлася за цим партномером
        pageProvider.resultPage().checkPartNumberInResult();// перевіряю чи правильний партномер в блоці результатів
        pageProvider.resultPage().checkPartNumberInSpecs(); // перевіряю чи правильний номер в специфікації
        pageProvider.resultPage().checkBrandName(TestData.BRAND_MODEL_IN_IMAGE); // перевіряю назву бренду( він відображається як картинка)
        pageProvider.resultPage().checkModelName(TestData.MODEL_NAME);  // перевіряю назву моделі








    }

}