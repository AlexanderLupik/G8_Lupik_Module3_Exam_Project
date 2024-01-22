package searchTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void firstTest(){
        pageProvider.searchPage().openWidget();
        pageProvider.searchPage().selectWidth("205");
     //   pageProvider.searchPage().selectHeight("205");
        Assert.assertTrue("element dysplay",pageProvider.searchPage().isButtonDisabled());

    }

}
