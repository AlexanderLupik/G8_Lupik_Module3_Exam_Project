package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommandActionsWithElements {

        public ParentPage(WebDriver webDriver) {
            super(webDriver);
        }

   final String BASEURL = "https://devapp.tireconnect.ca/web/5aa5fb55c50266079fe79d72a9319321";
  abstract protected String getRelativeUrl();

    protected void checkUrl(){
        Assert.assertEquals("Invalid page "
                , BASEURL + getRelativeUrl()
                , webDriver.getCurrentUrl()
        );
    }

}
