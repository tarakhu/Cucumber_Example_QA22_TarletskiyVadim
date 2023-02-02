package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchPage extends BasePage {

    private final static By SEARCH_INPUT = By.cssSelector("[name=ss]");
    private final static By SEARCH_BUTTON = By.cssSelector("button[type='submit']");


    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void setSearchValue(String value) {
        driver.findElement(SEARCH_INPUT).sendKeys(value);
    }

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
    }

}
