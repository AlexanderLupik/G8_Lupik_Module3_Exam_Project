package pages;

import org.openqa.selenium.WebDriver;

public class SummaryPage extends ParentPage
{
    public SummaryPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    protected String getRelativeUrl()
    {
        return "#!summary?location_id=14716&optional_services=use_default&quantities%5B0%5D=4&tire_ids%5B0%5D=SXJvbm1hbnx8OTEwNjR8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D";
    }
}
