package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BookingResultsPage;
import pages.BookingSearchPage;

public class BookingSearchAndResultsSteps {

    WebDriver driver;


    @When("I set {string} into search bar")
    public void iSetPremiereClasseWroclawCentrumIntoSearchBar(String value) {
        new BookingSearchPage(driver).setSearchValue(value);
    }

    @Then("{string} should be present in first search result title")
    public void premiereClasseWroclawCentrumShouldBePresentInFirstSearchResultTitle(String name) {
        String firstResultText = new BookingResultsPage(driver).getSearchResultTextByIndex(1);
        Assert.assertTrue(firstResultText.contains(name));
    }

    @And("I click to search button")
    public void iClickToSearchButton() {
        new BookingSearchPage(driver).clickSearchButton();
    }

    @And("Premiere Classe Wroclaw Centrum raiting should be {string}")
    public void premiereClasseWroclawCentrumRaitingShouldBe(double rating) {
        double firstResultRating = new BookingResultsPage(driver).getSearchResultRatingByIndex(1);
        Assert.assertEquals(firstResultRating, rating);
    }

    @Given("I am at {string} page")
    public void iAmAtWwwBookingComSearchresultsEnGbHtmlPage(String name) {
        new BookingSearchPage(driver).open();
    }
}
