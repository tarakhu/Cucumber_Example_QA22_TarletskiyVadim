package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingResultsPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;

public class BookingSearchAndResultsSteps {

    WebDriver driver;
    BookingSearchPage bookingSearchPage;
    BookingResultsPage bookingResultsPage;

    @Before
    public void before_all() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingResultsPage = new BookingResultsPage(driver);

    }

    @After
    public void after_all() {
        driver.quit();
    }

    @When("I set {string} into search bar")
    public void iSetPremiereClasseWroclawCentrumIntoSearchBar(String value) {
        bookingSearchPage.setSearchValue(value);
    }

    @Then("{string} should be present in first search result title")
    public void premiereClasseWroclawCentrumShouldBePresentInFirstSearchResultTitle(String name) {
        String firstResultText = bookingResultsPage.getSearchResultTextByIndex(1);
        Assert.assertTrue(firstResultText.contains(name));
    }

    @And("I click to search button")
    public void iClickToSearchButton() {
       bookingSearchPage.clickSearchButton();
    }

    @And("Premiere Classe Wroclaw Centrum raiting should be {string}")
    public void premiereClasseWroclawCentrumRaitingShouldBe(double rating) {
        double firstResultRating = bookingResultsPage.getSearchResultRatingByIndex(1);
        Assert.assertEquals(firstResultRating, rating);
    }


    @Given("I am at booking search  page")
    public void iAmAtBookingSearchPage() {
        new BookingSearchPage(driver).open();
    }
}
