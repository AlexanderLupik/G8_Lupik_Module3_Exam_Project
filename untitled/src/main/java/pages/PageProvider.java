package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;
    public PageProvider(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public SearchPage searchPage (){
        return new SearchPage(webDriver);
    }

    public ResultPage resultPage (){
        return new ResultPage(webDriver);
    }

    public SummaryPage summaryPage (){
        return new SummaryPage(webDriver);
    }

    public SaveQuotePage saveQuotePage (){
        return new SaveQuotePage(webDriver);
    }

    public EmailQuotePage emailQuotePage (){
        return new EmailQuotePage(webDriver);
    }

    public ComparePage comparePage (){
        return new ComparePage(webDriver);
    }

}
