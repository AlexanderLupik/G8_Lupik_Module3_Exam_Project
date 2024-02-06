package searchBySyzeAndFilterTest;

import baseTest.BaseTest;
import expectedResult.ExpectedResult;
import org.junit.Test;


public class SearchBySizeAndFilterTest extends BaseTest {
    @Test
    public void searchBySizeAndFilterTest() {
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().selectSearchBy("size");
        pageProvider.searchPage().selectWith("205");
        pageProvider.searchPage().selectProfile("55");
        pageProvider.searchPage().selectWheelSize("16");
        pageProvider.searchPage().selectSeason("all");
        pageProvider.searchPage().clickOnButtonSearch();

        pageProvider.resultPage().checkNumberOfTiresFound("3");
        pageProvider.resultPage().selectBrandFilter();
        pageProvider.resultPage().checkBrandName("Westlake Tire.");
        pageProvider.resultPage().checkModelName("RP18");
        pageProvider.resultPage().checkNumberOfTiresFound("1");
        pageProvider.resultPage().checkPartNumberInSpecs(ExpectedResult.PART_NUMBER3);
        pageProvider.resultPage().checkBrandInAppliedFilter("Westlake\uE5CD");


    }


}
