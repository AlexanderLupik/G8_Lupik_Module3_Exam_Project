package optionalServiceTest;

import baseTest.BaseTest;
import expectedResult.ExpectedResult;
import org.junit.Test;
import testData.TestData;

public class OptionalServiceTest extends BaseTest {

    @Test
    public void optionalServiceTest() {
        //перевіряю як працює опціональний сервіс
        //він з'являється тільки після вибору 4 шин і подефолту відключенний
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().checkIsRedirectToSearchPage();
        pageProvider.searchPage().enterPartNumberInToInputSearch(TestData.PART_NUMBER);
        pageProvider.searchPage().clickOnButtonSearch();

        pageProvider.resultPage().checkIsRedirectToResultPage();
        pageProvider.resultPage().clickOnButtonSelectTire();

        pageProvider.summaryPage().checkIsRedirectToSummaryPage();
        pageProvider.summaryPage().checkForNumberOfSelectedTires("1"); //перевіряю що вибрано 1 шину(по замовчуванню в налаштуваннях вибрано 1 шину)
        pageProvider.summaryPage().checkIsOptionalServiceNotVisible(); // сервіс не відображається
        pageProvider.summaryPage().checkSubtotalPrice(ExpectedResult.Subtotal1); //перевіряю ціну

        pageProvider.summaryPage().selectQuantityOfTires("3"); //вибираю 3 шини(нижня границя)
        pageProvider.summaryPage().checkIsOptionalServiceNotVisible();
        pageProvider.summaryPage().checkSubtotalPrice(ExpectedResult.Subtotal3); //перевіряю ціну

        pageProvider.summaryPage().selectQuantityOfTires("4"); //вибираю 4 шини(сервіс має з'явитися)
        pageProvider.summaryPage().checkIsOptionalServiceVisible();

    }
}
