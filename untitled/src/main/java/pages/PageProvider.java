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

}
