package sendMailTest;

import baseTest.BaseTest;
import expectedResult.ExpectedResult;
import org.junit.Test;
import testData.TestData;

public class SendMailTest extends BaseTest {

    @Test
    public void sendMailTest() {
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().checkIsRedirectToSearchPage();
        pageProvider.searchPage().enterPartNumberInToInputSearch(TestData.PART_NUMBER);
        pageProvider.searchPage().clickOnButtonSearch();

        pageProvider.resultPage().checkIsRedirectToResultPage();
        pageProvider.resultPage().clickOnButtonSelectTire();

        pageProvider.summaryPage().checkIsRedirectToSummaryPage();
        pageProvider.summaryPage().selectQuantityOfTires("2");
        pageProvider.summaryPage().checkIsOptionalServiceNotVisible();
        pageProvider.summaryPage().checkForNumberOfSelectedTires("2"); //перевіряю що вибрано 1 шину(по замовчуванню в налаштуваннях вибрано 1 шину)
        pageProvider.summaryPage().checkIsOptionalServiceNotVisible(); // сервіс не відображається
        pageProvider.summaryPage().checkSubtotalPrice(ExpectedResult.Subtotal2);


        pageProvider.summaryPage().clickButtonSaveYourQuote();
        pageProvider.saveQuotePage().checkIsRedirectToSaveQuotePage();
        pageProvider.saveQuotePage().setFollowUpCheckBoxSelected();
        pageProvider.saveQuotePage().clickOnButtonEmailQuote();

        pageProvider.emailQuotePage().checkIsRedirectToEmailQuotePage();
        pageProvider.emailQuotePage().enterFirstName(TestData.FIRST_NAME);
        pageProvider.emailQuotePage().enterLastName(TestData.LAST_NAME);
        pageProvider.emailQuotePage().enterEmail(TestData.EMAIL);
        pageProvider.emailQuotePage().enterPhone(TestData.PHONE);
        pageProvider.emailQuotePage().enterNotes(TestData.NOTES);
        pageProvider.emailQuotePage().clickOnButtonSendEmail();
        pageProvider.emailQuotePage().checkIsSuccessMessageVisible();
        pageProvider.emailQuotePage().checkIsSuccessMessageTextCorrect(ExpectedResult.SUCCESS_MESSAGE);

        //а далі треба перевірити апі та базу


    }
}
