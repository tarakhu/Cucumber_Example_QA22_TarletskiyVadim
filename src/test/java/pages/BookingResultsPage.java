package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class BookingResultsPage extends BasePage {

    private final static By SEARCH_RESULTS = By.xpath("//div[@data-testid='property-card']");


    public BookingResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTextByIndex(int index) {
        return getSearchResultByIndex(index).findElement(By.xpath("//div[@data-testid='title']")).getText();
    }

    private WebElement getSearchResultByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS).get(index - 1);
    }

    public double getSearchResultRatingByIndex(int index) {
        return Double.parseDouble(getSearchResultByIndex(index)
                .findElement(By.xpath("//div[@data-testid='review-score']/div[@aria-label]")).getText());
    }


}
